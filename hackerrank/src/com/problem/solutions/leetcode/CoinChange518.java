package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/coin-change-2/
public class CoinChange518 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(countChangeCombinations1(coins, amount));
        System.out.println(countChangeCombinations2(coins, amount));
    }

    private static int countChangeCombinations1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int result = countChangeCombinations1(coins, amount, coins.length - 1, dp);
        return result;
    }

    private static int countChangeCombinations1(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i < 0 || amount < 0) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        if (amount < coins[i]) {
            return countChangeCombinations1(coins, amount, i - 1, dp);
        }
        dp[i][amount] = countChangeCombinations1(coins, amount - coins[i], i, dp)
                + countChangeCombinations1(coins, amount, i - 1, dp);
        return dp[i][amount];
    }

    private static int countChangeCombinations2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }


}
