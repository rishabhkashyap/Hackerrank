package com.problem.solutions.leetcode;

public class MaxMatrixProduct1594 {
    private static final int MODULO = 10 ^ 9 + 7;

    public static void main(String[] args) {
        //  int[][] grid = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        int[][] grid = {{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}};
        System.out.println(maxProduct(grid));
    }

    private static int maxProduct(int[][] grid) {
        int result = maxProduct(grid, 0, 0);
        return result >= 0 ? result : -1;
    }

    private static int maxProduct(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        int result1 = maxProduct(grid, i + 1, j) * grid[i][j];
        int result2 = maxProduct(grid, i, j + 1) * grid[i][j];
        return Math.max(result1, result2) % MODULO;

    }
}
