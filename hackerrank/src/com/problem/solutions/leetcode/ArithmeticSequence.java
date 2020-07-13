//Problem: https://leetcode.com/problems/longest-arithmetic-sequence/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ArithmeticSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(findArithmeticSeqLen1(arr));
    }

    private static int findArithmeticSeqLen1(int[] arr) {
        Map<Integer, Integer>[] maps = new HashMap[arr.length];
        int result = 2;
        for (int i = 0; i < arr.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int difference = arr[i] - arr[j];
                maps[i].put(difference, maps[j].getOrDefault(difference, 1) + 1);
                result = Math.max(maps[i].get(difference), result);
            }
        }
        return result;
    }


}
