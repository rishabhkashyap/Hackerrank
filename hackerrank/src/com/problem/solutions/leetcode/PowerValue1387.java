package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PowerValue1387 {
    public static void main(String[] args) {
        int low = 12;
        int high = 15;
        int k = 2;
        System.out.println(findPowerValue(low, high, k));
    }

    private static int findPowerValue(int low, int high, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);
        for (int i = low; i <= high; i++) {
            map.put(i, findPowerValue(i, dp));
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        return list.get(k - 1).getKey();

    }


    private static int findPowerValue(int num, int[] dp) {
        if (num == 1) {
            return 0;
        }
        if (dp[num] != -1) {
            return dp[num];
        }
        int count = 0;
        if (num % 2 == 0) {
            count = findPowerValue(num / 2, dp) + 1;
        } else {
            count = findPowerValue(num * 3 + 1, dp) + 1;
        }
        return count;
    }
}
