package com.bupt.heartarea.utils;

/**
 * Created by yuqing on 2017/12/17.
 */

public class MathUtils {
    /**
     * 找到数组中的最大值
     *
     * @param array
     * @return
     */
    public static double findMax(double[] array) {
        double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 将数组上下翻转
     *
     * @param array
     * @return
     */
    public static double[] reverseArrayUpDown(double[] array) {
        double max = findMax(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = max - array[i];
        }
        return array;
    }
}
