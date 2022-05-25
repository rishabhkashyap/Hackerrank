package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/coin-change/
public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(minCoinsChange1(coins, amount));
    }

    private static int minCoinsChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int result = minCoinsChange1(coins, amount, coins.length - 1, dp);
        return result == 99999 ? -1 : result;
    }

    private static int minCoinsChange1(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (i < 0 || amount < 0) {
            return 99999;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        if (amount < coins[i]) {
            return minCoinsChange1(coins, amount, i - 1, dp);
        }
        int result1 = minCoinsChange1(coins, amount - coins[i], i, dp) + 1;
        int result2 = minCoinsChange1(coins, amount, i - 1, dp);
        dp[i][amount] = Math.min(result1, result2);
        return dp[i][amount];
    }

    private static int minCoinsChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j < coins[i - 1]) {

                    }
                }
            }
        }
        return dp[coins.length][amount];

    }

}
