package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

//Problem: https://leetcode.com/problems/perfect-squares/

public class PerfectSquares279 {
    public static void main(String[] args) {
        int target = 12;
        System.out.println(countSquares1(target));
        System.out.println(countSquares2(target));

    }

    private static int countSquares1(int target) {
        int range = (int) Math.sqrt(target);
        int[][] dp = new int[range + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return countSquares1(target, range, dp);
    }

    private static int countSquares1(int target, int i, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (i == 0 || target < 0) {
            return 9999;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if (target < i * i) {
            return countSquares1(target, i - 1, dp);
        }
        int result1 = countSquares1(target - (i * i), i, dp) + 1;
        int result2 = countSquares1(target, i - 1, dp);
        dp[i][target] = Math.min(result1, result2);
        return dp[i][target];
    }

    private static int countSquares2(int target) {
        int range = (int) Math.sqrt(target);
        int[][] dp = new int[range + 1][target + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = 99999;
            }
        }
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < i*i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - (i* i)] + 1);
                }
            }
        }
        return dp[range][target];

    }


}
