package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/reducing-dishes/
public class ReducingDishes1402 {
    public static void main(String[] args) {
        int[] ratings = {-1, -8, 0, 5, -9};
        System.out.println(maxLikeCoeff(ratings));
        System.out.println(maxLikeCoeff2(ratings));
    }

    private static int maxLikeCoeff(int[] ratings) {
        Arrays.sort(ratings);
        Map<String, Integer> map = new HashMap<>();
        return maxLikeCoeff(ratings, 0, 1, map);
    }

    private static int maxLikeCoeff(int[] ratings, int i, int time, Map<String, Integer> map) {
        if (i >= ratings.length) {
            return 0;
        }
        String key = "" + i + "_" + time;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result1 = maxLikeCoeff(ratings, i + 1, time, map);
        int result2 = maxLikeCoeff(ratings, i + 1, time + 1, map) + (time * ratings[i]);
        map.put(key, Math.max(result1, result2));
        return map.get(key);
    }

    private static int maxLikeCoeff2(int[] ratings) {
        Arrays.sort(ratings);
        int[][] dp = new int[ratings.length + 1][ratings.length + 2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxLikeCoeff2(ratings, 0, 1, dp);
    }

    private static int maxLikeCoeff2(int[] ratings, int i, int time, int[][] dp) {
        if (i >= ratings.length) {
            return 0;
        }
        if (dp[i][time] != -1) {
            return dp[i][time];
        }
        int result1 = maxLikeCoeff2(ratings, i + 1, time, dp);
        int result2 = maxLikeCoeff2(ratings, i + 1, time + 1, dp) + (time * ratings[i]);
        dp[i][time] = Math.max(result1, result2);
        return dp[i][time];
    }
}
