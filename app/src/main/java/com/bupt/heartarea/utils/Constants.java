/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.bupt.heartarea.utils;

import android.os.Environment;

/**
 * 常量类
 *
 * @author yuqing
 */
public final class Constants {

    //    public static final String URL_NEWS = "http://japi.juhe.cn/health_knowledge/infoNews?key=0a8206381422045a3834a8338e445e20&id=20000";
    public static final String URL_NEWS = "http://v.juhe.cn/toutiao/index?type=&key=5eb7335bad0e938076478a127c4911b5";
    public static final String MAIN_FILE_PATH = Environment.getExternalStorageDirectory() + "/heartarea/";
    //临时文件存放处
    public static final String TEMP_FILE_PATH = MAIN_FILE_PATH + "temp/";
    public static final String AVATAR_CACHE_FILE_NAME = "1.jpg";
    public static final String CAMERA_CACHE_FILE_NAME = "photo.jpg";

}
