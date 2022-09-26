package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/3sum-closest/
public class SumClosest16 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(findClosestSum(arr, target));


    }

    private static int findClosestSum(int[] arr, int target) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (diff > Math.abs(target - sum)) {
                    result = sum;
                    diff = Math.abs(target - sum);
                } else if (sum > target) {
                    --end;
                } else {
                    ++start;
                }
            }
        }
        return result;
    }
}
