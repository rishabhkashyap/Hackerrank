package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoKeyKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println(countOps(num));
    }

    private static int countOps(int num) {
        int[] dp = new int[num + 1];
        if (num > 1) {

            return countOps(1, num, 1, dp) + 1;
        } else {
            return 0;
        }
    }

    private static int countOps(int target, int num, int copyLen, int[] dp) {


        if (target == num) {
            return 0;
        }
        if (target > num) {
            return 2000;
        }

        int pasteOps = countOps(target + copyLen, num, copyLen, dp) + 1;
        int copyOps = countOps(target + target, num, target, dp) + 2;

        return Math.min(copyOps, pasteOps);
    }
}
