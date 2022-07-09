package com.problem.solutions.leetcode;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/delete-operation-for-two-strings/
public class StringDeleteOperation583 {
    public static void main(String[] args) {
        String str1 = "sea";
        String str2 = "eat";
        System.out.println(minDeleteSum(str1, str2));
        System.out.println(minDeleteOps(str1, str2));
    }

    private static int minDeleteSum(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minDeleteSum(str1, str1.length() - 1, str2, str2.length() - 1, dp);
    }

    private static int minDeleteSum(String str1, int i, String str2, int j, int[][] dp) {
        if (i < 0 && j >= 0) {
            return j + 1;
        }
        if (j < 0 && i >= 0) {
            return i + 1;
        }
        if (i < 0 && j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return minDeleteSum(str1, i - 1, str2, j - 1, dp);
        }
        int result1 = minDeleteSum(str1, i - 1, str2, j, dp) + 1;
        int result2 = minDeleteSum(str1, i, str2, j - 1, dp) + 1;
        dp[i][j] = Math.min(result1, result2);
        return dp[i][j];
    }

    private static int minDeleteOps(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])+1;
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
