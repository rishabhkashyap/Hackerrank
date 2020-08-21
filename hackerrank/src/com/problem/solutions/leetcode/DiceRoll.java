//Problem: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceRoll {
    private static final int MOD_VALUE = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(bufferedReader.readLine());
        int f = Integer.parseInt(bufferedReader.readLine());
        int target = Integer.parseInt(bufferedReader.readLine());
        System.out.println(countWays(d, f, target));
        System.out.println(countWays2(d, f, target));
    }

    private static int countWays(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return countWays(d, f, target, 0, dp);
    }

    private static int countWays(int d, int f, int target, int count, int[][] dp) {
        if (d == 0 && target == 0) {
            return (count + 1);
        }
        if (target < 0) {
            return 0;
        }
        if (d == 0) {
            return 0;
        }
        if (dp[d][target] != -1) {
            return dp[d][target];
        }
        dp[d][target] = 0;
        for (int i = 1; i <= f; i++) {
            dp[d][target] = (dp[d][target] + countWays(d - 1, f, target - i, count, dp)) % MOD_VALUE;

        }
        return dp[d][target];
    }

    private static int countWays2(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int dice = 1; dice <= d; ++dice) {
            for (int currentSum = 0; currentSum <= target; currentSum++) {
                for (int facevalue = 1; facevalue <= f; facevalue++) {
                    if (currentSum >= facevalue) {
                        dp[dice][currentSum] = (dp[dice][currentSum] + dp[dice - 1][currentSum - facevalue]) % MOD_VALUE;
                    }
                }
            }
        }
        return dp[d][target];
    }
}
