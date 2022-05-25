package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/combination-sum-iv/
public class CombinationSum377 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(countCombinationSum1(nums, target));
        System.out.println(countCombinationSum2(nums, target));
    }

    private static int countCombinationSum1(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return countCombinationSum1(nums, target, nums.length - 1, dp);
    }

    private static int countCombinationSum1(int[] nums, int target, int i, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (i < 0 || target < 0) {
            return 0;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if (target < nums[i]) {
            return countCombinationSum1(nums, target, i - 1, dp);
        }
        dp[i][target] = countCombinationSum1(nums, target, i - 1, dp)
                + countCombinationSum1(nums, target - nums[i], nums.length - 1, dp);

        return dp[i][target];
    }


    //Using 1D array
    private static int countCombinationSum2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return countCombinationSum2(nums, target, nums.length - 1, dp);
    }

    private static int countCombinationSum2(int[] nums, int target, int i, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (i < 0 || target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        if (target < nums[i]) {
            return countCombinationSum2(nums, target, i - 1, dp);
        }
        dp[target] = countCombinationSum2(nums, target, i - 1, dp)
                + countCombinationSum2(nums, target - nums[i], nums.length - 1, dp);

        return dp[target];
    }
}
