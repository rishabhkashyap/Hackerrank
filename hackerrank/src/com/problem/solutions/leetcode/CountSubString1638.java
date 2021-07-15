package com.problem.solutions.leetcode;
//Problem: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
public class CountSubString1638 {

    public static void main(String[] args) {
        String str1 = "abe";
        String str2 = "bbc";
        System.out.println(CountSubStringWithDiff(str1, str2));


    }

    private static int CountSubStringWithDiff(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int diff = 0;
                int start1 = i;
                int start2 = j;
                while (start1 < str1.length() && start2 < str2.length()) {
                    if (str1.charAt(start1) != str2.charAt(start2)) {
                        ++diff;
                    }
                    if (diff == 1) {
                        //Enable below print statement to see all substring combinations
                        //  System.out.println(str1.substring(i,start1+1) + "\t" + str2.substring(j,start2+1));
                        ++count;
                    }
                    if (diff == 2) {
                        break;
                    }
                    ++start1;
                    ++start2;
                }
            }
        }
        return count;
    }
}
