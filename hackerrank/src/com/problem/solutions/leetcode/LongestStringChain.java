//Problem:https://leetcode.com/problems/longest-string-chain/description/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LongestStringChain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        String[] arr = new String[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tokenizer.nextToken();
        }
        System.out.println(findLongestStringChain1(arr));
        System.out.println(findLongestStringChainLen(arr));

    }

    //This solution will give TLE because we are saving result from previous but
    // isPredecssor() is called multiple time which increase memoory usage and execution time
    //We need a method where isPredecssor is not called multiple times
    private static int findLongestStringChain1(String[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        Arrays.sort(arr, (e1, e2) -> e1.length() - e2.length());
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findLongestStringChain1(arr, 0, -1, dp);
    }

    private static int findLongestStringChain1(String[] arr, int i, int j,
                                               int[][] dp) {
        if (i >= arr.length || j >= arr.length) {
            return 0;
        }
        if (dp[j + 1][i] != -1) {
            return dp[j + 1][i];
        }
        int result1 = 0;
        if (j < 0 || isPredecessor2(arr[i], arr[j])) {
            result1 = findLongestStringChain1(arr, i + 1, i, dp) + 1;
        }
        int result2 = findLongestStringChain1(arr, i + 1, j, dp);
        dp[j + 1][i] = Math.max(result1, result2);
        return dp[j + 1][i];

    }


    private static boolean isPredecessor2(String string1, String string2) {
        for (int i = 0; i < string1.length(); i++) {
            if (i + 1 <= string1.length()) {
                if (string2.equals(string1.substring(0, i) + string1.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int findLongestStringChainLen(String[] arr) {
        Arrays.sort(arr, (e1, e2) -> e1.length() - e2.length());
        Map<String, Integer> map = new HashMap<>();
        int bestChainLength = 0;
        for (String word : arr) {
            int chainLength = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.deleteCharAt(i);
                String string = stringBuilder.toString();
                chainLength = Math.max(chainLength, map.getOrDefault(string, 0) + 1);
            }
            map.put(word, chainLength);
            bestChainLength = Math.max(bestChainLength, chainLength);
        }
        return bestChainLength;
    }


}
