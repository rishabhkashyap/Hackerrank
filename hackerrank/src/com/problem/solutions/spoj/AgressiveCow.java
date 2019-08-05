package com.problem.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//Problem statement https://www.spoj.com/problems/AGGRCOW/
public class AgressiveCow {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int barn = Integer.parseInt(tokenizer.nextToken());
            int cows = Integer.parseInt(tokenizer.nextToken());
            int[] barnLocation = new int[barn];

            for (int j = 0; j < barn; j++) {
                barnLocation[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(barnLocation);
            long minDistance = getMinDistance(barnLocation, cows);
            System.out.println(minDistance);

        }


    }

    private static long getMinDistance(int[] barnLocation, int cows) {

        long low = 0;
        long high = 1000000000;
        long answer = -1;
        while (low <= high) {
            int c = 1;
            long mid = low + (high - low) / 2;
            int start = barnLocation[0];
            for (int i = 1; i < barnLocation.length; i++) {
                if (barnLocation[i] - start >= mid) {
                    c++;
                    start = barnLocation[i];
                }
            }
            if (c < cows) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = mid;

            }
        }
        return answer;


    }

}
