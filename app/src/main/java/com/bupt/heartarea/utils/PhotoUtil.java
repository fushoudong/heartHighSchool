package com.bupt.heartarea.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;

/**
 * Created by yuqing on 2017/9/29.
 */

public class PhotoUtil {
    /**
     * 启动相机
     *
     * @param context
     * @param requestCode
     */
    public static void goToCamera(Context context, int requestCode) {
        Log.d("goToCamera", "*****************打开相机********************");
        //创建拍照存储的图片文件
        File tempFile = new File(FileUtils.checkDirPath(Constants.TEMP_FILE_PATH), Constants.AVATAR_CACHE_FILE_NAME);
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //可能要看一下
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml
//            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
//        } else {
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
//        }
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    /**
     * 启动相册
     *
     * @param context
     * @param requestCode
     */
    public static void goToPhoto(Context context, int requestCode) {
        Log.d("goToPhoto", "*****************打开图库********************");
        //跳转到调用系统图库
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(Intent.createChooser(intent, "请选择图片"), requestCode);
    }

}
