//Problem: https://leetcode.com/problems/minimum-cost-for-tickets/description/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class MinCostTicket983 {
    public static void main(String[] args) {
//        int[] days = {1, 4, 6, 7, 8, 20};
//        int[] costs = {2, 7, 15};

        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(finMinCost(days, costs));
    }

    private static int finMinCost(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, -1);
        return finMinCost(days, costs, 0, 0, 0, dp);
    }

    private static int finMinCost(int[] days, int[] costs, int i, int day, int limit, int[] dp) {
        if (i >= days.length) {
            return 0;
        }
        if (day + limit - 1 >= days[i]) {
            return finMinCost(days, costs, i + 1, day, limit, dp);
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result1 = finMinCost(days, costs, i + 1, days[i], 1, dp) + costs[0];
        int result2 = finMinCost(days, costs, i + 1, days[i], 7, dp) + costs[1];
        int result3 = finMinCost(days, costs, i + 1, days[i], 30, dp) + costs[2];
        dp[i] = Math.min(result1, Math.min(result2, result3));
        return dp[i];
    }
}
