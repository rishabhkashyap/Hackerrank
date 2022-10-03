package com.problem.solutions.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers448 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        findMissingNumbers1(arr).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        findMissingNumbers2(arr).forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> findMissingNumbers1(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 1; i <= arr.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> findMissingNumbers2(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] > 0) {
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
