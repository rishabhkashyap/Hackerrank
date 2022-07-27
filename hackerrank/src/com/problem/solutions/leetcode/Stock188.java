package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class Stock188 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(maxProfit1(prices, k));
        System.out.println(maxProfit2(prices, k));
    }

    private static int maxProfit1(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int day = 1; day < prices.length; day++) {
                dp[i][day] = dp[i][day - 1];
                for (int j = 0; j <= day; ++j) {
                    dp[i][day] = Math.max(dp[i][day], dp[i - 1][j] + (prices[day] - prices[j]));
                }
            }
        }
        return dp[k][prices.length - 1];
    }

    private static int maxProfit2(int[] prices, int k) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int day = 0; day <= prices.length; ++day) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[day][i][j] = -1;
                }
            }
        }
        return maxProfit2(prices, 0, 0, k, dp);
    }

    private static int maxProfit2(int[] prices, int i, int canSell, int k, int[][][] dp) {
        if (i >= prices.length || k == 0) {
            return 0;
        }
        if (dp[i][canSell][k] != -1) {
            return dp[i][canSell][k];
        }
        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        int op4 = 0;
        if (canSell == 0) {
            op1 = maxProfit2(prices, i + 1, 1, k, dp) - prices[i];
            op2 = maxProfit2(prices, i + 1, 0, k, dp);
        }
        if (canSell == 1) {
            op3 = maxProfit2(prices, i + 1, 0, k - 1, dp) + prices[i];
            op4 = maxProfit2(prices, i + 1, 1, k, dp);

        }
        dp[i][canSell][k] = Math.max(Math.max(op1, op2), Math.max(op3, op4));
        return dp[i][canSell][k];
    }
}
