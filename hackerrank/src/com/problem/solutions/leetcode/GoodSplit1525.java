package com.problem.solutions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoodSplit1525 {
    public static void main(String[] args) {
        String str = "aacaba";
        System.out.println(findGoodSplit(str));
    }

    private static int findGoodSplit(String str) {
        Map<String, Integer> map = new HashMap<>();
        int[] prefix = new int[str.length()];
        prefix[0] = 1;
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for (int i = 1; i < prefix.length; i++) {
            set.add(str.charAt(i));
            prefix[i] = set.size();

        }
        return findGoodSplit(str.toCharArray(), 0, 0, str.length() - 1, map);
    }

    private static int findGoodSplit(char[] arr, int start, int mid, int end, Map<String, Integer> map) {
        if (mid + 1 > arr.length) {
            return 0;
        }
        int distinctS1 = 0;
        int distinctS2 = 0;
        String key1 = start + "_" + mid;
        int s2Start = mid + 1;
        String key2 = s2Start + "_" + end;
        if (map.containsKey(key1)) {
            distinctS1 = map.get(key1);
        } else {
            distinctS1 = countUniqueChars(arr, start, mid);
            map.put(key1, distinctS1);
        }
        if (map.containsKey(key2)) {
            distinctS2 = map.get(key2);
        } else {
            distinctS2 = countUniqueChars(arr, mid + 1, end);
            map.put(key2, distinctS2);
        }

        if (distinctS1 == distinctS2) {
            return findGoodSplit(arr, start, mid + 1, end, map) + 1;
        }
        return findGoodSplit(arr, start, mid + 1, end, map);

    }

    private static int countUniqueChars(char[] arr, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(arr[i]);

        }
        return set.size();
    }
}
