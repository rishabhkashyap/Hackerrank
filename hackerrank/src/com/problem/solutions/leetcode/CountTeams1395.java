package com.problem.solutions.leetcode;

import java.util.Arrays;

public class CountTeams1395 {
    public static void main(String[] args) {
        int[] arr = {2,5,3,4,1};
        System.out.println(countTeams(arr));
    }

    private static int countTeams(int[] arr) {
        //Arrays.sort(arr);
        return (countTeams1(arr, 1,0 ,arr[0])+countTeams2(arr, 1,0 ,arr[0]));
    }

    private static int countTeams1(int[] arr, int j, int count,int prev) {
        if (arr.length < 3) {
            return 0;
        }
        if(j>=arr.length){
            return 0;
        }
        if(arr.length-j<3){
            return 0;
        }
        if (count % 3 == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = j; i < arr.length; i++) {
            if(prev<arr[i]){
                sum += countTeams1(arr, i + 1, count + 1,arr[i]);
            }

        }
        return sum;
    }
    private static int countTeams2(int[] arr, int j, int count,int prev) {
        if (arr.length < 3) {
            return 0;
        }

        if(j>=arr.length){
            return 0;
        }
        if(arr.length-j<3){
            return 0;
        }
        if (count % 3 == 1) {
            return 1;
        }

        int sum = 0;
        for (int i = j; i < arr.length; i++) {
            if(prev>arr[i]){
                sum += countTeams2(arr, i + 1, count + 1,arr[i]);
            }

        }
        return sum;
    }
}
