//Problem:https://leetcode.com/problems/maximum-length-of-pair-chain/

package com.problem.solutions.leetcode;

import java.util.Arrays;

public class MaxLenPairChain {

    public static void main(String[] args) {
        //int[][] arr = {{3, 4}, {2, 3}, {1, 2}};
        int[][] arr = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
//                {
//                {1, 2},
//                {2, 3},
//                {3, 4}
//            };
        System.out.println(findMaxPairChainLen(arr));
        System.out.println(findMaxPairChainLen2(arr));
    }

    private static int findMaxPairChainLen(int[][] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        return findMaxPairChainLen(arr, 0, -1, dp);


    }

    private static int findMaxPairChainLen(int[][] arr, int i, int previous, int[][] dp) {
        if (i >= arr.length) {
            return 0;
        }
        int result1 = 0;
        int result2 = 0;
        if (dp[i][previous + 1] != -1) {
            return dp[i][previous + 1];
        }
        if (previous < 0 || arr[previous][1] < arr[i][0]) {
            result1 = findMaxPairChainLen(arr, i + 1, i, dp) + 1;

        }
        result2 = findMaxPairChainLen(arr, i + 1, previous, dp);

        dp[i][previous + 1] = Math.max(result1, result2);
        return dp[i][previous + 1];
    }

    private static int findMaxPairChainLen2(int[][] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][0] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);

        }
        return maxLen;
    }


}
