package com.problem.solutions.leetcode;

import java.util.Arrays;

public class LastStoneII1049 {
    public static void main(String[] args) {
        //int[] arr = {3, 9, 7, 3};
        int[] arr = {31,26,33,21,40};
        System.out.println(findLastStoneVal(arr));
    }

    private static int findLastStoneVal(int[] nums) {

        int sum = Arrays.stream(nums).map(e -> e < 0 ? -1 * e : e)
                .sum();
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[nums.length][i] && sum>=2*i) {
                int diff = sum - 2 * i;
                minDiff = Math.min(minDiff, diff);
            }

        }

        return minDiff;
    }

//    private static boolean subSetSum(int[] nums, int i, int sum, int[][] dp) {
//        if (sum == 0) {
//          //  dp[i][sum] = 1;
//            return true;
//        }
//        if (i < 0) {
//            return false;
//        }
//        if (dp[i][sum] != -1) {
//            return dp[i][sum] == 1;
//        }
//        if (sum < nums[i]) {
//            return subSetSum(nums, i - 1,sum, dp);
//        }
//        boolean res = subSetSum(nums, i-1,sum - nums[i],  dp)
//                || subSetSum(nums,  i - 1,sum, dp);
//        dp[i][sum] = res ? 1 : 2;
//        return res;
//
//
//    }
}
