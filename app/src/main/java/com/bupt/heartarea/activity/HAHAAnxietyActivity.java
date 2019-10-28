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

public class HAHAAnxietyActivity extends Activity {
    private int[] R_id_anxiety1;
    private int[] R_id_anxiety2;
    private int[] R_id_anxiety3;
    private int[] R_id_anxiety4;
    private int[] R_id_anxiety5;
    private RadioButton[] anxiety1;
    private RadioButton anxiety101;
    private RadioButton anxiety102;
    private RadioButton anxiety103;
    private RadioButton anxiety104;
    private RadioButton anxiety105;
    private RadioButton anxiety11;
    private RadioButton anxiety111;
    private RadioButton anxiety112;
    private RadioButton anxiety113;
    private RadioButton anxiety114;
    private RadioButton anxiety115;
    private RadioButton anxiety12;
    private RadioButton anxiety121;
    private RadioButton anxiety122;
    private RadioButton anxiety123;
    private RadioButton anxiety124;
    private RadioButton anxiety125;
    private RadioButton anxiety13;
    private RadioButton anxiety131;
    private RadioButton anxiety132;
    private RadioButton anxiety133;
    private RadioButton anxiety134;
    private RadioButton anxiety135;
    private RadioButton anxiety14;
    private RadioButton anxiety141;
    private RadioButton anxiety142;
    private RadioButton anxiety143;
    private RadioButton anxiety144;
    private RadioButton anxiety145;
    private RadioButton anxiety15;
    private RadioButton[] anxiety2;
    private RadioButton anxiety21;
    private RadioButton anxiety22;
    private RadioButton anxiety23;
    private RadioButton anxiety24;
    private RadioButton anxiety25;
    private RadioButton[] anxiety3;
    private RadioButton anxiety31;
    private RadioButton anxiety32;
    private RadioButton anxiety33;
    private RadioButton anxiety34;
    private RadioButton anxiety35;
    private RadioButton[] anxiety4;
    private RadioButton anxiety41;
    private RadioButton anxiety42;
    private RadioButton anxiety43;
    private RadioButton anxiety44;
    private RadioButton anxiety45;
    private RadioButton[] anxiety5;
    private RadioButton anxiety51;
    private RadioButton anxiety52;
    private RadioButton anxiety53;
    private RadioButton anxiety54;
    private RadioButton anxiety55;
    private RadioButton anxiety61;
    private RadioButton anxiety62;
    private RadioButton anxiety63;
    private RadioButton anxiety64;
    private RadioButton anxiety65;
    private RadioButton anxiety71;
    private RadioButton anxiety72;
    private RadioButton anxiety73;
    private RadioButton anxiety74;
    private RadioButton anxiety75;
    private RadioButton anxiety81;
    private RadioButton anxiety82;
    private RadioButton anxiety83;
    private RadioButton anxiety84;
    private RadioButton anxiety85;
    private RadioButton anxiety91;
    private RadioButton anxiety92;
    private RadioButton anxiety93;
    private RadioButton anxiety94;
    private RadioButton anxiety95;
    private Button btn_hama_commit;
    private String getHama = "";
    private String[] getHamas;
    private int hama_score = 0;
    private ImageView iv_hama_back;
    private String[] rb_anxiety_selected;
    private String rb_anxiety_selected1;
    private String rb_anxiety_selected2;
    private String rb_anxiety_selected3;
    private String rb_anxiety_selected4;
    private String rb_anxiety_selected5;
    private String rb_anxiety_selected6;
    private String rb_anxiety_selected7;
    private String rb_anxiety_selected8;
    private String rb_anxiety_selected9;
    private String rb_anxiety_selected10;
    private String rb_anxiety_selected11;
    private String rb_anxiety_selected12;
    private String rb_anxiety_selected13;
    private String rb_anxiety_selected14;
    private int[] score;
    private boolean flag;
    private static final String TAG = "TAG";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hama_anxiety_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_hama_back = (ImageView)findViewById(R.id.iv_hama_back);
        btn_hama_commit = (Button)findViewById(R.id.btn_hama_commit);
        anxiety1 = new RadioButton[] {
                anxiety11, anxiety21, anxiety31, anxiety41, anxiety51, anxiety61, anxiety71, anxiety81,
                anxiety91, anxiety101, anxiety111, anxiety121, anxiety131, anxiety141 };
        anxiety2 = new RadioButton[] {
                anxiety12, anxiety22, anxiety32, anxiety42, anxiety52, anxiety62, anxiety72, anxiety82,
                anxiety92, anxiety102, anxiety112, anxiety122, anxiety132, anxiety142 };
        anxiety3 = new RadioButton[] {
                anxiety13, anxiety23, anxiety33, anxiety43, anxiety53, anxiety63, anxiety73, anxiety83,
                anxiety93, anxiety103, anxiety113, anxiety123, anxiety133, anxiety143 };
        anxiety4 = new RadioButton[] {
                anxiety14, anxiety24, anxiety34, anxiety44, anxiety54, anxiety64, anxiety74, anxiety84,
                anxiety94, anxiety104, anxiety114, anxiety124, anxiety134, anxiety144 };
        anxiety5 = new RadioButton[] {
                anxiety15, anxiety25, anxiety35, anxiety45, anxiety55, anxiety65, anxiety75, anxiety85,
                anxiety95, anxiety105, anxiety115, anxiety125, anxiety135, anxiety145 };
        R_id_anxiety1 = new int[] {R.id.anxiety11, R.id.anxiety21, R.id.anxiety31, R.id.anxiety41,
                R.id.anxiety51, R.id.anxiety61, R.id.anxiety71, R.id.anxiety81, R.id.anxiety91,
                R.id.anxiety101, R.id.anxiety111, R.id.anxiety121, R.id.anxiety131, R.id.anxiety141 };
        R_id_anxiety2 = new int[] {R.id.anxiety12, R.id.anxiety22, R.id.anxiety32, R.id.anxiety42,
                R.id.anxiety52, R.id.anxiety62, R.id.anxiety72, R.id.anxiety82, R.id.anxiety92,
                R.id.anxiety102, R.id.anxiety112, R.id.anxiety122, R.id.anxiety132, R.id.anxiety142};
        R_id_anxiety3 = new int[] {R.id.anxiety13, R.id.anxiety23, R.id.anxiety33, R.id.anxiety43,
                R.id.anxiety53, R.id.anxiety63, R.id.anxiety73, R.id.anxiety83, R.id.anxiety93,
                R.id.anxiety103, R.id.anxiety113, R.id.anxiety123, R.id.anxiety133, R.id.anxiety143};
        R_id_anxiety4 = new int[] {R.id.anxiety14, R.id.anxiety24, R.id.anxiety34, R.id.anxiety44,
                R.id.anxiety54, R.id.anxiety64, R.id.anxiety74, R.id.anxiety84, R.id.anxiety94,
                R.id.anxiety104, R.id.anxiety114, R.id.anxiety124, R.id.anxiety134, R.id.anxiety144};
        R_id_anxiety5 = new int[] {R.id.anxiety15, R.id.anxiety25, R.id.anxiety35, R.id.anxiety45,
                R.id.anxiety55, R.id.anxiety65, R.id.anxiety75, R.id.anxiety85, R.id.anxiety95,
                R.id.anxiety105, R.id.anxiety115, R.id.anxiety125, R.id.anxiety135, R.id.anxiety145};
        rb_anxiety_selected = new String[] {
                rb_anxiety_selected1, rb_anxiety_selected2, rb_anxiety_selected3, rb_anxiety_selected4, rb_anxiety_selected5,
                rb_anxiety_selected6, rb_anxiety_selected7, rb_anxiety_selected8, rb_anxiety_selected9, rb_anxiety_selected10,
                rb_anxiety_selected11, rb_anxiety_selected12, rb_anxiety_selected13, rb_anxiety_selected14 };
        byte b;
        for (b = 0; b < 14; b++) {
            anxiety1[b] = (RadioButton)findViewById(R_id_anxiety1[b]);
            anxiety2[b] = (RadioButton)findViewById(R_id_anxiety2[b]);
            anxiety3[b] = (RadioButton)findViewById(R_id_anxiety3[b]);
            anxiety4[b] = (RadioButton)findViewById(R_id_anxiety4[b]);
            anxiety5[b] = (RadioButton)findViewById(R_id_anxiety5[b]);
        }
        score = new int[] {
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1 };
        getHama = Constants.getHama_info();
        if (!getHama.equals("")) {
            getHamas = getHama.split(",");
            for (b = 0; b < 14; b++) {
                if (getHamas[b].equals("0")) {
                    anxiety1[b].setChecked(true);
                } else if (getHamas[b].equals("1")) {
                    anxiety2[b].setChecked(true);
                } else if (getHamas[b].equals("2")) {
                    anxiety3[b].setChecked(true);
                } else if (getHamas[b].equals("3")) {
                    anxiety4[b].setChecked(true);
                } else if (getHamas[b].equals("4")) {
                    anxiety5[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        this.iv_hama_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog();
            }
        });
        this.getHama = Constants.getHama_info();
        if (this.getHama.equals("")) {
            setParamsTrue();
        } else {
            setParamsFalse();
            setParamsTrue();
        }
        this.btn_hama_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                flag = true;
                String str2 = "";
                String str1 = "";
                byte b;
                for (b = 0; b < 14; b++) {
                    str2 = str2 + "rb" + b + true + " = " + rb_anxiety_selected[b] + "\n";
                    str1 = str1 + rb_anxiety_selected[b] + ",";
                }
                str1 = str1.substring(0, str1.length() - 1);
                Log.e(TAG, "onClick: "+str1);
                String[] test = str1.split(",");

                for (int i=0;i<test.length;i++){
                    hama_score = hama_score + score[i];
                    if (test[i].equals("null")){
                        flag = false;
                        Log.e(TAG, "onClick: "+i );
                        break;
                    }
                }
                if (flag){
                    Constants.setHama_info(str1);
                    Constants.setHama_score(hama_score);
                    Log.e(TAG, "onClick: "+Constants.getHama_info() );
                    Log.e(TAG, "onClick: "+Constants.getHama_score() );
                    Intent intent = new Intent(HAHAAnxietyActivity.this,MainQSActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(HAHAAnxietyActivity.this, "您还有未选择项", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setParamsFalse() {
        for (byte b = 0; b < 14; b++) {
            Log.i("anxiety1[" + b + "].isChecked()" + this.anxiety1[b].isChecked() + "\tanxiety2[" + b + "].isChecked()" + this.anxiety2[b].isChecked() + "\tanxiety3[" + b + "].isChecked()" + this.anxiety3[b].isChecked() + "\tanxiety4[" + b + "].isChecked()" + this.anxiety4[b].isChecked() + "\tanxiety5[" + b + "].isChecked()" + this.anxiety5[b].isChecked(), "initEvent: ");
            if (this.anxiety1[b].isChecked()) {
                this.rb_anxiety_selected[b] = "0";
                this.score[b] = 0;
            } else if (this.anxiety2[b].isChecked()) {
                this.rb_anxiety_selected[b] = "1";
                this.score[b] = 1;
            } else if (this.anxiety3[b].isChecked()) {
                this.rb_anxiety_selected[b] = "2";
                this.score[b] = 2;
            } else if (this.anxiety4[b].isChecked()) {
                this.rb_anxiety_selected[b] = "3";
                this.score[b] = 3;
            } else if (this.anxiety5[b].isChecked()) {
                this.rb_anxiety_selected[b] = "4";
                this.score[b] = 4;
            } else {
                this.rb_anxiety_selected[b] = null;
                this.score[b] = -1;
            }
        }
    }

    private void setParamsTrue() {
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            this.anxiety1[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_anxiety_selected[finalI] = "0";
                    score[finalI] = 0;
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            this.anxiety2[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_anxiety_selected[finalI] = "1";
                    score[finalI] = 1;
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            this.anxiety3[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_anxiety_selected[finalI] = "2";
                    score[finalI] = 2;
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            this.anxiety4[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_anxiety_selected[finalI] = "3";
                    score[finalI] = 3;
                }
            });
        }
        for (int b = 0; b < 14; b++) {
            final int finalI = b;
            this.anxiety5[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_anxiety_selected[finalI] = "4";
                    score[finalI] = 4;
                }
            });
        }
    }


    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(HAHAAnxietyActivity.this, MainQSActivity.class);
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
