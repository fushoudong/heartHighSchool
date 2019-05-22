package com.bupt.heartarea.bloodpressure;

import com.bupt.heartarea.utils.MathUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BloodPressure {

    public static int[] calBloodPressure(double[] data) {
        //  System.out.println ("here");
        List<Point> points = new ArrayList<Point>();
        List<Double> lBPList = new ArrayList<>();
        List<Double> hBPList = new ArrayList<>();
        double lBPSum = 0;
        double hBPSum = 0;
        int count = 0;
        //ArrayList<Integer> samples = new ArrayList<Integer>();
        //data是未处理的原始数据
        //double[] data={4.0063, 4.0134, 4.0282, 4.0469, 4.0629, 4.0701, 4.0648, 4.0471, 4.0208, 3.9927, 3.97, 3.9578, 3.9569, 3.9641, 3.9738, 3.9813, 3.9849, 3.9856, 3.9857, 3.9869, 3.9891, 3.9914, 3.993, 3.9939, 3.9947, 3.9955, 3.9961, 3.9957, 3.9938, 3.9907, 3.9873, 3.9848, 3.9839, 3.9844, 3.9857, 3.9871, 3.9885, 3.9898, 3.9911, 3.9925, 3.9937, 3.9947, 3.9956, 3.9966, 3.9977, 3.9983, 3.998, 3.9961, 3.993, 3.9895, 3.9866, 3.9851, 3.985, 3.9857, 3.9868, 3.9878, 3.9888, 3.9898, 3.9909, 3.992, 3.9931, 3.9946, 3.9964, 3.9985, 4.0002, 4.0007, 3.9995, 3.9965, 3.9926, 3.989, 3.9865, 3.9856, 3.9859, 3.9867, 3.9875, 3.9881, 3.9885, 3.989, 3.9898, 3.9907, 3.9915, 3.9923, 3.993, 3.9939, 3.9951, 3.996, 3.9959, 3.9944, 3.9914, 3.9878, 3.9845, 3.9823, 3.9814, 3.9814, 3.9818, 3.9822, 3.9825, 3.983, 3.9835, 3.9842, 3.9848, 3.9857, 3.9867, 3.9876, 3.988, 3.9873, 3.9853, 3.9825, 3.9796, 3.9774, 3.9762, 3.9758, 3.9758, 3.9759, 3.9762, 3.9767, 3.9776, 3.9787, 3.9798, 3.9807, 3.9814, 3.9823, 3.9836, 3.9848, 3.9855, 3.985, 3.983, 3.98, 3.9768, 3.9742, 3.9725, 3.9718, 3.9715, 3.9715, 3.9717, 3.9723, 3.9733, 3.9745, 3.9759, 3.9771, 3.9784, 3.9797, 3.981, 3.9822, 3.9828, 3.9822, 3.9806, 3.9782, 3.9759, 3.9742, 3.9734, 3.9732, 3.9733, 3.9735, 3.9736, 3.9739, 3.9744, 3.975, 3.9757, 3.9765, 3.9774, 3.978, 3.9783, 3.9778, 3.9765, 3.9746, 3.9727, 3.9714, 3.9708, 3.9708, 3.9711, 3.9712, 3.9714, 3.971, 3.9716, 3.9728, 3.9722, 3.971, 3.97, 3.9788, 3.9923};
        //double[] data={3.8859, 3.886, 3.8888, 3.8927, 3.896, 3.8977, 3.8982, 3.8983, 3.8989, 3.9004, 3.903, 3.9064, 3.9101, 3.9128, 3.9129, 3.9088, 3.8999, 3.8876, 3.8755, 3.8685, 3.8703, 3.8817, 3.8998, 3.9191, 3.9346, 3.9437, 3.9472, 3.9478, 3.9485, 3.9508, 3.9543, 3.9573, 3.9581, 3.9557, 3.9503, 3.9434, 3.937, 3.9326, 3.9307, 3.931, 3.9324, 3.9341, 3.9357, 3.9374, 3.9392, 3.9413, 3.9438, 3.9467, 3.95, 3.9527, 3.9538, 3.9523, 3.9478, 3.9414, 3.9349, 3.9299, 3.9271, 3.9263, 3.9267, 3.9277, 3.9286, 3.9294, 3.9301, 3.9308, 3.9317, 3.9332, 3.9351, 3.937, 3.9377, 3.9362, 3.9322, 3.9266, 3.9209, 3.9166, 3.9144, 3.9141, 3.915, 3.9162, 3.9173, 3.9182, 3.9187, 3.919, 3.9193, 3.9201, 3.9215, 3.9231, 3.9237, 3.9223, 3.9189, 3.9143, 3.9101, 3.9074, 3.9066, 3.907, 3.9078, 3.9084, 3.9089, 3.9098, 3.9113, 3.9136, 3.9165, 3.9195, 3.922, 3.9228, 3.9215, 3.9179, 3.9131, 3.9083, 3.9048, 3.903, 3.9026, 3.9031, 3.9039, 3.9049, 3.9061, 3.9076, 3.9095, 3.9119, 3.9147, 3.9174, 3.9191, 3.919, 3.9168, 3.9129, 3.9086, 3.9051, 3.9032, 3.9029, 3.9038, 3.9051, 3.9065, 3.908, 3.9096, 3.9114, 3.9136, 3.9161, 3.9188, 3.9211, 3.9223, 3.9216, 3.9192, 3.9157, 3.9122, 3.9099, 3.9091, 3.9095, 3.9107, 3.912, 3.9133, 3.9147, 3.9162, 3.9181, 3.9205, 3.9232, 3.9257, 3.9271, 3.9269, 3.9249, 3.9216, 3.9183, 3.9161, 3.9153, 3.9158, 3.9168, 3.9179, 3.9187, 3.9194, 3.9202, 3.9213, 3.9229, 3.9249, 3.9268, 3.9281, 3.9272, 3.9255, 3.923, 3.9181, 3.9133, 3.9098, 3.9173, 3.9305};
        int[] loc = FindPeaks.findPeaks1(data, data.length);//loc为极小值位置,这里是用于切割独立波的，但是要是想实时显示的话，这部分得在安卓写，可能和你实时显示心率的非常相似，应该不难
        for (int k = 1; k < loc.length - 1; k++) {
            double[] onewave = cut(data, loc[k], loc[k + 1]);//注意！！如果要实时显示的话，这里你要检测出来最低值（我这里是切割成独立波了，但这并不符合实时要求），
            //也就是在安卓端分割成独立波，这部分的代码我真的不会写，如果要实时显示血压值的话，从此部分以下是你安卓端的核心代码。有疑问打电话。
//    	double[] onewave=new double[onewave1.length];
//    	for (int z=0;z<onewave.length;z++){
//    		System.out.println(onewave[z]);  
//    	}
//    	
            double[] newonewave = newdata(onewave);//插值成10个

            int[] loc2 = FindPeaks.findPeaks(newonewave, newonewave.length);//找到每一个独立波的顶点


            double[] upwave = cut(newonewave, 0, loc2[0]);
            int SUT = upwave.length;
            double minupwave = min(upwave);
            double[] newupwave = new double[upwave.length];
            for (int z = 0; z < upwave.length; z++) {
                newupwave[z] = (upwave[z] - minupwave);
            }
            double shigh = newupwave[upwave.length - 1] - newupwave[0];
//      	  System.out.println(shigh);  
            int sw10 = cutlength(newupwave, 0.1 * shigh);
            int sw25 = cutlength(newupwave, 0.25 * shigh);
            int sw33 = cutlength(newupwave, 0.33 * shigh);
            int sw50 = cutlength(newupwave, 0.5 * shigh);
            int sw66 = cutlength(newupwave, 0.66 * shigh);
            int sw75 = cutlength(newupwave, 0.75 * shigh);


            double[] downwave = cut(newonewave, loc2[0] + 1, newonewave.length - 1);
            int DT = downwave.length;
            double mindownwave = min(downwave);
            double[] newdownwave = new double[downwave.length];
            for (int z = 0; z < downwave.length; z++) {
                newdownwave[z] = (downwave[z] - mindownwave);
            }
            double dhigh = newdownwave[downwave.length - 1] - newdownwave[0];
            //System.out.println(dhigh);
            double dw10 = cutlength(newdownwave, 0.1 * dhigh);
            double dw25 = cutlength(newdownwave, 0.25 * dhigh);
            double dw33 = cutlength(newdownwave, 0.33 * dhigh);
            double dw50 = cutlength(newdownwave, 0.5 * dhigh);
            double dw66 = cutlength(newdownwave, 0.66 * dhigh);
            double dw75 = cutlength(newdownwave, 0.75 * dhigh);
            double sdw10 = sw10 + dw10;
            double dsdw10 = dw10 / sw10;
            double sdw25 = sw25 + dw25;
            double dsdw25 = dw25 / sw25;
            double sdw33 = sw33 + dw33;
            double dsdw33 = dw33 / sw33;
            double sdw50 = sw50 + dw50;
            double dsdw50 = dw50 / sw50;
            double sdw66 = sw66 + dw66;
            double dsdw66 = dw66 / sw66;
            double sdw75 = sw75 + dw75;
            double dsdw75 = dw75 / sw75;
            double[] index = new double[21];
            index[0] = SUT;
            index[1] = DT;
            index[2] = sw10;
            index[3] = sdw10;
            index[4] = dsdw10;
            index[5] = sw25;
            index[6] = sdw25;
            index[7] = dsdw25;
            index[8] = sw33;
            index[9] = sdw33;
            index[10] = dsdw33;
            index[11] = sw50;
            index[12] = sdw50;
            index[13] = dsdw50;
            index[14] = sw66;
            index[15] = sdw66;
            index[16] = dsdw66;
            index[17] = sw75;
            index[18] = sdw75;
            index[19] = dsdw75;
            index[20] = 1;

            double[] highlinear = {-0.0141695308746375, 0.124514673756680, 2.91891907150545, -1.73543317769192, 29.7706514633325, 1.89003959594315, -1.74367630176961, 17.0293835574325, -4.68390081568273, 1.27447548792587, -8.47617739787337, -3.42989954043880, 1.07852460495530, -5.64326004574694, 6.14118371736822, -1.37687531927999, 5.88286130863679, 7.72229480589957, 1.10196544797836, 5.71695603892585, 33.3086261309679};
            double[] lowlinear = {-0.0621887441943530, -0.292516289680269, -0.0666167749995780, 0.215053032916887, 4.85563985289613, 1.84863853747798, -0.973486114606966, 12.1705848849598, -2.33050146046521, 0.778641443825689, -6.83689846262005, -1.95279214675570, 0.339701683423402, -7.21008891101360, 3.96824609349301, -1.94283642587498, 8.52859878912821, 2.27929902467412, 0.846829085786168, 4.29719364255601, 36.8946614586999};


            double highbp = 10;
            double lowbp = 10;
            for (int i = 0; i < 21; i++) {
                //System.out.println(index[i]);
                highbp = highbp + index[i] * highlinear[i];
                lowbp = lowbp + index[i] * lowlinear[i];
            }
            hBPList.add(highbp);
            lBPList.add(lowbp);

            System.out.println("高压：" + highbp);
            System.out.println("低压：" + lowbp);

            //double[] mapindex=mapminmax(index);
//          double[][] finalindex=new double[18][1];
//        //finalindex[0][0]=1;
//          for(int i=0;i<18;i++){
//        	finalindex[i][0]=mapindex[i];
//          }
//          Matrix Index=Matrix.constructWithCopy(finalindex);//把指标转换成矩阵
//      
//		
//	        
//          double[] result=fitnet.fitnnet(Index);//resulet存着结果[0]是高压[1]是低压

        }

        // 去掉高压计算中过低和过高的数值
        double highBloodPressureAver = MathUtil.getAverage(hBPList);
        double lowBloodPressureAver = MathUtil.getAverage(lBPList);


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
        int newlength = data.length * 125 / 100;

        double step = (1.0 / newlength);

//System.out.println(step);
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

