//Problem: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ASCIISum712 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string1 = bufferedReader.readLine();
        String string2 = bufferedReader.readLine();
        System.out.println(findMinASCIISum1(string1, string2));
        System.out.println(findMinASCIISum2(string1, string2));
    }

    private static int findMinASCIISum1(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return findMinASCIISum1(str1, str1.length() - 1, str2, str2.length() - 1, dp);
    }

    private static int findMinASCIISum1(String str1, int i, String str2, int j, int[][] dp) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            return findMinASCIISum1(str1, i, str2, j - 1, dp) + (int) str2.charAt(j);
        }
        if (j < 0) {
            return findMinASCIISum1(str1, i - 1, str2, j, dp) + (int) str1.charAt(i);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return findMinASCIISum1(str1, i - 1, str2, j - 1, dp);
        }

        int result1 = findMinASCIISum1(str1, i - 1, str2, j, dp) + (int) str1.charAt(i);
        int result2 = findMinASCIISum1(str1, i, str2, j - 1, dp) + (int) str2.charAt(j);
        dp[i][j] = Math.min(result1, result2);
        return dp[i][j];
    }

    private static int findMinASCIISum2(String string1, String string2) {
        int[][] dp = new int[string1.length() + 1][string2.length() + 1];
        //When one of the input strings is empty, the answer is the ASCII-sum of the other string.
        //dp[i][string2.length()] = dp[i+1][string1.length()] + string1.codePointAt(i).
        for (int i = 1; i <= string1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + string1.codePointAt(i - 1);
        }
        for (int j = 1; j <= string2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + string2.codePointAt(j - 1);
        }
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + string1.codePointAt(i - 1), dp[i][j - 1] + string2.codePointAt(j - 1));
                }
            }
        }
        return dp[string1.length()][string2.length()];
    }


}
