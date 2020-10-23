//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StockBuySaleWithCooldown {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(findMaxProfit(arr));
        System.out.println(findMaxProfit2(arr));

    }

    private static int findMaxProfit(int[] arr) {
        int[][] dp = new int[arr.length + 1][3];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        //0: buy
        //1:sell
        //2: rest
        int action = 0;
        return findMaxProfit(arr, 0, action, dp);
    }


    private static int findMaxProfit(int[] arr, int i, int action, int[][] dp) {

        if (i >= arr.length) {
            return 0;
        }
        if (dp[i][action] != -1) {
            return dp[i][action];
        }
        int result1 = 0;
        //If action is buy ,then in next recursion call action will be sell
        if (action == 0) {
            result1 = findMaxProfit(arr, i + 1, 1, dp) - arr[i];
        }
        //if action is sell then in next recursion call action will  be  rest
        if (action == 1) {
            result1 = findMaxProfit(arr, i + 1, 2, dp) + arr[i];
        }
        //If action is rest then in next recursion call action will be buy
        if (action == 2) {
            result1 = findMaxProfit(arr, i + 1, 0, dp);
        }
        //Other then buy,sell and rest just make call next recursion call with same action
        int result2 = findMaxProfit(arr, i + 1, action, dp);
        dp[i][action] = Math.max(result1, result2);
        return dp[i][action];

    }

    private static int findMaxProfit2(int[] arr) {
        int[] sell = new int[arr.length];
        int[] buy = new int[arr.length];
        int[] rest = new int[arr.length];
        buy[0] = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i > 2) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - arr[i]);
            }else{
                buy[i] = Math.max(buy[i - 1],  - arr[i]);
            }
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i]);
        }
        return sell[arr.length - 1];
    }


}
