package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Stocks121 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

    }

    public static int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            profit = Math.max(profit, price - lowestPrice);
            lowestPrice = Math.min(lowestPrice, price);
        }
        return profit ;
    }
}
