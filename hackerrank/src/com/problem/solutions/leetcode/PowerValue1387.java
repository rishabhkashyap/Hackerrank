package com.problem.solutions.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Problem: https://leetcode.com/problems/sort-integers-by-the-power-value/

public class PowerValue1387 {
    public static void main(String[] args) {
        int low = 144;
        int high = 163;
        int k = 5;
        System.out.println(findPowerValue(low, high, k));
    }

    private static int findPowerValue(int low, int high, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = low; i <= high; i++) {
            map.put(i, findPowerValue(i, dp));
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .collect(Collectors.toList());
        list.sort((e1, e2) -> compare(e1, e2));
        return list.get(k - 1).getKey();

    }


    private static int findPowerValue(int num, Map<Integer, Integer> dp) {
        if (num == 1) {
            return 0;
        }
        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        int count;
        if (num % 2 == 0) {
            count = findPowerValue(num / 2, dp) + 1;
        } else {
            count = findPowerValue(num * 3 + 1, dp) + 1;
        }
        dp.put(num, count);
        return count;
    }

    private static int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
        if (entry1.getValue() == entry2.getValue()) {
            return entry1.getKey() - entry2.getKey();
        }
        return entry1.getValue() - entry2.getValue();
    }
}
