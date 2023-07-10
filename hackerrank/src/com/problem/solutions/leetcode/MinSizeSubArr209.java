package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinSizeSubArr209 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 2, 4, 3};
//        int k = 7;
        int[] arr = {1, 4, 4};
        int k = 4;
        System.out.println(findMniSubArrLen(arr, k));

    }

    private static int findMniSubArrLen(int[] arr, int k) {
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (start < arr.length && end < arr.length) {
            sum += arr[end];
            while (sum >= k) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                ++start;
            }
            ++end;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
