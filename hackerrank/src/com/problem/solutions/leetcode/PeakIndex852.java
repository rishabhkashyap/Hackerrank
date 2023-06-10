package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndex852 {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(findPeakIndex1(arr));
        System.out.println(findPeakIndex3(arr));
        System.out.println(findPeakIndex2(arr));
    }

    private static int findPeakIndex1(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
                //Since element at right is greater than mid-element chances are peak
                //lies in right of the array,so move to right part of array
            } else if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
                //since element at left is greater than mid-element
                //chances are peak is in left part of array  ,so move to right part of array.
            } else if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }

        }
        return -1;
    }

    private static int findPeakIndex3(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length && mid - 1 >= 0 &&
                    arr[mid] > arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    private static int findPeakIndex2(int[] arr) {
        int peak = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (peak < arr[i]) {
                peak = arr[i];
                index = i;
            }
        }
        return index;

    }

}
