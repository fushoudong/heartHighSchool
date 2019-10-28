package com.bupt.heartarea.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bupt.heartarea.R;
import com.bupt.heartarea.view.ClipViewLayout;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ClipImageActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ClipImageActivity";
    private ImageView iv_clipBack;
    private ClipViewLayout cvl_circle;
    private ClipViewLayout cvl_rectangle;
    private TextView tv_clipCancel;
    private TextView tv_clipSure;

    //类别1：qq，2：weChat
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_image);
        type = getIntent().getIntExtra("type",1);
        init();
    }


    private void init() {
        cvl_circle = (ClipViewLayout) findViewById(R.id.cvl_circle);
        cvl_rectangle = (ClipViewLayout) findViewById(R.id.cvl_rectangle);
        iv_clipBack = (ImageView) findViewById(R.id.iv_clipBack);
        tv_clipSure = (TextView) findViewById(R.id.tv_clipSure);
        tv_clipCancel = (TextView) findViewById(R.id.tv_clipCancel);
        iv_clipBack.setOnClickListener(this);
        tv_clipSure.setOnClickListener(this);
        tv_clipCancel.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (type == 1){
            cvl_circle.setVisibility(View.VISIBLE);
            cvl_rectangle.setVisibility(View.GONE);
            //设置图片资源
            cvl_circle.setImageSrc(getIntent().getData());
        }else {
            cvl_circle.setVisibility(View.GONE);
            cvl_rectangle.setVisibility(View.VISIBLE);
            //设置图片资源
            cvl_rectangle.setImageSrc(getIntent().getData());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_clipBack:
                finish();
                break;
            case R.id.tv_clipCancel:
                finish();
                break;
            case R.id.tv_clipSure:
                generateUriAndReturn();
                break;
            default:
                break;
        }
    }

    /**
     * 生成URI并且通过setResult返回给打开的activity
     */
    private void generateUriAndReturn() {
        //调用返回剪贴图
        Bitmap zoomedCropBitmap;
        if (type == 1){
            zoomedCropBitmap = cvl_circle.clip();
        }else {
            zoomedCropBitmap = cvl_rectangle.clip();
        }
        if (zoomedCropBitmap == null){
            Log.e(TAG, "generateUriAndReturn == null");
            return;
        }
        Uri mSaveUri = Uri.fromFile(new File(getCacheDir(),"cropped_" +
                System.currentTimeMillis() + ".jpg"));
        if (mSaveUri != null){
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(mSaveUri);
                if (outputStream != null){
                    zoomedCropBitmap.compress(Bitmap.CompressFormat.JPEG,90,outputStream);
                }
            }catch (IOException e){
                Log.e(TAG, "cannot open file: "+mSaveUri,e);
            }finally {
                if (outputStream != null){
                    try{
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent();
            intent.setData(mSaveUri);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
