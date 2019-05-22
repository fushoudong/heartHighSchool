package com.bupt.heartarea.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bupt.heartarea.R;
import com.bupt.heartarea.bean.MeasureData;
import com.bupt.heartarea.bean.ResponseBean;
import com.bupt.heartarea.utils.GlobalData;
import com.bupt.heartarea.utils.TimeUtil;
import com.google.gson.Gson;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.adapter.LemonHelloEventDelegateAdapter;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuqing on 2017/1/1.
 */
public class questionnaireSurveyActivity extends Activity implements View.OnClickListener {

    private static final String URL_COLLECT_DATA = GlobalData.URL_HEAD + "/detect3/SHDataCollect";
    private EditText et_mUserName;
    private RadioGroup rg_mSex;
    private RadioButton rb_mMan;
    private RadioButton rb_mWoman;
    //    private EditText et_mFatigue;
    private Button btn_mSaveDataBtn;
    private String mfileName;
    private Spinner mSpinnerDisease;
    private EditText mEtHeight, mEtWeight;
    private String mUserName = "";
    private MeasureData mMeasureData = new MeasureData();
    private int mHeight = -1;
    private int mWeight = -1;
    private int mSex = 0;
    private int mPressure = 0;
    private String mMeasureDataString;
    private int mDisease = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_survey);
        init();
        mMeasureData = (MeasureData) getIntent().getSerializableExtra("measure_data");
        Gson gson = new Gson();
        mMeasureDataString = gson.toJson(mMeasureData);
        Log.i("mMeasureDataString", mMeasureDataString);

    }



    void init() {
        et_mUserName = (EditText) findViewById(R.id.id_et_usermame);
        et_mUserName = (EditText) findViewById(R.id.id_et_usermame);
        mEtHeight = (EditText) findViewById(R.id.id_et_height);
        mEtWeight = (EditText) findViewById(R.id.id_et_weight);
        btn_mSaveDataBtn = (Button) findViewById(R.id.id_btn_savedata);
        btn_mSaveDataBtn.setOnClickListener(this);

        rg_mSex = (RadioGroup) findViewById(R.id.id_rg_sex);
        rb_mMan = (RadioButton) findViewById(R.id.id_rb_man);
        rb_mMan.setChecked(true);
        rb_mWoman = (RadioButton) findViewById(R.id.id_rb_woman);

        et_mUserName.setText(GlobalData.getUsername());
        switch (GlobalData.getSex()) {
            case 0:
                rb_mMan.setChecked(true);
                break;
            case 1:
                rb_mWoman.setChecked(true);
                break;
            default:
                rb_mMan.setChecked(true);
                break;
        }

        mSpinnerDisease = (Spinner) findViewById(R.id.id_spinner_disease);
        getUserInformationFromSP();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_savedata:
                mUserName = et_mUserName.getText().toString().trim();
                switch (mSpinnerDisease.getSelectedItem().toString()){
                    case "没有":
                        mDisease = 0;
                        break;
                    case "心衰":
                        mDisease = 1;
                        break;
                    case "房颤":
                        mDisease = 2;
                        break;
                    case "不知道":
                        mDisease =3;
                        break;
                }
                if (mUserName.equals("")) {
                    Toast.makeText(questionnaireSurveyActivity.this, "请输入您的姓名", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (mEtHeight.getText().toString().trim().equals("")) {
                    Toast.makeText(questionnaireSurveyActivity.this, "请输入您的身高", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    mHeight = Integer.parseInt(mEtHeight.getText().toString().trim());
                    if (mHeight >= 100 && mHeight <= 200) {

                    } else {
                        Toast.makeText(questionnaireSurveyActivity.this, "请输入您正确的身高，范围100-200（cm）", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                if (mEtWeight.getText().toString().trim().equals("")) {
                    Toast.makeText(questionnaireSurveyActivity.this, "请输入您的体重", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    mWeight = Integer.parseInt(mEtWeight.getText().toString().trim());
                    if (mWeight >= 40 && mWeight <= 200) {

                    } else {
                        Toast.makeText(questionnaireSurveyActivity.this, "请输入您正确的体重，范围40-200（kg）", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                rg_mSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == rb_mMan.getId()) {
                            mSex = 0;
                        } else {
                            mSex = 1;
                        }
                    }
                });

                postToServer();
                break;
        }

    }

    /**
     * 将采集到的数据发送到服务器端
     */
    void postToServer() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_COLLECT_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("Response", s);
                System.out.println(s);
                Gson gson = new Gson();
                ResponseBean responseBean = gson.fromJson(s, ResponseBean.class);
                if (responseBean!=null&&responseBean.getCode() == 0) {
                    LemonHello.getSuccessHello("上传成功", "感谢您对我们工作的支持，谢谢您的使用")
                            .setContentFontSize(14)
                            .addAction(new LemonHelloAction("我知道啦", new LemonHelloActionDelegate() {
                                @Override
                                public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                                    helloView.hide();
                                    finish();
                                }
                            }))
                            .setEventDelegate(new LemonHelloEventDelegateAdapter() {
                                @Override
                                public void onMaskTouch(LemonHelloView helloView, LemonHelloInfo helloInfo) {
                                    super.onMaskTouch(helloView, helloInfo);
                                    helloView.hide();
                                    finish();
                                }
                            })
                            .show(questionnaireSurveyActivity.this);
                } else if(responseBean!=null){
                    Toast.makeText(questionnaireSurveyActivity.this, responseBean.getMsg(), Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(questionnaireSurveyActivity.this, "上传失败", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("volleyError",volleyError.getMessage(),volleyError);
                byte[] htmlBodyBytes = volleyError.networkResponse.data;
                Log.e("volleyError body----->",new String(htmlBodyBytes),volleyError);
                Toast.makeText(questionnaireSurveyActivity.this, "连接服务器失败", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> map = new HashMap<>();
                map.put("userid", GlobalData.getUserid());
                map.put("username", mUserName);
                map.put("time", TimeUtil.getCurrentTime());
                map.put("date", TimeUtil.getCurrentDate());
                map.put("height", String.valueOf(mHeight));
                map.put("weight", String.valueOf(mWeight));
                map.put("sex", String.valueOf(mSex));
                map.put("disease", String.valueOf(mDisease));
                map.put("all_data", String.valueOf(mMeasureDataString));
                Log.i("收集数据", map.toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void getUserInformationFromSP() {
        SharedPreferences sp = getSharedPreferences("information", Context.MODE_PRIVATE);
        if (sp != null) {
            et_mUserName.setText(sp.getString("username", "")); // 第二个参数为默认值
            mEtHeight.setText(sp.getInt("height", -1) + "");
            mEtWeight.setText(sp.getInt("weight", -1) + "");
            switch (sp.getInt("sex", 0)) {
                case 0:
                    rb_mMan.setChecked(true);
                    break;
                case 1:
                    rb_mWoman.setChecked(true);
                    break;
                default:
                    rb_mMan.setChecked(true);
                    break;
            }
        }
    }
}

