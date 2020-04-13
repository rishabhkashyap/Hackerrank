package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Problem:https://leetcode.com/problems/is-subsequence/description/
public class Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        System.out.println(isSubSequence(s, t));
    }

    private static boolean isSubSequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int location = t.indexOf(s.charAt(0));
        if (location>=0) {
            return isSubSequence(s.substring(1),t.substring(location+1));
        } else {
            return false;
        }
    }
}
