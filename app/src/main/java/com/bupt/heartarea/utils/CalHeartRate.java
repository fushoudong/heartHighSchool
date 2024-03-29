package com.bupt.heartarea.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by yuqing on 2017/2/16.
 */
public class CalHeartRate {

    private static List<Integer> mCalAverageList = new ArrayList<Integer>();

    /**
     * 简单寻峰算法
     *
     * @param datas 原始数据数组
     * @return 峰值下标列表
     */
    public static List<Integer> findPeaks(double[] datas) {
        List<Integer> list = new ArrayList<>();
        int last_index = -100;
        int length = datas.length;

        for (int i = 1; i < length - 8; i++) {
            if (datas[i] > datas[i - 1] && datas[i] > datas[i + 1]
                    && datas[i] > datas[i + 2]
                    && datas[i] > datas[i + 3]
                    && datas[i] > datas[i + 4]
                    && datas[i] > datas[i + 5]
                    && datas[i] > datas[i + 6]
                    && datas[i] > datas[i + 7]
            ) {
                if (i - last_index > 10) {
                    list.add(i);
                    last_index = i;
                }
            }


        }
        System.out.println("findPeaks()");
        System.out.println(list);
        return list;
    }

    /**
     * 简单寻峰算法
     *
     * @param list 原始数据列表
     * @return 峰值下标列表
     */
    public static List<Integer> findPeaks(List<Double> list) {
        double[] datas = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            datas[i] = list.get(i);
        }
        List<Integer> res_list = findPeaks(datas);
        return res_list;
    }

    /**
     * 实时心率专用寻峰
     *
     * @param datas
     * @return
     */
    public static List<Integer> findPeaksRealTime(double[] datas) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> indMax = new ArrayList<Integer>();
        int length = datas.length;
        for (int i = 1; i < length - 8; i++) {
            if (datas[i] > datas[i - 1] && datas[i] > datas[i + 1] && datas[i] > datas[i + 2] &&
                    datas[i] > datas[i + 3] && datas[i] > datas[i + 4] && datas[i] > datas[i + 5] &&
                    datas[i] > datas[i + 6] && datas[i] > datas[i + 7]) {
                list.add(i);
            }
        }
//        for (int i = 1; i < length - 1; i++) {
//            double firstDerivative = (datas[i] - datas[i - 1]) / 0.005;
//            double secondDerivative = (datas[i + 1] + datas[i - 1] - 2 * datas[i]) /
//                    Math.pow(0.005, 2);
//            if (firstDerivative < 1 && secondDerivative < 0) {
//                indMax.add(i);
//            }
//        }
        System.out.println("findPeaks()");
        System.out.println(list);
        return list;
    }

    /**
     * 实时心率专用寻峰
     *
     * @param list
     * @return
     */
    public static List<Integer> findPeaksRealTime(List<Double> list) {
        double[] datas = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            datas[i] = list.get(i);
        }
        List<Integer> res_list = findPeaksRealTime(datas);
        return res_list;
    }

    /**
     * 计算心率
     *
     * @param datas    数据数组
     * @param interval 两帧之间的间隔，单位ms
     * @return 心率值
     */
    public static int calHeartRate(double[] datas, int interval) {
        int heartRate = 0;
        if (datas == null || datas.length == 0) return 0;
        List<Integer> list = findPeaks(datas);
        int length = list.size();
        if (length > 1) {
            int duration = list.get(length - 1) - list.get(0);
            heartRate = (length - 1) * (60 * 1000) / interval / duration;
        }
        return heartRate;

    }

    public static int calHeartRate(List<Integer> peaks_list, int interval) {
        int heartRate = 0;
        if (peaks_list == null || peaks_list.size() == 0) return 0;
        int length = peaks_list.size();
        if (length > 1) {
            int duration = peaks_list.get(length - 1) - peaks_list.get(0);
            heartRate = (length - 1) * (60 * 1000) / interval / duration;
        }
        return heartRate;

    }

    /**
     * 计算RR间隔
     *
     * @param peaks_list 峰值下标列表
     * @return RR间隔列表
     */
    public static List<Integer> calRRIntevalOrigin(List<Integer> peaks_list) {
        if (peaks_list == null || peaks_list.size() == 0) return null;
        List<Integer> rrList = new ArrayList<Integer>();
        int length = peaks_list.size();
        for (int i = 0; i < length - 1; i++)
            rrList.add((peaks_list.get(i + 1) - peaks_list.get(i)));
        return rrList;
    }

    /***
     *  二次寻峰
     * @param rrInteval
     * @return 去除异常的峰值横坐标
     */
    public static List<Integer> findPeaksAgain(List<Integer> rrInteval, int interval) {
        List<Integer> peaksAgain = new ArrayList<Integer>();
        int index = 0;
        int count = 0;
        for (int i = 0; i < rrInteval.size(); i++) {
            if (500 <= rrInteval.get(i) && rrInteval.get(i) <= 1400) {
                index += rrInteval.get(i) / interval;
                peaksAgain.add(index);
                count++;
//                Log.e("index", String.valueOf(index));
//                Log.e("count", String.valueOf(count));
            }
        }
        return peaksAgain;
    }


    /**
     * 计算rr间隔
     *
     * @param peaks_list 峰下标列表
     * @param interval   两次采样的时间间隔
     * @return
     */
    public static List<Integer> calRRInteval(List<Integer> peaks_list, int interval) {
        if (peaks_list == null || peaks_list.size() == 0) return null;
        List<Integer> rrList = new ArrayList<Integer>();
        int length = peaks_list.size();
//        for (int i = 0; i < length - 1; i++) {
//            rrList.add((peaks_list.get(i + 1) - peaks_list.get(i)) * interval);
//        }
//        return rrList;
        // 寻找相邻RR间隔差小于等于100的数据
        for (int i = 1; i < length - 1; i++) {
            int rrDiffer = (peaks_list.get(i + 1) + peaks_list.get(i - 1) - 2 * peaks_list.get(i)) * interval;
            int rr = (peaks_list.get(i + 1) - peaks_list.get(i)) * interval;
            if (rr > 0 && Math.abs(rrDiffer) <= 200) {
                mCalAverageList.add(rr);
//                Log.e("滑动有效rr间隔值", String.valueOf(rr));
//                Log.e("peaksList i + 1", String.valueOf((peaks_list.get(i + 1))));
//                Log.e("peaksList i", String.valueOf((peaks_list.get(i))));
//                Log.e("有效rr间隔值", String.valueOf((peaks_list.get(i + 1) - peaks_list.get(i)) * interval));

            }
            rrList.add((peaks_list.get(i + 1) - peaks_list.get(i)) * interval);
        }
        return rrList;
    }

    public static int lowpass(int input) {
        double lowpass = 0.0f;
        lowpass = (double) input * 0.1f + lowpass * 0.9f;
        return (int) lowpass;
    }

    /***
     * 用滑动平均值去除rr间隔异常点
     * @return
     */
    public static List<Integer> removalRRList(List<Integer> rr) {

        List<Integer> removalList = new ArrayList<Integer>();
        if (mCalAverageList.size() > 8) {
//            System.out.println("有效rrList"+mCalAverageList);
            int average = calMovingAverage(mCalAverageList, 8);
//            System.out.println("有效滑动平均值" + average);
            for (int i = 0; i < rr.size(); i++) {
                int abs = Math.abs(rr.get(i) - average);
                if (abs < 200) {
                    removalList.add(rr.get(i));
                    Log.e(TAG, "removalRRList: " +rr.get(i));
                }
            }
        }
        return removalList;
    }

    /***
     * 计算滑动平均值
     * @param arrayList
     * @param T
     * @return
     */
    public static int calMovingAverage(List<Integer> arrayList, int T) {
        int sum = 0, average = 0;
        for (int i = 0; i <= arrayList.size() - T; i++) {
            int temp = 0;
            for (int j = 0; j < T; j++) {
                temp += arrayList.get(i + j);
            }
            sum += temp / T;
        }
        average = sum / (arrayList.size() - T + 1);
        return average;
    }


}
