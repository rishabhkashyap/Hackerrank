package com.problem.solutions.leetcode;

import java.util.HashSet;
import java.util.Set;
//Problem: https://leetcode.com/problems/set-matrix-zeroes/description/
public class MatrixZero73 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setMatrixZero2(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }


    //Use auxiliary space to store rows and columns that contains zero
    private static void setMatrixZero1(int[][] arr) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    //use first row and column to store result of  other rows and column by making cell in first
    //row and column as zero in case any cell has zero in it.To deal with edge case where
    //first row or column has zero in it, use 2 variables to store data about first row/column
    // it by setting them true or false accordingly
    private static void setMatrixZero2(int[][] arr) {
        boolean colFistHasZero = false;
        boolean rowFirstHasZero = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                colFistHasZero = true;
                break;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 0) {
                rowFirstHasZero = true;
                break;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        if (colFistHasZero) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }
        if (rowFirstHasZero) {
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = 0;
            }

        }

    }
}
