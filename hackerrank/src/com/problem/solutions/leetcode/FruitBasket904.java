package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/fruit-into-baskets/description/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitBasket904 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        //int[] arr = {0};
        System.out.println(findMaxFruit(arr));
        System.out.println(totalFruitBruteForce(arr));
    }
    //Sliding window approach
    private static int findMaxFruit(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFruitCount = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while (start < arr.length && end < arr.length) {
            int count = map.getOrDefault(arr[end], 0);
            map.put(arr[end], ++count);
            while (map.size() > 2) {
                int freq = map.get(arr[start]);
                if (--freq == 0) {
                    map.remove(arr[start]);
                } else {
                    map.put(arr[start], freq);
                }
                ++start;
            }
            maxFruitCount = Math.max(maxFruitCount,
                    map.values().stream().reduce(0, Integer::sum));
            ++end;
        }
        return maxFruitCount;
    }

    //Valid but TLE
    private static int totalFruitBruteForce(int[] fruits) {
        int ans = 0;
        for (int i = 0; i < fruits.length; i++) {
            // we will fix the position i and from here
            // we would check how many fruits we can collect
            // the set will store the number of unique fruits we've found
            Set<Integer> basket = new HashSet<>();
            int j = i;  // start from current index i
            while (j < fruits.length) {
                if (basket.size() == 2 && !basket.contains(fruits[j])) {
                    break;
                }
                basket.add(fruits[j]);
                ++j;
            }
            // compute the window size
            // why j-i and not j-i+1?
            // because at the end j will be third type of fruit
            // we don't want to count that position, so we don't have to add 1
            // say j = 3 and i = 1, sub array size is 3
            // but j is at a fruit which we don't want, so we want to ignore that place
            // so only j-i which is 2 (j-i+1 = 3, it includes the unwanted fruit too)
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
