package com.problem.solutions.leetcode;

import java.util.Stack;

//Problem: https://leetcode.com/problems/backspace-string-compare/
public class BackspaceCompare844 {
    public static void main(String[] args) {
        String str1 = "ab##";
        String str2 = "c#d#";
        System.out.println(isEqual1(str1, str2));
        System.out.println(isEqual2(str1, str2));
    }

    private static boolean isEqual1(String str1, String str2) {
        String updatedString1 = typeString(str1);
        String updatedString2 = typeString(str2);
        return updatedString1.equals(updatedString2);
    }

    private static String typeString(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            ++i;
        }
        return sb.toString();
    }

    private static boolean isEqual2(String str1, String str2) {
        Stack<Character> stack1 = typeString2(str1);
        Stack<Character> stack2 = typeString2(str2);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;

    }

    private static Stack<Character> typeString2(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }
}
