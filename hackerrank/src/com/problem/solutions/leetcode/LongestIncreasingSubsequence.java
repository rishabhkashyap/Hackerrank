//Problem: https://leetcode.com/problems/longest-increasing-subsequence/description/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(longestIncreasingSubsequenceLength(arr));
        System.out.println(longestIncreasingSubsequenceLen(arr));
    }

    private static int longestIncreasingSubsequenceLength(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return longestIncreasingSubsequenceLength(arr, -1, 0, dp);
    }

    private static int longestIncreasingSubsequenceLength(int[] arr, int previousIndex, int currentIndex,
                                                          int[][] dp) {
        if (currentIndex >= arr.length) {
            return 0;
        }
        if (dp[previousIndex + 1][currentIndex] != -1) {
            return dp[previousIndex + 1][currentIndex];
        }

        int result1 = 0;
        if (previousIndex < 0 || arr[currentIndex] > arr[previousIndex]) {
            result1 = longestIncreasingSubsequenceLength(arr, currentIndex, currentIndex + 1, dp) + 1;
        }
        int result2 = longestIncreasingSubsequenceLength(arr, previousIndex, currentIndex + 1, dp);

        dp[previousIndex + 1][currentIndex] = Math.max(result1, result2);
        return dp[previousIndex + 1][currentIndex];
    }

    private static int longestIncreasingSubsequenceLen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < arr.length; i++) {
            /*
             1. dp[i]: The best answer so far for the LIS from 0...i
             2. dp[j] + 1: The value of maxLength[j] is the length
                of the LIS from 0...j, we conceptually "append" this item to
                that LIS by adding 1 to that subproblem answer, yielding a
                potentially new answer for LIS[0..i]
            * */
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


}
