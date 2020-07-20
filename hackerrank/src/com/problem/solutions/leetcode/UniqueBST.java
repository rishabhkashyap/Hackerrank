
//https://leetcode.com/problems/unique-binary-search-trees/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class UniqueBST {


    public static void main(String[] args) {

        int num = 3;
        System.out.println(countBST(num));
        System.out.println(countBST2(num));

    }

    private static int countBST(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        return countBST(num, dp);
    }

    private static int countBST(int num, int[] dp) {
        if (num == 0 || num == 1) {
            return 1;
        }

        if (dp[num] != -1) {
            return dp[num];
        }
        int result = 0;
        for (int i = 1; i <= num; ++i) {
            result += countBST(i - 1, dp) * countBST(num - i, dp);
        }
        return result;

    }

    private static int countBST2(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        // represent tree of size 1,2,3...etc
        for (int i = 2; i <= num; i++) {
            // represents nodes 1,2,3...i
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[num];
    }
}
