package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaxAvgSubArray643 {
    public static void main(String[] args) {
//        int[] arr = {1, 12, -5, -6, 50, 3};
//        int k = 4;
        int[] arr = {-1};
        int k = 1;
        System.out.println(findMaxAvgSubArrayLen(arr, k));
    }

    private static double findMaxAvgSubArrayLen(int[] arr, int k) {
        int start = 0;
        int end = 0;
        double sum = 0;
        double maxSum = Integer.MIN_VALUE;
        while (end < arr.length && start < arr.length) {
            sum += arr[end];
            if (end - start + 1 > k) {
                sum -= arr[start];
                ++start;
            }
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
            ++end;
        }
        return maxSum / k;
    }

}
