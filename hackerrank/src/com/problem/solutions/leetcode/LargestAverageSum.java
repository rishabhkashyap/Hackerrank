//Problem:https://leetcode.com/problems/largest-sum-of-averages/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestAverageSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[stringTokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(calculateLargestAverageSum(arr, k));

    }

    private static double calculateLargestAverageSum(int[] arr, int k) {
        //ith location stores sum of element till ith element
        double[] preSum = new double[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        double[][] dp = new double[arr.length + 1][k + 1];
        for (double[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return calculateLargestAverageSum(arr, k, 0, preSum, dp);
    }

    private static double calculateLargestAverageSum(int[] arr, int k, int i, double[] preSum, double[][] dp) {

        if (i >= arr.length) {
            return 0;
        }
        if (k == 1) {
            return (preSum[arr.length - 1] - preSum[i] + arr[i]) / (arr.length - i);
        }
        if (k > arr.length) {
            return 0;
        }
        if (k == arr.length) {
            return preSum[arr.length - 1];
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        double result = 0;
        for (int j = i; j < arr.length; j++) {
            //preSum[j] - preSum[i]: sum of elements from i to j where j is excluded and i in included
            double result1 = ((preSum[j] - preSum[i] + arr[i]) / (j - i + 1));
            double result2 = calculateLargestAverageSum(arr, k - 1, j + 1, preSum, dp);
            dp[i][k] = Math.max(dp[i][k], (result1 + result2));

        }
        return dp[i][k];
    }


}

