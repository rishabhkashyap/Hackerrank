package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class SortedArrMedian4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(findMedian(arr1, arr2));
    }

    private static double findMedian(int[] arr1, int[] arr2) {
        return findMedianHelper(arr1, arr2);
    }

    private static double findMedianHelper(int[] arr1, int[] arr2) {
        int low = 0;
        int high = arr1.length;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (arr1.length + arr2.length + 1) / 2 - cut1;
            int max1 = (cut1 - 1 >= 0) ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int max2 = (cut2 - 1 >= 0) ? arr2[cut2 - 1] : Integer.MIN_VALUE;
            int min1 = (cut1 < arr1.length) ? arr1[cut1] : Integer.MAX_VALUE;
            int min2 = (cut2 < arr2.length) ? arr2[cut2] : Integer.MAX_VALUE;
            if (max1 <= min2 && max2 <= min1) {
                if ((arr1.length + arr2.length) % 2 == 0) {
                    return (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0;
                } else {
                    return Math.max(max1, max2);
                }
            }
            if (max1 > min2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }
}
