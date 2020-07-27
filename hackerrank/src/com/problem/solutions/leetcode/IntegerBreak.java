//Problem: https://leetcode.com/problems/integer-break/submissions/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class IntegerBreak {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(getMaxProduct(num));
        System.out.println(getMaxProduct2(num));
    }

    private static int getMaxProduct(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        return getMaxProduct(num, dp);
    }

    private static int getMaxProduct(int num, int[] dp) {
        if (num == 1 || num == 2) {
            return 1;
        }
        if (dp[num] != -1) {
            return dp[num];
        }

        for (int i = 1; i <= num - 1; i++) {
            // do not  break number
            int result1 = i * (num - i);
            //break number
            int result2 = i * getMaxProduct(num - i, dp);
            dp[num] = Math.max(dp[num], Math.max(result1, result2));
        }
        return dp[num];
    }

    private static int getMaxProduct2(int num) {
        int[] dp = new int[num + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                int result1 = j * (i - j);
                int result2 = j * dp[i - j];
                dp[i] = Math.max(dp[i], Math.max(result1, result2));
            }
        }
        return dp[num];
    }


}
