package com.problem.solutions.coding.blocks;

import java.util.Arrays;

public class WineProfit {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 2, 5};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return getMaxProfit(arr, 0, arr.length - 1, dp);
    }

    private static int getMaxProfit(int[] arr, int i, int j, int[][] dp) {
        if (i >= arr.length || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int year = arr.length - (j - i);
        if (i == j) {
            return arr[i] * year;
        }
        int result1 = getMaxProfit(arr, i + 1, j, dp) + (arr[i] * year);
        int result2 = getMaxProfit(arr, i, j - 1, dp) + (arr[j] * year);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];
    }
}
