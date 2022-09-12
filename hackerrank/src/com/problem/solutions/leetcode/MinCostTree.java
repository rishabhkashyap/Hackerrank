package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Problem: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

public class MinCostTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(getMinSum(arr));

    }

    private static int getMinSum(int[] arr) {
        Value[][] dp = new Value[arr.length][arr.length];
        for (Value[] values : dp) {
            Arrays.fill(values, null);
        }

        return getMinSum(arr, 0, arr.length - 1, dp).getMinSum();
    }

    private static Value getMinSum(int[] arr, int i, int j, Value[][] dp) {
        if (i == j) {
            return new Value(arr[i], 0);
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int maxLeafSofar = Integer.MIN_VALUE;
        int minSumSoFar = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            Value left = getMinSum(arr, i, k, dp);
            Value right = getMinSum(arr, k + 1, j, dp);
            maxLeafSofar = Math.max(left.getMaxLeaf(), right.getMaxLeaf());
            minSumSoFar = Math.min(minSumSoFar, left.getMinSum() + right.getMinSum() + (left.getMaxLeaf() * right.getMaxLeaf()));

        }
        dp[i][j] = new Value(maxLeafSofar, minSumSoFar);
        return dp[i][j];
    }

    private static int getMax(int[] arr, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static class Value {
        private int maxLeaf;
        private int minSum;

        public Value(int maxValue, int minSum) {
            this.maxLeaf = maxValue;
            this.minSum = minSum;
        }

        public int getMaxLeaf() {
            return maxLeaf;
        }

        public int getMinSum() {
            return minSum;
        }
    }
}
