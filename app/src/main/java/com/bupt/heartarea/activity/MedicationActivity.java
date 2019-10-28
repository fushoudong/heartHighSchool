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

public class MedicationActivity extends Activity {
    private static final String TAG = "MedicationActivity";
    private int[] R_id_no;
    private int[] R_id_yes;
    private Button btn_commit;
    private String getMedication;
    private String[] getMedications;
    private ImageView iv_medication_back;
    private RadioButton[] rb_medication_no;
    private RadioButton rb_medication_no1;
    private RadioButton rb_medication_no2;
    private RadioButton rb_medication_no3;
    private RadioButton rb_medication_no4;
    private RadioButton rb_medication_no5;
    private String[] rb_medication_selected;
    private String rb_medication_selected1;
    private String rb_medication_selected2;
    private String rb_medication_selected3;
    private String rb_medication_selected4;
    private String rb_medication_selected5;
    private RadioButton[] rb_medication_yes;
    private RadioButton rb_medication_yes1;
    private RadioButton rb_medication_yes2;
    private RadioButton rb_medication_yes3;
    private RadioButton rb_medication_yes4;
    private RadioButton rb_medication_yes5;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_information);
        initView();
        initEvent();

    }

    private void initView() {
        R_id_yes = new int[] { R.id.btn_medication_yes1, R.id.btn_medication_yes2, R.id.btn_medication_yes3,
                R.id.btn_medication_yes4, R.id.btn_medication_yes5 };
        R_id_no = new int[] { R.id.btn_medication_no1, R.id.btn_medication_no2, R.id.btn_medication_no3,
                R.id.btn_medication_no4, R.id.btn_medication_no5 };
        iv_medication_back = (ImageView)findViewById(R.id.iv_medication_back);
        rb_medication_yes = new RadioButton[] { rb_medication_yes1, rb_medication_yes2, rb_medication_yes3,
                rb_medication_yes4, rb_medication_yes5 };
        rb_medication_no = new RadioButton[] { rb_medication_no1, rb_medication_no2, rb_medication_no3,
                rb_medication_no4, rb_medication_no5 };
        rb_medication_selected = new String[] { rb_medication_selected1, rb_medication_selected2,
                rb_medication_selected3, rb_medication_selected4, rb_medication_selected5 };
        for (int b = 0; b < 5; b++) {
            rb_medication_yes[b] = (RadioButton)findViewById(R_id_yes[b]);
            rb_medication_no[b] = (RadioButton)findViewById(R_id_no[b]);
        }
        btn_commit = (Button)findViewById(R.id.bt_medication_commit);
        getMedication = Constants.getMedication_info();
        Log.e(TAG, "initView: "+getMedication );
        if (!getMedication.equals("")) {
            getMedications = getMedication.split(",");
            for (int b = 0; b < 5; b++) {
                if (getMedications[b].equals("0")) {
                    rb_medication_yes[b].setChecked(true);
                } else if (getMedications[b].equals("1")) {
                    rb_medication_no[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_medication_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog();
            }
        });
        getMedication = Constants.getMedication_info();
        Log.e(TAG, "initEvent: "+getMedication );
        if (getMedication.equals("")) {
            setParamsTrue();
        } else {
            setParamsFalse();
            setParamsTrue();
        }
        btn_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                String str2 = "";
                String str1 = "";
                Log.e(TAG, "onClick: ");
                for (int b = 0; b < 5; b++) {
                    str1 = str1 + rb_medication_selected[b] + ",";
                }
                Log.e(TAG, "onClick: "+str1);
                str1 = str1.substring(0, str1.length() - 1);
                String[] test = str1.split(",");

                for (int i=0;i<test.length;i++){
                    if (test[i].equals(null)){
                        flag = false;
                        break;
                    }
                }
                if (flag == false){
                    Toast.makeText(MedicationActivity.this, "您还有未选择项", Toast.LENGTH_SHORT).show();
                }else {
                    Constants.setMedication_info(str1);
                    Log.e(TAG, "onClick: "+Constants.getMedication_info());
                    Intent intent = new Intent(MedicationActivity.this,MainQSActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }


    private void setParamsFalse() {
        for (int b = 0; b < 5; b++) {
            if (rb_medication_yes[b].isChecked()) {
                rb_medication_selected[b] = "0";
            } else if (rb_medication_no[b].isChecked()) {
                rb_medication_selected[b] = "1";
            } else {
                rb_medication_selected[b] = null;
            }
        }
        Log.e(TAG, "setParamsFalse: "+ rb_medication_selected[0]+"."+rb_medication_selected[1]+
                "."+rb_medication_selected[2]+"."+rb_medication_selected[3]+"."+rb_medication_selected[4]);
    }

    private void setParamsTrue() {
        for (int b = 0; b < 5; b++) {
            final int finalB = b;
            rb_medication_yes[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_medication_selected[finalB] = "0";
                    Log.e(TAG, "onClick: "+"rb_medication_selected["+finalB+"] :"
                            +rb_medication_selected[finalB]);
                }
            });
        }
        for (int b = 0; b < 5; b++) {
            final int finalB = b;
            rb_medication_no[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_medication_selected[finalB] = "1";
                    Log.e(TAG, "onClick: "+"rb_medication_selected["+finalB+"] :"
                            +rb_medication_selected[finalB]);
                }
            });
        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(MedicationActivity.this, MainQSActivity.class);
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
