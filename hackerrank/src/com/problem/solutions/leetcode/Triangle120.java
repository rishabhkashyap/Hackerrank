package com.problem.solutions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/triangle/
public class Triangle120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minSum(triangle));
        System.out.println(minSum2(triangle));

    }

    private static int minSum(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 99999);
        }
        return minSum(triangle, 0, 0, dp);
    }

    private static int minSum(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i >= triangle.size() || j >= triangle.get(i).size()) {
            return 0;
        }
        if (dp[i][j] != 99999) {
            return dp[i][j];
        }
        int op1 = minSum(triangle, i + 1, j, dp);
        int op2 = minSum(triangle, i + 1, j + 1, dp);
        dp[i][j] = Math.min(op1, op2) + triangle.get(i).get(j);
        return dp[i][j];
    }

    private static int minSum2(List<List<Integer>> triange) {
        int[] dp = new int[triange.get(triange.size() - 1).size() + 1];
        for (int i = triange.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triange.get(i).size(); j++) {
                dp[j] = triange.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
