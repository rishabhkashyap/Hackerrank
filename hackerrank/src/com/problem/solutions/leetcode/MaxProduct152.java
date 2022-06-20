package com.problem.solutions.leetcode;

public class MaxProduct152 {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(findMaxProduct1(arr));
    }

    private static int findMaxProduct1(int[] arr) {
        int maxProd = Integer.MIN_VALUE;
        int maxProductSoFar = 1;
        int negativeProd=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int product=
            if (maxProd < maxProductSoFar) {
                maxProd = maxProductSoFar;
            }
            if (maxProductSoFar < 0) {
                negativeProd=1;
                maxProductSoFar = 1;
            }

        }
        return maxProd;
    }
}
