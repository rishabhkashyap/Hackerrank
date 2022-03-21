package com.problem.solutions.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String str = "cdd";
        List<List<String>> result = palindromicPartitions(str);
        result.forEach(e -> System.out.println(e));
    }

    private static List<List<String>> palindromicPartitions(String str) {
        List<List<String>> result = new ArrayList<>();
        palindromicPartitions(str, "", result);
        return result;
    }

    private static void palindromicPartitions(String str, String currentResult, List<List<String>> result) {
        if (str.length() == 0) {
            result.add(Arrays.asList(currentResult.split("-")));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String rest = str.substring(i + 1);
            if (isPalindrome(prefix)) {
                palindromicPartitions(rest, currentResult + prefix + "-", result);
            }
        }

    }

    private static boolean isPalindrome(String prefix) {
        int i = 0;
        int j = prefix.length() - 1;
        while (i < j) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
