package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Problem: https://www.hackerrank.com/challenges/the-power-sum/problem
public class PowerSum {

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        getPowerCount(x, n);
        System.out.println(count);
    }

    private static void getPowerCount(int x, int n) {

        powerCountHelper(x, x, n, 1);
    }

    private static void powerCountHelper(int maxVal, int x, int n, int index) {
        if (x == 0) {
            //System.out.println();
            //numbers.forEach(e -> System.out.print(e + "\t"));
            ++count;
            return;
        }
        if (x < 0) {
            return;
        }
        for (int i = index; i <= maxVal; i++) {

            powerCountHelper(maxVal, x - (int) Math.pow(i, n), n, i + 1);


        }
    }


}
