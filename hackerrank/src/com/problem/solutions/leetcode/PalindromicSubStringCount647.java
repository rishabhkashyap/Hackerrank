package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problem: https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubStringCount647 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        System.out.println(countPalindromicSubstring(string));

    }


    private static int countPalindromicSubstring(String str) {
        int count = str.length();
        boolean[][] dp = new boolean[str.length() + 1][str.length() + 1];
        for (int i = 1; i < str.length(); i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= str.length(); len++) {
            for (int start = 0; start <= str.length() - len; start++) {
                int end = start + len - 1;
                //  System.out.println(str.substring(start, end));
                if (len == 2 && str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = true;
                    ++count;
                } else {
                    if (dp[start + 1][end - 1] == true && str.charAt(start) == str.charAt(end)) {
                        ++count;
                        dp[start][end] = true;
                    }
                }

            }
        }
        return count;
    }

}
