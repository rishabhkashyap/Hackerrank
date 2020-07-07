//Problem: https://leetcode.com/problems/minimum-path-sum/

package com.problem.solutions.leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(findMinPathSum1(arr));
        System.out.println(findMinPathSum2(arr));
    }

    private static int findMinPathSum1(int[][] arr) {
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findMinPathSum1(arr, 0, 0, dp);
    }

    private static int findMinPathSum1(int[][] arr, int i, int j, int[][] dp) {

        if (i >= arr.length || j >= arr[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == arr.length - 1) {
            return findMinPathSum1(arr, i, j + 1, dp) + arr[i][j];
        }
        if (j == arr[0].length - 1) {
            return findMinPathSum1(arr, i + 1, j, dp) + arr[i][j];
        }
        int result1 = findMinPathSum1(arr, i + 1, j, dp) + arr[i][j];
        int result2 = findMinPathSum1(arr, i, j + 1, dp) + arr[i][j];
        dp[i][j] = Math.min(result1, result2);
        return dp[i][j];
    }

    private static int findMinPathSum2(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j != 0) {
                    arr[i][j] += arr[i][j - 1];
                } else if (i != 0 && j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else if (i == 0 && j == 0) {
                    arr[i][j] = arr[i][j];
                } else {
                    arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j]) + arr[i][j];
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
