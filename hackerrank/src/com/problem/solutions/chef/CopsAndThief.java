package com.problem.solutions.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CopsAndThief {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = null;
        for (int i = 0; i < t; i++) {
            int count=0;
            int max = 0;
            int min = 0;
            int[] arr = new int[101];


            tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());

            x = x * time;
 
            tokenizer = new StringTokenizer(br.readLine());
            for (int p=0;p<n;p++){
                max = 0;
                min = 0;
                int copHouse = Integer.parseInt(tokenizer.nextToken());
                max=x + copHouse;
                min=copHouse - x;
                if (max> 100) {
                    max = 100;
                }

                if (min< 1) {
                    min = 1;
                }

             for(int k=min;k<=max;k++){
                    if(arr[k]!=1){
                        arr[k]=1;
                    }

             }

            }


            count=(int)Arrays.stream(arr,1,arr.length)
                       .filter(ele->ele==0)
                      .count();
            System.out.println(count);
        }
    }
}
