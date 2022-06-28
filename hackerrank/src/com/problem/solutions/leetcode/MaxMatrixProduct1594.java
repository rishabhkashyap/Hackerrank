package com.problem.solutions.leetcode;

public class MaxMatrixProduct1594 {
    private static final int MODULO = 10 ^ 9 + 7;
    private static long result = -1;

    public static void main(String[] args) {
        //int[][] grid = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        int[][] grid = {{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}};
       // int[][] grid={{1,3},{0,-4}};
        maxProduct(grid);
        System.out.println(result < 0 ? -1 : (int)(result % MODULO));
    }

    private static void maxProduct(int[][] grid) {
        maxProduct(grid, 0, 0, grid[0][0]);
    }

    private static void maxProduct(int[][] grid, int i, int j, long product) {
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            result = Math.max(result, product);
            return;
        }

        if (grid[i][j] == 0) {
            result = Math.max(result, 0);
            // System.out.println("inside zero = "+result);
            return;
        }
        if (i + 1 < grid.length) {
            maxProduct(grid, i + 1, j, product * grid[i + 1][j]);
        }
        if (j + 1 < grid[0].length) {
            maxProduct(grid, i, j + 1, product * grid[i][j + 1]);
        }


    }
}
