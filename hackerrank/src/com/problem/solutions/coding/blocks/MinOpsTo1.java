package com.problem.solutions.coding.blocks;

import java.util.Arrays;

public class MinOpsTo1 {
    public static void main(String[] args) {
        int number = 28;
        System.out.println(countMinSteps(number));
    }

    private static int countMinSteps(int number) {
        int[] dp = new int[number + 1];
        Arrays.fill(dp, -1);
        return countMinSteps(number, dp);
    }

    private static int countMinSteps(int number, int[] dp) {
        if (number == 1 || number <= 0) {
            return 0;
        }
        if (dp[number] != -1) {
            return dp[number];
        }
        int result1 = number % 3 == 0 ? countMinSteps(number / 3) : Integer.MAX_VALUE;
        int result2 = number % 2 == 0 ? countMinSteps(number / 2) : Integer.MAX_VALUE;
        int result3 = countMinSteps(number - 1);
        dp[number] = Math.min(result1, Math.min(result2, result3)) + 1;
        return dp[number];


    }
}
