package com.problem.solutions.leetcode;

import java.util.*;
//Problem: https://leetcode.com/problems/3sum/
public class SumTriplet15 {
    public static void main(String[] args) {

        int[] arr = null;
          arr = new int[]{-1, 0, 1, 2, -1, -4};
        //arr = new int[]{0, 0, 0};
        List<List<Integer>> result = findTriplets2(arr);
        result.stream().forEach(System.out::println);
    }

    //works but TLE
    private static List<List<Integer>> findTriplets(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 0 - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int next = target - arr[j];
                int index = Arrays.binarySearch(arr, j + 1, arr.length, next);
                if (index > 0) {
                    result.add(Arrays.asList(arr[i], arr[j], next));
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static List<List<Integer>> findTriplets2(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int low = i + 1;
            int high = arr.length - 1;
            while (low < high) {
                int temp = arr[low] + arr[high] + arr[i];
                if (temp == 0) {
                    result.add(Arrays.asList(arr[i], arr[low], arr[high]));
                    //Increment low and high to avoid any duplicates
                    --high;
                    ++low;
                } else if (temp < 0) {
                    ++low;
                } else {
                    --high;
                }
            }

        }
        return new ArrayList<>(result);
    }
}
