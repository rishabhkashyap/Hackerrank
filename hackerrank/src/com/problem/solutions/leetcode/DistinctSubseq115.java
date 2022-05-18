package com.problem.solutions.leetcode;

import java.util.Arrays;

public class DistinctSubseq115 {
    public static void main(String[] args) {
        String str = "rabbbit";
        String pattern = "rabbit";
        System.out.println(countSubsequences1(str, pattern));
        System.out.println(countSubsequences2(str, pattern));
    }

    private static int countSubsequences1(String str, String pattern) {
        int[][] dp = new int[str.length() + 1][pattern.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return countSubsequences1(str, pattern, 0, 0, dp);
    }

    private static int countSubsequences1(String str, String pattern, int i, int j, int[][] dp) {
        if (j == pattern.length()) {
            return 1;
        }
        if (i >= str.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str.charAt(i) == pattern.charAt(j)) {
            dp[i][j] = countSubsequences1(str, pattern, i + 1, j + 1, dp)
                    + countSubsequences1(str, pattern, i + 1, j, dp);
        } else {
            dp[i][j] = countSubsequences1(str, pattern, i + 1, j, dp);
        }
        return dp[i][j];
    }


    //Code not working
    private static int countSubsequences2(String string, String pattern) {
        int[][] dp = new int[string.length() + 1][pattern.length() + 1];
        for (int i = string.length() - 1; i >= 0; --i) {
            for (int j = pattern.length() - 1; j >= 0; --j) {
                if (j == pattern.length()) {
                    dp[0][j] = 1;
                } else {

                    if (string.charAt(i) == pattern.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }

}
