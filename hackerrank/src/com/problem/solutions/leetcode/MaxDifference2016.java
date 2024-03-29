package com.problem.solutions.leetcode;

//Problem:https://leetcode.com/problems/maximum-difference-between-increasing-elements/
public class MaxDifference2016 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 4};
        System.out.println(findMaxDiff(nums));
        System.out.println(maximumDifference(nums));
    }

    private static int findMaxDiff(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        int minSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (minSoFar > nums[i]) {
                minSoFar = nums[i];
            }
            min[i] = minSoFar;
        }
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min[i] < nums[i]) {
                result = Math.max(result, nums[i] - min[i]);
            }
        }
        return result;
    }

    //Similar to buy and sell stock
    private static int maximumDifference(int[] nums) {
        int min=Integer.MAX_VALUE;
        int result=-1;
        for(int i=0;i<nums.length;i++){
            result=Math.max(result,nums[i]-min);
            min=Math.min(min,nums[i]);
        }
        return result==0?-1:result;

    }

}
