
//Problem: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
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
        System.out.println(isEqualSubsetAvailable(arr));
    }

    private static boolean isEqualSubsetAvailable(int[] arr) {
        double sum = Arrays.stream(arr).sum();
        int[][] dp = new int[arr.length + 1][(int) sum + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return isEqualSubsetAvailable(arr, sum / 2, 0, dp);

    }

    private static boolean isEqualSubsetAvailable(int[] arr, double target, int i,
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
        boolean result1 = isEqualSubsetAvailable(arr, target - arr[i], i + 1, dp);
        boolean result2 = isEqualSubsetAvailable(arr, target, i + 1, dp);
        dp[i][(int) target] = result1 || result2 == true ? 1 : 2;
        return result1 || result2;
    }


}
