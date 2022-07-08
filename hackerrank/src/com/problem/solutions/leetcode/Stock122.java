package com.problem.solutions.leetcode;

public class Stock122 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        boolean canSell = false;
        return maxProfit(prices, canSell, 0);
    }

    private static int maxProfit(int[] prices, boolean canSell, int i) {
        if (i >= prices.length) {
            return 0;
        }
        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        int op4=0;
        if (!canSell) {
            op1 = maxProfit(prices, true, i + 1) - prices[i];
            op2 = maxProfit(prices, false, i + 1);
        }
        if (canSell) {
            op3 = maxProfit(prices, false, i + 1) + prices[i];
            op4 = maxProfit(prices, true, i + 1);
        }
        return Math.max(Math.max(op1, op2), Math.max(op3,op4));

    }
}
