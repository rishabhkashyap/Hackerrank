package com.problem.solutions.leetcode;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/edit-distance/
public class EditDistance72 {
    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        System.out.println(minOperation1(str1, str2));
        System.out.println(minOperation2(str1, str2));
    }

    private static int minOperation1(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minOperation1(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    private static int minOperation1(String str1, String str2, int i, int j, int[][] dp) {
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
            return minOperation1(str1, str2, i - 1, j - 1, dp);
        }
        int insertOp = minOperation1(str1, str2, i, j - 1, dp);
        int deleteOp = minOperation1(str1, str2, i - 1, j, dp);
        int replaceOp = minOperation1(str1, str2, i - 1, j - 1, dp);
        dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
        return dp[i][j];
    }

    private static int minOperation2(String str1, String str2) {
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
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }
}
