package com.problem.solutions.leetcode;
//Problem: https://leetcode.com/problems/first-missing-positive/description/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingPositive41 {
    public static void main(String[] args) {
        int[] arr = {2};
        //int[] arr={3,4,-1,1};
        //int[] arr = {7, 8, 9, 11, 12};
        System.out.println(findSmallestMissingNum(arr));
        System.out.println(findSmallestMissingNum2(arr));
    }

    private static int findSmallestMissingNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(e -> set.add(e));
        int missingNum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(missingNum)) {
                ++missingNum;
            } else {
                break;
            }

        }
        return missingNum;
    }

    private static int findSmallestMissingNum2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        //Mark numbers as negative if they are present in array
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (index > 0 && index <= arr.length) {
                if (arr[index - 1] > 0) {
                    arr[index - 1] *= -1;
                } else if (arr[index - 1] == 0) {
                    arr[index - 1] = arr.length + 1;
                }
            }
        }
        int missingNum = 1;
        while (missingNum <= arr.length) {
            if (arr[missingNum-1] < 0 || arr[missingNum-1] == arr.length + 1) {
                ++missingNum;
            } else {
                return missingNum;
            }
        }
        return missingNum;
    }
}
