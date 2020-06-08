
//Problem: https://leetcode.com/problems/stone-game/description/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StoneGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(isAlexWinner(arr));
    }

    private static boolean isAlexWinner(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return isAlexWinner(arr, 0, arr.length - 1, 0, 0, 0, dp) == 0 ? true : false;
    }

    private static int isAlexWinner(int[] arr, int i, int j, int player, int score1, int score2, int[][] dp) {
        if (i > j) {
            return score1 > score2 ? 0 : 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (player == 0) {
            int result1 = isAlexWinner(arr, i + 1, j, 1, score1 + arr[i], score2, dp);
            int result2 = isAlexWinner(arr, i, j - 1, 1, score1 + arr[j], score2, dp);
            dp[i][j] = result1 == 0 ? result1 : result2;
            return dp[i][j];
        } else {
            int result1 = isAlexWinner(arr, i + 1, j, 0, score1 + arr[i], score2, dp);
            int result2 = isAlexWinner(arr, i, j - 1, 0, score1 + arr[j], score2, dp);
            dp[i][j] = result1 == 0 ? result1 : result2;
            return dp[i][j];

        }
    }
}
