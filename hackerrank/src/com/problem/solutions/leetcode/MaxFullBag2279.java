package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
public class MaxFullBag2279 {
    public static void main(String[] args) {
//        int[] capacity = {2, 3, 4, 5};
//        int[] rocks = {1, 2, 4, 4};
//        int aRocks = 2;
        int[] capacity = {54, 18, 91, 49, 51, 45, 58, 54, 47, 91, 90, 20, 85, 20, 90, 49, 10, 84, 59, 29, 40, 9, 100, 1, 64, 71, 30, 46, 91};
        int[] rocks = {14, 13, 16, 44, 8, 20, 51, 15, 46, 76, 51, 20, 77, 13, 14, 35, 6, 34, 34, 13, 3, 8, 1, 1, 61, 5, 2, 15, 18};
        int aRocks = 77;
        System.out.println(countFullBags(capacity, rocks, aRocks));
        System.out.println(countFullBags2(capacity, rocks, aRocks));
    }

    //TLE but valid solution
    private static int countFullBags(int[] capacity, int[] rocks, int aRocks) {
        int[][] arr = new int[capacity.length][rocks.length];
        for (int i = 0; i < capacity.length; i++) {
            arr[i] = new int[]{capacity[i], rocks[i]};
        }
        Arrays.sort(arr, (e1, e2) -> (e1[0] - e1[1]) - (e2[0] - e2[1]));
        for (int[] pair : arr) {
            if (pair[1] < pair[0]) {
                int weightToAdd = pair[0] - pair[1];
                if (weightToAdd <= aRocks) {
                    pair[1] += weightToAdd;
                    aRocks -= weightToAdd;
                }
            }
        }
        int fullBagCount = 0;
        for (int[] pair : arr) {
            if (pair[0] == pair[1]) {
                ++fullBagCount;
            }
        }
        return fullBagCount;
    }


    private static int countFullBags2(int[] capacity, int[] rocks, int aRocks) {
        int[] diffArr = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            diffArr[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(diffArr);
        int fullBagCount = 0;
        for (int rem : diffArr) {
            if (rem <= aRocks) {
                aRocks -= rem;
                rem=0;
            }

            if (rem==0) {
                ++fullBagCount;
            }
        }
        return fullBagCount;
    }
}
