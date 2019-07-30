/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/7/29
 * Time: 22:03
 * Description: 堆排序：建立最大堆，利用最大堆为根节点的特性 时间复杂度 O（n^2）
 */
package com.steven.sort;

public class HeapSort {
//    public static void main(String[] args) {
//        int[] nums = new int[]{11,1,34,45,23,4,234,23, 345,12,14,16};
//        headSort(nums);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//    }

//    /**
//     * 堆排序
//     */
//    public static void headSort(int[] list) {
//        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
//        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
//            headAdjust(list, list.length, i);
//        }
//        //排序，将最大的节点放在堆尾，然后从根节点重新调整
//        for (int i = list.length - 1; i >= 1; i--) {
//            int temp = list[0];
//            list[0] = list[i];
//            list[i] = temp;
//            headAdjust(list, i, 0);
//        }
//    }
//
//    private static void headAdjust(int[] list, int len, int i) {
//        int k = i, temp = list[i], index = 2 * k + 1;
//        while (index < len) {
//            if (index + 1 < len) {
//                if (list[index] < list[index + 1]) {
//                    index = index + 1;
//                }
//            }
//            if (list[index] > temp) {
//                list[k] = list[index];
//                k = index;
//                index = 2 * k + 1;
//            } else {
//                break;
//            }
//        }
//        list[k] = temp;
//    }


        public static void heapSort(int[] arr) {
            // 建堆
            Heap.heapcreate(arr);

//            for (int a :
//                    arr) {
//                System.out.println(a);
//            }
            for (int i = arr.length-1; i >0; i--) {
                int max = arr[0];
                arr[0] = arr[i];
                arr[i] = max;
                Heap.heapAdjust(arr,0, i);
            }
            for (int a :
                    arr) {
                System.out.println(a);
            }
        }

    public static void main(String[] args) {
        int[] arr = new int[]{11,1,34,45,23,4,234,23, 345,12,14,16};
        heapSort(arr);
    }
}

// 最小堆
class Heap {
    private int[] arr;
    // 容量
    private int capacity;
    // 大小
    private int size;

    public Heap(int[] arr) {
        this.arr = arr;
    }

    // 插入
    public void insert(int a) {

    }

    // 删除
    public void delete(int a) {

    }


    // 创建堆，n/2处的节点即叶节点，必为堆，不必排序
    public static int heapcreate(int[] arr) {
       if(arr.length < 1){
           return -1;
       }
        for (int i = arr.length/2-1; i >= 0; i--) {
            heapAdjust(arr,i,arr.length);
        }
        return 0;
    }
    // 从位置i开始调整堆
    public static void heapAdjust(int[] arr,int i,int length) {
        int tmp = arr[i];
        //查找2i与2i+1的子节点，比较两个子节点的大小，再用大的与tmp比较
        for (int j = 2 * i+1; j < length; j = 2 * i + 1) {
            if(j+1 < length && arr[j] <arr[j+1]){
                ++j;
            }
            // tmp大于arr[j]表示不用调整了
            if(tmp >= arr[j]) {
                break;
            }
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = tmp;

    }
}
