package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Problem: https://leetcode.com/problems/perfect-squares/description/

public class MinPerfectSquares {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        System.out.println(countSquares1(number));
        System.out.println(countSquares2(number));
        System.out.println(countSquareByFillingArray(number));


    }


    //Recursion

    private static int countSquares1(int number) {
        int count = 0;
        int[] arr = new int[(int) Math.sqrt(number) + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i * i;
        }
        return countSquaresHelper(number, arr, 1, count);


    }

    private static int countSquaresHelper(int number, int[] arr, int index, int count) {
        if (number == 0) {
            return count;
        }
        if (number < 0) {
            return Integer.MAX_VALUE;
        }
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        int result1 = countSquaresHelper(number - arr[index], arr, index, count + 1);
        int result2 = countSquaresHelper(number, arr, index + 1, count);
        return Math.min(result1, result2);
    }

    //Recursion with DP
    private static int countSquares2(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return countSquaresHelperDP(target, 1, dp);
    }

    private static int countSquaresHelperDP(int target, int number, int[] dp) {
        if (target == 0) {
            return 0;
        }
        if (target < number * number) {
            return 99999;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int result1 = countSquaresHelperDP(target - (number * number), number, dp) + 1;
        int result2 = countSquaresHelperDP(target, number + 1, dp);
        dp[target] = Math.min(result1, result2);
        return dp[target];

    }

    //Filling array
    private static int countSquareByFillingArray(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 99999);
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= (int) Math.sqrt(target); j++) {
                if (i == (j * j)) {
                    dp[i] = 1;
                } else if (i > (j * j)) {
                    dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]);
                }
            }

        }
        return dp[target];
    }

}



