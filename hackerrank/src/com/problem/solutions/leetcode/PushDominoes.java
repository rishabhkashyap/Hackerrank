//https://leetcode.com/problems/push-dominoes/submissions/

package com.problem.solutions.leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PushDominoes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String result = pushDominoes(bufferedReader.readLine());
        System.out.println(result);
    }

    private static String pushDominoes(String string) {
        char[] arr = string.toCharArray();
        int[] leftDistance = new int[arr.length];
        int[] rightDistance = new int[arr.length];
        int distance = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'R') {
                distance = i;
            } else if (arr[i] == 'L') {
                distance = arr.length;
            }
            rightDistance[i] = distance == arr.length ? arr.length : Math.abs(i - distance);

        }
        distance = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                distance = i;
            } else if (arr[i] == 'R') {
                distance = -1;
            }
            leftDistance[i] = distance == -1 ? arr.length : Math.abs(distance - i);
        }
        for (int i = 0; i < arr.length; i++) {

            if (leftDistance[i] > rightDistance[i]) {
                arr[i] = 'R';
            } else if (leftDistance[i] < rightDistance[i]) {
                arr[i] = 'L';
            } else if (leftDistance[i] == rightDistance[i]) {
                arr[i] = '.';
            }
        }

        return String.valueOf(arr);
    }

    private static void pushDominoes(char[] arr, int i, int prev) {
        if (i >= arr.length || prev >= arr.length) {
            return;
        }
        if (prev == -1) {
            char rightDomino = arr[i + 1];
            if (rightDomino == 'L') {
                arr[i] = 'L';
            }
            pushDominoes(arr, i + 1, i);
        } else {
            char leftDomino = arr[prev];
            char rightDomino = ' ';
            if (i + 1 < arr.length) {
                rightDomino = arr[i + 1];
                if (leftDomino == 'R' && rightDomino == '.') {
                    arr[i] = 'R';
                } else if (leftDomino == '.' && rightDomino == 'L') {
                    arr[i] = 'L';
                } else if (leftDomino == 'R' && rightDomino == 'L') {
                    arr[i] = '.';
                }
                pushDominoes(arr, i + 1, i);
            }
        }

    }
}
