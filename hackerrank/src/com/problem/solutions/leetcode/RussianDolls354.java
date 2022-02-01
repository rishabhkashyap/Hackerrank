package com.problem.solutions.leetcode;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/russian-doll-envelopes/

public class RussianDolls354 {
    public static void main(String[] args) {
        int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        // int[][] arr = {{4, 5}, {6, 7}, {2, 3}};
        //  int[][] arr={{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        System.out.println(findMaxEnvelope(arr));
    }

    private static int findMaxEnvelope(int[][] arr) {
        Arrays.sort(arr, (e1, e2) -> compare(e1, e2));
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxCount = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }

    private static int compare(int[] arr1, int[] arr2) {

        return arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0];

    }
}
