/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/29
 * Time: 21:24
 * Description: 希尔排序 时间复杂度 O（n^2）
 * 间隔的排序插入排序
 */
package com.steven.sort;

public class ShellSort {

    // 原始希尔排序 时间复杂度 O（n^2）
    public static void shellSort(int[] arr) {
        for (int d = arr.length/2; d >0 ; d /= 2) {
            int j;
            for (int i = d; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; (j >= d) && (arr[j-d] > tmp) ; j -= d) {
                    arr[j] = arr[j-d];
                }
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345};
        shellSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }
}
