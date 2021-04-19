package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Problem: https://leetcode.com/problems/partition-array-for-maximum-sum/submissions/
public class MaxSumPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int k = Integer.parseInt(bufferedReader.readLine());
        System.out.println(getMaxSum(arr, k));
    }

    private static int getMaxSum(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return getMaxSum(arr, 0, k, dp);
    }

    private static int getMaxSum(int[] arr, int i, int k, int[] dp) {
        if (i == arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int maxElement = 0;
        int maxSum = 0;
        for (int j = i; j < i + k && j < arr.length; ++j) {
            maxElement = Math.max(maxElement, arr[j]);
            maxSum = Math.max(maxSum, maxElement * (j - i + 1) + getMaxSum(arr, j + 1, k, dp));

        }
        dp[i] = maxSum;
        return dp[i];
    }
}
