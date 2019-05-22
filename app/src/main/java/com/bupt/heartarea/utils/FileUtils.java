package com.bupt.heartarea.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by suiyf on 2016/4/15.
 */
public class FileUtils {
    private static final String TAG = "";

    /**
     * 判断uri对应的文件是否存在
     *
     * @param uriString
     * @return
     */
    public static boolean existFileFromUri(String uriString) {
        if (TextUtils.isEmpty(uriString)) {
            return false;
        }
        URI uri = URI.create(uriString);
        File file = new File(uri);
        return file.exists();
    }


    /**
     * 删除uri指定的文件
     *
     * @param uri 下载文件对应的uri
     */
    public static void deleteFileFromUri(String uri) {
        if (!TextUtils.isEmpty(uri)) {
            final File file;
            try {
                file = new File(new URI(uri));
                if (file.exists() && !file.delete()) {
                    Log.w(TAG, "file: '" + uri + "' couldn't be deleted");
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
                Log.w(TAG, "file: '" + uri + "' couldn't be deleted");
            }

        }
    }

    public static void deleteFileIfExists(String path) {
        if (!TextUtils.isEmpty(path)) {
            final File file = new File(path);
            if (file.exists() && !file.delete()) {
                Log.w(TAG, "file: '" + path + "' couldn't be deleted");
            }
        }
    }

    /**
     * 下载文件
     *
     * @param fileUrl  下载文件对应的 url
     * @param filePath 保存文件的路径
     * @param fileName 保存文件的名称
     * @param listener 文件下载完成时的回调
     */
    public static void downloadFile(String fileUrl, final String filePath,
                                    String fileName, final OnDownloadFileListener listener) {
        if (TextUtils.isEmpty(fileUrl)
                || TextUtils.isEmpty(filePath)
                || TextUtils.isEmpty(fileName)) {
            return;
        }
        final File file = new File(filePath, fileName);
        File parentFile = new File(filePath);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            return;
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final Request request = new Request.Builder()
                .url(fileUrl)
                .build();
        final Call call = new OkHttpClient.Builder()
                .build()
                .newCall(request);
        final long startTime = SystemClock.elapsedRealtime();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, e.toString());
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len, current = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        current += len;
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, e.toString());
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                        if (listener != null) {
                            long consumedTime = SystemClock.elapsedRealtime() - startTime;
                            listener.onComplete(consumedTime);
                        }
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    }
                }
            }
        });
    }


    public interface OnDownloadFileListener {
        void onComplete(long consumedTime);
    }

    /**
     * 文件重命名
     *
     * @param srcFilePath 源文件的路径
     * @param srcFileName 源文件的文件名
     * @param desFilePath 目标文件的路径
     * @param desFileName 目标文件的文件名
     * @return
     */
    public static boolean renameFile(String srcFilePath, String srcFileName, String desFilePath, String desFileName) {
        try {
            File from = new File(srcFilePath, srcFileName);
            if (from.exists()) {
                File to = new File(desFilePath, desFileName);
                from.renameTo(to);
            } else {
                Log.d("rename file", "源文件不存在");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean renameFile(String srcFilePath, String desFilePath) {
        try {
            File from = new File(srcFilePath);
            if (from.exists()) {
                File to = new File(desFilePath);
                from.renameTo(to);
                Log.d("重命名路径", to.getAbsolutePath() + "");
            } else {
                Log.d("rename file", "源文件不存在");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 修改文件的后缀名
     *
     * @param srcFile
     * @param suffix
     * @return
     */
    public static boolean renameFileSuffix(String srcFile, String suffix) {
        String path = srcFile.substring(0, srcFile.lastIndexOf('/') + 1);
        String realFileName = srcFile.substring(srcFile.lastIndexOf('/') + 1, srcFile.lastIndexOf('.'));
        return renameFile(srcFile, path + realFileName + "." + suffix);
    }

    /**
     * 获取当前目录下所有指定后缀名的绝对路径
     *
     * @param fileAbsolutePath
     * @param suffix
     * @return
     */
    public static List<String> getFilesNameList(String fileAbsolutePath, String suffix) {
        List<String> list = new ArrayList<>();
        File file = new File(fileAbsolutePath);
        File[] subFiles = file.listFiles();

        for (File subFile : subFiles) {
            // 判断是否为文件夹
            if (!subFile.isDirectory()) {
                String filename = subFile.getAbsolutePath();
                // 判断是否为指定的后缀名结尾
                if (filename.trim().toLowerCase().endsWith(suffix)) {
                    list.add(filename);
                }
            }
        }
        return list;
    }

    /**
     * 根据Uri返回文件绝对路径
     * 兼容了file:///开头的 和 content://开头的情况
     */
    public static String getRealFilePathFromUri(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_FILE.equalsIgnoreCase(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equalsIgnoreCase(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    /**
     * 检查文件是否存在
     */
    public static String checkDirPath(String dirPath) {
        if (TextUtils.isEmpty(dirPath)) {
            return "";
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dirPath;
    }

    /**
     * 创建文件（仅文件）
     *
     * @param filePath
     * @return
     */
    public static boolean createFile(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        String dirPath = filePath.substring(0, filePath.lastIndexOf('/'));
        if (TextUtils.isEmpty(dirPath)) {
            return false;
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;


    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
