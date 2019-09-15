package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


//https://www.hackerrank.com/challenges/stone-division-2/problem
public class StoneDivision {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            long nStones = Long.parseLong(tokenizer.nextToken());
            int nset = Integer.parseInt(tokenizer.nextToken());
            long[] set = new long[nset];
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < nset; j++) {
                set[j] = Long.parseLong(tokenizer.nextToken());
            }
            Arrays.sort(set);
            Map<Long, Long> pileMap = new HashMap<>();
            long count = divideStone(nStones, set, pileMap);
            System.out.println(count);
        }
    }

    private static long divideStone(long nStones, long[] set, Map<Long, Long> pileMap) {
        if (nStones == 1) {
            return 0;
        }
        if(pileMap.containsKey(nStones)){
            return pileMap.get(nStones);
        }
        int count = 0;
        long pileSize = 0;
        long divideCount = 0;
        long ans = 0;
        for (int j = 0; j < set.length; j++) {
            long y = set[j];
            if (nStones / y > 1 && nStones % y == 0) {
                pileSize = nStones / y;
                divideCount = divideStone(set[j], set, pileMap);
                ans = Math.max(ans, 1 + (pileSize * divideCount));

            }
        }
        pileMap.put(nStones, ans);
        return ans;
    }
}
