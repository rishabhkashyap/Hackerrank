//Problem: https://leetcode.com/problems/partition-equal-subset-sum/description/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class EqualSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(isEqualSubsetAvailable1(arr));
        System.out.println(isEqualSubsetAvailable2(arr));
    }

    private static boolean isEqualSubsetAvailable1(int[] arr) {
        double sum = Arrays.stream(arr).sum();
        int[][] dp = new int[arr.length + 1][(int) sum + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return isEqualSubsetAvailable1(arr, sum / 2, 0, dp);

    }

    private static boolean isEqualSubsetAvailable1(int[] arr, double target, int i,
                                                   int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || i >= arr.length) {
            return false;
        }
        if (dp[i][(int) target] == 1) {
            return true;
        } else if (dp[i][(int) target] == 2) {
            return false;
        }
        boolean result1 = isEqualSubsetAvailable1(arr, target - arr[i], i + 1, dp);
        boolean result2 = isEqualSubsetAvailable1(arr, target, i + 1, dp);
        dp[i][(int) target] = result1 || result2 == true ? 1 : 2;
        return result1 || result2;
    }


    private static boolean isEqualSubsetAvailable2(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) {
            return false;
        }
        return isEqualSubsetAvailable1(arr, sum / 2);

    }

    private static boolean isEqualSubsetAvailable1(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 1; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= target; ++i) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int w = 1; w <= target; ++w) {
                if (w >= arr[i - 1]) {
                    dp[i][w] = (dp[i - 1][w] || dp[i - 1][w - arr[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[arr.length][target];
    }


}
