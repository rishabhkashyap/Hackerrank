package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Problem:https://leetcode.com/problems/house-robber-ii/description/

public class HouseRober213 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreElements()) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(getMaxAmount(arr.length, arr));
        System.out.println(maxAmount(arr));
    }

    private static int getMaxAmount(int i, int[] arr) {
        int[] dp = new int[10000];

        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        Arrays.fill(dp, -1);
        int result1 = getMaxHelper(i - 2, Arrays.copyOfRange(arr, 0, arr.length - 1), dp);
        Arrays.fill(dp, -1);
        int result2 = getMaxHelper(i - 2, Arrays.copyOfRange(arr, 1, arr.length), dp);
        return Math.max(result1, result2);
    }


    private static int getMaxHelper(int i, int[] arr, int[] dp) {
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
            result1 = getMaxHelper(i - 2, arr, dp) + arr[i];
        }

        if (dp[i - 1] != -1) {
            result2 = dp[i - 1];
        } else {
            result2 = getMaxHelper(i - 1, arr, dp);
        }


        dp[i] = Math.max(result1, result2);
        return dp[i];
    }

    //Simpler solution
    private static int maxAmount(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int pattern1 = maxAmount(nums, 0, nums.length - 2, dp);
        Arrays.fill(dp, -1);
        int pattern2 = maxAmount(nums, 1, nums.length - 1, dp);
        return Math.max(pattern1, pattern2);
    }

    private static int maxAmount(int[] nums, int i, int j, int[] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int op1 = maxAmount(nums, i + 1, j, dp);
        int op2 = maxAmount(nums, i + 2, j, dp) + nums[i];
        dp[i] = Math.max(op1, op2);
        return dp[i];
    }

}

