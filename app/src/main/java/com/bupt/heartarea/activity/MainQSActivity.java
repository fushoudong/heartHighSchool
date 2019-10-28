package com.bupt.heartarea.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bupt.heartarea.HeartAreaApplication;
import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;
import com.bupt.heartarea.helper.TipHelper;
import com.bupt.heartarea.utils.GlobalData;

import net.lemonsoft.lemonbubble.LemonBubble;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainQSActivity extends Activity implements View.OnClickListener {
    private static final String KEY_STEP_NUMBER_LIST = "stepNumberList";
    private static final int MSG_WHAT_MARK = 3;
    private static final int MSG_WHAT_SHOW_TIME = 1;
    private static final int REFRESH_STEP_WHAT = 0;
    private static final String URL_POST = "http://47.92.80.155/detect3/InvesHighSchoolUpdateServlet";
    private static final String[] step_numbers = {
            "5000", "5500", "6000", "6500", "7000", "7500", "8000", "8500", "9000", "9500",
            "10000", "10500", "11000", "11500", "12000", "12500", "13000", "13500", "14000", "14500",
            "15000", "15500", "16000", "16500", "17000", "17500", "18000", "18500", "19000", "19500",
            "20000" };
    private long TIME_INTERVAL_REFRESH = 500L;
    private int after_step_number;
    private int before_step_number;
    private Button bt_start;

    private Button btn_commit_main;
    private CheckBox cb_diabetes;
    private CheckBox cb_high_blood_pressure;
    private float currentStepNumber;
//    private DialProgress dialProgress;
    private double distance;
    private double energy;
    private EditText et_address;
    private EditText et_age;
    private EditText et_id;
    private EditText et_name;
    private EditText et_tel;
    private String general_info;
    private TextView general_status;
    private String getAllstr;
    private String[] getAllstrs;
    private String hama_info;
    private int hama_score;
    private TextView hama_status;
    //private ISportStepInterface iSportStepInterface;

    private LinearLayout ll_anxiety_activity;
    private LinearLayout ll_danger_activity;
    private LinearLayout ll_general_activity;
    private LinearLayout ll_life_activity;
    private LinearLayout ll_medication_activity;
    private LinearLayout ll_self_activity;
    private LinearLayout ll_self_anxiety_activity;
    private LinearLayout ll_sleep_activity;

//    private Handler mDelayHandler = new Handler(new TodayStepCounterCall(this));

    private LinearLayout mExpandView;
    private NumberPicker mNumberPicker;
    private int mSelectedIndex;
    private int mStepSum;
    private int max;
    private String medication_info;
    private TextView medication_status;
    private MediaPlayer mp;
    private RadioButton rb_boy;
    private RadioButton rb_girl;
    private String risk_factor_info;
    private TextView risk_factor_status;
    private String seattle_info;
    private double seattle_score;
    private TextView seattle_status;
    private String self_anxiety_info;
    private int self_anxiety_score;
    private TextView self_anxiety_status;
    private String self_evalution_info;
    private int self_evalution_score;
    private TextView self_evalution_status;
    private TimerTask showTimerTask = null;
    private String sleep_quality_info;
    private int sleep_quality_score;
    private TextView sleep_quality_status;
    private String steps;
    private int tenMesc = 36000;
    private Timer timer = new Timer();
    private TimerTask timerTask = null;
    private String title = "";
    private HeartAreaApplication tsApplication;
    private TextView tv_com;
    private TextView tv_distance;
    private TextView tv_energy;
    private TextView tv_hour;
    private TextView tv_level;
    private TextView tv_main_title;
    private TextView tv_minute;
    private TextView tv_msecond;
    private TextView tv_second;
    private TextView tv_step_number;
    private TextView tv_step_number_result;
    String tx1;
    private static final String TAG = "MainQSActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qs_main);
        initView();
        initEvent();
    }

    private void initView() {
        ll_general_activity = (LinearLayout)findViewById(R.id.ll_general_info);
        ll_medication_activity = (LinearLayout)findViewById(R.id.ll_medication);
        ll_danger_activity = (LinearLayout)findViewById(R.id.ll_danger);
        ll_life_activity = (LinearLayout)findViewById(R.id.ll_life);
        ll_anxiety_activity = (LinearLayout)findViewById(R.id.ll_anxiety);
        ll_self_anxiety_activity = (LinearLayout)findViewById(R.id.ll_self_anxiety_activity);
        ll_sleep_activity = (LinearLayout)findViewById(R.id.ll_sleep);
        ll_self_activity = (LinearLayout)findViewById(R.id.ll_self);
        tv_step_number_result = (TextView)findViewById(R.id.tv_step_number_result);
        mExpandView = (LinearLayout)findViewById(R.id.expand);
        //dialProgress = (DialProgress)findViewById(R.id.);
        tv_distance = (TextView)findViewById(R.id.tv_left_bottom);
        tv_level = (TextView)findViewById(R.id.tv_center_bottom);
        tv_energy = (TextView)findViewById(R.id.tv_right_bottom);
        tsApplication = (HeartAreaApplication)getApplication();
//        TodayStepManager.init(getApplication());
       // tv_step_number = (TextView)findViewById(R.id.tv_step_number_result);
        //StartService();
        tv_hour = (TextView)findViewById(R.id.tv_hour);
        tv_minute = (TextView)findViewById(R.id.tv_minute);
        tv_second = (TextView)findViewById(R.id.tv_second);
        tv_msecond = (TextView)findViewById(R.id.tv_m_second);
        tv_com = (TextView)findViewById(R.id.tv_com);
        bt_start = (Button)findViewById(R.id.bt_start);
//        showTimerTask = new TimerTask() {
//            public void run() { MainQSActivity.handler.sendEmptyMessage(1); }
//        };
        //timer.schedule(showTimerTask, 200L, 200L);
        tv_main_title = (TextView)findViewById(R.id.tv_main_title_qs);
        title = "基本信息情况(" + Constants.getWeeks() + ")";
        tv_main_title.setText(title);
        general_status = (TextView)findViewById(R.id.tv_status1);
        medication_status = (TextView)findViewById(R.id.tv_status2);
        risk_factor_status = (TextView)findViewById(R.id.tv_status3);
        seattle_status = (TextView)findViewById(R.id.tv_status4);
        hama_status = (TextView)findViewById(R.id.tv_status6);
        self_anxiety_status = (TextView)findViewById(R.id.tv_status5);
        sleep_quality_status = (TextView)findViewById(R.id.tv_status7);
        self_evalution_status = (TextView)findViewById(R.id.tv_status8);
        general_info = Constants.getGeneral_info();
        medication_info = Constants.getMedication_info();
        risk_factor_info = Constants.getRisk_factor_info();
        seattle_info = Constants.getSeattle_info();
        hama_info = Constants.getHama_info();
        self_anxiety_info = Constants.getSelf_anxiety_info();
        sleep_quality_info = Constants.getSleep_quality_info();
        self_evalution_info = Constants.getSelf_evalution_info();
        if (general_info == null)
            general_status.setText("还未填写");
        if (medication_info == null)
            medication_status.setText("还未填写");
        if (risk_factor_info == null)
            risk_factor_status.setText("还未填写");
        if (seattle_info == null)
            seattle_status.setText("还未填写");
        if (hama_info == null)
            hama_status.setText("还未填写");
        if (self_anxiety_info == null)
            self_anxiety_status.setText("还未填写");
        if (sleep_quality_info == null)
            sleep_quality_status.setText("还未填写");
        if (self_evalution_info == null)
            self_evalution_status.setText("还未填写");
        if (steps == null)
            tv_step_number_result.setText("还未测量");
        btn_commit_main = (Button)findViewById(R.id.bt_commit_main);
        et_id = (EditText)findViewById(R.id.et_id);
        et_name = (EditText)findViewById(R.id.et_name);
        et_age = (EditText)findViewById(R.id.et_age);
        et_tel = (EditText)findViewById(R.id.et_tel);
        et_address = (EditText)findViewById(R.id.et_address);
        rb_boy = (RadioButton)findViewById(R.id.rb_boy);
        rb_girl = (RadioButton)findViewById(R.id.rb_girl);
        cb_diabetes = (CheckBox)findViewById(R.id.cb_diabetes);
        cb_high_blood_pressure = (CheckBox)findViewById(R.id.high_blood_pressure);
        cb_diabetes = (CheckBox) findViewById(R.id.cb_diabetes);

        et_address.setEnabled(false);
        et_name.setEnabled(false);
        et_age.setEnabled(false);
        et_tel.setEnabled(false);
        et_id.setEnabled(false);
        rb_boy.setEnabled(false);
        rb_girl.setEnabled(false);
        cb_diabetes.setEnabled(false);
        cb_high_blood_pressure.setEnabled(false);
        cb_diabetes.setEnabled(false);
        getAllstr = Constants.getAllstrs();
        getAllstrs = getAllstr.split(",");
        et_id.setText(getAllstrs[0]);
        et_name.setText(getAllstrs[1]);
        et_age.setText(getAllstrs[3]);
        et_tel.setText(getAllstrs[4]);
        et_address.setText(getAllstrs[5]);
        if (getAllstrs[2].equals("0")) {
            rb_boy.setChecked(true);
        } else {
            rb_girl.setChecked(true);
        }
        if (getAllstrs[6].equals("0")) {
            cb_diabetes.setChecked(true);
            return;
        }
        if (getAllstrs[6].equals("1")) {
            cb_high_blood_pressure.setChecked(true);
            return;
        }
        if (getAllstrs[6].equals("2")) {
            cb_diabetes.setChecked(true);
            cb_high_blood_pressure.setChecked(true);
            return;
        }
        cb_diabetes.setChecked(false);
        cb_high_blood_pressure.setChecked(false);
    }

    private void initEvent() {
        ll_general_activity.setOnClickListener(this);
        ll_medication_activity.setOnClickListener(this);
        ll_danger_activity.setOnClickListener(this);
        ll_life_activity.setOnClickListener(this);
        ll_anxiety_activity.setOnClickListener(this);
        ll_self_anxiety_activity.setOnClickListener(this);
        ll_sleep_activity.setOnClickListener(this);
        ll_self_activity.setOnClickListener(this);
        btn_commit_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJSON3();
            }
        });
    }


    private void openDialog() {
        (new AlertDialog.Builder(this))
                .setTitle("消息提示框")
                .setMessage("确定退出吗")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            mp.stop();
            mp.release();
        }
            }).show(); }

//    private void remindUser() {
//        this.mp = MediaPlayer.create(this, 2131099648);
//        this.mp.start();
//        TipHelper.Vibrate(this, new long[] { 800L, 1000L, 800L, 1000L, 800L, 1000L, 800L, 1000L, 800L, 1000L }, false);
//        this.bt_start.setEnabled(true);
//        openDialog();
//    }

    private void setJSON3() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.e(TAG, "onResponse: "+s);
                        LemonBubble.getRightBubbleInfo()// 增加无限点语法修改bubbleInfo的特性
                                .setTitle("提交成功")
                                .setTitleFontSize(12)// 修改字体大小
                                .setTitleColor(Color.parseColor("#a269af73"))
                                .setMaskColor(Color.argb(100, 0, 0, 0))// 修改蒙版颜色
                                .show(MainQSActivity.this, 2000);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainQSActivity.this,"连接服务器失败，请检查网络连接",Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                Log.e(TAG, "getParams: "+getAllstr+"week:"+Constants.getWeek_no() + "   userid:"+GlobalData.getUserid());
                map.put("userid", GlobalData.getUserid());
                map.put("week_num", Constants.getWeek_no());
                map.put("sex", getAllstrs[2]);
                map.put("tel", getAllstrs[4]);
                map.put("age", getAllstrs[3]);
                map.put("address", getAllstrs[5]);
                map.put("illness", getAllstrs[6]);
                map.put("username", getAllstrs[1]);
                map.put("data_1", general_info);
                map.put("data_2", medication_info);
                map.put("data_3", risk_factor_info);
                map.put("data_4", seattle_info);
                map.put("data_5", hama_info);
                map.put("data_6", self_anxiety_info);
                map.put("data_7", sleep_quality_info);
                map.put("data_8", self_evalution_info);
                map.put("score_4", seattle_score + "");
                map.put("score_5", hama_score + "");
                map.put("score_6", self_anxiety_score + "");
                map.put("score_7", sleep_quality_score + "");
                map.put("score_8", self_evalution_score + "");
                map.put("steps", Constants.getSteps());
                Log.e(TAG, "getParams: "+map.toString() );
                return map;
            }
        };
        requestQueue.add(stringRequest);
       }

    private void setUnEditable(EditText paramEditText) {
        paramEditText.setFocusable(false);
        paramEditText.setFocusableInTouchMode(false);
    }

//    private void startTimer() {
//        Log.i(TAG, "startTimer: ");
//        this.btn_commit_main.setEnabled(false);
//        this.btn_commit_main.setTextColor(-7829368);
//        if (this.timerTask == null) {
//            this.timerTask = new TimerTask() {
//                public void run() {
//                    if (MainQSActivity.this.tenMesc == 0)
//                        MainQSActivity.this.stopTimer();
//                }
//            };
//            this.timer.schedule(this.timerTask, 10L, 10L);
//        }
//    }

//    private void stopTimer() {
//        this.handler.sendEmptyMessage(3);
//        Log.i(TAG, "stopTimer: ");
//        if (this.timerTask != null) {
//            this.tenMesc = 36000;
//            this.timerTask.cancel();
//            this.timerTask = null;
//        }
//    }

//    private void updateStepCount() {
//        Log.e(TAG, "updateStepCount: " + this.mStepSum);
//        this.tv_step_number.setText("����������" + this.mStepSum + "��");
//        this.dialProgress.setValue(this.mStepSum);
//        this.currentStepNumber = this.mStepSum;
//        if (String.valueOf(this.currentStepNumber) != null) {
//            int i = (int)this.dialProgress.getMaxValue();
//            this.distance = this.mStepSum * 0.7D / 1000.0D;
//            this.energy = this.distance * 120.0D;
//            double d = (new BigDecimal(this.distance)).setScale(2, 4).doubleValue();
//            this.tv_distance.setText(d + " km");
//            d = (new BigDecimal(this.energy)).setScale(1, 4).doubleValue();
//            this.tv_energy.setText(d + " cal");
//            d = this.mStepSum / i;
//            if (d < 0.3D) {
//                this.tv_level.setText("������");
//                return;
//            }
//            if (d < 0.7D) {
//                this.tv_level.setText("��������");
//                return;
//            }
//            if (d < 1.0D) {
//                this.tv_level.setText("��������");
//                return;
//            }
//            this.tv_level.setText("����");
//            return;
//        }
//        Toast.makeText(this, "error", 0).show();
//    }
//
//    public void initExpandView() {
//        this.mLinearLayout.setClickable(true);
//        this.mLinearLayout.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View param1View) {
//                if (MainQSActivity.this.mExpandView.getVisibility() == 8) {
//                    MainQSActivity.this.mExpandView.setVisibility(0);
//                    MainQSActivity.this.mTextView.setText("������������");
//                    MainQSActivity.this.mImageView.setImageDrawable(MainQSActivity.this.getResources().getDrawable(2130837665));
//                    return;
//                }
//                MainQSActivity.this.mExpandView.setVisibility(8);
//                MainQSActivity.this.mTextView.setText("������������");
//                MainQSActivity.this.mImageView.setImageDrawable(MainQSActivity.this.getResources().getDrawable(2130837611));
//            }
//        });
//    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_general_info:
                startActivity(new Intent(MainQSActivity.this,GeneralActivity.class));
                finish();
                break;
            case R.id.ll_medication:
                startActivity(new Intent(MainQSActivity.this,MedicationActivity.class));
                finish();
                break;
            case R.id.ll_danger:
                startActivity(new Intent(MainQSActivity.this,RiskFactorActivity.class));
                break;
            case R.id.ll_life:
                startActivity(new Intent(MainQSActivity.this,SeattleActivity.class));
                break;
            case R.id.ll_self_anxiety_activity:
                startActivity(new Intent(MainQSActivity.this,SelfAnxietyActivity.class));
                break;
            case R.id.ll_anxiety:
                startActivity(new Intent(MainQSActivity.this,HAHAAnxietyActivity.class));
                break;
            case R.id.ll_sleep:
                startActivity(new Intent(MainQSActivity.this,SleepQualityIndexActivity.class));
                break;
            case R.id.ll_self :
                startActivity(new Intent(MainQSActivity.this,SelfEvalutionActivity.class));
                break;
            default:
                break;
        }
        finish();
    }


    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        this.timer.cancel();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: ");
        super.onStart();
        general_info = Constants.getGeneral_info();
        medication_info = Constants.getMedication_info();
        risk_factor_info = Constants.getRisk_factor_info();
        seattle_info = Constants.getSeattle_info();
        hama_info = Constants.getHama_info();
        self_anxiety_info = Constants.getSelf_anxiety_info();
        sleep_quality_info = Constants.getSleep_quality_info();
        self_evalution_info = Constants.getSelf_evalution_info();
        seattle_score = Constants.getSeattle_score();
        hama_score = Constants.getHama_score();
        self_anxiety_score = Constants.getSelf_anxiety_score();
        self_evalution_score = Constants.getSelf_evalution_score();
        sleep_quality_score = Constants.getSleep_quality_score();
        steps = Constants.getSteps();
        String logStr = "general_info = " + general_info + "\nmedication_info = " + medication_info +
                "\nrisk_factor_info = " + risk_factor_info + "\nseattle_info = " + seattle_info +
                "\nhama_info = " + hama_info + "\nself_anxiety_info = " + self_anxiety_info +
                "\nsleep_quality_info = " + sleep_quality_info +
                "\nself_evalution_info = " + self_evalution_info;
        Log.e(TAG, "onStart: " + logStr);
        if (general_info.equals("")) {
            general_status.setText("还未填写");
        } else {
            general_status.setText("已填写");
            general_status.setTextColor(Color.GRAY);
        }
        if (medication_info.equals("")) {
            medication_status.setText("还未填写");
        } else {
            medication_status.setText("已填写");
            medication_status.setTextColor(Color.GRAY);
        }
        if (risk_factor_info.equals("")) {
            risk_factor_status.setText("还未填写");
        } else {
            risk_factor_status.setText("已填写");
            risk_factor_status.setTextColor(Color.GRAY);
        }
        if (seattle_info.equals("")) {
            seattle_status.setText("还未填写");
        } else if (seattle_score != -1.0D) {
            seattle_status.setText(seattle_score + "分");
            seattle_status.setTextColor(Color.GRAY);
        } else {
            seattle_status.setText("请计算得分");
        }
        if (hama_info.equals("")) {
            hama_status.setText("还未填写");
        } else if (hama_score != -1) {
            hama_status.setText(hama_score + "分");
            if (hama_score < 14) {
                hama_status.setTextColor(Color.RED);
            } else if (hama_score < 21) {
                hama_status.setTextColor(Color.YELLOW);
            } else if (hama_score < 29) {
                hama_status.setTextColor(Color.parseColor("#FFA500"));
            } else {
                hama_status.setTextColor(Color.BLUE);
            }
        } else {
            hama_status.setText("请计算得分");
        }
        if (self_anxiety_info.equals("")) {
            self_anxiety_status.setText("还未填写");
        } else if (self_anxiety_score != -1) {
            self_anxiety_status.setText(self_anxiety_score + "分");
            if (self_anxiety_score < 50) {
                self_anxiety_status.setTextColor(Color.RED);
            } else if (self_anxiety_score <= 59) {
                self_anxiety_status.setTextColor(Color.YELLOW);
            } else if (self_anxiety_score <= 69) {
                self_anxiety_status.setTextColor(Color.parseColor("#FFA500"));
            } else {
                self_anxiety_status.setTextColor(Color.BLUE);
            }
        } else {
            self_anxiety_status.setText("请计算得分");
        }
        if (sleep_quality_info.equals("")) {
            sleep_quality_status.setText("还未填写");
        } else if (sleep_quality_score != -1) {
            sleep_quality_status.setText(sleep_quality_score + "分");
            if (sleep_quality_score <= 5 && sleep_quality_score >= 0) {
                sleep_quality_status.setTextColor(Color.RED);
            } else if (sleep_quality_score <= 10 && sleep_quality_score >= 6) {
                sleep_quality_status.setTextColor(Color.YELLOW);
            } else if (sleep_quality_score <= 15 && sleep_quality_score >= 11) {
                sleep_quality_status.setTextColor(Color.parseColor("#FFA500"));
            } else {
                sleep_quality_status.setTextColor(Color.BLUE);
            }
        } else {
            hama_status.setText("请计算得分");
        }
        if (self_evalution_info.equals("")) {
            self_evalution_status.setText("还未填写");
        } else if (self_evalution_score != -1) {
            self_evalution_status.setText(self_evalution_score + "分");
            self_evalution_status.setTextColor(Color.BLUE);
        } else {
            hama_status.setText("请计算得分");
        }
        if (steps.equals("")) {
            tv_step_number_result.setText("还未测量");
            return;
        }
        tv_step_number_result.setText("共计" + Constants.getSteps() + "步");
    }
//
//    class TodayStepCounterCall implements Handler.Callback {
//        public boolean handleMessage(Message param1Message) {
//            switch (param1Message.what) {
//                default:
//                    return false;
//                case 0:
//                    break;
//            }
//            if (MainQSActivity.this.iSportStepInterface != null) {
//                int i = 0;
//                try {
//                    int j = MainQSActivity.this.iSportStepInterface.getCurrentTimeSportStep();
//                    i = j;
//                } catch (RemoteException param1Message) {
//                    param1Message.printStackTrace();
//                }
//                if (MainQSActivity.this.mStepSum != i) {
//                    MainQSActivity.access$1802(MainQSActivity.this, i);
//                    MainQSActivity.this.updateStepCount();
//                }
//            }
//            MainQSActivity.this.mDelayHandler.sendEmptyMessageDelayed(0, MainQSActivity.this.TIME_INTERVAL_REFRESH);
//            return false;
//        }
//    }
}
