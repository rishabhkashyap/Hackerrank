package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/subarray-product-less-than-k/
public class SubarrayProduct713 {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        int k = 100;
        System.out.println(countSubArrayProductLessThanK(arr, k));
    }

    private static int countSubArrayProductLessThanK(int[] arr, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        int product = 1;
        while (j < arr.length) {
            product *= arr[j];
            while (i<arr.length && product >= k) {
                product /= arr[i];
                ++i;
            }
            if (product < k) {
                count+=j-i+1;
            }
            ++j;
        }
        return count;
    }
}
