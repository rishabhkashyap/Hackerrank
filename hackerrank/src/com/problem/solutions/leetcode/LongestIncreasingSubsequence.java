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
    }

    private static int longestIncreasingSubsequenceLength(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return longestIncreasingSubsequenceLength(arr, -1, 0, dp);
        //return lengthofLIS(arr, Integer.MIN_VALUE, 0);
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



}
