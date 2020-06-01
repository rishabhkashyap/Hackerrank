//Problem: https://leetcode.com/problems/counting-bits/description/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = getSetBitArr(n);
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));

    }

    private static int[] getSetBitArr(int n) {
        int[] arr = null;
        if (n == 0) {
            arr = new int[1];
            arr[0] = 0;
            return arr;
        } else {
            arr = new int[n + 1];
            arr[0] = 0;
            arr[1] = 1;
            getSetBitArr(n, arr, 2);
            return arr;
        }

    }

    private static void getSetBitArr(int n, int[] arr, int i) {
        if (i > n) {
            return;
        }
        if (i % 2 == 0) {
            arr[i] = arr[i / 2];
        } else {
            arr[i] = arr[i / 2] + 1;
        }
        getSetBitArr(n, arr, i + 1);
    }

    //Faster solution
    private static int[] countBits(int num) {
        int[] arr = null;
        if (num == 0) {
            arr = new int[1];
            arr[0] = 0;
            return arr;
        } else {
            arr = new int[num + 1];
            arr[0] = 0;
            arr[1] = 1;
            for(int i=2;i<=num;i++){
                if (i % 2 == 0) {
                    arr[i] = arr[i / 2];
                } else {
                    arr[i] = arr[i / 2] + 1;
                }
            }
            return arr;
        }

    }
}
