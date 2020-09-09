//Problem: https://leetcode.com/problems/delete-and-earn/submissions/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeleteNEarn {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] arr = new int[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(getMaxEarning1(arr));
        System.out.println(getMaxEarning2(arr));
        System.out.println(getMaxEarning3(arr));
    }

    private static int getMaxEarning1(int[] arr) {
        return getMaxEarning1(arr, 0);

    }

    //Solution works but gives TLE for few test cases
    private static int getMaxEarning1(int[] arr, int i) {
        if (i == arr.length) {
            return 0;
        }

        int result1 = getMaxEarning1(arr, i + 1);
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int earnings = deleteAndEarn(arrCopy, arr[i]);
        int result2 = getMaxEarning1(arrCopy, i + 1) + earnings;
        return Math.max(result1, result2);


    }

    private static int deleteAndEarn(int[] arrCopy, int ele) {
        int earning = 0;
        for (int i = 0; i < arrCopy.length; i++) {
            if (arrCopy[i] == ele - 1 || arrCopy[i] == ele + 1) {
                arrCopy[i] = 0;
            }
            if (arrCopy[i] == ele) {
                earning += ele;
                arrCopy[i] = 0;
            }
        }
        return earning;
    }

    //Right solution but stackoverflow when earning size is greater than 1000,but accepted
    //by leetcode
    private static int getMaxEarning2(int[] arr) {
        int[] earning = new int[1000];
        for (int element : arr) {
            earning[element] += element;
        }
        int[] dp = new int[earning.length + 1];
        Arrays.fill(dp, -1);
        return getMaxEarning2(earning, earning.length - 1, dp);
    }


    private static int getMaxEarning2(int[] earning, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (i == 0 || i == 1) {
            return earning[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result1 = getMaxEarning2(earning, i - 1, dp);
        int result2 = getMaxEarning2(earning, i - 2, dp) + earning[i];
        dp[i] = Math.max(result1, result2);
        return dp[i];
    }

    private static int getMaxEarning3(int[] arr) {
        int[] earnings = getEarning(arr);
        int[] dp = new int[earnings.length];
        dp[0] = earnings[0];
        dp[1] = earnings[1];
        for (int i = 2; i < earnings.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + earnings[i]);
        }
        return dp[earnings.length - 1];

    }

    private static int[] getEarning(int[] arr) {
        int[] earning = new int[20002];
        for (int element : arr) {
            earning[element] += element;
        }
        return earning;
    }


}
