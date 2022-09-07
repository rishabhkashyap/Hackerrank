package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
import java.util.Arrays;

public class ShipCapacity1011 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(findMinShipCapacity(weights, days));
    }

    private static int findMinShipCapacity(int[] weights, int days) {
        int start = Arrays.stream(weights).max().getAsInt();
        int end = Arrays.stream(weights).sum();
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidCapacity(weights, days, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;

    }

    private static boolean isValidCapacity(int[] weights, int days, int mid) {
        int currentCap = 0;
        for (int weight : weights) {
            if (currentCap + weight > mid) {
                currentCap = weight;
                --days;
                if(days<1){
                    return false;
                }
            } else {
                currentCap+= weight;
            }

        }
        return true;
    }
}
