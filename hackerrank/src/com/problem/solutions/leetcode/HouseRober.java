package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Problem:https://leetcode.com/problems/house-robber/description/

public class HouseRober {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreElements()) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] dp=new int[10000];
        Arrays.fill(dp,-1);
        System.out.println(getMaxAmount(arr.length - 1, arr,dp));
    }

    private static int getMaxAmount(int i, int[] arr,int[] dp) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return arr[0];
        }
        if (i == 1) {
            return Math.max(arr[0], arr[1]);
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result1 = 0;
        int result2 = 0;
        if (dp[i - 2] != -1) {
            result1 = dp[i - 2] + arr[i];
        } else {
            result1 = getMaxAmount(i - 2, arr, dp) + arr[i];
        }

        if (dp[i - 1] != -1) {
            result2 = dp[i - 1];
        } else {
            result2 = getMaxAmount(i - 1, arr, dp);
        }


        dp[i] = Math.max(result1, result2);
        return dp[i];
    }

}

