package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MaxPossibleSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(findMaxSum1(arr));
        System.out.println(findMaxSum2(arr));
        System.out.println(findMaxSum3(arr));
    }

    private static int findMaxSum1(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        return findMaxSum1(arr, 0, 0, map);
    }


    //Valid solution but TLE
    private static int findMaxSum1(int[] arr, int i, int remainder, Map<String, Integer> dp) {
        if (i >= arr.length) {
            return remainder % 3 == 0 ? 0 : Integer.MIN_VALUE;
        }
        String key = i + "_" + remainder;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int result1 = findMaxSum1(arr, i + 1, remainder, dp);
        int result2 = findMaxSum1(arr, i + 1, remainder + arr[i] % 3, dp) + arr[i];
        dp.put(key, Math.max(result1, result2));
        return dp.get(key);


    }

    private static int findMaxSum2(int[] arr) {
        int[][] dp = new int[arr.length + 1][3];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return findMaxSum2(arr, 0, 0, dp);

    }

    //Valid solution but TLE
    private static int findMaxSum2(int[] arr, int i, int remainder, int[][] dp) {
        if (i >= arr.length) {
            return remainder == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[i][remainder] != -1) {
            return dp[i][remainder];
        }
        if (arr[i] % 3 == 0) {
            if (remainder == 0) {
                return Math.max(findMaxSum2(arr, i + 1, 0, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 0, dp));
            }
            if (remainder == 1) {
                return Math.max(findMaxSum2(arr, i + 1, 1, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 1, dp));
            }
            if (remainder == 2) {
                return Math.max(findMaxSum2(arr, i + 1, 2, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 2, dp));
            }
        }
        if (arr[i] % 3 == 1) {
            if (remainder == 0) {
                return Math.max(findMaxSum2(arr, i + 1, 2, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 0, dp));
            }
            if (remainder == 1) {
                return Math.max(findMaxSum2(arr, i + 1, 0, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 1, dp));
            }
            if (remainder == 2) {
                return Math.max(findMaxSum2(arr, i + 1, 1, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 2, dp));
            }
        }
        if (arr[i] % 3 == 2) {
            if (remainder == 0) {
                return Math.max(findMaxSum2(arr, i + 1, 1, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 0, dp));
            }
            if (remainder == 1) {
                return Math.max(findMaxSum2(arr, i + 1, 2, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 1, dp));
            }
            if (remainder == 2) {
                return Math.max(findMaxSum2(arr, i + 1, 0, dp) + arr[i],
                        findMaxSum2(arr, i + 1, 2, dp));
            }
        }
        return -1;
    }


    //dp[i][0]: Represents greatest sum that is divisible by  3 in range i...n-1
    //dp[i][1]: Represents greatest sum that gives dp[i ][1]%3=1 in range i...n-1
    //dp[i][2]: Represents greatest sum that gives dp[i ][1]%3=2 in range i...n-1
    private static int findMaxSum3(int[] arr) {
        int[][] dp = new int[arr.length + 1][3];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return findMaxSum3(arr, 0, 0, dp);
    }

    private static int findMaxSum3(int[] arr, int i, int remainder, int[][] dp) {
        if (i >= arr.length) {
            return remainder == 0 ? remainder : Integer.MIN_VALUE;
        }
        if (dp[i][remainder] != -1) {
            return dp[i][remainder];
        }
        int difference = remainder - (arr[i] % 3);
        int nextRemainder = difference >= 0 ? difference : difference + 3;
        int result1 = findMaxSum3(arr, i + 1, nextRemainder, dp) + arr[i];
        int result2 = findMaxSum3(arr, i + 1, remainder, dp);
        dp[i][remainder] = Math.max(result1, result2);
        return dp[i][remainder];
    }

}
