package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Problem:https://leetcode.com/submissions/detail/331127802/
public class MaxWaterContainer {
    private static int maxArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        getMaxArea(arr);
        System.out.println(maxArea);
    }

    private static void getMaxArea(int[] arr) {
        maxAreaHelper(arr, 0, arr.length - 1);
    }

    private static void maxAreaHelper(int[] arr, int i, int j) {
        if (i >= arr.length || j < 0) {
            return;
        }
        int currentArea = Math.min(arr[i], arr[j]) * (j - i);
        if (currentArea > maxArea) {
            maxArea = currentArea;
        }
        if (arr[i] < arr[j]) {
            maxAreaHelper(arr, i + 1, j);
        } else {
            maxAreaHelper(arr, i, j - 1);
        }

    }


}
