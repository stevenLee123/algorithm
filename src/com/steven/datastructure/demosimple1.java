package com.steven.datastructure;

/**
 * @Author: StevenLee
 * @Email: 1144873128@qq.com
 * @Description:
 * @Date: create in 13:18 2019/7/27
 * @Modified By: 空间复杂度：
 *                  循环与递归 实际中尽量避免递归，过多的递归会导致栈内存溢出错误StackOverflowError，递归需要暂用太多空间
 *
 */
public class demosimple1 {
    public static void printN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
    public static void printN2(int n) {
        if(n > 0) {
            printN2(n-1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        printN(5000);
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("print2start.....");
        Long start2 = System.currentTimeMillis();
        printN2(5000);
        Long end2 = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
