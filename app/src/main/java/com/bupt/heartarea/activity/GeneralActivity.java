package com.bupt.heartarea.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.bupt.heartarea.R;
import com.bupt.heartarea.constants.Constants;

public class GeneralActivity extends AppCompatActivity {
    private String blood_pressure;
    private Button bt_commit;
    private String culture;
    private EditText et_blood_pressure;
    private EditText et_culture;
    private EditText et_height;
    private EditText et_ldl_c;
    private EditText et_tc;
    private EditText et_tg;
    private EditText et_waist;
    private EditText et_weight;
    private String getGeneral = "";
    private String[] getGenerals;
    private String height;
    private ImageView iv_general_back;
    private String ldl_c;
    private String mSmoke;
    private String mSpinner;
    private RadioButton rb_smoke_no;
    private RadioButton rb_smoke_yes;
    private Spinner sp_work;
    private String tc;
    private String tg;
    private String waist;
    private String weight;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_information);
        initView();
        initEvent();
    }

    private void initView() {
        iv_general_back = (ImageView)findViewById(R.id.iv_general_back);
        et_tg = (EditText)findViewById(R.id.et_tg);
        et_tc = (EditText)findViewById(R.id.et_tc);
        et_ldl_c = (EditText)findViewById(R.id.et_ldl_c);
        et_height = (EditText)findViewById(R.id.et_height);
        et_blood_pressure = (EditText)findViewById(R.id.et_blood_pressure);
        et_weight = (EditText)findViewById(R.id.et_weight);
        et_waist = (EditText)findViewById(R.id.et_waist);
        et_culture = (EditText)findViewById(R.id.et_culture);
        rb_smoke_yes = (RadioButton)findViewById(R.id.rb_smoke_yes);
        rb_smoke_no = (RadioButton)findViewById(R.id.rb_smoke_no);
        sp_work = (Spinner)findViewById(R.id.sp_work);
        bt_commit = (Button)findViewById(R.id.bt_general_commit);
        getGeneral = Constants.getGeneral_info();
        if (!getGeneral.equals("")) {
            getGenerals = getGeneral.split(",");
            et_tg.setText(getGenerals[0]);
            et_tc.setText(getGenerals[1]);
            et_ldl_c.setText(getGenerals[2]);
            et_height.setText(getGenerals[3]);
            et_blood_pressure.setText(getGenerals[4]);
            et_weight.setText(getGenerals[5]);
            et_waist.setText(getGenerals[6]);
            et_culture.setText(getGenerals[8]);
            if (getGenerals[7].equals("0")) {
                rb_smoke_yes.setChecked(true);
            } else if (getGenerals[7].equals("1")) {
                rb_smoke_no.setChecked(true);
            }
            if (getGenerals[9].equals("小学或以下")) {
                sp_work.setSelection(0);
                return;
            }
        } else {
            return;
        }
        if (getGenerals[9].equals("初中")) {
            sp_work.setSelection(1);
            return;
        }
        if (getGenerals[9].equals("高中")) {
            sp_work.setSelection(2);
            return;
        }
        sp_work.setSelection(3);
    }

    private void initEvent() {
        mSmoke = "";
        rb_smoke_yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSmoke = "0";
                Log.e("TAG", "onClick: "+mSmoke);
            }
        });
        rb_smoke_no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSmoke = "1";
                Log.e("TAG", "onClick: "+mSmoke);
            }
        });
        getGeneral = Constants.getGeneral_info();
        if (getGeneral.equals("")) {
            rb_smoke_no.setChecked(true);
        } else {
            if (rb_smoke_yes.isChecked()) {
                mSmoke = "0";
                Log.e("TAG", "initEvent: "+ rb_smoke_no.isChecked());
            } else if (rb_smoke_no.isChecked()) {
                mSmoke = "1";
                Log.e("TAG", "initEvent: "+ rb_smoke_no.isChecked());
            } else {
                mSmoke = null;
            }
        }
        iv_general_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { openDialog(); }
        });
        sp_work.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                mSpinner = (String) sp_work.getSelectedItem();
            }

            public void onNothingSelected(AdapterView<?> param1AdapterView) {}
        });
        bt_commit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                tg = et_tg.getText().toString();
                tc = et_tc.getText().toString();
                ldl_c = et_ldl_c.getText().toString();
                height = et_height.getText().toString();
                blood_pressure = et_blood_pressure.getText().toString();
                weight = et_weight.getText().toString();
                waist = et_waist.getText().toString();
                culture = et_culture.getText().toString();
               // "TG=" + tg + ";TC=" + tc + ";LDL_C=" + ldl_c + ";height=" + height + ";blood_pressure=" + blood_pressure + ";weight" + weight + ";waist=" + waist + ";culture" + culture + ";smoke=" + mSmoke + ";work=" + mSpinner + ";";
                String str = tg + "," + tc + "," + ldl_c + "," + height + "," + blood_pressure + "," + weight + "," + waist + "," + mSmoke + "," + culture + "," + mSpinner;
                if (tg.length() != 0 && tc.length() != 0 && ldl_c.length() != 0 && height.length() != 0 && blood_pressure.length() != 0 && weight.length() != 0 && waist.length() != 0 && culture.length() != 0 && mSmoke.length() != 0) {
                    Intent intent = new Intent(GeneralActivity.this, MainQSActivity.class);
                    Constants.setGeneral_info(str);
                    Log.e("TAG", "onClick: "+Constants.getGeneral_info());
                    startActivity(intent);
                    finish();
                    return;
                }else {
                    Toast.makeText(GeneralActivity.this, "您还有未选项", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Intent intent = new Intent(GeneralActivity.this, MainQSActivity.class);
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
