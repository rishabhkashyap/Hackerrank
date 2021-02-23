//Problem: hackerearth.com/problem/algorithm/mancunian-and-k-ordered-lcs-e6a4b8c6/

package com.problem.solutions.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KOrderLCS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr1 = readArray(bufferedReader, m);
        int[] arr2 = readArray(bufferedReader, n);
        System.out.println(longestSubSeqLen(arr1, arr2, k));
    }

    private static int[] readArray(BufferedReader bufferedReader, int m) throws IOException {
        int[] arr = new int[m];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    private static int longestSubSeqLen(int[] arr1, int[] arr2, int k) {
        int[][][] dp = new int[arr1.length][arr2.length][k+1];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int m = 0; m < k+1; m++) {
                    dp[i][j][m] = -1;
                }

            }
        }
        return longestSubSeqLen(arr1, arr2, 0, 0, k, dp);
    }

    private static int longestSubSeqLen(int[] arr1, int[] arr2, int i, int j, int k, int[][][] dp) {
        if (i >= arr1.length || j >= arr2.length) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (arr1[i] == arr2[j]) {
            return longestSubSeqLen(arr1, arr2, i + 1, j + 1, k, dp) + 1;
        } else {
            if (k > 0) {
                return longestSubSeqLen(arr1, arr2, i + 1, j + 1, k - 1, dp) + 1;
            }
        }
        int result1 = longestSubSeqLen(arr1, arr2, i + 1, j, k, dp);
        int result2 = longestSubSeqLen(arr1, arr2, i, j + 1, k, dp);
        dp[i][j][k] = Math.max(result1, result2);
        return dp[i][j][k];
    }
}
