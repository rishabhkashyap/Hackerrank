
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StockBuySaleWithTransactionFee714 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int fee = Integer.parseInt(bufferedReader.readLine());
        System.out.println(findMaxProfit(arr, fee));
        System.out.println(findMaxProfit2(arr, fee));
        System.out.println(findMaxProfit3(arr, fee));
    }

    private static int findMaxProfit(int[] arr, int fee) {
        int[][] dp = new int[arr.length + 1][2];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findMaxProfit(arr, fee, 0, 0, dp);
    }

    /*
    1.There are 2 possibilities either we can buy or sell stock
    2.Buy stock
        a. Buy at  today ie result-price[i] and set flag to 1 so that we can sell in next function call
        b.Hold for today and buy some other day
    3 Sell stock
        a. Sell today ie result+price[i]=fees and set flag to 0,so that we can buy in next function call
        b. Hold for today and sell some other day

    */
    private static int findMaxProfit(int[] arr, int fee, int i, int bought, int[][] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i][bought] != -1) {
            return dp[i][bought];
        }
        int result1;
        if (bought == 1) {
            result1 = findMaxProfit(arr, fee, i + 1, 0, dp) + arr[i] - fee;
        } else {
            result1 = findMaxProfit(arr, fee, i + 1, 1, dp) - arr[i];
        }
        int result2 = findMaxProfit(arr, fee, i + 1, bought, dp);
        dp[i][bought] = Math.max(result1, result2);
        return dp[i][bought];

    }


    /*
    Definition:
    hold[i] - the maximum profit you can earn if you have to hold at day[i]
    sold[i] - the maximum profit you can earn if you have to sold at day[i]

    Formula:
    hold[i] = max(hold[i - 1], sold[i - 1] - p[i])       // if hold at [i-1], no op; if sold at [i-1], buy at [i] with cost of p[i];
    sold[i] = max(sold[i - 1], hold[i - 1] + p[i] - fee) // if sold at [i-1], no op; if hold at [i-1], sell at [i] with gain of p[i] - fee;

    Initialization:
    hold[0] = 0 - price[0];  // buy shares with cost of p[0];
    sold[0] = 0;             // no op no cost;
    */

    private static int findMaxProfit2(int[] arr, int fees) {
        int[] sell = new int[arr.length];
        int[] hold = new int[arr.length];
        hold[0] = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + arr[i] - fees);
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - arr[i]);


        }
        return sell[arr.length - 1];
    }

    //We only need to maintain previous value of sell,so we can use variable instead of array

    private static int findMaxProfit3(int[] arr, int fees) {
        //int[] sell = new int[arr.length];
        int sell = 0;
        int[] hold = new int[arr.length];
        hold[0] = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            hold[i] = Math.max(hold[i - 1], sell - arr[i]);
            sell = Math.max(sell, hold[i - 1] + arr[i] - fees);

        }
        return sell;
    }
}
