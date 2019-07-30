/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/29
 * Time: 21:47
 * Description: 选择排序 ，时间复杂度O(n^2)
 * 从数组中找到最小的元素，并将其赋值给数组第一个位置，以此类推，第二次从第二个元素开始查找最小元素并将其赋值给第二个元素，直到最后一个元素
 */
package com.steven.sort;

public class SelectionSort {
    // 选择排序
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            // 优化方案：优化查找最小元素的算法
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j + 1] < min) {
                    min = arr[j+1];
                    index = j+1;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345};
        selectionSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

}
