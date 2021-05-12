package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/count-sorted-vowel-strings/
import java.util.ArrayList;
import java.util.Arrays;

public class SortedVowelStrings {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countVowelString(n));
    }

    private static int countVowelString(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        return countVowelString(vowels, n, 0, new ArrayList<Character>());
    }

    private static int countVowelString(char[] vowels, int n, int index, ArrayList<Character> result) {
        if (n == result.size()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < vowels.length; i++) {
            if (result.size() == 0 || result.get(result.size() - 1) <= vowels[i]) {
                result.add(vowels[i]);
                count += countVowelString(vowels, n, i, result);
                result.remove(result.size() - 1);
            }
        }

        return count;
    }
}
