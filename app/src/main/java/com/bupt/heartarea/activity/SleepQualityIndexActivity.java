package com.bupt.heartarea.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;

public class SleepQualityIndexActivity extends Activity {
    private int[] R_id_sleep1;
    private int[] R_id_sleep2;
    private int[] R_id_sleep3;
    private int[] R_id_sleep4;
    private Button btn_calc;
    private Button btn_sleep_quality_commit;
    private EditText et_qs1;
    private EditText et_qs2;
    private EditText et_qs3;
    private EditText et_qs4;
    private String getSleepQuality;
    private String[] getSleepQualitys;
    private ImageView iv_sleep_quality_back;
    private int[] part;
    private int partB;
    private int partB1;
    private int partB2;
    private int partD;
    private int partD1;
    private double partD2;
    private int[] partE;
    private int partG1;
    private int partG2;
    private String[] rb_selected;
    private String rb_selected5a;
    private String rb_selected5b;
    private String rb_selected5c;
    private String rb_selected5d;
    private String rb_selected5e;
    private String rb_selected5f;
    private String rb_selected5g;
    private String rb_selected5h;
    private String rb_selected5i;
    private String rb_selected5j;
    private String rb_selected6;
    private String rb_selected7;
    private String rb_selected8;
    private String rb_selected9;
    private RadioButton[] rb_sleep_quality1;
    private RadioButton[] rb_sleep_quality2;
    private RadioButton[] rb_sleep_quality3;
    private RadioButton[] rb_sleep_quality4;
    private RadioButton rb_sleep_quality_5a1;
    private RadioButton rb_sleep_quality_5a2;
    private RadioButton rb_sleep_quality_5a3;
    private RadioButton rb_sleep_quality_5a4;
    private RadioButton rb_sleep_quality_5b1;
    private RadioButton rb_sleep_quality_5b2;
    private RadioButton rb_sleep_quality_5b3;
    private RadioButton rb_sleep_quality_5b4;
    private RadioButton rb_sleep_quality_5c1;
    private RadioButton rb_sleep_quality_5c2;
    private RadioButton rb_sleep_quality_5c3;
    private RadioButton rb_sleep_quality_5c4;
    private RadioButton rb_sleep_quality_5d1;
    private RadioButton rb_sleep_quality_5d2;
    private RadioButton rb_sleep_quality_5d3;
    private RadioButton rb_sleep_quality_5d4;
    private RadioButton rb_sleep_quality_5e1;
    private RadioButton rb_sleep_quality_5e2;
    private RadioButton rb_sleep_quality_5e3;
    private RadioButton rb_sleep_quality_5e4;
    private RadioButton rb_sleep_quality_5f1;
    private RadioButton rb_sleep_quality_5f2;
    private RadioButton rb_sleep_quality_5f3;
    private RadioButton rb_sleep_quality_5f4;
    private RadioButton rb_sleep_quality_5g1;
    private RadioButton rb_sleep_quality_5g2;
    private RadioButton rb_sleep_quality_5g3;
    private RadioButton rb_sleep_quality_5g4;
    private RadioButton rb_sleep_quality_5h1;
    private RadioButton rb_sleep_quality_5h2;
    private RadioButton rb_sleep_quality_5h3;
    private RadioButton rb_sleep_quality_5h4;
    private RadioButton rb_sleep_quality_5i1;
    private RadioButton rb_sleep_quality_5i2;
    private RadioButton rb_sleep_quality_5i3;
    private RadioButton rb_sleep_quality_5i4;
    private RadioButton rb_sleep_quality_5j1;
    private RadioButton rb_sleep_quality_5j2;
    private RadioButton rb_sleep_quality_5j3;
    private RadioButton rb_sleep_quality_5j4;
    private RadioButton rb_sleep_quality_61;
    private RadioButton rb_sleep_quality_62;
    private RadioButton rb_sleep_quality_63;
    private RadioButton rb_sleep_quality_64;
    private RadioButton rb_sleep_quality_71;
    private RadioButton rb_sleep_quality_72;
    private RadioButton rb_sleep_quality_73;
    private RadioButton rb_sleep_quality_74;
    private RadioButton rb_sleep_quality_81;
    private RadioButton rb_sleep_quality_82;
    private RadioButton rb_sleep_quality_83;
    private RadioButton rb_sleep_quality_84;
    private RadioButton rb_sleep_quality_91;
    private RadioButton rb_sleep_quality_92;
    private RadioButton rb_sleep_quality_93;
    private RadioButton rb_sleep_quality_94;
    private int sleep_quality_score = 0;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private TextView tv_sleep_day;
    private TextView tv_sleep_final;
    private TextView tv_sleep_in_time;
    private TextView tv_sleep_medication;
    private TextView tv_sleep_quality;
    private TextView tv_sleep_time;
    private TextView tv_sleep_xiaolv;
    private TextView tv_sleep_zhangai;
    private boolean flag;
    private int sumQS = 0;
    private int sumScore = 0;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_quality_index_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_sleep_quality_back = (ImageView)findViewById(R.id.iv_sleep_quality);
        btn_sleep_quality_commit = (Button)findViewById(R.id.btn_slepp_quality_commit);
        btn_sleep_quality_commit.setClickable(false);
        btn_calc = (Button)findViewById(R.id.btn_calc);
        rb_sleep_quality1 = new RadioButton[] {
                rb_sleep_quality_5a1, rb_sleep_quality_5b1, rb_sleep_quality_5c1, rb_sleep_quality_5d1,
                rb_sleep_quality_5e1, rb_sleep_quality_5f1, rb_sleep_quality_5g1, rb_sleep_quality_5h1,
                rb_sleep_quality_5i1, rb_sleep_quality_5j1, rb_sleep_quality_61, rb_sleep_quality_71,
                rb_sleep_quality_81, rb_sleep_quality_91 };
        rb_sleep_quality2 = new RadioButton[] {
                rb_sleep_quality_5a2, rb_sleep_quality_5b2, rb_sleep_quality_5c2, rb_sleep_quality_5d2,
                rb_sleep_quality_5e2, rb_sleep_quality_5f2, rb_sleep_quality_5g2, rb_sleep_quality_5h2,
                rb_sleep_quality_5i2, rb_sleep_quality_5j2, rb_sleep_quality_62, rb_sleep_quality_72,
                rb_sleep_quality_82, rb_sleep_quality_92 };
        rb_sleep_quality3 = new RadioButton[] {
                rb_sleep_quality_5a3, rb_sleep_quality_5b3, rb_sleep_quality_5c3, rb_sleep_quality_5d3,
                rb_sleep_quality_5e3, rb_sleep_quality_5f3, rb_sleep_quality_5g3, rb_sleep_quality_5h3,
                rb_sleep_quality_5i3, rb_sleep_quality_5j3, rb_sleep_quality_63, rb_sleep_quality_73,
                rb_sleep_quality_83, rb_sleep_quality_93 };
        rb_sleep_quality4 = new RadioButton[] {
                rb_sleep_quality_5a4, rb_sleep_quality_5b4, rb_sleep_quality_5c4, rb_sleep_quality_5d4,
                rb_sleep_quality_5e4, rb_sleep_quality_5f4, rb_sleep_quality_5g4, rb_sleep_quality_5h4,
                rb_sleep_quality_5i4, rb_sleep_quality_5j4, rb_sleep_quality_64, rb_sleep_quality_74,
                rb_sleep_quality_84, rb_sleep_quality_94 };
        rb_selected = new String[] {
                rb_selected5a, rb_selected5b, rb_selected5c, rb_selected5d, rb_selected5e, rb_selected5f,
                rb_selected5g, rb_selected5h, rb_selected5i, rb_selected5j, rb_selected6,
                rb_selected7, rb_selected8, rb_selected9 };
        R_id_sleep1 = new int[] {
                R.id.rb_pittsburgh_sleep_quality_index_5a1, R.id.rb_pittsburgh_sleep_quality_index_5b1,
                R.id.rb_pittsburgh_sleep_quality_index_5c1, R.id.rb_pittsburgh_sleep_quality_index_5d1,
                R.id.rb_pittsburgh_sleep_quality_index_5e1, R.id.rb_pittsburgh_sleep_quality_index_5f1,
                R.id.rb_pittsburgh_sleep_quality_index_5g1, R.id.rb_pittsburgh_sleep_quality_index_5h1,
                R.id.rb_pittsburgh_sleep_quality_index_5i1, R.id.rb_pittsburgh_sleep_quality_index_5j1,
                R.id.rb_pittsburgh_sleep_quality_index_61, R.id.rb_pittsburgh_sleep_quality_index_71,
                R.id.rb_pittsburgh_sleep_quality_index_81, R.id.rb_pittsburgh_sleep_quality_index_91 };
        R_id_sleep2 = new int[] {
                R.id.rb_pittsburgh_sleep_quality_index_5a2, R.id.rb_pittsburgh_sleep_quality_index_5b2,
                R.id.rb_pittsburgh_sleep_quality_index_5c2, R.id.rb_pittsburgh_sleep_quality_index_5d2,
                R.id.rb_pittsburgh_sleep_quality_index_5e2, R.id.rb_pittsburgh_sleep_quality_index_5f2,
                R.id.rb_pittsburgh_sleep_quality_index_5g2, R.id.rb_pittsburgh_sleep_quality_index_5h2,
                R.id.rb_pittsburgh_sleep_quality_index_5i2, R.id.rb_pittsburgh_sleep_quality_index_5j2,
                R.id.rb_pittsburgh_sleep_quality_index_62, R.id.rb_pittsburgh_sleep_quality_index_72,
                R.id.rb_pittsburgh_sleep_quality_index_82, R.id.rb_pittsburgh_sleep_quality_index_92 };
        R_id_sleep3 = new int[] {
                R.id.rb_pittsburgh_sleep_quality_index_5a3, R.id.rb_pittsburgh_sleep_quality_index_5b3,
                R.id.rb_pittsburgh_sleep_quality_index_5c3, R.id.rb_pittsburgh_sleep_quality_index_5d3,
                R.id.rb_pittsburgh_sleep_quality_index_5e3, R.id.rb_pittsburgh_sleep_quality_index_5f3,
                R.id.rb_pittsburgh_sleep_quality_index_5g3, R.id.rb_pittsburgh_sleep_quality_index_5h3,
                R.id.rb_pittsburgh_sleep_quality_index_5i3, R.id.rb_pittsburgh_sleep_quality_index_5j3,
                R.id.rb_pittsburgh_sleep_quality_index_63, R.id.rb_pittsburgh_sleep_quality_index_73,
                R.id.rb_pittsburgh_sleep_quality_index_83, R.id.rb_pittsburgh_sleep_quality_index_93 };
        R_id_sleep4 = new int[] {
                R.id.rb_pittsburgh_sleep_quality_index_5a4, R.id.rb_pittsburgh_sleep_quality_index_5b4,
                R.id.rb_pittsburgh_sleep_quality_index_5c4, R.id.rb_pittsburgh_sleep_quality_index_5d4,
                R.id.rb_pittsburgh_sleep_quality_index_5e4, R.id.rb_pittsburgh_sleep_quality_index_5f4,
                R.id.rb_pittsburgh_sleep_quality_index_5g4, R.id.rb_pittsburgh_sleep_quality_index_5h4,
                R.id.rb_pittsburgh_sleep_quality_index_5i4, R.id.rb_pittsburgh_sleep_quality_index_5j4,
                R.id.rb_pittsburgh_sleep_quality_index_64, R.id.rb_pittsburgh_sleep_quality_index_74,
                R.id.rb_pittsburgh_sleep_quality_index_84, R.id.rb_pittsburgh_sleep_quality_index_94 };
        et_qs1 = (EditText)findViewById(R.id.et_in1);
        et_qs2 = (EditText)findViewById(R.id.et_in2);
        et_qs3 = (EditText)findViewById(R.id.et_in3);
        et_qs4 = (EditText)findViewById(R.id.et_in4);
        byte b;
        for (b = 0; b < 14; b++) {
            rb_sleep_quality1[b] = (RadioButton)findViewById(R_id_sleep1[b]);
            rb_sleep_quality2[b] = (RadioButton)findViewById(R_id_sleep2[b]);
            rb_sleep_quality3[b] = (RadioButton)findViewById(R_id_sleep3[b]);
            rb_sleep_quality4[b] = (RadioButton)findViewById(R_id_sleep4[b]);
        }
        tv_sleep_quality = (TextView)findViewById(R.id.tv_sleep_quality);
        tv_sleep_in_time = (TextView)findViewById(R.id.tv_sleep_in_time);
        tv_sleep_time = (TextView)findViewById(R.id.tv_sleep_time);
        tv_sleep_xiaolv = (TextView)findViewById(R.id.tv_sleep_xiaolv);
        tv_sleep_zhangai = (TextView)findViewById(R.id.tv_sleep_zhangai);
        tv_sleep_medication = (TextView)findViewById(R.id.tv_sleep_medication);
        tv_sleep_day = (TextView)findViewById(R.id.tv_sleep_day);
        tv_sleep_final = (TextView)findViewById(R.id.tv_sleep_final);
        part = new int[] { -1, -1, -1, -1, -1, -1, -1 };
        partE = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        getSleepQuality = Constants.getSleep_quality_info();
        if (!getSleepQuality.equals("")) {
            getSleepQualitys = getSleepQuality.split(",");
            et_qs1.setText(getSleepQualitys[0]);
            et_qs2.setText(getSleepQualitys[1]);
            et_qs3.setText(getSleepQualitys[2]);
            et_qs4.setText(getSleepQualitys[3]);
            for (b = 0; b < 14; b++) {
                if (getSleepQualitys[b + 4].equals("0")) {
                    rb_sleep_quality1[b].setChecked(true);
                } else if (getSleepQualitys[b + 4].equals("1")) {
                    rb_sleep_quality2[b].setChecked(true);
                } else if (getSleepQualitys[b + 4].equals("2")) {
                    rb_sleep_quality3[b].setChecked(true);
                } else {
                    rb_sleep_quality4[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_sleep_quality_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog(); }
        });
        getSleepQuality = Constants.getSleep_quality_info();
        if (getSleepQuality.equals("")) {
            getParamsTrue();
        } else {
            getParamsFalse();
            getParamsTrue();
        }
        btn_calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                btn_sleep_quality_commit.setClickable(true);
                flag = true;
                sumQS = 0;
                sumScore = 0;
                str1 = et_qs1.getText().toString();
                str2 = et_qs2.getText().toString();
                str3 = et_qs3.getText().toString();
                str4 = et_qs4.getText().toString();

                for(int i = 0 ;i < 14 ;i ++){
                    if (rb_selected[i].equals("null")){
                        flag = false;
                        break;
                    }
                }
                if (str1.length() != 0 && str2.length() != 0 && str3.length() != 0 && str4.length() != 0 && flag == true){
                    int toBed = Integer.parseInt(str1);
                    int toAsleep = Integer.parseInt(str2);
                    int toAwake = Integer.parseInt(str3);
                    double allTime = Integer.parseInt(str4);
                    double calcSleepTime;
                    if (toAsleep <= 15){
                        partB1 = 0;
                    }else if (toAsleep <= 30){
                        partB1 = 1;
                    }else if (toAsleep <= 60){
                        partB1 = 2;
                    }else {
                        partB1 = 3;
                    }

                    if (allTime > 7.0D) {
                        part[2] = 0;//睡眠时间得分
                    } else if (allTime > 6.0D) {
                        part[2] = 1;
                    } else if (allTime > 5.0D) {
                        part[2] = 2;
                    } else {
                        part[2] = 3;
                    }
                    if (toBed > 12){
                        calcSleepTime = toAwake + 24 - toBed;
                    }else {
                        if (toBed > toAwake){
                            calcSleepTime = (toAwake + 12) - toBed;
                        }else {
                            calcSleepTime = toAwake - toBed;
                        }
                    }

                    partD2 = allTime/calcSleepTime;
                    if (partD2 > 1.0D) {
                        Toast.makeText(SleepQualityIndexActivity.this, "实际睡眠时间填写有误", Toast.LENGTH_SHORT).show();
                    } else if (partD2 > 0.85D) {
                        Log.e(TAG, "onClick: "+partD2);
                        partD = 0;
                    } else if (partD2 > 0.75D) {
                        Log.e(TAG, "onClick: "+partD2);
                        partD = 1;
                    } else if (partD2 > 0.65D) {
                        Log.e(TAG, "onClick: "+partD2);
                        partD = 2;
                    } else {
                        Log.e(TAG, "onClick: "+partD2);
                        partD = 3;
                    }
                    partB = partB1 + partB2;
                    if (partG2 + partG1 == 0) {
                        part[6] = 0;//日间功能障碍得分
                    } else if (partG2 + partG1 <= 2 && partG2 + partG1 >= 1) {
                        part[6] = 1;
                    } else if (partG2 + partG1 <= 4 && partG2 + partG1 >= 3) {
                        part[6] = 2;
                    } else {
                        part[6] = 3;
                    }
                    part[1] = partB;//入睡时间得分
                    part[3] = partD;//睡眠效率得分
                    for (int i = 0; i < 9; i++){
                        sumQS = sumQS + partE[i];
                    }
                    if (sumQS == 0) {
                        part[4] = 0;//睡眠障碍得分
                    } else if (sumQS <= 9 && sumQS >= 1) {
                        part[4] = 1;
                    } else if (sumQS <= 18 && sumQS >= 10) {
                        part[4] = 2;
                    } else {
                        part[4] = 3;
                    }
                   for (int i = 0; i< 7; i++){
                       sumScore = sumScore + part[i];
                   }
                    tv_sleep_quality.setText(part[0] + "分");
                    tv_sleep_in_time.setText(part[1] + "分");
                    tv_sleep_time.setText(part[2] + "分");
                    tv_sleep_xiaolv.setText(part[3] + "分");
                    tv_sleep_zhangai.setText(part[4] + "分");
                    tv_sleep_medication.setText(part[5] + "分");
                    tv_sleep_day.setText(part[6] + "分");
                    tv_sleep_final.setText(sumScore + "分");
                    Constants.setSleep_quality_score(sumScore);

                }else {
                    Toast.makeText(SleepQualityIndexActivity.this, "您还有未选项！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_sleep_quality_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                String strqs1;
                String strqs2;
                String strqs3;
                String strqs4;
                strqs1 = et_qs1.getText().toString();
                strqs2 = et_qs2.getText().toString();
                strqs3 = et_qs3.getText().toString();
                strqs4 = et_qs4.getText().toString();
                String str2 = tv_sleep_quality.getText().toString();
                String str3 = tv_sleep_in_time.getText().toString();
                String str4 = tv_sleep_time.getText().toString();
                String str5 = tv_sleep_xiaolv.getText().toString();
                String str6 = tv_sleep_zhangai.getText().toString();
                String str7 = tv_sleep_medication.getText().toString();
                String str8 = tv_sleep_day.getText().toString();
                String str9 = tv_sleep_final.getText().toString();
                String part3 =str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6 + "\n" + str7 + "\n" + str8 + "\n" + str9;
                String part1 = strqs1 + "," + strqs2 + "," + strqs3 + "," + strqs4 + ",";
                for (int b = 0; b < 14; b++)
                    part1 = part1 + rb_selected[b] + ",";
                str1 = part1.substring(0, part1.length() - 1);
                if (str2.equals("") && str3.equals("") && str4.equals("") && str5.equals("") && str6.equals("") && str7.equals("") && str8.equals("") && str9.equals("")) {
                    Toast.makeText(SleepQualityIndexActivity.this,"请计算得分",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SleepQualityIndexActivity.this, MainQSActivity.class);
                    Constants.setSleep_quality_info(str1);
                    Constants.setSleep_quality_score(sumScore);
                    Log.e(TAG, "onClick: "+Constants.getSleep_quality_info());
                    Log.e(TAG, "onClick: "+Constants.getSleep_quality_score());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void getParamsFalse() {
        for (int b = 0; b < 14; b++) {
            if (rb_sleep_quality1[b].isChecked()) {
                rb_selected[b] = "0";
                if (b == 0) {
                    partB2 = 0;
                } else if (0 < b && b < 10) {
                    partE[b - 1] = 0;
                } else if (b == 10) {
                    part[0] = 0;
                } else if (b == 11) {
                    part[5] = 0;
                } else if (b == 12) {
                    partG1 = 0;
                } else {
                    partG2 = 0;
                }
            } else if (rb_sleep_quality2[b].isChecked()) {
                rb_selected[b] = "1";
                if (b == 0) {
                    partB2 = 1;
                } else if (b < 10 && b > 0) {
                    partE[b - 1] = 1;
                } else if (b == 10) {
                    part[0] = 1;
                } else if (b == 11) {
                    part[5] = 1;
                } else if (b == 12) {
                    partG1 = 1;
                } else {
                    partG2 = 1;
                }
            } else if (rb_sleep_quality3[b].isChecked()) {
                rb_selected[b] = "2";
                if (b == 0) {
                    partB2 = 2;
                } else if (b < 10 && b>0) {
                    partE[b - 1] = 2;
                } else if (b == 10) {
                    part[0] = 2;
                } else if (b == 11) {
                    part[5] = 2;
                } else if (b == 12) {
                    partG1 = 2;
                } else {
                    partG2 = 2;
                }
            } else if (rb_sleep_quality4[b].isChecked()) {
                rb_selected[b] = "3";
                if (b == 0) {
                    partB2 = 3;
                } else if (b < 10 && b > 0) {
                    partE[b - 1] = 3;
                } else if (b == 10) {
                    part[0] = 3;
                } else if (b == 11) {
                    part[5] = 3;
                } else if (b == 12) {
                    partG1 = 3;
                } else {
                    partG2 = 3;
                }
            }
        }
    }

    private void getParamsTrue() {

        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            rb_sleep_quality1[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "0";
                    if (finalI == 0) {
                        partB2 =  0;
                        return;
                    } else if (finalI < 10 && finalI > 0) {
                        partE[finalI - 1] = 0;
                        return;
                    } else if (finalI == 10) {
                        part[0] = 0;
                        return;
                    } else if (finalI == 11) {
                        part[5] = 0;
                        return;
                    } else if (finalI == 12) {
                        partG1 = 0;
                        return;
                    }else {
                        partG2 = 0;
                    }
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            rb_sleep_quality2[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "1";
                    if (finalI == 0) {
                        partB2 =  1;
                        return;
                    }else if (finalI < 10 && finalI > 0) {
                        partE[finalI - 1] = 1;
                        return;
                    }else if (finalI == 10) {
                        part[0] = 1;
                        return;
                    }else if (finalI == 11) {
                        part[5] = 1;
                        return;
                    }else if (finalI == 12) {
                        partG1 = 1;
                        return;
                    }else {
                        partG2 = 1;
                    }
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            rb_sleep_quality3[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "2";
                    if (finalI == 0) {
                        partB2 = 2;
                        return;
                    }else if (finalI < 10 && finalI > 0) {
                        partE[finalI - 1] = 2;
                        return;
                    }else if (finalI == 10) {
                        part[0] = 2;
                        return;
                    }else if (finalI == 11) {
                        part[5] = 2;
                        return;
                    }else if (finalI == 12) {
                        partG1 = 2;
                        return;
                    }else {
                        partG2 = 2;
                    }
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            rb_sleep_quality4[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_selected[finalI] = "3";
                    if (finalI == 0) {
                        partB2 = 3;
                        return;
                    }else if (finalI < 10 && finalI > 0) {
                        partE[finalI - 1] = 3;
                        return;
                    }else if (finalI == 10) {
                        part[0] = 3;
                        return;
                    }else if (finalI == 11) {
                        part[5] = 3;
                        return;
                    }else if (finalI == 12) {
                        partG1 = 3;
                        return;
                    }else {
                        partG2 = 3;
                    }
                }
            });
        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(SleepQualityIndexActivity.this, MainQSActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        });
        builder.setMessage("您确定要返回主界面吗");
        builder.setTitle("提示！");
        builder.show();
    }
}
