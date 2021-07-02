package com.problem.solutions.leetcode;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/where-will-the-ball-fall/

public class BallFall1706 {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}};
//        int[][] grid = {{1, 1, 1, 1, 1, 1},
//                {-1, -1, -1, -1, -1, -1},
//                {1, 1, 1, 1, 1, 1},
//                {-1, -1, -1, -1, -1, -1}};
        int[] result = findBallLocation(grid);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] findBallLocation(int[][] grid) {
        int[] result = new int[grid[0].length];
        int[][] dp = new int[grid.length + 1][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -2);
        }
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findBallLocation(grid, 0, i, dp);
        }
        return result;
    }

    private static int findBallLocation(int[][] grid, int row, int col, int[][] dp) {
        if (row > grid.length || col > grid[0].length) {
            return -1;
        }
        if (row == grid.length) {
            return col;
        }
        if (dp[row][col] != -2) {
            return dp[row][col];
        }
        if (grid[row][col] == 1 && isvaid(grid, row, col + 1) && grid[row][col + 1] == 1) {

            dp[row][col] = findBallLocation(grid, row + 1, col + 1, dp);
            return dp[row][col];

        }
        if (grid[row][col] == -1 && isvaid(grid, row, col - 1) && grid[row][col - 1] == -1) {

            dp[row][col] = findBallLocation(grid, row + 1, col - 1, dp);
            return dp[row][col];

        }
        return -1;
    }

    private static boolean isvaid(int[][] grid, int row, int col) {
        boolean validRow = row >= 0 && row < grid.length;
        boolean validCol = col >= 0 && col < grid[0].length;
        return validCol && validRow;
    }
}
