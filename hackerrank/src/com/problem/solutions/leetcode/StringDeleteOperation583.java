package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/delete-operation-for-two-strings/
public class StringDeleteOperation583 {
    public static void main(String[] args) {
        String str1 = "sea";
        String str2 = "eat";
        System.out.println(minDeleteSum(str1, str2));
    }

    private static int minDeleteSum(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        if (str1.equals(str2.length())) {
            return 0;
        }
        return minDeleteSum(str1, str1.length() - 1, str2, str2.length() - 1, dp);
    }

    private static int minDeleteSum(String str1, int i, String str2, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            return minDeleteSum(str1, i, str2, j - 1, dp) + 1;
        }
        if (j < 0) {
            return minDeleteSum(str1, i - 1, str2, j, dp) + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = Integer.MAX_VALUE;
        if (str1.charAt(i) == str2.charAt(j)) {
            return minDeleteSum(str1, i - 1, str2, j - 1, dp);
        }

        int result1 = minDeleteSum(str1, i - 1, str2, j, dp) + 1;
        int result2 = minDeleteSum(str1, i, str2, j - 1, dp) + 1;
        dp[i][j] = Math.min(result1, result2);
        return dp[i][j];
    }
}
