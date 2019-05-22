package com.hackerrank.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisors {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        int m = 1000000000 + 7;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] numbers = new int[n];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(tokenizer.nextToken());
            }

            long result = getDivisor(numbers);
            System.out.println(result % m);
        }

    }

    private static int getDivisor(int[] numbers, int m) {
        int number = 1;
        for (int i = 0; i < numbers.length; i++) {
            number = (number * numbers[i]) % m;
        }

        int factors = countFactors(number);
        return factors;
    }

    private static int countFactors(int number) {

        int count = 0;
        for (int i = 1; i * i <= number; i++) {

            if (number % i == 0) {
                ++count;
            }
            double divisor2 = (double) number / (double) i;
            if (divisor2 != i && Math.ceil(divisor2) == divisor2) {
                ++count;
            }

        }
        return count;
    }


    private static long getDivisor(int[] numbers) {
        int[] factorFreq = new int[1000001];
        long count = 1;

        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            //Check whether number is prime
            if (isPrime(temp)) {
                ++factorFreq[temp];
                continue;
            }
            while (temp % 2 == 0) {
                ++factorFreq[2];
                temp = temp / 2;
            }
            if (isPrime(temp)) {
                ++factorFreq[temp];
                continue;
            }

            for (int j = 3; j <= numbers[i]; j += 2) {

                if(temp==0){
                    break;
                }
                while (temp % j == 0) {
                    ++factorFreq[j];
                    temp = temp / j;
                }
            }


        }
        for (int i = 2; i < factorFreq.length; i++) {
            if (factorFreq[i] != 0) {
                count = count*(factorFreq[i]+1);
            }

        }
        return count;


    }


    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
