package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//Problem https://leetcode.com/problems/filling-bookcase-shelves/description/
public class BookcaseShelves {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int[][] arr = {
//                {1, 1},
//                {2, 3},
//                {2, 3},
//                {1, 1},
//                {1, 1},
//                {1, 1},
//                {1, 2}
//        };
        int[][] arr = {{7, 3}, {8, 7}, {2, 7}, {2, 5}};
        System.out.println(findMinHeight(arr, 10));
    }

    private static int findMinHeight(int[][] arr, int shelfWidth) {
        int[][] dp = new int[arr.length + 1][shelfWidth + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findMinHeight(arr, shelfWidth, 0, 0, 0, dp);
//        return minHeight(arr,shelfWidth,0,0,0,dp);
    }

    private static int findMinHeight(int[][] arr, int shelfWidth, int i, int totalWidth,
                                     int previousHeight, int[][] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i][totalWidth] != -1) {
            return dp[i][totalWidth];
        }
        int result1 = Integer.MAX_VALUE;
        if (totalWidth + arr[i][0] <= shelfWidth) {
            int maxHeight = Math.max(arr[i][1], previousHeight);
            int difference = maxHeight - previousHeight;
            result1 = difference + findMinHeight(arr, shelfWidth, i + 1, totalWidth + arr[i][0],
                    maxHeight, dp);
        }
        int result2 = findMinHeight(arr, shelfWidth, i + 1, arr[i][0], arr[i][1], dp) + arr[i][1];
        dp[i][totalWidth] = Math.min(result1, result2);
        return dp[i][totalWidth];
    }

}
