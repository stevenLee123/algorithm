/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/6/29
 * Time: 11:10
 * Description:LCS算法找出最长对称字符子串
 */
package com.steven.LCS;




public class LCSDemo2 {

    public static void main(String[] args) {
        //  输出最长对称字符串：goog
        String input1 = "google";
        //  输出最长对称字符串：aba
        String input2 = "abcda";
        // 输出2个最长对称字符串：pop/upu
        String input3 = "pop-upu";
        getLCS(input3);

    }


    public static int getLCS(String str) {
        StringBuilder sb = new StringBuilder(str);
        String newStr = sb.reverse().toString();
        char[] c1 = str.toCharArray();
        char[] c2 = newStr.toCharArray();
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (c1[j - 1] == c2[i - 1]) { //此处应该减1.
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }
        String result = getLCSSubString(dp, c1, c1.length, c2.length, new StringBuilder());
        System.out.println(result);
        return dp[n][n];
    }

    // 可能还存在问题。。。
    public static String getLCSSubString(int[][] LCSMatrix, char[] chars, int horIndex, int verIndex, StringBuilder result) {

        //横向找
        for (int i = horIndex,j = verIndex; j >0; j--) {
            // 如果是0，表示迭代结束
            if(i == 0 || j == 0){
                break;
            }
            if(LCSMatrix[i][j] == LCSMatrix[i][j-1]){
                continue;
            }else{
                result.append(chars[j - 1]);
                i--;
            }
        }
        StringBuilder verResult = new StringBuilder();
        //纵向找
        for (int i = horIndex,j = verIndex; i >0; i--) {
            // 如果是0，表示迭代结束
            if(i == 0 || j == 0){
                break;
            }
            if(LCSMatrix[i][j] == LCSMatrix[i-1][j]){
                continue;
            }else{
                if(i == horIndex){
                    break;
                }
                verResult.append(chars[j - 1]);
                    j--;
            }
        }
        if(verResult.length()>0){
            result.append("/"+verResult);
        }


        return result.toString();
    }

}
