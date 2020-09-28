//Problem: https://leetcode.com/problems/count-numbers-with-unique-digits/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(countUniqueDigitNumbers(n));
        System.out.println(countUniqueDigitNumbers2(n));
        System.out.println(countUniqueDigitNumbers3(n));
    }

    private static long countUniqueDigitNumbers(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += countUniqueDigitNumbers(i, 8);
        }
        return result;

    }

    private static long countUniqueDigitNumbers(int n, int i) {
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 81;
        }
        return countUniqueDigitNumbers(n - 1, i - 1) * i;
    }

    private static int countUniqueDigitNumbers2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int sum = 10;
        int digits = 9;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * digits;
            --digits;
            sum += dp[i];
        }
        return sum;
    }

    private static int countUniqueDigitNumbers3(int n) {
        int numbers = 9;
        int sum = 10;
        int digits = 9;
        for (int i = 2; i <= n ; i++) {
            numbers = numbers * digits;
            --digits;
            sum += numbers;
        }
        return sum;
    }
}
