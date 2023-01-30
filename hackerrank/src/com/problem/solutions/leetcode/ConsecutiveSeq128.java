package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class ConsecutiveSeq128 {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(consecutiveSeqLen1(arr));
        System.out.println(consecutiveSeqLen2(arr));
    }

    //Solution works but gives Memory limit exceeded for large input
    private static int consecutiveSeqLen1(int[] arr) {
        Arrays.sort(arr);
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return consecutiveSeqLen1(arr, -1, 0, dp);
    }

    private static int consecutiveSeqLen1(int[] arr, int prev, int next, int[][] dp) {
        if (next >= arr.length) {
            return 0;
        }
        if (dp[prev + 1][next] != -1) {
            return dp[prev + 1][next];
        }
        int max1 = 0;
        if (prev < 0 || arr[prev] + 1 == arr[next]) {
            max1 = consecutiveSeqLen1(arr, next, next + 1, dp) + 1;
        }
        int max2 = consecutiveSeqLen1(arr, prev, next + 1, dp);
        dp[prev + 1][next] = Math.max(max1, max2);
        return dp[prev + 1][next];
    }

    private static int consecutiveSeqLen2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(e -> set.add(e));
        int result = 0;
        for (int ele : arr) {
            if (!set.contains(ele - 1)) {
                int count = 0;
                int start = ele;
                while (set.contains(start)) {
                    ++count;
                    ++start;
                }
                result = Math.max(count, result);
            }

        }
        return result;
    }
}
