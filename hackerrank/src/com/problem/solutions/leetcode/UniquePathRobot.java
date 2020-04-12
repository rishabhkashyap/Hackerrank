package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 // Problem:https://leetcode.com/problems/unique-paths/description/
public class UniquePathRobot {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] dp = new int[1000][1000];
        initializeArray(dp);
        System.out.println(move(1, 1, m, n, dp));
    }

    private static int move(int i, int j, int m, int n, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;
        }

        if (dp[i + 1][j] == -1) {
            dp[i + 1][j] = move(i + 1, j, m, n, dp);
        }

        if (dp[i][j + 1] == -1) {
            dp[i][j + 1] = move(i, j + 1, m, n, dp);
        }

        return dp[i + 1][j] + dp[i][j + 1];
    }

    private static void initializeArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
