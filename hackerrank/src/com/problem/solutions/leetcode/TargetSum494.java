package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Problem: https://leetcode.com/problems/target-sum/description/

public class TargetSum494 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int s = Integer.parseInt(bufferedReader.readLine());
        List<Character> list = new ArrayList<>();
        System.out.println(countWays(arr, s));
        System.out.println(findWays(arr, s));
    }

    private static int countWays(int[] arr, int s) {
        int[][] dp = new int[1000][3000];
        initializeArray(dp);
        return countWaysHelper(arr, s, 0, 0, dp);

    }


    private static int countWaysHelper(int[] arr, int target, int sum, int index,
                                       int[][] dp) {
        if (index == arr.length && sum == target) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        if (dp[index][sum + 1000] != Integer.MAX_VALUE) {
            return dp[index][sum + 1000];
        }

        dp[index][sum + 1000] = countWaysHelper(arr, target, sum + arr[index], index + 1, dp)
                + countWaysHelper(arr, target, sum - arr[index], index + 1, dp);

        return dp[index][sum + 1000];
    }


    private static void initializeArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int countWaysRecursive(int[] arr, int target, int sum, int index) {
        if (index == arr.length && sum == target) {
            return 1;
        }

        if (index >= arr.length) {
            return 0;
        }
        int positiveWays = countWaysRecursive(arr, target, sum + arr[index], index + 1);
        int negativeWays = countWaysRecursive(arr, target, sum - arr[index], index + 1);
        return positiveWays + negativeWays;
    }

    private static int findWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return findWays(nums, target, 0, 0, map);
    }

    private static int findWays(int[] nums, int target, int sum, int i, Map<String, Integer> map) {
        if (target == sum && i == nums.length) {
            return 1;
        }
        if (i >= nums.length) {
            return 0;
        }
        String key = "" + sum + "_" + i;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result1 = findWays(nums, target, sum + nums[i], i + 1, map);
        int result2 = findWays(nums, target, sum - nums[i], i + 1, map);
        map.put(key, result1 + result2);
        return result1 + result2;
    }
}
