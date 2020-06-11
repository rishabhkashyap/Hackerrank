package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PalindromicSubStringCount {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        System.out.println(countPalindromicString2(string));

    }


    private static int countPalindromicString2(String string) {
        boolean[][] dp = new boolean[string.length() + 1][string.length() + 1];
        int count = 0;
        //covering palindromic substring of length 1
        for (int i = 0; i < string.length(); i++) {
            ++count;
            dp[i][i] = true;
        }

        for (int len = 2; len <= string.length(); ++len) {
            for (int start = 0; start <= string.length() - len; ++start) {
                int end = start + len - 1;
                //Covering palindromic substring of length 2
                if (start == end - 1 && string.charAt(start) == string.charAt(end)) {
                    ++count;
                    dp[start][end] = true;
                }
                if ((string.charAt(start) == string.charAt(end)) && dp[start + 1][end - 1]) {
                    ++count;
                    dp[start][end] = true;
                }
            }
        }
        return count;

    }

}
