package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Problem: https://leetcode.com/problems/word-break/
public class WordBreak139 {
    public static void main(String[] args) {
        String string = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(canBreakWord(string, wordDict));
    }

    private static boolean canBreakWord(String string, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[][] dp = new int[string.length() + 1][string.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return canBreakWord(string, set, 0, string.length() - 1, dp);
    }

    private static boolean canBreakWord(String string, Set<String> set, int i,
                                        int j, int[][] dp) {
        if (i > j) {
            return false;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j]==1?true:false;
        }
        if (set.contains(string.substring(i, j + 1))) {
            return true;
        }
        boolean result=false;
        dp[i][j]=0;
        for (int k = i; k < j; k++) {
            if (canBreakWord(string, set, i, k, dp)
                    && canBreakWord(string, set, k + 1, j, dp)) {
                dp[i][j] = 1;
                result=true;
            }
        }
        return result;
    }
}
