package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Problem:https://leetcode.com/problems/climbing-stairs/description/

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(findWays(n));
        System.out.println(findWays2(n));
    }

    private static int findWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findWays(n, dp);
    }

    private static int findWays(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (n <= 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = findWays(n - 1, dp) + findWays(n - 2, dp);
        return dp[n];

    }

    private static int findWays2(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


}
