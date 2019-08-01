/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/31
 * Time: 23:26
 * Description: 快速排序（与归并类似） 分而治之 选择主元 子集划分
 */
package com.steven.sort;

public class FastSort {

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345,12,15};
        quickSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

    public static void quickSort(int[] arr) {
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr,int left,int right) {
        if(right - left > 1){
            int pivot = median3(arr,left,right);
            int i = left;
            int j = right-1;
            for (;;) {
                while (arr[++i] < pivot);
                while (arr[--j] > pivot);
                if (i < j) {
                    swap(arr,i,j);
                } else {
                    break;
                }
            }
            swap(arr,i,right-1);
            sort(arr,left,i-1);
            sort(arr,i+1,right);
        }
    }

    public static int median3(int[] arr,int left ,int right) {
        int middle = (left+right)/2;
        if(arr[left] > arr[middle]) {
            swap(arr,left,middle);
        }
        if(arr[left] >arr[right]) {
            swap(arr,left,right);
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
