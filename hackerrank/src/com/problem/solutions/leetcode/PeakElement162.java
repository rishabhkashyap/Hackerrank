package com.problem.solutions.leetcode;
//https://leetcode.com/problems/find-peak-element/description/
public class PeakElement162 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(findPeakElement(arr));
    }

    private static int findPeakElement(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        // check if 0th/n-1th index is the peak element
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length && mid - 1 >= 0 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
