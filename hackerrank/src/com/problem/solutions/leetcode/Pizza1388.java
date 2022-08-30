package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/pizza-with-3n-slices/
public class Pizza1388 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(maxAmount(nums));

    }

    private static int maxAmount(int[] nums) {

        int[][] dp = new int[nums.length][nums.length / 3 + 1];
        initializeDp(dp);
        int pattern1 = maxAmount(nums, 0, nums.length - 2, nums.length / 3, dp);
        initializeDp(dp);
        int pattern2 = maxAmount(nums, 1, nums.length - 1, nums.length / 3, dp);
        return Math.max(pattern1, pattern2);
    }

    private static void initializeDp(int[][] dp) {
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
    }

    private static int maxAmount(int[] nums, int i, int j, int k, int[][] dp) {
        if (i > j || k <= 0) {
            return 0;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int op1 = maxAmount(nums, i + 1, j, k, dp);
        int op2 = maxAmount(nums, i + 2, j, k - 1, dp) + nums[i];
        dp[i][k] = Math.max(op1, op2);
        return dp[i][k];
    }
}
