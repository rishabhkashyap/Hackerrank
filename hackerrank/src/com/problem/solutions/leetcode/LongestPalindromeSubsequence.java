
//Problem: https://leetcode.com/problems/longest-palindromic-subsequence/description/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class LongestPalindromeSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        System.out.println(getPalindomLength1(string));
        System.out.println(getPalindomLength2(string));
        System.out.println(getPalindomLength3(string));
    }

    private static int getPalindomLength1(String string) {
        return palindromeHelper1(string, 0, string.length() - 1);
    }


    //Recursion

    private static int palindromeHelper1(String string, int i, int j) {
        if (i >= string.length() || j < 0) {
            return 0;
        }
        if (string.charAt(i) == string.charAt(j)) {
            return palindromeHelper1(string, i + 1, j - 1) + 1;
        }
        int result1 = palindromeHelper1(string, i + 1, j);
        int result2 = palindromeHelper1(string, i, j - 1);
        return Math.max(result1, result2);
    }

    private static int getPalindomLength2(String string) {
        int[][] dp = new int[string.length() + 1][string.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return palindromeHelper2(string, 0, string.length() - 1, dp);
    }


    //Recursion+dp
    private static int palindromeHelper2(String string, int i, int j, int[][] dp) {
        if (i >= string.length() || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (string.charAt(i) == string.charAt(j)) {
            return palindromeHelper2(string, i + 1, j - 1, dp) + 1;
        }
        int result1 = palindromeHelper2(string, i + 1, j, dp);
        int result2 = palindromeHelper2(string, i, j - 1, dp);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];

    }

    private static int getPalindomLength3(String string) {
        int[][] dp = new int[string.length() + 1][string.length() + 1];
        int i = 0;
        int j = string.length() - 1;
        while (i < string.length() || j >= 0) {
            if (i + 1 < string.length() && j - 1 >= 0) {
                if (string.charAt(i) == string.charAt(j)) {
                    dp[i][j] = ++dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
            ++i;
            --j;

        }
        return dp[string.length() + 1][string.length() + 1];
    }
}
