package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem:https://leetcode.com/problems/burst-balloons/
public class BurstBallon312 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        // int[]arr={1,5};
        System.out.println(maxValue(arr));
    }

    private static int maxValue(int[] arr) {
        int[][] dp=new int[arr.length+1][arr.length+1];
        for(int[]dpArr:dp){
            Arrays.fill(dpArr,-1);
        }
        return maxValue(arr, 0, arr.length - 1,dp);
    }

    private static int maxValue(int[] arr, int i, int j,int[][] dp) {
        if (i > j) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int result = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {

            int left = i - 1 < 0 ? 1 : arr[i - 1];
            int right = j + 1 >= arr.length ? 1 : arr[j + 1];
            int temp = left * arr[k] * right;
            temp += maxValue(arr, i, k - 1,dp);
            temp += maxValue(arr, k + 1, j,dp);
            result = Math.max(result, temp);

        }
        dp[i][j]=result;
        return result;
    }


}
