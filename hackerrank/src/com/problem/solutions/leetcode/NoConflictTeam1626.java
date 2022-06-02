package com.problem.solutions.leetcode;

import java.util.Arrays;

public class NoConflictTeam1626 {
    public static void main(String[] args) {
//        int[] scores = {1, 3, 5, 10, 15};
//        int[] ages = {1, 2, 3, 4, 5};

//        int[] scores = {4,5,6,5};
//        int[] ages = {2,1,2,1};
        int[] scores = {4};
        int[] ages = {1};
        System.out.println(maxScore(scores, ages));
        System.out.println(maxScore2(scores, ages));
    }

    private static int maxScore(int[] scores, int[] ages) {

        int[][] team = new int[scores.length][ages.length];
        for (int i = 0; i < scores.length; i++) {
            team[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(team, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        int[][] dp = new int[scores.length + 5][scores.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxScore(team, -1, 0, dp);
    }

    private static int maxScore(int[][] team, int prev, int current, int[][] dp) {
        if (current >= team.length || prev >= team.length) {
            return 0;
        }
        if (dp[prev + 1][current] != -1) {
            return dp[prev + 1][current];
        }
        int result1 = 0;
        if (prev == -1 || (team[prev][1] <= team[current][1])) {
            result1 = maxScore(team, current, current + 1, dp) + team[current][1];
        }
        int result2 = maxScore(team, prev, current + 1, dp);
        dp[prev + 1][current] = Math.max(result1, result2);
        return dp[prev + 1][current];
    }

    private static int maxScore2(int[] scores, int[] ages) {
        if (ages.length == 1) {
            return scores[0];
        }
        int[][] team = new int[scores.length][ages.length];
        for (int i = 0; i < scores.length; i++) {
            team[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(team, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        int[] dp = new int[scores.length];
        dp[0] = team[0][1];
        int maxScore = Integer.MIN_VALUE;
        for (int i = 1; i < ages.length; i++) {
            for (int j = 0; j < i; j++) {
                if (team[j][1] <= team[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + team[i][1]);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }
        return maxScore;


    }
}
