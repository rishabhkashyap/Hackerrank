package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Stock122 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(maxStockProfit(arr));
        System.out.println(maxStockProfit2(arr));
    }

    private static int maxStockProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxStockProfit(prices, 0, 0, dp);
    }

    private static int maxStockProfit(int[] prices, int canSell, int i, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][canSell] != -1) {
            return dp[i][canSell];
        }
        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        int op4 = 0;
        if (canSell == 0) {
            op1 = maxStockProfit(prices, 1, i + 1, dp) - prices[i];
            op2 = maxStockProfit(prices, 0, i + 1, dp);
        }
        if (canSell == 1) {
            op3 = maxStockProfit(prices, 0, i + 1, dp) + prices[i];
            op4 = maxStockProfit(prices, 1, i + 1, dp);
        }
        dp[i][canSell] = Math.max(Math.max(op1, op2), Math.max(op3, op4));
        return dp[i][canSell];

    }

    private static int maxStockProfit2(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (sell < prices[i]) {
                sell = prices[i];
            } else {
                profit += (sell - buy);
                buy = prices[i];
                sell = prices[i];
            }
        }
        profit += (sell - buy);
        return profit;
    }
}
