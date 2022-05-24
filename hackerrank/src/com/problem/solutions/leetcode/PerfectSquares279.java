package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectSquares279 {
    public static void main(String[] args) {
        int target = 12;
        System.out.println(countSquares(target));

    }

    private static int countSquares(int target) {
        int range = (int) Math.sqrt(target);
        int[][] dp = new int[range + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return countSquares(target, range, dp);
    }

    private static int countSquares(int target, int i, int[][] dp) {
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
            return countSquares(target, i - 1, dp);
        }
        int result1 = countSquares(target - (i * i), i, dp) + 1;
        int result2 = countSquares(target, i - 1, dp);
        dp[i][target] = Math.min(result1, result2);
        return dp[i][target];
    }


}
