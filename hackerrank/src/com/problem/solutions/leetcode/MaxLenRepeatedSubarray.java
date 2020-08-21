//Problem: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxLenRepeatedSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr1 = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(tokenizer.nextToken());

        }
        tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr2 = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(findRepeatedSubarrayLen(arr1, arr2));
        System.out.println(findRepeatedSubarrrayLen2(arr1, arr2));

    }


    //Result TLE
    private static int findRepeatedSubarrayLen(int[] arr1, int[] arr2) {
        int maxLen = arr1.length < arr2.length ? arr1.length + 1 : arr2.length + 1;
        int[][][] dp = new int[arr1.length + 1][arr2.length + 1][maxLen];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return findRepeatedSubarrrayLen(arr1, 0, arr2, 0, dp, 0);
    }

    //Correct solution but TLE
    private static int findRepeatedSubarrrayLen(int[] arr1, int i, int[] arr2, int j, int[][][] dp, int count) {
        if (i >= arr1.length || j >= arr2.length) {
            return count;
        }
        if (dp[i][j][count] != -1) {
            return dp[i][j][count];
        }

        int result = count;
        if (arr1[i] == arr2[j]) {
            result = findRepeatedSubarrrayLen(arr1, i + 1, arr2, j + 1, dp, count + 1);
        }
        int result1 = findRepeatedSubarrrayLen(arr1, i + 1, arr2, j, dp, 0);
        int result2 = findRepeatedSubarrrayLen(arr1, i, arr2, j + 1, dp, 0);
        dp[i][j][count] = Math.max(result, Math.max(result1, result2));
        return dp[i][j][count];
    }

    private static int findRepeatedSubarrrayLen2(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        int maxLen = 0;
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = ++dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
