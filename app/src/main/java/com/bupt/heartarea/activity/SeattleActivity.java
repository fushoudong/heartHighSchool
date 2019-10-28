package com.bupt.heartarea.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;

import java.math.BigDecimal;

public class SeattleActivity extends Activity {
    private int[] R_id1;
    private int[] R_id2;
    private int[] R_id3;
    private int[] R_id4;
    private int[] R_id5;
    private int[] R_id_11;
    private int[] R_id_12;
    private int[] R_id_13;
    private int[] R_id_14;
    private int[] R_id_15;
    private int[] R_id_16;
    private Button btn_seattle_commit;
    private String getSeattle;
    private String[] getSeattles;
    private ImageView iv_seattle_back;
    private RadioButton[] rb_seattle1;
    private RadioButton rb_seattle10_1;
    private RadioButton rb_seattle10_2;
    private RadioButton rb_seattle10_3;
    private RadioButton rb_seattle10_4;
    private RadioButton rb_seattle10_5;
    private RadioButton[] rb_seattle11;
    private RadioButton rb_seattle11_1;
    private RadioButton rb_seattle11_2;
    private RadioButton rb_seattle11_3;
    private RadioButton rb_seattle11_4;
    private RadioButton rb_seattle11_5;
    private RadioButton[] rb_seattle12;
    private RadioButton[] rb_seattle13;
    private RadioButton[] rb_seattle14;
    private RadioButton[] rb_seattle15;
    private RadioButton[] rb_seattle16;
    private RadioButton rb_seattle1_11;
    private RadioButton rb_seattle1_12;
    private RadioButton rb_seattle1_13;
    private RadioButton rb_seattle1_14;
    private RadioButton rb_seattle1_15;
    private RadioButton rb_seattle1_16;
    private RadioButton rb_seattle1_21;
    private RadioButton rb_seattle1_22;
    private RadioButton rb_seattle1_23;
    private RadioButton rb_seattle1_24;
    private RadioButton rb_seattle1_25;
    private RadioButton rb_seattle1_26;
    private RadioButton rb_seattle1_31;
    private RadioButton rb_seattle1_32;
    private RadioButton rb_seattle1_33;
    private RadioButton rb_seattle1_34;
    private RadioButton rb_seattle1_35;
    private RadioButton rb_seattle1_36;
    private RadioButton rb_seattle1_41;
    private RadioButton rb_seattle1_42;
    private RadioButton rb_seattle1_43;
    private RadioButton rb_seattle1_44;
    private RadioButton rb_seattle1_45;
    private RadioButton rb_seattle1_46;
    private RadioButton rb_seattle1_51;
    private RadioButton rb_seattle1_52;
    private RadioButton rb_seattle1_53;
    private RadioButton rb_seattle1_54;
    private RadioButton rb_seattle1_55;
    private RadioButton rb_seattle1_56;
    private RadioButton rb_seattle1_61;
    private RadioButton rb_seattle1_62;
    private RadioButton rb_seattle1_63;
    private RadioButton rb_seattle1_64;
    private RadioButton rb_seattle1_65;
    private RadioButton rb_seattle1_66;
    private RadioButton rb_seattle1_71;
    private RadioButton rb_seattle1_72;
    private RadioButton rb_seattle1_73;
    private RadioButton rb_seattle1_74;
    private RadioButton rb_seattle1_75;
    private RadioButton rb_seattle1_76;
    private RadioButton rb_seattle1_81;
    private RadioButton rb_seattle1_82;
    private RadioButton rb_seattle1_83;
    private RadioButton rb_seattle1_84;
    private RadioButton rb_seattle1_85;
    private RadioButton rb_seattle1_86;
    private RadioButton rb_seattle1_91;
    private RadioButton rb_seattle1_92;
    private RadioButton rb_seattle1_93;
    private RadioButton rb_seattle1_94;
    private RadioButton rb_seattle1_95;
    private RadioButton rb_seattle1_96;
    private RadioButton[] rb_seattle2;
    private RadioButton rb_seattle2_1;
    private RadioButton rb_seattle2_2;
    private RadioButton rb_seattle2_3;
    private RadioButton rb_seattle2_4;
    private RadioButton rb_seattle2_5;
    private RadioButton[] rb_seattle3;
    private RadioButton rb_seattle3_1;
    private RadioButton rb_seattle3_2;
    private RadioButton rb_seattle3_3;
    private RadioButton rb_seattle3_4;
    private RadioButton rb_seattle3_5;
    private RadioButton rb_seattle3_6;
    private RadioButton[] rb_seattle4;
    private RadioButton rb_seattle4_1;
    private RadioButton rb_seattle4_2;
    private RadioButton rb_seattle4_3;
    private RadioButton rb_seattle4_4;
    private RadioButton rb_seattle4_5;
    private RadioButton rb_seattle4_6;
    private RadioButton[] rb_seattle5;
    private RadioButton rb_seattle5_1;
    private RadioButton rb_seattle5_2;
    private RadioButton rb_seattle5_3;
    private RadioButton rb_seattle5_4;
    private RadioButton rb_seattle5_5;
    private RadioButton rb_seattle5_6;
    private RadioButton rb_seattle6_1;
    private RadioButton rb_seattle6_2;
    private RadioButton rb_seattle6_3;
    private RadioButton rb_seattle6_4;
    private RadioButton rb_seattle6_5;
    private RadioButton rb_seattle7_1;
    private RadioButton rb_seattle7_2;
    private RadioButton rb_seattle7_3;
    private RadioButton rb_seattle7_4;
    private RadioButton rb_seattle7_5;
    private RadioButton rb_seattle8_1;
    private RadioButton rb_seattle8_2;
    private RadioButton rb_seattle8_3;
    private RadioButton rb_seattle8_4;
    private RadioButton rb_seattle8_5;
    private RadioButton rb_seattle9_1;
    private RadioButton rb_seattle9_2;
    private RadioButton rb_seattle9_3;
    private RadioButton rb_seattle9_4;
    private RadioButton rb_seattle9_5;
    private String[] rb_seattle_selected1;
    private String[] rb_seattle_selected2;
    private String rb_seattled10;
    private String rb_seattled11;
    private String rb_seattled1_1;
    private String rb_seattled1_2;
    private String rb_seattled1_3;
    private String rb_seattled1_4;
    private String rb_seattled1_5;
    private String rb_seattled1_6;
    private String rb_seattled1_7;
    private String rb_seattled1_8;
    private String rb_seattled1_9;
    private String rb_seattled2;
    private String rb_seattled3;
    private String rb_seattled4;
    private String rb_seattled5;
    private String rb_seattled6;
    private String rb_seattled7;
    private String rb_seattled8;
    private String rb_seattled9;
    private int[] score1;
    private int score1_final = 0;
    private double[] score2;
    private double seattle_score = 0.0D;
    private boolean flag;

    private static final String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seattle_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_seattle_back = (ImageView)findViewById(R.id.iv_seattle_back);
        btn_seattle_commit = (Button)findViewById(R.id.btn_seattle_commit);
        rb_seattle11 = new RadioButton[] { rb_seattle1_11, rb_seattle1_21, rb_seattle1_31, rb_seattle1_41,
                rb_seattle1_51, rb_seattle1_61, rb_seattle1_71, rb_seattle1_81, rb_seattle1_91 };
        rb_seattle12 = new RadioButton[] { rb_seattle1_12, rb_seattle1_22, rb_seattle1_32, rb_seattle1_42,
                rb_seattle1_52, rb_seattle1_62, rb_seattle1_72, rb_seattle1_82, rb_seattle1_92 };
        rb_seattle13 = new RadioButton[] { rb_seattle1_13, rb_seattle1_23, rb_seattle1_33, rb_seattle1_43,
                rb_seattle1_53, rb_seattle1_63, rb_seattle1_73, rb_seattle1_83, rb_seattle1_93 };
        rb_seattle14 = new RadioButton[] { rb_seattle1_14, rb_seattle1_24, rb_seattle1_34, rb_seattle1_44,
                rb_seattle1_54, rb_seattle1_64, rb_seattle1_74, rb_seattle1_84, rb_seattle1_94 };
        rb_seattle15 = new RadioButton[] { rb_seattle1_15, rb_seattle1_25, rb_seattle1_35, rb_seattle1_45,
                rb_seattle1_55, rb_seattle1_65, rb_seattle1_75, rb_seattle1_85, rb_seattle1_95 };
        rb_seattle16 = new RadioButton[] { rb_seattle1_16, rb_seattle1_26, rb_seattle1_36, rb_seattle1_46,
                rb_seattle1_56, rb_seattle1_66, rb_seattle1_76, rb_seattle1_86, rb_seattle1_96 };
        rb_seattle1 = new RadioButton[] { rb_seattle2_1, rb_seattle3_1, rb_seattle4_1, rb_seattle5_1,
                rb_seattle6_1, rb_seattle7_1, rb_seattle8_1, rb_seattle9_1, rb_seattle10_1, rb_seattle11_1 };
        rb_seattle2 = new RadioButton[] { rb_seattle2_2, rb_seattle3_2, rb_seattle4_2, rb_seattle5_2,
                rb_seattle6_2, rb_seattle7_2, rb_seattle8_2, rb_seattle9_2, rb_seattle10_2, rb_seattle11_2 };
        rb_seattle3 = new RadioButton[] { rb_seattle2_3, rb_seattle3_3, rb_seattle4_3, rb_seattle5_3,
                rb_seattle6_3, rb_seattle7_3, rb_seattle8_3, rb_seattle9_3, rb_seattle10_3, rb_seattle11_3 };
        rb_seattle4 = new RadioButton[] { rb_seattle2_4, rb_seattle3_4, rb_seattle4_4, rb_seattle5_4,
                rb_seattle6_4, rb_seattle7_4, rb_seattle8_4, rb_seattle9_4, rb_seattle10_4, rb_seattle11_4 };
        rb_seattle5 = new RadioButton[] { rb_seattle2_5, rb_seattle3_5, rb_seattle4_5, rb_seattle5_5,
                rb_seattle6_5, rb_seattle7_5, rb_seattle8_5, rb_seattle9_5, rb_seattle10_5, rb_seattle11_5 };
        rb_seattle_selected1 = new String[] { rb_seattled1_1, rb_seattled1_2, rb_seattled1_3, rb_seattled1_4,
                rb_seattled1_5, rb_seattled1_6, rb_seattled1_7, rb_seattled1_8, rb_seattled1_9 };
        rb_seattle_selected2 = new String[] { rb_seattled2, rb_seattled3, rb_seattled4, rb_seattled5,
                rb_seattled6, rb_seattled7, rb_seattled8, rb_seattled9, rb_seattled10, rb_seattled11 };
        R_id_11 = new int[] { R.id.rb_qs_11, R.id.rb_qs_21, R.id.rb_qs_31, R.id.rb_qs_41, R.id.rb_qs_51,
                R.id.rb_qs_61, R.id.rb_qs_71, R.id.rb_qs_81, R.id.rb_qs_91 };
        R_id_12 = new int[] { R.id.rb_qs_12, R.id.rb_qs_22, R.id.rb_qs_32, R.id.rb_qs_42, R.id.rb_qs_52,
                R.id.rb_qs_62, R.id.rb_qs_72, R.id.rb_qs_82, R.id.rb_qs_92  };
        R_id_13 = new int[] { R.id.rb_qs_13, R.id.rb_qs_23, R.id.rb_qs_33, R.id.rb_qs_43, R.id.rb_qs_53,
                R.id.rb_qs_63, R.id.rb_qs_73, R.id.rb_qs_83, R.id.rb_qs_93  };
        R_id_14 = new int[] { R.id.rb_qs_14, R.id.rb_qs_24, R.id.rb_qs_34, R.id.rb_qs_44, R.id.rb_qs_54,
                R.id.rb_qs_64, R.id.rb_qs_74, R.id.rb_qs_84, R.id.rb_qs_94  };
        R_id_15 = new int[] { R.id.rb_qs_15, R.id.rb_qs_25, R.id.rb_qs_35, R.id.rb_qs_45, R.id.rb_qs_55,
                R.id.rb_qs_65, R.id.rb_qs_75, R.id.rb_qs_85, R.id.rb_qs_95  };
        R_id_16 = new int[] { R.id.rb_qs_16, R.id.rb_qs_26, R.id.rb_qs_36, R.id.rb_qs_46, R.id.rb_qs_56,
                R.id.rb_qs_66, R.id.rb_qs_76, R.id.rb_qs_86, R.id.rb_qs_96  };
        R_id1 = new int[] { R.id.rb_qs21, R.id.rb_qs31, R.id.rb_qs41, R.id.rb_qs51, R.id.rb_qs61,
                R.id.rb_qs71, R.id.rb_qs81, R.id.rb_qs91, R.id.rb_qs101, R.id.rb_qs111 };
        R_id2 = new int[] { R.id.rb_qs22, R.id.rb_qs32, R.id.rb_qs42, R.id.rb_qs52, R.id.rb_qs62,
                R.id.rb_qs72, R.id.rb_qs82, R.id.rb_qs92, R.id.rb_qs102, R.id.rb_qs112 };
        R_id3 = new int[] { R.id.rb_qs23, R.id.rb_qs33, R.id.rb_qs43, R.id.rb_qs53, R.id.rb_qs63,
                R.id.rb_qs73, R.id.rb_qs83, R.id.rb_qs93, R.id.rb_qs103, R.id.rb_qs113 };
        R_id4 = new int[] { R.id.rb_qs24, R.id.rb_qs34, R.id.rb_qs44, R.id.rb_qs54, R.id.rb_qs64,
                R.id.rb_qs74, R.id.rb_qs84, R.id.rb_qs94, R.id.rb_qs104, R.id.rb_qs114 };
        R_id5 = new int[] { R.id.rb_qs25, R.id.rb_qs35, R.id.rb_qs45, R.id.rb_qs55, R.id.rb_qs65,
                R.id.rb_qs75, R.id.rb_qs85, R.id.rb_qs95, R.id.rb_qs105, R.id.rb_qs115 };
        rb_seattle3_6 = (RadioButton)findViewById(R.id.rb_qs36);
        rb_seattle4_6 = (RadioButton)findViewById(R.id.rb_qs46);
        rb_seattle5_6 = (RadioButton)findViewById(R.id.rb_qs56);
        byte b;
        for (b = 0; b < 9; b++) {
            rb_seattle11[b] = (RadioButton)findViewById(R_id_11[b]);
            rb_seattle12[b] = (RadioButton)findViewById(R_id_12[b]);
            rb_seattle13[b] = (RadioButton)findViewById(R_id_13[b]);
            rb_seattle14[b] = (RadioButton)findViewById(R_id_14[b]);
            rb_seattle15[b] = (RadioButton)findViewById(R_id_15[b]);
            rb_seattle16[b] = (RadioButton)findViewById(R_id_16[b]);
        }
        for (b = 0; b < 10; b++) {
            rb_seattle1[b] = (RadioButton)findViewById(R_id1[b]);
            rb_seattle2[b] = (RadioButton)findViewById(R_id2[b]);
            rb_seattle3[b] = (RadioButton)findViewById(R_id3[b]);
            rb_seattle4[b] = (RadioButton)findViewById(R_id4[b]);
            rb_seattle5[b] = (RadioButton)findViewById(R_id5[b]);
        }
        score1 = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        score2 = new double[] {
                -1.0D, -1.0D, -1.0D, -1.0D, -1.0D, -1.0D, -1.0D, -1.0D, -1.0D, -1.0D,
                -1.0D };
        getSeattle = Constants.getSeattle_info();
        if (!getSeattle.equals("")) {
            getSeattles = getSeattle.split(",");
            for (b = 0; b < 9; b++) {
                if (getSeattles[b].equals("0")) {
                    rb_seattle11[b].setChecked(true);
                } else if (getSeattles[b].equals("1")) {
                    rb_seattle12[b].setChecked(true);
                } else if (getSeattles[b].equals("2")) {
                    rb_seattle13[b].setChecked(true);
                } else if (getSeattles[b].equals("3")) {
                    rb_seattle14[b].setChecked(true);
                } else if (getSeattles[b].equals("4")) {
                    rb_seattle15[b].setChecked(true);
                } else {
                    rb_seattle16[b].setChecked(true);
                }
            }
            for (b = 9; b < 19; b++) {
                if (b == 10) {
                    if (getSeattles[b].equals("0")) {
                        rb_seattle1[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("1")) {
                        rb_seattle2[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("2")) {
                        rb_seattle3[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("3")) {
                        rb_seattle4[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("4")) {
                        rb_seattle5[b - 9].setChecked(true);
                    } else {
                        rb_seattle3_6.setChecked(true);
                    }
                } else if (b == 11) {
                    if (getSeattles[b].equals("0")) {
                        rb_seattle1[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("1")) {
                        rb_seattle2[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("2")) {
                        rb_seattle3[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("3")) {
                        rb_seattle4[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("4")) {
                        rb_seattle5[b - 9].setChecked(true);
                    } else {
                        rb_seattle4_6.setChecked(true);
                    }
                } else if (b == 12) {
                    if (getSeattles[b].equals("0")) {
                        rb_seattle1[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("1")) {
                        rb_seattle2[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("2")) {
                        rb_seattle3[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("3")) {
                        rb_seattle4[b - 9].setChecked(true);
                    } else if (getSeattles[b].equals("4")) {
                        rb_seattle5[b - 9].setChecked(true);
                    } else {
                        rb_seattle5_6.setChecked(true);
                    }
                } else if (getSeattles[b].equals("0")) {
                    rb_seattle1[b - 9].setChecked(true);
                } else if (getSeattles[b].equals("1")) {
                    rb_seattle2[b - 9].setChecked(true);
                } else if (getSeattles[b].equals("2")) {
                    rb_seattle3[b - 9].setChecked(true);
                } else if (getSeattles[b].equals("3")) {
                    rb_seattle4[b - 9].setChecked(true);
                } else {
                    rb_seattle5[b - 9].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_seattle_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog();
            }
        });
        getSeattle = Constants.getSeattle_info();
        if (getSeattle.equals("")) {
            getParamsTrue();
        } else {
            getParamsFalse();
            getParamsTrue();
        }
        btn_seattle_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                score1_final = 0;
                seattle_score = 0.0d;
                flag = true;
                String str2 = "";
                String str3 = "";
                double d = 0.0D;
                byte b1;
                for (b1 = 0; b1 < 9; b1++) {
                    str2 = str2 + "rb1_" + b1 + true + " = " + rb_seattle_selected1[b1] + "\n";
                    str3 = str3 + rb_seattle_selected1[b1] + ",";
                }
                for (b1 = 0; b1 < 10; b1++) {
                    str2 = str2 + "rb" + (b1 + 2) + " = " + rb_seattle_selected2[b1] + "\n";
                    str3 = str3 + rb_seattle_selected2[b1] + ",";
                }
                for (b1 = 0; b1 < 9; b1++)
                    score1_final = score1_final + score1[b1];
                score2[0] = (score1_final - 9) / 45.0D * 100.0D;
                for (b1 = 0; b1 < 11; b1++)
                    d += score2[b1];
                BigDecimal bigDecimal = new BigDecimal(d / 11.0D);
                seattle_score = bigDecimal.setScale(2, 4).doubleValue();
                String str1 = str3.substring(0, str3.length() - 1);

                String[] test = str1.split(",");
                for (int i = 0;i<19;i++){
                    if (test[i].equals("null")){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    Intent intent = new Intent(SeattleActivity.this, MainQSActivity.class);
                    Constants.setSeattle_info(str1);
                    Constants.setSeattle_score(seattle_score);
                    Log.e(TAG, "onClick: " + Constants.getSeattle_info());
                    Log.e(TAG, "onClick: " + Constants.getSeattle_score());
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SeattleActivity.this, "您还有未选项", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getParamsFalse() {
        byte b;
        for (b = 0; b < 9; b++) {
            if (rb_seattle11[b].isChecked()) {
                rb_seattle_selected1[b] = "0";
                score1[b] = 1;
            } else if (rb_seattle12[b].isChecked()) {
                rb_seattle_selected1[b] = "1";
                score1[b] = 2;
            } else if (rb_seattle13[b].isChecked()) {
                rb_seattle_selected1[b] = "2";
                score1[b] = 3;
            } else if (rb_seattle14[b].isChecked()) {
                rb_seattle_selected1[b] = "3";
                score1[b] = 4;
            } else if (rb_seattle15[b].isChecked()) {
                rb_seattle_selected1[b] = "4";
                score1[b] = 5;
            } else if (rb_seattle16[b].isChecked()) {
                rb_seattle_selected1[b] = "5";
                score1[b] = 6;
            } else {
                rb_seattle_selected1[b] = null;
                score1[b] = -1;
            }
        }
        for (b = 0; b < 10; b++) {
            if (b == 1) {
                if (rb_seattle1[b].isChecked()) {
                    rb_seattle_selected2[b] = "0";
                    score2[2] = 0.0D;
                } else if (rb_seattle2[b].isChecked()) {
                    rb_seattle_selected2[b] = "1";
                    score2[2] = 20.0D;
                } else if (rb_seattle3[b].isChecked()) {
                    rb_seattle_selected2[b] = "2";
                    score2[2] = 40.0D;
                } else if (rb_seattle4[b].isChecked()) {
                    rb_seattle_selected2[b] = "3";
                    score2[2] = 60.0D;
                } else if (rb_seattle5[b].isChecked()) {
                    rb_seattle_selected2[b] = "4";
                    score2[2] = 80.0D;
                } else if (rb_seattle3_6.isChecked()) {
                    rb_seattle_selected2[b] = "5";
                    score2[2] = 100.0D;
                } else {
                    rb_seattle_selected2[b] = null;
                    score2[2] = -1.0D;
                }
            } else if (b == 2) {
                if (rb_seattle1[b].isChecked()) {
                    rb_seattle_selected2[b] = "0";
                    score2[3] = 0.0D;
                } else if (rb_seattle2[b].isChecked()) {
                    rb_seattle_selected2[b] = "1";
                    score2[3] = 20.0D;
                } else if (rb_seattle3[b].isChecked()) {
                    rb_seattle_selected2[b] = "2";
                    score2[3] = 40.0D;
                } else if (rb_seattle4[b].isChecked()) {
                    rb_seattle_selected2[b] = "3";
                    score2[3] = 60.0D;
                } else if (rb_seattle5[b].isChecked()) {
                    rb_seattle_selected2[b] = "4";
                    score2[3] = 80.0D;
                } else if (rb_seattle4_6.isChecked()) {
                    rb_seattle_selected2[b] = "5";
                    score2[3] = 100.0D;
                } else {
                    rb_seattle_selected2[b] = null;
                    score2[3] = -1.0D;
                }
            } else if (b == 3) {
                if (rb_seattle1[b].isChecked()) {
                    rb_seattle_selected2[b] = "0";
                    score2[4] = 0.0D;
                } else if (rb_seattle2[b].isChecked()) {
                    rb_seattle_selected2[b] = "1";
                    score2[4] = 20.0D;
                } else if (rb_seattle3[b].isChecked()) {
                    rb_seattle_selected2[b] = "2";
                    score2[4] = 40.0D;
                } else if (rb_seattle4[b].isChecked()) {
                    rb_seattle_selected2[b] = "3";
                    score2[4] = 60.0D;
                } else if (rb_seattle5[b].isChecked()) {
                    rb_seattle_selected2[b] = "4";
                    score2[4] = 80.0D;
                } else if (rb_seattle5_6.isChecked()) {
                    rb_seattle_selected2[b] = "5";
                    score2[4] = 100.0D;
                } else {
                    rb_seattle_selected2[b] = null;
                    score2[3] = -1.0D;
                }
            } else if (rb_seattle1[b].isChecked()) {
                rb_seattle_selected2[b] = "0";
                score2[b + 1] = 0.0D;
            } else if (rb_seattle2[b].isChecked()) {
                rb_seattle_selected2[b] = "1";
                score2[b + 1] = 25.0D;
            } else if (rb_seattle3[b].isChecked()) {
                rb_seattle_selected2[b] = "2";
                score2[b + 1] = 50.0D;
            } else if (rb_seattle4[b].isChecked()) {
                rb_seattle_selected2[b] = "3";
                score2[b + 1] = 75.0D;
            } else if (rb_seattle5[b].isChecked()) {
                rb_seattle_selected2[b] = "4";
                score2[b + 1] = 100.0D;
            } else {
                rb_seattle_selected2[b] = null;
                score2[b + 1] = -1.0D;
            }
        }
    }

    private void getParamsTrue() {

        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle11[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "0";
                    score1[finalI] = 1;
                }
            });
        }
        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle12[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "1";
                    score1[finalI] = 2;
                }
            });
        }
        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle13[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "2";
                    score1[finalI] = 3;
                }
            });
        }
        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle14[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "3";
                    score1[finalI] = 4;
                }
            });
        }
        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle15[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "4";
                    score1[finalI] = 5;
                }
            });
        }
        for (int b = 0; b < 9; b++) {
            final int  finalI = b;
            rb_seattle16[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected1[finalI] = "5";
                    score1[finalI] = 6;
                }
            });
        }
        for (int b = 0; b < 10; b++) {
            final int  finalI = b;
            rb_seattle1[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected2[finalI] = "0";
                    score2[finalI + 1] = 0.0D;
                }
            });
        }
        for (int b = 0; b < 10; b++) {
            final int  finalI = b;
            rb_seattle2[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected2[finalI] = "1";
                    if (finalI == 1) {
                        score2[finalI + 1] = 20.0D;
                        return;
                    }
                    if (finalI == 2) {
                        score2[finalI + 1] = 20.0D;
                        return;
                    }
                    if (finalI == 3) {
                        score2[finalI + 1] = 20.0D;
                        return;
                    }
                    score2[finalI + 1] = 25.0D;
                }
            });
        }
        for (int b = 0; b < 10; b++) {
            final int  finalI = b;
            rb_seattle3[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected2[finalI] = "2";
                    if (finalI == 1) {
                        score2[finalI + 1] = 40.0D;
                        return;
                    }
                    if (finalI == 2) {
                        score2[finalI + 1] = 40.0D;
                        return;
                    }
                    if (finalI == 3) {
                        score2[finalI + 1] = 40.0D;
                        return;
                    }
                    score2[finalI + 1] = 50.0D;
                }
            });
        }
        for (int b = 0; b < 10; b++) {
            final int  finalI = b;
            rb_seattle4[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected2[finalI] = "3";
                    if (finalI == 1) {
                        score2[finalI + 1] = 60.0D;
                        return;
                    }
                    if (finalI == 2) {
                        score2[finalI + 1] = 60.0D;
                        return;
                    }
                    if (finalI == 3) {
                        score2[finalI + 1] = 60.0D;
                        return;
                    }
                    score2[finalI + 1] = 75.0D;
                }
            });
        }
        for (int b = 0; b < 10; b++) {
            final int  finalI = b;
            rb_seattle5[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_seattle_selected2[finalI] = "4";
                    if (finalI == 1) {
                        score2[finalI + 1] = 80.0D;
                        return;
                    }
                    if (finalI == 2) {
                        score2[finalI + 1] = 80.0D;
                        return;
                    }
                    if (finalI == 3) {
                        score2[finalI + 1] = 80.0D;
                        return;
                    }
                    score2[finalI + 1] = 100.0D;
                }
            });
        }
        rb_seattle3_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                rb_seattle_selected2[1] = "5";
                score2[2] = 100.0D;
            }
        });
        rb_seattle4_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                rb_seattle_selected2[2] = "5";
                score2[3] = 100.0D;
            }
        });
        rb_seattle5_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                rb_seattle_selected2[3] = "5";
                score2[4] = 100.0D;
            }
        });
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(SeattleActivity.this, MainQSActivity.class);
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
