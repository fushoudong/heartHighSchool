package com.bupt.heartarea.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;

public class SelfAnxietyActivity extends AppCompatActivity {
    private int[] R_id_self_anxiety1;
    private int[] R_id_self_anxiety2;
    private int[] R_id_self_anxiety3;
    private int[] R_id_self_anxiety4;
    private Button btn_self_anxiety_commit;
    private String getSelfAnxiety;
    private String[] getSelfAnxietys;
    private int hama_score = 0;
    private ImageView iv_self_anxiety_back;
    private RadioButton[] rb_self_anixety1;
    private RadioButton rb_self_anixety101;
    private RadioButton rb_self_anixety102;
    private RadioButton rb_self_anixety103;
    private RadioButton rb_self_anixety104;
    private RadioButton rb_self_anixety11;
    private RadioButton rb_self_anixety111;
    private RadioButton rb_self_anixety112;
    private RadioButton rb_self_anixety113;
    private RadioButton rb_self_anixety114;
    private RadioButton rb_self_anixety12;
    private RadioButton rb_self_anixety121;
    private RadioButton rb_self_anixety122;
    private RadioButton rb_self_anixety123;
    private RadioButton rb_self_anixety124;
    private RadioButton rb_self_anixety13;
    private RadioButton rb_self_anixety131;
    private RadioButton rb_self_anixety132;
    private RadioButton rb_self_anixety133;
    private RadioButton rb_self_anixety134;
    private RadioButton rb_self_anixety14;
    private RadioButton rb_self_anixety141;
    private RadioButton rb_self_anixety142;
    private RadioButton rb_self_anixety143;
    private RadioButton rb_self_anixety144;
    private RadioButton rb_self_anixety151;
    private RadioButton rb_self_anixety152;
    private RadioButton rb_self_anixety153;
    private RadioButton rb_self_anixety154;
    private RadioButton rb_self_anixety161;
    private RadioButton rb_self_anixety162;
    private RadioButton rb_self_anixety163;
    private RadioButton rb_self_anixety164;
    private RadioButton rb_self_anixety171;
    private RadioButton rb_self_anixety172;
    private RadioButton rb_self_anixety173;
    private RadioButton rb_self_anixety174;
    private RadioButton rb_self_anixety181;

    private RadioButton rb_self_anixety182;
    private RadioButton rb_self_anixety183;
    private RadioButton rb_self_anixety184;
    private RadioButton rb_self_anixety191;
    private RadioButton rb_self_anixety192;
    private RadioButton rb_self_anixety193;
    private RadioButton rb_self_anixety194;
    private RadioButton[] rb_self_anixety2;
    private RadioButton rb_self_anixety201;
    private RadioButton rb_self_anixety202;
    private RadioButton rb_self_anixety203;
    private RadioButton rb_self_anixety204;
    private RadioButton rb_self_anixety21;
    private RadioButton rb_self_anixety22;
    private RadioButton rb_self_anixety23;
    private RadioButton rb_self_anixety24;
    private RadioButton[] rb_self_anixety3;
    private RadioButton rb_self_anixety31;
    private RadioButton rb_self_anixety32;
    private RadioButton rb_self_anixety33;
    private RadioButton rb_self_anixety34;
    private RadioButton[] rb_self_anixety4;
    private RadioButton rb_self_anixety41;
    private RadioButton rb_self_anixety42;
    private RadioButton rb_self_anixety43;
    private RadioButton rb_self_anixety44;
    private RadioButton rb_self_anixety51;
    private RadioButton rb_self_anixety52;
    private RadioButton rb_self_anixety53;
    private RadioButton rb_self_anixety54;
    private RadioButton rb_self_anixety61;
    private RadioButton rb_self_anixety62;
    private RadioButton rb_self_anixety63;
    private RadioButton rb_self_anixety64;
    private RadioButton rb_self_anixety71;
    private RadioButton rb_self_anixety72;
    private RadioButton rb_self_anixety73;
    private RadioButton rb_self_anixety74;
    private RadioButton rb_self_anixety81;
    private RadioButton rb_self_anixety82;
    private RadioButton rb_self_anixety83;
    private RadioButton rb_self_anixety84;
    private RadioButton rb_self_anixety91;
    private RadioButton rb_self_anixety92;
    private RadioButton rb_self_anixety93;
    private RadioButton rb_self_anixety94;
    private String[] rb_self_anxiety_selected;
    private String rb_self_anxiety_selected1;
    private String rb_self_anxiety_selected10;
    private String rb_self_anxiety_selected11;
    private String rb_self_anxiety_selected12;
    private String rb_self_anxiety_selected13;
    private String rb_self_anxiety_selected14;
    private String rb_self_anxiety_selected15;
    private String rb_self_anxiety_selected16;
    private String rb_self_anxiety_selected17;
    private String rb_self_anxiety_selected18;
    private String rb_self_anxiety_selected19;
    private String rb_self_anxiety_selected2;
    private String rb_self_anxiety_selected20;
    private String rb_self_anxiety_selected3;
    private String rb_self_anxiety_selected4;
    private String rb_self_anxiety_selected5;
    private String rb_self_anxiety_selected6;
    private String rb_self_anxiety_selected7;
    private String rb_self_anxiety_selected8;
    private String rb_self_anxiety_selected9;
    private int[] score;
    private static boolean flag;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_anxiety_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_self_anxiety_back = (ImageView)findViewById(R.id.iv_self_anxiety_back);
        btn_self_anxiety_commit = (Button)findViewById(R.id.btn_self_anxiety_commit);
        rb_self_anixety1 = new RadioButton[] {
                rb_self_anixety11, rb_self_anixety21, rb_self_anixety31, rb_self_anixety41, rb_self_anixety51,
                rb_self_anixety61, rb_self_anixety71, rb_self_anixety81, rb_self_anixety91, rb_self_anixety101,
                rb_self_anixety111, rb_self_anixety121, rb_self_anixety131, rb_self_anixety141, rb_self_anixety151,
                rb_self_anixety161, rb_self_anixety171, rb_self_anixety181, rb_self_anixety191, rb_self_anixety201 };
        rb_self_anixety2 = new RadioButton[] {
                rb_self_anixety12, rb_self_anixety22, rb_self_anixety32, rb_self_anixety42, rb_self_anixety52,
                rb_self_anixety62, rb_self_anixety72, rb_self_anixety82, rb_self_anixety92, rb_self_anixety102,
                rb_self_anixety112, rb_self_anixety122, rb_self_anixety132, rb_self_anixety142, rb_self_anixety152,
                rb_self_anixety162, rb_self_anixety172, rb_self_anixety182, rb_self_anixety192, rb_self_anixety202 };
        rb_self_anixety3 = new RadioButton[] {
                rb_self_anixety13, rb_self_anixety23, rb_self_anixety33, rb_self_anixety43, rb_self_anixety53,
                rb_self_anixety63, rb_self_anixety73, rb_self_anixety83, rb_self_anixety93, rb_self_anixety103,
                rb_self_anixety113, rb_self_anixety123, rb_self_anixety133, rb_self_anixety143, rb_self_anixety153,
                rb_self_anixety163, rb_self_anixety173, rb_self_anixety183, rb_self_anixety193, rb_self_anixety203 };
        rb_self_anixety4 = new RadioButton[] {
                rb_self_anixety14, rb_self_anixety24, rb_self_anixety34, rb_self_anixety44, rb_self_anixety54,
                rb_self_anixety64, rb_self_anixety74, rb_self_anixety84, rb_self_anixety94, rb_self_anixety104,
                rb_self_anixety114, rb_self_anixety124, rb_self_anixety134, rb_self_anixety144, rb_self_anixety154,
                rb_self_anixety164, rb_self_anixety174, rb_self_anixety184, rb_self_anixety194, rb_self_anixety204 };
        rb_self_anxiety_selected = new String[] {
                rb_self_anxiety_selected1, rb_self_anxiety_selected2, rb_self_anxiety_selected3, rb_self_anxiety_selected4,
                rb_self_anxiety_selected5, rb_self_anxiety_selected6, rb_self_anxiety_selected7, rb_self_anxiety_selected8,
                rb_self_anxiety_selected9, rb_self_anxiety_selected10, rb_self_anxiety_selected11, rb_self_anxiety_selected12,
                rb_self_anxiety_selected13, rb_self_anxiety_selected14, rb_self_anxiety_selected15, rb_self_anxiety_selected16,
                rb_self_anxiety_selected17, rb_self_anxiety_selected18, rb_self_anxiety_selected19, rb_self_anxiety_selected20 };
        R_id_self_anxiety1 = new int[] { R.id.rb_sas11, R.id.rb_sas21, R.id.rb_sas31, R.id.rb_sas41, R.id.rb_sas51, R.id.rb_sas61,
                R.id.rb_sas71, R.id.rb_sas81, R.id.rb_sas91, R.id.rb_sas101, R.id.rb_sas111, R.id.rb_sas121, R.id.rb_sas131,
                R.id.rb_sas141, R.id.rb_sas151, R.id.rb_sas161, R.id.rb_sas171, R.id.rb_sas181, R.id.rb_sas191, R.id.rb_sas201};
        R_id_self_anxiety2 = new int[] {R.id.rb_sas12, R.id.rb_sas22, R.id.rb_sas32, R.id.rb_sas42, R.id.rb_sas52, R.id.rb_sas62,
                R.id.rb_sas72, R.id.rb_sas82, R.id.rb_sas92, R.id.rb_sas102, R.id.rb_sas112, R.id.rb_sas122, R.id.rb_sas132,
                R.id.rb_sas142, R.id.rb_sas152, R.id.rb_sas162, R.id.rb_sas172, R.id.rb_sas182, R.id.rb_sas192, R.id.rb_sas202};
        R_id_self_anxiety3 = new int[] {R.id.rb_sas13, R.id.rb_sas23, R.id.rb_sas33, R.id.rb_sas43, R.id.rb_sas53, R.id.rb_sas63,
                R.id.rb_sas73, R.id.rb_sas83, R.id.rb_sas93, R.id.rb_sas103, R.id.rb_sas113, R.id.rb_sas123, R.id.rb_sas133,
                R.id.rb_sas143, R.id.rb_sas153, R.id.rb_sas163, R.id.rb_sas173, R.id.rb_sas183, R.id.rb_sas193, R.id.rb_sas203};
        R_id_self_anxiety4 = new int[] {R.id.rb_sas14, R.id.rb_sas24, R.id.rb_sas34, R.id.rb_sas44, R.id.rb_sas54, R.id.rb_sas64,
                R.id.rb_sas74, R.id.rb_sas84, R.id.rb_sas94, R.id.rb_sas104, R.id.rb_sas114, R.id.rb_sas124, R.id.rb_sas134,
                R.id.rb_sas144, R.id.rb_sas154, R.id.rb_sas164, R.id.rb_sas174, R.id.rb_sas184, R.id.rb_sas194, R.id.rb_sas204};
        for (int b = 0; b < 20; b++) {
            rb_self_anixety1[b] = (RadioButton)findViewById(R_id_self_anxiety1[b]);
            rb_self_anixety2[b] = (RadioButton)findViewById(R_id_self_anxiety2[b]);
            rb_self_anixety3[b] = (RadioButton)findViewById(R_id_self_anxiety3[b]);
            rb_self_anixety4[b] = (RadioButton)findViewById(R_id_self_anxiety4[b]);
        }
        score = new int[] {
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        getSelfAnxiety = Constants.getSelf_anxiety_info();
        if (!getSelfAnxiety.equals("")) {
            getSelfAnxietys = getSelfAnxiety.split(",");
            for (int b = 0; b < 20; b++) {
                if (getSelfAnxietys[b].equals("0")) {
                    rb_self_anixety1[b].setChecked(true);
                } else if (getSelfAnxietys[b].equals("1")) {
                    rb_self_anixety2[b].setChecked(true);
                } else if (getSelfAnxietys[b].equals("2")) {
                    rb_self_anixety3[b].setChecked(true);
                } else {
                    rb_self_anixety4[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_self_anxiety_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog();
            }
        });
        getSelfAnxiety = Constants.getSelf_anxiety_info();
        if (getSelfAnxiety.equals("")) {
            setParamsTrue();
        } else {
            setParamsFalse();
            setParamsTrue();
        }
        btn_self_anxiety_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                flag = true;
                hama_score = 0;
                String str2 = "";
                String str1 = "";
                for (int b = 0; b < 20; b++) {
                    str2 = str2 + "rb" + b + true + " = " + rb_self_anxiety_selected[b] + "\n";
                    str1 = str1 + rb_self_anxiety_selected[b] + ",";
                    hama_score = hama_score + score[b];
                }
                str1 = str1.substring(0, str1.length() - 1);
                Log.e(TAG, "onClick: "+str1 );
                String[] test = str1.split(",");

                for (int i=0;i<test.length;i++){
                    if (test[i].equals("null")){
                        flag = false;
                        Log.e(TAG, "onClick: " + i );
                        break;
                    }
                }
                if (flag ){
                    Constants.setSelf_anxiety_info(str1);
                    Constants.setSelf_anxiety_score(hama_score);
                    Log.e(TAG, "onClick: "+Constants.getSelf_anxiety_info() );
                    Log.e(TAG, "onClick: "+Constants.getSelf_anxiety_score() );
                    Intent intent = new Intent(SelfAnxietyActivity.this,MainQSActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SelfAnxietyActivity.this, "您还有未选择项", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void setParamsFalse() {
        for (byte b = 0; b < 20; b++) {
            if (rb_self_anixety1[b].isChecked()) {
                rb_self_anxiety_selected[b] = "0";
                score[b] = 4;
            } else if (rb_self_anixety2[b].isChecked()) {
                rb_self_anxiety_selected[b] = "1";
                score[b] = 3;
            } else if (rb_self_anixety3[b].isChecked()) {
                rb_self_anxiety_selected[b] = "2";
                score[b] = 2;
            } else if (rb_self_anixety4[b].isChecked()) {
                rb_self_anxiety_selected[b] = "3";
                score[b] = 1;
            } else {
                rb_self_anxiety_selected[b] = null;
                score[b] = -1;
            }
        }
    }

    private void setParamsTrue() {

        for (int b = 0; b < 20; b++) {
            final int finalI = b;
            rb_self_anixety1[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_self_anxiety_selected[finalI] = "0";
                    score[finalI] = 4;
                }
            });
        }
        for (int b = 0; b < 20; b++) {
            final int finalI = b;
            rb_self_anixety2[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_self_anxiety_selected[finalI] = "1";
                    score[finalI] = 3;
                }
            });
        }
        for (int b = 0; b < 20; b++) {
            final int finalI = b;
            rb_self_anixety3[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_self_anxiety_selected[finalI] = "2";
                    score[finalI] = 2;
                }
            });
        }
        for (int b = 0; b < 20; b++) {
            final int finalI = b;
            rb_self_anixety4[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_self_anxiety_selected[finalI] = "3";
                    score[finalI] = 1;
                }
            });
        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(SelfAnxietyActivity.this, MainQSActivity.class);
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
