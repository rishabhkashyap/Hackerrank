package com.problem.solutions.leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Problem: https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);

        int[] cost = new int[tokenizer.countTokens() + 1];
        int[] dp = new int[tokenizer.countTokens() + 1];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            cost[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(getMinCost(cost.length - 1, cost, dp));

    }

    private static int getMinCost(int n, int[] cost, int[] dp) {
        if (n == 0 || n == 1) {
            return cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = Math.min(getMinCost(n - 1, cost, dp), getMinCost(n - 2, cost, dp)) + cost[n];
        return dp[n];
    }
}
