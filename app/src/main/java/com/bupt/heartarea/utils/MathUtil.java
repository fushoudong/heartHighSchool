package com.bupt.heartarea.utils;

import java.util.List;

/**
 * Created by yuqing on 2017/12/26.
 */

public class MathUtil {
    public static double getAverage(List<Double> list) {
        double sum = 0;
        for (double item : list) {
            sum += item;
        }
        return sum / list.size();
    }
}
