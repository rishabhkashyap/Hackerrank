package com.problem.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModularExpo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        long m = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(calculateExpo(a, b, m)%m);
    }


    public static long calculateExpo(long a, long b, long m) {
        long result = 1;
        while (b > 0) {
            long bitResult = a & 1;
            if (bitResult == 1) {
                result = (result * a);
            }
            a = a * a;
            b=b>>1;
        }
        return result;
    }

    private static long fastModuloExponetian(long n, long l, long p) {
        long result=1;
        while(l>0){
            long bitResult=l&1;
            if(bitResult==1){
                result=(result*n)%p;
            }
            n=(n*n)%p;
            l=l>>1;
        }
        return result;
    }
}
