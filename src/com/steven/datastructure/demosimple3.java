package com.steven.datastructure;

/**
 * @Author: StevenLee
 * @Email: 1144873128@qq.com
 * @Description:
 * @Date: create in 14:52 2019/7/27
 * @Modified By: 最大子列和问题 给定一个列求其最大子列和
 * 1.暴力求解 T（n） = O(n^3)
 * 2.简单优化（在暴力求解的基础上第三层循环中避免使用） 时间复杂度 T（n） = O(n^2)
 * 3.分而治之（将串分成两个部分，左边右边分别计算最大子串，再计算合并的之后的子串，使用递归调用将）T（n） = O(nlogn)
 * 4.在线处理 只需要一个for循环，向右累加，如果发现更大的子串，更新当前结果，如果当前自子串为负，则不可能使的后面部分增大，抛弃掉
 */
public class demosimple3 {
    // 暴力求解
    public static  int getSubcolumnSum(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            if(i == 0) {
                maxSum = a[0];
            }
            for (int j = i; j < a.length ; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if(thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
    // j这层循环已经计算过的值不需要再k循环里重复计算
    public static int getSubcolumnSum2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            if(i == 0) {
                maxSum = a[0];
            }
            int thisSum = 0;
            for (int j = i; j < a.length ; j++) {
                //在前一次循环的基础上累加即可
                thisSum += a[j];
                if(thisSum >maxSum) {
                    maxSum  = thisSum;
                }
            }
        }
        return maxSum;
    }

    // 分而治之
    public static int getSubcolumnSum3(int a[], int left,int right) {
        int mid=0;
        int maxLeft=0, maxRight=0, maxMiddle=0;
        //如果只有一个数
        if (left == right)
        {
            if (a[left] > 0)
                return a[left];
            else
                return 0;
        }
        //求中间值
        mid = (left + right) / 2;
        //对左边的子列用分而治之法
        maxLeft = getSubcolumnSum3(a, left, mid);
        //对右边的子列用分而治之法
        maxRight = getSubcolumnSum3(a, mid + 1, right);
        //遍历整个子列
        maxMiddle = maxCross(a,left,mid,right);
        return Max(maxLeft, maxRight, maxMiddle);
    }
    //求三个数的最大值
    private  static int Max(int a, int b, int c) {
        int max;
        max = (a > b) ? a : b;
        max = (max > c) ? max : c;
        return max;
    }

    //遍历整个子列求最大值
    private static int maxCross(int a[], int left, int mid, int right) {
        int leftSum=0,rightSum=0,sum=0;
        int i;
        //遍历从中间到左边
        for (i = mid; i >=left; i--)
        {
            sum += a[i];
            if (sum > leftSum)
                leftSum = sum;
        }
        //遍历从中间到右边
        sum = 0;
        for (i = mid + 1; i <= right; i++)
        {
            sum += a[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        return leftSum + rightSum;
    }

    // 在线处理
    private static int getSubcolumnSum4(int[] a) {
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if(thisSum > maxSum) {
                maxSum = thisSum;
            } else if(thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] a=  new int[]{1,2,-4,5,4,-5,6,6,22,-76,7,7,-345,8,8,8};
        System.out.println(getSubcolumnSum(a));
        System.out.println(getSubcolumnSum2(a));
        System.out.println(getSubcolumnSum3(a,0,a.length-1));
        System.out.println(getSubcolumnSum4(a));
    }
}
