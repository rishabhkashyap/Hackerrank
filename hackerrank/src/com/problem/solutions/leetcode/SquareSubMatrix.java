//Problem: https://leetcode.com/problems/count-square-submatrices-with-all-ones/

package com.problem.solutions.leetcode;

import java.util.Arrays;

public class SquareSubMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1}
//        };
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(countSubMatrices(matrix));
    }

    private static int countSubMatrices(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
                    count += matrix[i][j];
                }
                if (matrix[i][j] == 1 && (i == 0 || j == 0)) {
                    ++count;
                }
            }
        }
        return count;
    }

}
