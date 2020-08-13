//Problem: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
package com.problem.solutions.leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinScorePolygon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(findMinScoreTriangulation(arr));
        System.out.println(findMinScoreTriangulation2(arr));
    }

    private static int findMinScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, Integer.MAX_VALUE);
        }

        return findMinScoreTriangulation(arr, 0, arr.length - 1, dp);
    }

    private static int findMinScoreTriangulation(int[] arr, int left, int right, int[][] dp) {
        if (right - left + 1 < 3) {
            return 0;
        }
        if (dp[left][right] != Integer.MAX_VALUE) {
            return dp[left][right];
        }

        //Loops run till right -1 because we do not want to multiply right with k when k is equal to right
        //left  right and k must be three unique vertices in each execution
        for (int k = left + 1; k < right; k++) {
            int triangleProduct = arr[k] * arr[right] * arr[left];
            int result1 = findMinScoreTriangulation(arr, left, k, dp);
            int result2 = findMinScoreTriangulation(arr, k, right, dp);
            dp[left][right] = Math.min(dp[left][right], triangleProduct + result1 + result2);

        }
        return dp[left][right];

    }

    private static int findMinScoreTriangulation2(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int vertices = 2; vertices <= arr.length; vertices++) {
            for (int left = 0; left < arr.length - vertices; left++) {
                int right = left + vertices;
                dp[left][right] = Integer.MAX_VALUE;
                for (int k = left + 1; k < right; k++) {
                    int product = arr[k] * arr[left] * arr[right];
                    dp[left][right] = Math.min(dp[left][right], product + dp[left][k] + dp[k][right]);
                }

            }
        }
        return dp[0][arr.length - 1];
    }


}
