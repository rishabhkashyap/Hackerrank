package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromeCut132 {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(minPalindromicCuts(str));
    }

    private static int minPalindromicCuts(String str) {
        int[][] dp = new int[str.length()][str.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minPalindromicCuts(str, 0, str.length() - 1, dp);
    }

    private static int minPalindromicCuts(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if (isPalindrome(str, i, k)) {
                dp[i][j] = Math.min(dp[i][j], minPalindromicCuts(str, i, k, dp)
                        + minPalindromicCuts(str, k + 1, j, dp) + 1);

            }

        }
        return dp[i][j];
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
