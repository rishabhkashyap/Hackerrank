package com.problem.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Eko {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        long m = Long.parseLong(tokenizer.nextToken());
        int[] trees = new int[n];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long result = getMinimumSawHeight1(trees, m);
        System.out.println(result);

    }

    private static long getMinimumSawHeight(int[] trees, long m) {

        long high = 2000000000;
        long low = 1;
        long result=-1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long minLength =0;

            for(int i=0;i<trees.length;i++){
                if(trees[i]>mid){
                    minLength+=trees[i]-mid;
                }
            }
            if(minLength<m){
                high=mid-1;
            }else{
             result=mid;
             low=mid+1;
            }
        }
        return result;



    }

    private static long getMinimumSawHeight1(int[] trees, long m) {
        Arrays.sort(trees);
        long high = trees[trees.length-1];
        long low = 1;
        long result=-1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long minLength =0;

            for(int i=0;i<trees.length;i++){
                if(trees[i]>mid){
                    minLength+=trees[i]-mid;
                }
            }
            if(minLength<m){
                high=mid-1;
            }else{
                result=mid;
                low=mid+1;
            }
        }
        return result;



    }



}
