/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/31
 * Time: 7:58
 * Description: 归并排序，递归写法
 * 利用有序子序列的合并操作，将数组不断分解，直到其为有序的子序列对为止，在对子序列对进行排序，
 * 一步一步递归将为两个有序的子序列，再对这对有序子序列进行操作
 * 核心思想：分而治之
 */
package com.steven.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345};
        mergeSort(arr);
        for (int a :
                arr) {
            System.out.println(a);
        }
    }
    // 入口函数
    public static void mergeSort(int[] arr) {
        int[] tmpArr= new int[arr.length];
        sort(arr,tmpArr, 0, arr.length - 1);
    }
    // 数组分解为子序列,这里传递tmpArr是为了降低空间使用了，避免重复开辟数组空间
    public static void sort(int[] arr,int[] tmpArr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr,tmpArr, L, mid);
        sort(arr,tmpArr,mid + 1, R);
        merge(arr,tmpArr, L, mid, R);
    }
    // 子序列排序
    public static void merge(int[] arr, int[] tmpArr, int L, int mid, int R) {
//        int[] tempArr = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int length = R - L + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            tmpArr[L++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            tmpArr[L++] = arr[p1++];
        }
        while(p2 <= R) {
            tmpArr[L++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
//        for(i = 0; i < temp.length; i++) {
//            arr[L + i] = temp[i];
//        }
        for (int j = R; j > R-length ; j--) {
            arr[j] = tmpArr[j];
        }
    }
}
