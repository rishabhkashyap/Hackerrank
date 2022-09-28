package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/trapping-rain-water/
public class RainWater42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calculateTrapWater(arr));
        System.out.println(calculateTrapWater2(arr));

    }

    private static int calculateTrapWater(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; --i) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }
        int waterAmount = 0;
        for (int i = 0; i < arr.length; i++) {
            int wallHeight = Math.min(leftMax[i], rightMax[i]);
            if (wallHeight - arr[i] > 0) {
                waterAmount += wallHeight - arr[i];
            }
        }
        return waterAmount;
    }

    //2 Pointer approach
    private static int calculateTrapWater2(int[] arr) {
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int i = 0;
        int j = arr.length - 1;
        int waterAmount = 0;
        while (i < j) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, arr[++i]);
                waterAmount += leftMax - arr[i];
            } else {
                rightMax = Math.max(rightMax, arr[--j]);
                waterAmount += rightMax - arr[j];
            }
        }
        return waterAmount;
    }

}
