//Problem: https://leetcode.com/problems/arithmetic-slices/description/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArithmeticSlices {
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        countArithmeticSlices(arr);
        System.out.println(sum);
        System.out.println(countArithmeticSlices2(arr));
    }

    private static int countArithmeticSlices(int[] arr) {
        return countArithmeticSlices(arr, 0);

    }

    private static int countArithmeticSlices(int[] arr, int i) {
        if (i >= arr.length - 2) {
            return 0;
        }

        int aSlice = 0;
        if (arr[i] - arr[i + 1] == arr[i + 1] - arr[i + 2]) {
            aSlice = 1 + countArithmeticSlices(arr, i + 1);
            sum += aSlice;

        } else {
            countArithmeticSlices(arr, i + 1);
        }
        return aSlice;
    }

    private static int countArithmeticSlices2(int[] arr) {
        int[] dp = new int[arr.length];
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];

            }
        }
        return sum;
    }



}
