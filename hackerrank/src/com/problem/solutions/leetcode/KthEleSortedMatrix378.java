package com.problem.solutions.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
//Problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KthEleSortedMatrix378 {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(findKthSmallestElement1(arr, k));
        System.out.println(findKthSmallestElement2(arr, k));

    }


    //Time complexity=O(nlogn)
    private static int findKthSmallestElement1(int[][] arr, int k) {
        int low = arr[0][0];
        int high = arr[arr.length - 1][arr.length - 1];
        while (low <= high) {
            int midElement = low + ((high - low) / 2);
            int count = findSmallElementCount(arr, midElement);
            if (count < k) {
                low = midElement + 1;
            } else {
                high = midElement - 1;
            }
        }
        return low;
    }

    private static int findSmallElementCount(int[][] arr, int target) {
        int i = arr.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < arr.length) {
            if (arr[i][j] > target) {
                --i;
            } else {
                ++j;
                count += i + 1;
            }
        }
        return count;
    }

    private static int findKthSmallestElement2(int[][] arr, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(k, (e1, e2) -> e2 - e1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(arr[i][j]);
                } else {
                    if (maxHeap.peek() > arr[i][j]) {
                        maxHeap.remove();
                        maxHeap.add(arr[i][j]);
                    }
                }
            }
        }
        return maxHeap.peek();

    }
}
