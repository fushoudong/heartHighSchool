package com.bupt.heartarea.bloodpressure;

import android.util.Log;

import com.bupt.heartarea.utils.MathUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BloodPressure3 {

    public static int[] cal(double[] data) {
        //  System.out.println ("here");
        List<Point> points = new ArrayList<>();
        List<Double> lBPList = new ArrayList<>();
        List<Double> hBPList = new ArrayList<>();
        //ArrayList<Integer> samples = new ArrayList<Integer>();
        //data是未处理的原始数据
//        double[] data = {4.4382, 4.4359, 4.438, 4.441, 4.4475, 4.4504, 4.4566, 4.4588, 4.453, 4.4263, 4.415, 4.4329, 4.4314, 4.4309, 4.4295, 4.4261, 4.4257, 4.4454, 4.4491, 4.4521, 4.4558, 4.4571, 4.4566, 4.4445, 4.4221, 4.4202, 4.4207, 4.4207, 4.4219, 4.4221, 4.423, 4.4257, 4.4313, 4.4344, 4.4395, 4.4422, 4.4428, 4.4402, 4.4284, 4.4147, 4.406, 4.4229, 4.4223, 4.4229, 4.4215, 4.4231, 4.4253, 4.4274, 4.4297, 4.4333, 4.436, 4.4416, 4.4403, 4.4172, 4.4105, 4.41, 4.411, 4.43, 4.4314, 4.4328, 4.4339, 4.4394, 4.443, 4.4494, 4.4516, 4.454, 4.4564, 4.4477, 4.4329, 4.4197, 4.4192, 4.4203, 4.421, 4.4243, 4.4245, 4.4268, 4.4291, 4.4348, 4.438, 4.4425, 4.4443, 4.4472, 4.4479, 4.4251, 4.4136, 4.4122, 4.4133, 4.4156, 4.4178, 4.4193, 4.4205, 4.4241, 4.4268, 4.4317, 4.4335, 4.4381, 4.4392, 4.4437, 4.4434, 4.4174, 4.4083, 4.4084, 4.4101, 4.4128, 4.4144, 4.4157, 4.4158, 4.4178, 4.4206, 4.4259, 4.4282, 4.4334, 4.4345, 4.4389, 4.4348, 4.4083, 4.4039, 4.4073, 4.4248, 4.4285, 4.4289, 4.428, 4.4317, 4.4344, 4.4366, 4.442, 4.4464, 4.4491, 4.4502, 4.437, 4.4242, 4.4162, 4.4209, 4.4223, 4.4269, 4.4272, 4.4288, 4.4309, 4.4358, 4.4387, 4.4412, 4.4467, 4.4518, 4.4534, 4.431, 4.4202, 4.4179, 4.4196, 4.4218, 4.4238, 4.4252, 4.4258, 4.4291, 4.4331, 4.4414, 4.4446, 4.4508, 4.4541, 4.4537, 4.4405, 4.4253, 4.4273, 4.4325, 4.4356, 4.44, 4.444, 4.4519, 4.4626, 4.4632, 4.4703, 4.4668, 4.4543, 4.4557, 4.435, 4.4046, 4.3989, 4.394, 4.3969, 4.4084, 4.417, 4.4377, 4.4457, 4.4728, 4.491, 4.5022, 4.4798, 4.3964, 4.3611, 4.3143, 4.3125, 4.3385, 4.354, 4.3822, 4.3975, 4.398, 4.398, 4.3898, 4.3888, 4.3915, 4.39, 4.3919, 4.4116, 4.4138, 4.4032, 4.3844, 4.384, 4.3852, 4.3851, 4.3838, 4.3816, 4.3851, 4.3832, 4.4031, 4.4048, 4.4114, 4.4141, 4.4225, 4.4258, 4.4122, 4.4021, 4.3979, 4.3999, 4.4, 4.4029, 4.4025, 4.4019, 4.4042, 4.4061, 4.4098, 4.4122, 4.4156, 4.419, 4.4205, 4.4191, 4.4016, 4.4002, 4.4037, 4.4076, 4.4093, 4.4079, 4.4069, 4.4084, 4.4095, 4.4131, 4.4146, 4.4182, 4.4186, 4.4219, 4.416, 4.3985, 4.3968, 4.3976, 4.3978, 4.3987, 4.3989, 4.3991, 4.4001, 4.404, 4.4056, 4.4097, 4.4115, 4.415, 4.4161, 4.4045, 4.3961, 4.3917, 4.3928, 4.3932, 4.3944, 4.3962, 4.3962, 4.3983, 4.4003, 4.4042, 4.4063, 4.4103, 4.4121, 4.4141, 4.4106, 4.3922, 4.3892, 4.3913, 4.3932, 4.394, 4.3946, 4.3959, 4.3966, 4.4002, 4.4018, 4.4057, 4.4077, 4.4117, 4.4138, 4.4105, 4.4009, 4.3921, 4.3936, 4.3966, 4.3981, 4.3995, 4.3995};
        int[] loc = FindPeaks.findPeaks1(data, data.length);//loc为极小值位置,这里是用于切割独立波的，但是要是想实时显示的话，这部分得在安卓写，可能和你实时显示心率的非常相似，应该不难


        for (int k = 1; k < loc.length - 1; k++) {

            double[] onewave = cut(data, loc[k], loc[k + 1]);//注意！！如果要实时显示的话，这里你要检测出来最低值（我这里是切割成独立波了，但这并不符合实时要求），
            //也就是在安卓端分割成独立波，这部分的代码我真的不会写，如果要实时显示血压值的话，从此部分以下是你安卓端的核心代码。有疑问打电话。

//    	

            int[] loc2 = FindPeaks.findPeaks(onewave, onewave.length);//找到每一个独立波的顶点


            double[] upwave = cut(onewave, 0, loc2[0]);
            double[] downwave = cut(onewave, loc2[0] + 1, onewave.length - 1);
            double[] newup = newdata(upwave);//插值成10个
            double[] newdown = newdata(downwave);
            double[] downindex = diff(newup);
            double[] upindex = diff(newdown);

            double[] index = new double[19];
            for (int i = 0; i < 9; i++) {
                index[i] = upindex[i] * 20;
            }

            for (int i = 9; i < 18; i++) {
                index[i] = downindex[i - 9] * 20;
            }
            index[18] = 1;
            double highbp = -20;//不负责的基线
            double lowbp = 20;//不负责的基线

            double[] lowlinear = {-12.4790426441190, -9.49787124512876, 15.2922542593380, 17.1467857290624, -13.3239693154164, -5.41261893384273, 11.8722628613353, -8.36558445890467, -0.791878551938001, 10.9104018012751, -25.7469621690637, -27.7147878543286, 57.3795514425693, 9.92006554071782, -17.7395886102993, 9.02206050376846, -9.51945876425961, -41.4985134709573, 55.0282974369257};

            double[] highlinear = {46.3137504466218, 15.2460718206509, -18.4331285472097, -27.3991054208228, 20.6807874239300, 7.77256302711625, -27.4313268314167, 45.6875703869633, -36.4016652038733, 157.068787828387, -87.5053405304108, 64.0054535997326, -242.282144160349, -74.5739606999987, 80.9763044589780, 13.8179057116384, -9.70507235073275, 138.896132220458, 141.469957750558};
            for (int i = 0; i < 19; i++) {
                //System.out.println(index[i]);
                highbp = highbp + index[i] * highlinear[i];
                lowbp = lowbp + index[i] * lowlinear[i];
            }

            Log.e("high pressure", highbp + "");
            Log.e("low pressure", lowbp + "");
            hBPList.add(highbp);
            lBPList.add(lowbp);
        }

        //  去掉第一个 和 最后一个波形
        hBPList.remove(hBPList.size() - 1);
        hBPList.remove(0);
        lBPList.remove(lBPList.size() - 1);
        lBPList.remove(0);


        for (int i = hBPList.size() - 1; i >= 0; i--) {
//            if (Math.abs(hBPList.get(i) - highBloodPressureAver) > highBloodPressureAver * 0.2) {
            if (hBPList.get(i) < 80 || hBPList.get(i) > 180) {
                lBPList.remove(i);
                hBPList.remove(i);
            }
        }

        // 去掉一个最高 去掉一个最低
        Collections.sort(hBPList);
        Collections.sort(lBPList);
        hBPList.remove(hBPList.size() - 1);
        hBPList.remove(0);
        lBPList.remove(lBPList.size() - 1);
        lBPList.remove(0);
        return new int[]{(int) MathUtil.getAverage(hBPList), (int) MathUtil.getAverage(lBPList)};

    }

    public static double sum(double[] data, int s, int e) {//求和
        double sum = 0.0;
        for (int i = s; i <= e; i++) {
            sum = sum + data[i];
        }
        return sum;
    }

    public static double[] cut(double[] data, int start, int end) {//截取
        double[] cut = new double[end - start + 1];
        for (int i = start; i <= end; i++) {
            cut[i - start] = data[i];
            //System.out.println(data[i]);
        }
        return cut;
    }

    public static int cutlength(double[] data, double minvalue) {//截取，截取小于minvalue的长度
        int cutlength = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > minvalue) {
                cutlength = cutlength + 1;
            }
            //System.out.println(data[i]);
        }
        return cutlength;
    }


    public static double[] diff(double[] data) {//差值，diff
        double[] diff = new double[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            diff[i] = data[i + 1] - data[i];
        }
        return diff;
    }

    public static double max(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static double min(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static double[] mapminmax(double[] data) {//差值，diff
        double[] map = new double[data.length];
        double max = max(data);
        double min = min(data);
        for (int i = 0; i < data.length; i++) {
            map[i] = 2 * ((data[i] - min) / (max - min)) - 1;

        }
        return map;
    }

    public static double[] newdata(double[] data) {//插值，用于补偿手机和开源网站中数据的采集频率差的问题
        List<Point> points = new ArrayList<Point>();
        for (int j = 0; j < data.length; j++) {

            points.add(new Point(j, (int) (data[j] * 100000)));//points是point（int，int）格式数据，所以把纵坐标加大

        }
        BasicSpline spline = new BasicSpline();//spline插值方法，结果用spline.getPoint得到，在第二个循环
        if (points.size() > 2) {//检验必须有两个点（不然不能进行插值计算）
            for (Point p : points) {
                spline.addPoint(p);
            }
            spline.calcSpline();
        }
        int newlength = 10;

        double step = (1.0 / newlength);

        System.out.println(newlength);
        double[] originaldata = new double[newlength + 1];//定义新的插值后数据
        if (points.size() > 2) {
            int i = 0;
            for (float f = 0; f <= 1; f += step) {//把原来几个个值经过插值计算变成10个值，其实就是使得曲线更平滑，相当于一个重采样（但是这个重采样更接近曲线本身）
                Point px = spline.getPoint(f);
                double y = px.y;
                originaldata[i] = y / 100000;
                i = i + 1;
            }
        }
        return originaldata;
    }
}

