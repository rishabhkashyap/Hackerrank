package com.problem.solutions.leetcode;

import java.util.*;

public class Duplicate442 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] result = getDuplicates1(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
        List<Integer> duplicates = getDuplicates2(arr);
        System.out.println();
        duplicates.forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] getDuplicates1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (set.contains(num)) {
                list.add(num);
            } else {
                set.add(num);
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    private static List<Integer> getDuplicates2(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (arr[Math.abs(num) - 1] < 0) {
                result.add(Math.abs(num));
            } else {
                arr[Math.abs(num) - 1] = -arr[Math.abs(num) - 1];
            }
        }
        return result;
    }
}
