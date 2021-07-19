package com.problem.solutions.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        for (int i = low; i <= high; i++) {
            map.put(i, findPowerValue(i));
        }
//        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toList());
//        return list.get(k-1).getKey();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e1,LinkedHashMap::new));
    }


    private static int findPowerValue(int num) {
        if (num == 1) {
            return 0;
        }
        int count = 0;
        if (num % 2 == 0) {
            count = findPowerValue(num / 2) + 1;
        } else {
            count = findPowerValue(num * 3 + 1) + 1;
        }
        return count;
    }
}
