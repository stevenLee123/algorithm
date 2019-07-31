/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/31
 * Time: 22:15
 * Description: 归并排序2 非递归写法 稳定
 * 将数组分为n个子序列，每个子序列长度为1，对相邻子序列进行归并,开辟临时数组，第一次归并到临时数组中，第二次归并到原始数组，第三次再归并到临时数组
 */
package com.steven.sort;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345, 56, 12,13};
        mergeSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

    // 入口函数
    public static void mergeSort(int[] arr) {
        int[] tmpArr = new int[arr.length];
        int subLength = 1;
        while(subLength < arr.length) {
            sort(arr,tmpArr,subLength);
            subLength *= 2;
            sort(tmpArr,arr,subLength);
            subLength *= 2;
        }
    }

    /**
     *
     * @param arr
     * @param tmpArr
     * @param subLength 归并子序列长度
     */
    public static void sort(int[] arr, int tmpArr[],int subLength) {
        int i;
        for (i = 0; i <= arr.length - 2*subLength; i += 2*subLength) {
            merge(arr, tmpArr,i,i+subLength-1,i + 2*subLength - 1);
        }
        // 数组尾巴处理
        if(i + subLength < arr.length) {
            merge(arr,tmpArr,i,i + subLength-1,arr.length-1);
        } else {
            for (int j = i; j < arr.length; j++) {
                tmpArr[j] = arr[j];
            }
        }
    }

    public static void merge(int[] arr, int[] tmpArr,int L, int middle, int R) {
        int p1 =  L;
        int p2 = middle + 1;
        int length = R - L + 1;
        while(p1 <= middle && p2 <= R) {
            tmpArr[L++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= middle) {
            tmpArr[L++] = arr[p1++];
        }
        while (p2 <= R) {
            tmpArr[L++] = arr[p2++];
        }
        for (int i = R; i >R - length ; i--) {
            arr[i] = tmpArr[i];
        }
    }

}
