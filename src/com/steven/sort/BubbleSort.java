/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/29
 * Time: 20:30
 * Description: 冒泡排序，这里只针对数组,时间复杂度 O（n^2）
 * 将数组循环n轮，每一轮遍历分别比较相邻两个元素的大小，将较大的元素放在后面
 */
package com.steven.sort;

public class BubbleSort {
    // 最原始的冒泡排序
    public static void bubbleSort(int[] arr) {
        int count = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                count ++;
            }
        }
        System.out.println("count: "+ count);
    }
    //判断每一趟比较是否有元素进行了交换，没有则表明已经完成了排序
    public static void bubbleSort2(int[] arr) {
        boolean flag = false;
        int count = 0;
        for (int i = arr.length-1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
                count ++;
            }
            if(!flag) break;
        }
        System.out.println("count: "+ count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345};
        bubbleSort(arr);
//        bubbleSort2(arr);
        for (int a:
             arr) {
            System.out.println(a);
        }
    }
}
