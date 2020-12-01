//Problem: https://leetcode.com/problems/dice-roll-simulation/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceSimulator {
//    private static int ans = 0;
    private static final int M=1000000000+7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        }
        System.out.println(countSequence1(arr, n));
        System.out.println(countSequence2(arr, n));
    }

    private static int countSequence1(int[] arr, int n) {
        return countSequence1(arr, n, -1, 0);

    }

    private static int countSequence1(int[] arr, int n, int last, int currentLen) {
        if (n == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (i == last && currentLen == arr[i]) {
                continue;
            }
            ans += countSequence1(arr, n - 1, i, i == last ? currentLen + 1 : 1);
        }
        return ans;
    }

    private static int countSequence2(int[] arr, int dices) {
        int[][][] dp = new int[5000][6][16];
        return countSequence2(arr, dices, -1, 0, dp);
    }

    private static int countSequence2(int[] arr, int dices, int lastNumber, int lastNumberLen, int[][][] dp) {
        if (dices == 0) {
            return 1;
        }
        if (lastNumber >= 0 && dp[dices][lastNumber][lastNumberLen] > 0) {
            return dp[dices][lastNumber][lastNumberLen];
        }
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (i == lastNumber && lastNumberLen == arr[i]) {
                continue;
            }
            ans = (ans+countSequence2(arr, dices - 1, i, i == lastNumber ? lastNumberLen + 1 : 1, dp))%M;
        }
        if (lastNumber >= 0) {
            dp[dices][lastNumber][lastNumberLen] = ans;
        }
        return ans;
    }
}
