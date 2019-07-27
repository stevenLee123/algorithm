package com.steven.datastructure;

/**
 * @Author: StevenLee
 * @Email: 1144873128@qq.com
 * @Description:
 * @Date: create in 13:54 2019/7/27
 * @Modified By: 时间复杂度 求多项式的和
 *
 */
public class demosimple2 {
    // 直接使用循环
    public static double getMultinomialCount(int n, double[] a, double x) {
        Double result = 0d;
        for (int i = 0; i < n; i++) {
            result += a[i]*Math.pow(x,i);
        }
        return result;
    }
    // 使用结合律
    public static double getMultinomialCount2(int n, double[] a,double x) {
        Double result = a[n];
        for (int i = n; i > 0  ; i--) {
            result = a[i-1] + result*x;
        }
        return result;
    }
    public static void main(String[] args) {
        double[] a= new double[]{1,2,3,4,5,6,7,8,9,10,11,12};
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getMultinomialCount(a.length,a,2.2);
//            System.out.println();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        Long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getMultinomialCount2(a.length-1,a,2.2);
//            System.out.println(getMultinomialCount2(a.length-1,a,2.2));
        }
        Long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);
    }
}
