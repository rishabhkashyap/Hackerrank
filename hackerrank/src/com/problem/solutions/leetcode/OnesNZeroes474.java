package com.problem.solutions.leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Problem: https://leetcode.com/problems/ones-and-zeroes/description/

public class OnesNZeroes474 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        String[] strings = new String[tokenizer.countTokens()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = tokenizer.nextToken();
        }
        System.out.println("\n" + maxCount1(strings, m, n));
        System.out.println("\n" + maxCount2(strings, m, n));
        System.out.println("\n" + maxCount3(strings, m, n));

    }


    //Recursion
    private static int maxCount1(String[] strings, int zeroes, int ones) {
        int count = maxCountHelper1(strings, zeroes, ones, 0);
        return count;
    }

    private static int maxCountHelper1(String[] strings, int zeroes, int ones, int index) {

        if (index >= strings.length || ones + zeroes == 0) {
            return 0;
        }

        int zeroCount = getCount(strings[index]);
        int oneCount = strings[index].length() - zeroCount;
        int result1 = 0;
        if (zeroes >= zeroCount && ones >= oneCount) {
            result1 = maxCountHelper1(strings, zeroes - zeroCount, ones - oneCount, index + 1) + 1;
        }
        int result2 = maxCountHelper1(strings, zeroes, ones, index + 1);
        return Math.max(result1, result2);


    }


    //Recursion+DP
    private static int maxCount2(String[] strings, int zeroes, int ones) {
        int[][][] dp = new int[zeroes + 1][ones + 1][strings.length + 1];
        initalizeDP(dp);
        int count = maxCountHelper2(strings, zeroes, ones, 0, dp);
        return count;
    }

    private static int maxCountHelper2(String[] strings, int zeroes, int ones, int index, int[][][] dp) {
        if (ones + zeroes == 0 || index >= strings.length) {
            return 0;
        }
        if (dp[zeroes][ones][index] != -1) {
            return dp[zeroes][ones][index];
        }
        int zeroCount = getCount(strings[index]);
        int oneCount = strings[index].length() - zeroCount;
        int result1 = 0;
        if (zeroes >= zeroCount && ones >= oneCount) {
            result1 = maxCountHelper2(strings, zeroes - zeroCount, ones - oneCount,
                    index + 1, dp) + 1;
        }
        int result2 = maxCountHelper2(strings, zeroes, ones, index + 1, dp);
        dp[zeroes][ones][index] = Math.max(result1, result2);
        return dp[zeroes][ones][index];

    }

    private static void initalizeDP(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }

    //Fill Array
    private static int maxCount3(String[] strings, int zeroes, int ones) {
        int[][] dp = new int[zeroes + 1][ones + 1];
        for (String string : strings) {
            int zeroCount = getCount(string);
            int oneCount = string.length() - zeroCount;
            for (int i = zeroes; i >= 0; i--) {
                for (int j = ones; j >= 0; j--) {
                    if (i >= zeroCount && j >= oneCount) {
                        dp[i][j] = Math.max(dp[i - zeroCount][j - oneCount] + 1, dp[i][j]);
                    }

                }
            }
        }
        return dp[zeroes][ones];
    }

    private static int getCount(String string) {
        int zeroCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                ++zeroCount;
            }
        }
        return zeroCount;
    }


}
