package com.problem.solutions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Problem: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/


public class GoodSplit1525 {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(findGoodSplits(str));
    }

    private static int findGoodSplits(String str) {
        Map<String, Integer> map = new HashMap<>();
        //Number of unique character from 0 ... len-1
        int[] prefix = new int[str.length()];

        //Number of unique characters from len-1 ....0
        int[] suffix = new int[str.length()];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < prefix.length; i++) {
            set.add(str.charAt(i));
            prefix[i] = set.size();

        }
        set.clear();
        for (int i = str.length() - 1; i >= 0; --i) {
            set.add(str.charAt(i));
            suffix[i] = set.size();
        }
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                ++count;
            }
        }

        return count;
    }

//    private static int findGoodSplit(char[] arr, int start, int mid, int end, Map<String, Integer> map) {
//
//
//    }


}
