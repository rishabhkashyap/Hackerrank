package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class StockBuySale {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(findMaxProfit(arr, arr.length - 2, arr[arr.length - 1]));

    }

    private static int findMaxProfit(int[] arr, int index, int maxPrice) {
        if (index == 0) {
            return maxPrice-arr[0]>=0?maxPrice-arr[0]:0;
        }
        int maxProfit = 0;
        if (arr[index] > maxPrice) {
            maxProfit = findMaxProfit(arr, index - 1, arr[index]);
        } else {
            maxProfit = findMaxProfit(arr, index - 1, maxPrice);
        }
        return Math.max(maxProfit, maxPrice - arr[index]);

    }
}
