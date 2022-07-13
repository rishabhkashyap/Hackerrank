package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public class Stock123 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maxProfit1(prices, k));
        System.out.println(maxProfit2(prices, k));
    }

    private static int maxProfit1(int[] prices, int k) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int p = 0; p <= 2; p++) {
                    dp[i][j][p] = -1;
                }
            }
        }
        return maxProfit1(prices, 0, 0, k, dp);
    }

    private static int maxProfit1(int[] prices, int i, int canSell, int k, int[][][] dp) {
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
            op1 = maxProfit1(prices, i + 1, 1, k, dp) - prices[i];
            op2 = maxProfit1(prices, i + 1, 0, k, dp);
        }
        if (canSell == 1) {
            op3 = maxProfit1(prices, i + 1, 0, k - 1, dp) + prices[i];
            op4 = maxProfit1(prices, i + 1, 1, k, dp);
        }
        dp[i][canSell][k] = Math.max(Math.max(op1, op2), Math.max(op3, op4));
        return dp[i][canSell][k];
    }

    private static int maxProfit2(int[] prices, int k) {
        int buy = prices[0];
        //Stores max profit if stock is sold before ith day or on ith day
        int[] profitTillDate = new int[prices.length];
        //Stores max profit when stock is bought on i th day and sold on any day after i th day
        int[] profitAfterDate = new int[prices.length];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - buy);
            if (profit > profitTillDate[i - 1]) {
                profitTillDate[i] = profit;
            } else {
                profitTillDate[i] = profitTillDate[i - 1];
            }
            buy = Math.min(buy, prices[i]);
        }
        int sell = prices[prices.length - 1];
        profit = Integer.MIN_VALUE;
        for (int i = prices.length - 2; i >= 0; i--) {
            profit = Math.max(profit, sell - prices[i]);
            if (profit > profitAfterDate[i + 1]) {
                profitAfterDate[i] = profit;
            } else {
                profitAfterDate[i] = profitAfterDate[i + 1];
            }
            sell = Math.max(sell, prices[i]);
        }
        profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, profitTillDate[i] + profitAfterDate[i]);
        }
        return profit;


    }
}
