package com.problem.solutions.leetcode;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/spiral-matrix/description/
public class SpiralMatrix54 {
    public static void main(String[] args) {
        //  int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //  int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] arr={{1,2,3}};
        int[][] arr = {{1}, {2}, {3}};

        List<Integer> result = getSpiralView(arr);
        result.forEach(e -> System.out.print(e + "\t"));
    }

    private static List<Integer> getSpiralView(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = arr.length;
        int left = 0;
        int right = arr[0].length;
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                result.add(arr[top][i]);
            }
            ++top;
            for (int i = top; i < bottom; i++) {
                result.add(arr[i][right - 1]);
            }
            --right;
//            if (left > right && top > bottom) {
//                break;
//            }
            //Deals with edge case where input is matrix of size 1Xn
            if (top < bottom) {
                for (int i = right - 1; i >= left; --i) {
                    result.add(arr[bottom - 1][i]);
                }
                --bottom;
            }
            //Deals with edge case where input matrix is of size of nX1
            if (left < right) {
                for (int i = bottom - 1; i >= top; --i) {
                    result.add(arr[i][left]);
                }
                ++left;
            }
        }
        return result;
    }
}
