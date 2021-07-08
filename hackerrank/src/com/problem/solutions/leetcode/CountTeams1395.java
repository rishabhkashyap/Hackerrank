package com.problem.solutions.leetcode;
//Problem: https://leetcode.com/problems/count-number-of-teams/

public class CountTeams1395 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(countTeams(arr));
    }

    /*
    Find out how many triplets are possible if current element is in middle
    count element that are greater and lesser than current element in left and right direction
    Use those count to calculate following scenarios
    number of triplets in decreasing order where current element is mid element
        count1=all elements that are less then current in left* all elements that are larger than element
    number of triplets in increasing order where current element is mid element
        count2=all elements that are greater then current in left* all elements that are less than current element
        Final result=count1+count2
    */
    private static int countTeams(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += countLessRating(arr, i);

        }
        return count;
    }

    private static int countLessRating(int[] arr, int i) {
        int leftSmall = 0;
        int leftLarge = 0;
        int rightSmall = 0;
        int rightLarge = 0;

        int j = 0;
        int k = arr.length - 1;
        while (j < i) {
            if (arr[i] > arr[j]) {
                ++leftSmall;
            } else {
                ++leftLarge;
            }
            ++j;
        }
        while (k > i) {
            if (arr[i] > arr[k]) {
                ++rightSmall;
            } else {
                ++rightLarge;
            }
            --k;
        }
        return (leftSmall * rightLarge) + (leftLarge * rightSmall);
    }


}
