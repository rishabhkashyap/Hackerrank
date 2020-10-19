//Problem: https://leetcode.com/problems/largest-1-bordered-square/
package com.problem.solutions.leetcode;

public class Largest1BorderedSquare {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        //int[][] arr = {{1, 1, 0, 0}};
        System.out.println(getElementsInSquare1(arr));
    }

    private static int getElementsInSquare1(int[][] arr) {
        int horizontal[][] = new int[arr.length][arr[0].length];
        int vertical[][] = new int[arr.length][arr[0].length];
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    horizontal[i][j] = (j == 0) ? 1 : horizontal[i][j - 1] + 1;
                    vertical[i][j] = (i == 0) ? 1 : vertical[i - 1][j] + 1;

                }
            }
        }
        print(horizontal);
        System.out.println();
        print(vertical);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                int small = Math.min(horizontal[i][j], vertical[i][j]);
                while (small > maxLength) {
                    if (horizontal[i - small+1][j] >= small
                            && vertical[i][j - small+1] >= small) {
                        maxLength = small;
                    }
                    --small;
                }


            }
        }
        return maxLength*maxLength;
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
