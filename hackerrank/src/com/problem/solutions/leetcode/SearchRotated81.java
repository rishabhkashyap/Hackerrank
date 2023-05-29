package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class SearchRotated81 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(elementExist(arr, target));
    }

    private static boolean elementExist(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[low] < arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[low] > arr[mid]) {
                if (target <= arr[high] && target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                //increment low in case of duplicates
                ++low;
            }
        }
        return false;
    }
}
