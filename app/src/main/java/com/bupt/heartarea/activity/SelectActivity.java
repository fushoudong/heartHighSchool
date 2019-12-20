package com.bupt.heartarea.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;
import com.bupt.heartarea.utils.GlobalData;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SelectActivity extends AppCompatActivity {
    private static final String URL_GET = "http://39.100.6.159:8080/detect3/InvesHighSchoolServlet";
    private static final String TAG = "SelectActivity";
    private String getAlls;
    private LinearLayout ll_eight_week;
    private LinearLayout ll_four_week;
    private LinearLayout ll_one_week;
    private LinearLayout ll_twelve_week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initView();
        initEvent();
    }

    private void initView() {
        ll_one_week = (LinearLayout)findViewById(R.id.ll_after_one_week);
        ll_four_week = (LinearLayout)findViewById(R.id.ll_after_four_week);
        ll_eight_week = (LinearLayout)findViewById(R.id.ll_after_eight_week);
        ll_twelve_week = (LinearLayout)findViewById(R.id.ll_after_twelve_week);
        Constants.setGeneral_info(null);
        Constants.setMedication_info(null);
        Constants.setRisk_factor_info(null);
        Constants.setSeattle_info(null);
        Constants.setSeattle_score(-1.0D);
        Constants.setHama_info(null);
        Constants.setHama_score(-1);
        Constants.setSelf_anxiety_info(null);
        Constants.setSelf_anxiety_score(-1);
        Constants.setSleep_quality_info(null);
        Constants.setSleep_quality_score(-1);
        Constants.setSelf_evalution_info(null);
        Constants.setSelf_evalution_score(-1);
    }

    private void initEvent() {
        ll_one_week.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                setStrings("1");
            }
        });
        ll_four_week.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                setStrings("2");
            }
        });
        ll_eight_week.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                setStrings("3");
            }
        });
        ll_twelve_week.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                setStrings("4");
            }
        });
    }

    private void setStrings(final String weeks) {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_GET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.e(TAG, "onResponse: "+s);
                        try {
                            JSONObject jSONObject = new JSONObject(s);
                            String Sbody = jSONObject.getString("body");
                            JSONObject body = new JSONObject(Sbody);
                            Log.e(TAG, "onResponse: " + body);
                            String id = GlobalData.getUserid();

                            String name = body.getString("username");
                            String sex = body.getString("sex");
                            String age = body.getString("age");
                            String tel = body.getString("tel");
                            String address = body.getString("address");
                            String illness = body.getString("illness");
                            String allStr = id + "," + name + "," + sex + "," + age + ","
                                    + tel + "," + address + "," + illness;
                            Constants.setAllstrs(allStr);
                            Log.e(TAG, "onResponse: " + "进入loge" + allStr);

                            Constants.setGeneral_info(body.getString("data_1"));
                            Constants.setMedication_info(body.getString("data_2"));
                            Constants.setRisk_factor_info(body.getString("data_3"));
                            Constants.setSeattle_info(body.getString("data_4"));
                            if (!body.getString("data_4").equals("")) {
                                Constants.setSeattle_score(Double.parseDouble(body.getString("score_4")));
                            } else {
                                Constants.setSeattle_score(-1.0D);
                            }
                            Constants.setHama_info(body.getString("data_5"));
                            if (!Constants.getHama_info().equals("")) {
                                Constants.setHama_score(Integer.parseInt(body.getString("score_5")));
                            } else {
                                Constants.setHama_score(-1);
                            }
                            Constants.setSelf_anxiety_info(body.getString("data_6"));
                            if (!Constants.getSelf_anxiety_info().equals("")) {
                                Constants.setSelf_anxiety_score(Integer.parseInt(body.getString("score_6")));
                            } else {
                                Constants.setSelf_anxiety_score(-1);
                            }
                            Constants.setSleep_quality_info(body.getString("data_7"));
                            if (!Constants.getSleep_quality_info().equals("")) {
                                Constants.setSleep_quality_score(Integer.parseInt(body.getString("score_7")));
                            } else {
                                Constants.setSleep_quality_score(-1);
                            }
                            Constants.setSelf_evalution_info(body.getString("data_8"));
                            if (!Constants.getSelf_evalution_info().equals("")) {
                                Constants.setSelf_evalution_score(Integer.parseInt(body.getString("score_8")));
                            } else {
                                Constants.setSelf_evalution_score(-1);
                            }
                            Constants.setSteps(body.getString("steps"));


                            String other = Constants.getGeneral_info()+ ";" + Constants.getMedication_info()+ ";"
                                    + Constants.getRisk_factor_info() + ";" +Constants.getSeattle_info() + ";"
                                    + Constants.getHama_info() + ";" + Constants.getSelf_anxiety_info() + ";"
                                    + Constants.getSleep_quality_info() + ";" + Constants.getSelf_evalution_info();

                            Log.e(TAG, "onResponse: " + "进入loge:" + other);
                            if (weeks == "1") {
                                Log.e(TAG, "onResponse: " + "Week:" + weeks);
                                Constants.setWeeks("第一个月");
                                Constants.setWeek_no(weeks);
                                Intent intent1 = new Intent(SelectActivity.this, MainQSActivity.class);
                                intent1.putExtra("weeks", Constants.getWeeks());
                                startActivity(intent1);
                                return;
                            }else if (weeks == "2") {
                                Constants.setWeeks("第二个月");
                                Constants.setWeek_no(weeks);
                                Intent intent1 = new Intent(SelectActivity.this, MainQSActivity.class);
                                intent1.putExtra("weeks", Constants.getWeeks());
                                SelectActivity.this.startActivity(intent1);
                                return;
                            }else if (weeks == "3") {
                                Constants.setWeeks("第三个月");
                                Constants.setWeek_no(weeks);
                                Intent intent1 = new Intent(SelectActivity.this, MainQSActivity.class);
                                intent1.putExtra("weeks", Constants.getWeeks());
                                SelectActivity.this.startActivity(intent1);
                                return;
                            }else {
                                Constants.setWeeks("第四个月");
                                Constants.setWeek_no(weeks);
                                Intent intent = new Intent(SelectActivity.this, MainQSActivity.class);
                                intent.putExtra("weeks", Constants.getWeeks());
                                SelectActivity.this.startActivity(intent);
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast.makeText(SelectActivity.this, "连接服务器失败请检查网络连接", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("userid", GlobalData.getUserid());
                map.put("week_num", weeks);
                Log.e(TAG, "getParams: "+GlobalData.getUserid() + " " +weeks);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

}
