package com.bupt.heartarea.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bupt.heartarea.BuildConfig;
import com.bupt.heartarea.R;
import com.bupt.heartarea.bean.ResponseBean;
import com.bupt.heartarea.retrofit.HttpManager;
import com.bupt.heartarea.utils.Constants;
import com.bupt.heartarea.utils.FileUtil;
import com.bupt.heartarea.utils.FileUtils;
import com.bupt.heartarea.utils.GlobalData;
import com.bupt.heartarea.view.CircleImageView;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import static com.bupt.heartarea.utils.FileUtil.getRealFilePathFromUri;
import static java.lang.String.valueOf;
import static okhttp3.MultipartBody.FORM;


public class MyInformationActivity extends Activity implements View.OnClickListener {


    ImageView mBackIcon;
    TextView mSave, mTvSex, mTvBirthday;
    EditText mEtName, mEtEmail;
    RelativeLayout mRL_birthday, mRL_sex;
    Activity mActivity;
    Context mContext;
    private int mSex_Int = 0;
    private String mBirthday;
    private String mName;
    private String mEmail;

    // 弹窗item
    private String[] items_sex = new String[]{"男", "女"};

    // 用户缓存
    private SharedPreferences preferences;
    private static final String URL_CHANGE_INFORMATION = GlobalData.URL_HEAD + "/detect3/ChangeServlet";
    // 上传用户头像的url
    private static final String URL_IMAGE_HEAD = GlobalData.URL_HEAD + "/detect3/HeadIconServlet";
    private static final String URL_BASE = "http://47.92.80.155/";

    //修改头像
    //请求相机
    private static final int REQUEST_CAPTURE = 100;
    //请求相册
    private static final int REQUEST_PICK = 101;
    //请求截图
    private static final int REQUEST_CROP_PHOTO = 102;
    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;
    //头像1
    private CircleImageView headImage;
    //头像2
    private ImageView headImage2;
    //调用照相机返回图片文件
    private File tempFile;
    // 1: qq, 2: weixin
    private int type = 1;
    private Bitmap mainBitmap;

    private String TAG = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_information);
        mContext = this;
        mActivity = this;
        initView();

        try {
            FileInputStream in = new FileInputStream("/data/user/0/com.bupt.heartarealinear/files/icon.jpg");
            Bitmap getBitmap = BitmapFactory.decodeStream(in);
            headImage.setImageBitmap(getBitmap);
            mainBitmap = getBitmap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String getEmail = preferences.getString("email","");
        mEtEmail.setText(getEmail);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    private void initView() {
        /**
         * 更换头像
         */
        headImage = (CircleImageView) findViewById(R.id.id_iv_headpicture_change_information);
        mBackIcon = (ImageView) findViewById(R.id.id_iv_back);
        mEtName = (EditText) findViewById(R.id.id_et_name_change_information);
        mEtEmail = (EditText) findViewById(R.id.id_et_email_value);
        mSave = (TextView) findViewById(R.id.id_tv_save);
        mTvSex = (TextView) findViewById(R.id.id_tv_sex_value);
        mTvBirthday = (TextView) findViewById(R.id.id_tv_birthday_value);
        mRL_birthday = (RelativeLayout) findViewById(R.id.id_rl_birthday);
        mRL_sex = (RelativeLayout) findViewById(R.id.id_rl_sex);


        mEtName.setText(GlobalData.getUsername());
        mEtEmail.setText(GlobalData.getEmail());
        if (GlobalData.getSex() != -1) {
            mTvSex.setText(items_sex[GlobalData.getSex()]);

        }
        mTvBirthday.setText(GlobalData.getBirthday());
        headImage.setOnClickListener(this);
        mBackIcon.setOnClickListener(this);
        mEtName.setOnClickListener(this);
        mEtEmail.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mRL_birthday.setOnClickListener(this);
        mRL_sex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_iv_headpicture_change_information:
                uploadHeadImage();
                break;
            case R.id.id_iv_back:
                finish();
                break;
            case R.id.id_tv_save:
                mName = mEtName.getText().toString().trim();
                if (mName == null || mName.equals("")) {
                    Toast.makeText(MyInformationActivity.this, "请输入您的昵称", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    int length = mName.length();
                    if (length > 8 || length < 2) {
                        Toast.makeText(MyInformationActivity.this, "昵称长度应为2~8个字符", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                if (mTvSex.getText().toString() == null || mTvSex.getText().toString().equals("")) {
                    Toast.makeText(MyInformationActivity.this, "请选择您的性别", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (mTvBirthday.getText().toString() == null || mTvBirthday.getText().toString().equals("")) {
                    Toast.makeText(MyInformationActivity.this, "请选择您的生日", Toast.LENGTH_SHORT).show();
                    break;
                }if (!mEtEmail.getText().toString().toString().matches
                    ("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){
                Toast.makeText(MyInformationActivity.this,"邮箱格式不正确",Toast.LENGTH_SHORT).show();
            }else {
                saveToSever();
                saveData(mEtEmail.getText().toString());
                Log.e(TAG, "onActivityResult: "+mainBitmap);
                try {
                    File file = new File(getFilesDir(),"icon.jpg");
                    Log.e(TAG, "onClick: "+file);
                    if (file.exists()){
                        file.delete();
                        Log.e(TAG, "onClick: "+"删除成功" );
                    }
                    FileOutputStream out = new FileOutputStream(file);
                    Log.e(TAG, "onClick: "+"输出流创建成功" );
                    mainBitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
                    Log.e(TAG, "onClick: "+"压缩成功" );
                    out.flush();
                    Log.e(TAG, "onClick: "+"创建成功" );
                    out.close();
                    Log.e(TAG, "onClick: "+"关闭成功" );
                    //保存图片后发送广播通知更新数据库
                    Uri uri1 = Uri.fromFile(file);
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri1));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }}
                final HashMap<String, String> params = new HashMap<>();
                params.put("userid", GlobalData.userid + "");

                final File file = new File(mContext.getExternalFilesDir(""), getPhotoFileName());
                Log.i("File", mContext.getExternalFilesDir("") + "");
//                filesDir = mContext.getExternalFilesDir("");
//                /storage/emulated/0/Android/data/com.bupt.heartarea/files


                String oldpath = mContext.getExternalFilesDir("") + "/" + getPhotoFileName();
                String newpath = Environment.getExternalStorageDirectory() + "/download/" + getPhotoFileName();
                Log.i("oldpath", oldpath);
                Log.i("newpath", newpath);
                // 拷贝头像
                FileUtil.copyFile(oldpath, newpath);
                // 向服务器上传头像
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        saveFileToServer(URL_IMAGE_HEAD, params, file);
//                    }
//                }).start();
                postImageToServer(URL_BASE, "detect3/HeadIconServlet", "icon", file, params);
                break;
            case R.id.id_rl_birthday:
                showDatePickerDialog1();
                break;
            case R.id.id_rl_sex:
                showSexDialog();
                break;

        }
    }

    private void saveData(String email) {
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("email",email);
        editor.commit();
    }

    /**
     * 本地修改头像
     */
    /**
     * 上传头像
     */
    private void uploadHeadImage() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);
        TextView btnCarema = (TextView) view.findViewById(R.id.tv_camera);
        TextView btnPhoto = (TextView) view.findViewById(R.id.tv_album);
        TextView btnCancel = (TextView) view.findViewById(R.id.tv_cancel);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        popupWindow.setOutsideTouchable(true);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        //popupWindow在弹窗的时候背景半透明
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.5f;
        getWindow().setAttributes(params);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
            }
        });

        btnCarema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
                if (ContextCompat.checkSelfPermission(MyInformationActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(MyInformationActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    //跳转到调用系统相机
                    gotoCamera();
                }
                popupWindow.dismiss();
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
                if (ContextCompat.checkSelfPermission(MyInformationActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请READ_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(MyInformationActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            READ_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    //跳转到相册
                    gotoPhoto();
                }
                popupWindow.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }


    /**
     * 外部存储权限申请返回
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoCamera();
            }
        } else if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoPhoto();
            }
        }
    }


    /**
     * 跳转到相册
     */
    private void gotoPhoto() {
        Log.d("evan", "*****************打开图库********************");
        //跳转到调用系统图库
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), REQUEST_PICK);
    }


    /**
     * 跳转到照相机
     */
    private void gotoCamera() {
        Log.d("evan", "*****************打开相机********************");
        //创建拍照存储的图片文件
        tempFile = new File(FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/"), System.currentTimeMillis() + ".jpg");
        Log.e(TAG, "gotoCamera: "+tempFile.getName());
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(MyInformationActivity.this, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, REQUEST_CAPTURE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQUEST_CAPTURE: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    gotoClipActivity(Uri.fromFile(tempFile));
                }
                break;
            case REQUEST_PICK:  //调用系统相册返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    gotoClipActivity(uri);
                }
                break;
            case REQUEST_CROP_PHOTO:  //剪切图片返回
                if (resultCode == RESULT_OK) {
                    final Uri uri = intent.getData();
                    if (uri == null) {
                        return;
                    }
                    String cropImagePath = getRealFilePathFromUri(getApplicationContext(), uri);
                    Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
                    if (type == 1) {
                        headImage.setImageBitmap(bitMap);
                    } else {
                        headImage2.setImageBitmap(bitMap);
                    }
                    //此处后面可以将bitMap转为二进制上传后台网络
                    //......
                    mainBitmap = bitMap;

                }
                break;
        }
    }


    /**
     * 打开截图界面
     */
    public void gotoClipActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, ClipImageActivity.class);
        intent.putExtra("type", 1);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }


    /**
     * 使用系统当前日期加以调整作为照片的名称
     *
     * @return
     */
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'img'_yyyyMMdd_HHmmss");
        return GlobalData.userid + ".jpg";
    }


    /**
     * 弹出选项窗口方法
     */
    private void showSexDialog() {
        new AlertDialog.Builder(this)
                .setTitle("选择性别")
                .setItems(items_sex, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, final int which) {

                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mSex_Int = which;
                                mTvSex.setText(items_sex[which]);
                            }
                        });


                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // 隐藏对话框,释放对话框所占的资源
                        arg0.dismiss();
                    }
                }).show();
    }


    //         对话框下的DatePicker示例 Example in dialog
    private void showDatePickerDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(MyInformationActivity.this).create();
        dialog.show();
        DatePicker picker = new DatePicker(MyInformationActivity.this);
        picker.setDate(1990, 1);
        picker.setMode(DPMode.SINGLE);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(final String date) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] dates = date.split("-");
                        if (Integer.parseInt(dates[1]) < 10) dates[1] = "0" + dates[1];
                        if (Integer.parseInt(dates[2]) < 10) dates[2] = "0" + dates[2];
                        String new_date = dates[0] + "-" + dates[1] + "-" + dates[2];
                        mBirthday = new_date;
                        mTvBirthday.setText(new_date);
                    }
                });
                dialog.dismiss();
            }
        });
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setContentView(picker, params);
        dialog.getWindow().setGravity(Gravity.CENTER);
    }

    /**
     * 向服务器上传用户的信息数据
     */
    private void saveToSever() {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CHANGE_INFORMATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();

                ResponseBean responseBean = gson.fromJson(s, ResponseBean.class);
                if (responseBean != null) {
                    if (responseBean.getCode() == 0) {
                        GlobalData.username = mName;
                        GlobalData.sex = (mSex_Int);
                        GlobalData.email = (mEmail);
                        GlobalData.birthday = (mTvBirthday.getText().toString().trim());
                        Toast.makeText(mContext, "修改成功", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else {
                    Toast.makeText(mContext, "请求服务器错误", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                mName = mEtName.getText().toString();
                mEmail = mEtEmail.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("userid", GlobalData.getUserid());
                map.put("username", mName);
                map.put("sex", String.valueOf(mSex_Int));
                map.put("email", mEmail);
                map.put("birthday", mTvBirthday.getText().toString().trim());
                map.put("identification", "");
                Log.i("Information Params", map.toString());
                return map;
            }
        };
        queue.add(stringRequest);


    }

    /**
     * 向服务器上传用户的信息数据
     */
    private void saveToSeverTest() {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.108.224.93/detect3/HeadIconServlet", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();

                ResponseBean responseBean = gson.fromJson(s, ResponseBean.class);
                if (responseBean != null) {
                    if (responseBean.getCode() == 0) {
                        GlobalData.username = mName;
                        GlobalData.sex = (mSex_Int);
                        GlobalData.email = (mEmail);
                        GlobalData.birthday = (mTvBirthday.getText().toString().trim());
                        Toast.makeText(mContext, "修改成功", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else {
                    Toast.makeText(mContext, "请求服务器错误", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                mName = mEtName.getText().toString();
                mEmail = mEtEmail.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("userid", GlobalData.getUserid());
                map.put("username", mName);
                map.put("sex", String.valueOf(mSex_Int));
                map.put("email", mEmail);
                map.put("birthday", mTvBirthday.getText().toString().trim());
                map.put("identification", "");
                Log.i("Information Params", map.toString());
                return map;
            }
        };
        queue.add(stringRequest);


    }

    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {
        String year, month, day;

        @Override
        public void onDateSet(android.widget.DatePicker view, int myyear, int monthOfYear, int dayOfMonth) {
            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year = String.valueOf(myyear);
            month = String.valueOf(monthOfYear + 1);
            day = String.valueOf(dayOfMonth);
            //更新日期
            updateDate();
        }


        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate() {
            if (Integer.parseInt(month) < 10) month = "0" + month;
            if (Integer.parseInt(day) < 10) day = "0" + day;
            String new_date = year + "-" + month + "-" + day;
            mBirthday = new_date;
            mTvBirthday.setText(new_date);
        }
    };

    private void showDatePickerDialog1() {
        DatePickerDialog dpd = new DatePickerDialog(MyInformationActivity.this, Datelistener, 1990, 0, 1);
        dpd.show();//显示DatePickerDialog组件
    }


    /**
     * 向服务器上传用户头像
     *
     * @param url
     * @param map
     * @param file
     */
    protected void saveFileToServer(final String url, final Map<String, String> map, File file) {
        OkHttpClient client = new OkHttpClient();
        // form 表单形式上传
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(FORM);
        if (file != null) {
            // MediaType.parse() 里面是上传的文件类型。
            RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
            String filename = file.getName();
            // 参数分别为， 请求key ，文件名称 ， RequestBody
            requestBody.addFormDataPart("icon", file.getName(), body);
        }
        if (map != null) {
            // map 里面是请求中所需要的 key 和 value
            for (Map.Entry entry : map.entrySet()) {
                requestBody.addFormDataPart(valueOf(entry.getKey()), valueOf(entry.getValue()));
            }
        }


        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url).post(requestBody.build())
                .tag(getApplicationContext())
                .build();
        // readTimeout("请求超时时间" , 时间单位);
        client.newBuilder().readTimeout(5000, TimeUnit.MILLISECONDS).build().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("saveFileToServer", "onFailure()" + e);

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {

                if (response.isSuccessful()) {
                    Log.i("response", response + "");
                    String str = response.body().string();
                    Log.i("saveFileToServer", response.message() + " , body " + str);

                } else {
                    Log.i("saveFileToServer", response.message() + " error : body " + response.body().string());
                }
            }


        });

    }


    private void postImageToServer(String baseUrl, String suffixUrl, String key, File file, final HashMap<String, String> params) {
//        retrofit2.Call<String> call = HttpManager.getInstance().postImage(baseUrl, suffixUrl, key, file, file.getName(), params);
        retrofit2.Call<String> call = HttpManager.getInstance().postImage(baseUrl + suffixUrl, key, file, file.getName(), params);
        call.enqueue(new retrofit2.Callback<String>() {
            @Override
            public void onResponse(retrofit2.Call<String> call, retrofit2.Response<String> response) {
                if (response.isSuccessful()) {
                    Log.i("response", response + "");
                    String str = response.body();
                    Log.i("saveFileToServer", response.message() + " , body " + str);

                } else {
                    Log.i("saveFileToServer", response.message() + " error : body " + response.body());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<String> call, Throwable t) {
                Log.i("saveFileToServer", "onFailure()" + t.toString());
            }
        });
    }
}



