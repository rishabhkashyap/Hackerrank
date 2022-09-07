package com.problem.solutions.leetcode;

public class StringWrap467 {
    public static void main(String[] args) {
        String str = "zab";
        generateSubstrings(str);
    }

    private static void generateSubstrings(String str) {
        for (int len = 1; len <= str.length(); len++) {
            for (int start = 0; start <= str.length() - len; start++) {
                int end = start + len;
                System.out.println(str.substring(start, end));
            }
        }
    }
}
