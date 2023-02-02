package com.problem.solutions.leetcode;
//Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class SmallestLetter744 {
    public static void main(String[] args) {
        char[] arr={'c','f','j'};
        char target='c';
        System.out.println(nextGreatestLetter(arr,target));

    }
    private static char nextGreatestLetter(char[] arr,char target){
        int low=0;
        int high=arr.length-1;
        char result=arr[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target<arr[mid]){
                result=arr[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return result;
    }
}
