/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/31
 * Time: 23:26
 * Description: 快速排序（与归并类似） 分而治之
 */
package com.steven.sort;

public class FastSort {

    public static int median3(int[] arr,int left ,int right) {
        int middle = (left+right)/2;
        if(arr[left] > arr[middle]) {
            swap(arr,left,middle);
        }
        if(arr[right] >arr[arr.length-1]) {
            swap(arr,right,arr.length-1);
        }
        if(arr[middle] >arr[right]) {
            swap(arr,middle,right);
        }
        swap(arr,middle,right-1);
        return arr[right-1];
    }
    public static void swap(int[] arr, int index1,int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
