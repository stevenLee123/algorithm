/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/29
 * Time: 20:47
 * Description: 插入排序,与冒泡排序的时间复杂度一样，为O（n^2）
 * 从数组的第二个元素开始以依次选出元素，与前面的元素依次进行比较，如果前面的元素比选出的元素大，则往后移该元素，如果遇到比该元素小的元素，则将选出元素插入到该元素后面
 *
 */
package com.steven.sort;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // 这里j要定义在for循环外面
        int j;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; (j > 0) && (tmp < arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345};
        insertionSort(arr);
        for (int a:
                arr) {
            System.out.println(a);
        }
    }
}
