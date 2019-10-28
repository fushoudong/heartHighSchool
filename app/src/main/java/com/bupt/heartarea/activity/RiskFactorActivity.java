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

public class RiskFactorActivity extends AppCompatActivity {
    private int[] R_id_no;
    private int[] R_id_yes;
    private Button btn_risk_commit;
    private String getRiskFactor;
    private String[] getRiskFactors;
    private ImageView iv_risk_factor_back;
    private RadioButton[] rb_risk_no;
    private RadioButton rb_risk_no1;
    private RadioButton rb_risk_no2;
    private RadioButton rb_risk_no3;
    private RadioButton rb_risk_no4;
    private RadioButton rb_risk_no5;
    private RadioButton rb_risk_no6;
    private RadioButton rb_risk_no7;
    private RadioButton rb_risk_no8;
    private String[] rb_risk_selected;
    private String rb_risk_selected1;
    private String rb_risk_selected2;
    private String rb_risk_selected3;
    private String rb_risk_selected4;
    private String rb_risk_selected5;
    private String rb_risk_selected6;
    private String rb_risk_selected7;
    private String rb_risk_selected8;
    private RadioButton[] rb_risk_yes;
    private RadioButton rb_risk_yes1;
    private RadioButton rb_risk_yes2;
    private RadioButton rb_risk_yes3;
    private RadioButton rb_risk_yes4;
    private RadioButton rb_risk_yes5;
    private RadioButton rb_risk_yes6;
    private RadioButton rb_risk_yes7;
    private RadioButton rb_risk_yes8;
    private boolean flag = true;
    private String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_factor_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_risk_factor_back = (ImageView)findViewById(R.id.iv_risk_factor_back);
        btn_risk_commit = (Button)findViewById(R.id.btn_risk_factor_commit);
        rb_risk_yes = new RadioButton[] { rb_risk_yes1, rb_risk_yes2, rb_risk_yes3, rb_risk_yes4,
                rb_risk_yes5, rb_risk_yes6, rb_risk_yes7, rb_risk_yes8 };
        rb_risk_no = new RadioButton[] { rb_risk_no1, rb_risk_no2, rb_risk_no3, rb_risk_no4,
                rb_risk_no5, rb_risk_no6, rb_risk_no7, rb_risk_no8 };
        rb_risk_selected = new String[] { rb_risk_selected1, rb_risk_selected2, rb_risk_selected3,
                rb_risk_selected4, rb_risk_selected5, rb_risk_selected6,
                rb_risk_selected7, rb_risk_selected8 };
        R_id_yes = new int[] { R.id.btn_risk_yes1, R.id.btn_risk_yes2, R.id.btn_risk_yes3, R.id.btn_risk_yes4,
                R.id.btn_risk_yes5, R.id.btn_risk_yes6, R.id.btn_risk_yes7, R.id.btn_risk_yes8 };
        R_id_no = new int[] { R.id.btn_risk_no1, R.id.btn_risk_no2, R.id.btn_risk_no3, R.id.btn_risk_no4,
                R.id.btn_risk_no5, R.id.btn_risk_no6, R.id.btn_risk_no7, R.id.btn_risk_no8 };
        for (int b = 0; b < 8; b++) {
            rb_risk_yes[b] = (RadioButton)findViewById(R_id_yes[b]);
            rb_risk_no[b] = (RadioButton)findViewById(R_id_no[b]);
        }
        getRiskFactor = Constants.getRisk_factor_info();
        if (!getRiskFactor.equals("")) {
            getRiskFactors = getRiskFactor.split(",");
            for (int b = 0; b < 8; b++) {
                if (getRiskFactors[b].equals("0")) {
                    rb_risk_yes[b].setChecked(true);
                } else if (getRiskFactors[b].equals("1")) {
                    rb_risk_no[b].setChecked(true);
                }
            }
        }
    }

    private void initEvent() {
        iv_risk_factor_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                openDialog();
            }
        });
        getRiskFactor = Constants.getRisk_factor_info();
        if (getRiskFactor.equals("")) {
            setParamsTrue();
        } else {
            setParamsFalse();
            setParamsTrue();
        }
        btn_risk_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                String str2 = "";
                String str1 = "";
                byte b;
                for (b = 0; b < 8; b++) {
                    str2 = str2 + "rb" + b + true + " = " + rb_risk_selected[b] + "\n";
                    str1 = str1 + rb_risk_selected[b] + ",";
                }
                Log.e(TAG, "onClick: "+str2);
                str1 = str1.substring(0, str1.length() - 1);
                String[] test = str1.split(",");

                for (int i=0;i<test.length;i++){
                    if (test[i].equals(null)){
                        flag = false;
                        break;
                    }
                }
                if (flag == false){
                    Toast.makeText(RiskFactorActivity.this, "您还有未选择项", Toast.LENGTH_SHORT).show();
                }else {
                    Constants.setRisk_factor_info(str1);
                    Log.e(TAG, "onClick: "+Constants.getRisk_factor_info());
                    Intent intent = new Intent(RiskFactorActivity.this,MainQSActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setParamsFalse() {
        for (byte b = 0; b < 8; b++) {
            if (rb_risk_yes[b].isChecked()) {
                rb_risk_selected[b] = "0";
            } else if (rb_risk_no[b].isChecked()) {
                rb_risk_selected[b] = "1";
            } else {
                rb_risk_selected[b] = null;
            }
        }
    }

    private void setParamsTrue() {
        for (int b = 0; b < 8; b++) {
            final int finalB = b;
            rb_risk_yes[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_risk_selected[finalB] = "0";
                }
            });
        }
        for (int b = 0; b < 8; b++) {
            final int finalB = b;
            rb_risk_no[b].setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    rb_risk_selected[finalB] = "1";
                }
            });
        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(RiskFactorActivity.this, MainQSActivity.class);
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
