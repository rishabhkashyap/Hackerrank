package com.problem.solutions.leetcode;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/generate-parentheses/

public class Parentheses22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParanthesis(n);
        result.forEach(e -> System.out.print(e+"\t"));
    }

    private static List<String> generateParanthesis(int n) {

        String string = "";
        List<String> result = new ArrayList<>();
        generateParanthesis(string, n, n, result);
        return result;
    }

    private static void generateParanthesis(String string, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            //  System.out.println(string);
            result.add(string);
            return;
        }
        if (left > 0) {
            generateParanthesis(string + "(", left - 1, right, result);
        }
        //When closing bracket is greater than opening bracket we know for sure
        //there string is not balanced therefore add closing bracket to balance string
        if (right > 0 && left < right) {
            generateParanthesis(string + ")", left, right - 1, result);
        }


    }
}
