//Problem: https://leetcode.com/problems/minimum-falling-path-sum/description/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class MinFallingPath {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(findMinPath(arr));
        System.out.println(findMinPathSum(arr));
    }

    private static int findMinPath(int[][] arr) {
        int minValue = Integer.MAX_VALUE;
        int[][] dp = new int[arr.length + 1][arr[0].length];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        for (int j = 0; j < arr[0].length; j++) {

            minValue = Math.min(minValue, findMinPath(arr, 0, j, dp));

        }
        return minValue;
    }

    private static int findMinPath(int[][] arr, int i, int j, int[][] dp) {
        if (j >= arr[0].length || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == arr.length - 1) {
            return arr[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result1 = findMinPath(arr, i + 1, j, dp);
        int result2 = findMinPath(arr, i + 1, j - 1, dp);
        int result3 = findMinPath(arr, i + 1, j + 1, dp);
        dp[i][j] = Math.min(result1, Math.min(result2, result3)) + arr[i][j];
        return dp[i][j];
    }

    private static int findMinPathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                if (j >= 1) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < arr[0].length) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                min = Math.min(min, dp[i - 1][j]);
                dp[i][j]+=arr[i][j] + min;

            }
        }
        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();

    }

}
