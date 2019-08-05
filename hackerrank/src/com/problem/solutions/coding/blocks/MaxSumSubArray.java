package com.problem.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] arr = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j< n; j++) {
                arr[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            System.out.println(getMaxSum(arr));
        }
    }

    private static int getMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumSoFar = 0;
        for (int number : arr) {
            maxSumSoFar += number;
            if (maxSum < maxSumSoFar) {
                maxSum = maxSumSoFar;
            }
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            }
        }
        return maxSum;
    }
}
