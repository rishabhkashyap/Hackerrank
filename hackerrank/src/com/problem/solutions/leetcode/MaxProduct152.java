package com.problem.solutions.leetcode;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/maximum-product-subarray/

public class MaxProduct152 {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(findMaxProduct1(arr));
    }

    private static int findMaxProduct1(int[] arr) {
        int maxProd = Arrays.stream(arr).max().getAsInt();
        int maxProductSoFar = 1;
        int minProductSoFar = 1;
        for (int ele : arr) {
            if (ele == 0) {
                minProductSoFar = 1;
                maxProductSoFar = 1;
            } else {

                int temp = maxProductSoFar;
                maxProductSoFar = Math.max(Math.max(maxProductSoFar * ele, minProductSoFar * ele), ele);
                //Since max product so far is changed, using value stored int temp
                minProductSoFar = Math.min(Math.min(temp * ele, minProductSoFar * ele), ele);
                maxProd = Math.max(maxProd, maxProductSoFar);
            }

        }
        return maxProd;
    }
}
