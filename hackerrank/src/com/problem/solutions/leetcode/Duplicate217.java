package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Problem:https://leetcode.com/problems/contains-duplicate/
public class Duplicate217 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicates1(arr));
        System.out.println(hasDuplicates2(arr));
    }

    //sort and count
    private static boolean containsDuplicates1(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                ++count;
            } else {
                if (count >= 2) {
                    return true;
                }
                count = 1;
            }
        }
        return false;
    }

    private static boolean hasDuplicates2(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }

}
