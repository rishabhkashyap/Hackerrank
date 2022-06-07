package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem link: https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII63 {
    public static void main(String[] args) {
        //int[][] arr = {{0, 1}, {0, 0}};
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(countUniquePaths1(arr));
    }

    private static int countUniquePaths1(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return countUniquePaths1(arr, 0, 0, dp);
    }

    private static int countUniquePaths1(int[][] arr, int i, int j, int[][] dp) {
        if (i == arr.length - 1 && j == arr[0].length - 1 && arr[i][j] == 0) {
            return 1;
        }
        if (i >= arr.length || j >= arr[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (arr[i][j] == 1) {
            return 0;
        }
        dp[i][j] = countUniquePaths1(arr, i + 1, j, dp);
        dp[i][j] += countUniquePaths1(arr, i, j + 1, dp);
        return dp[i][j];

    }
}
