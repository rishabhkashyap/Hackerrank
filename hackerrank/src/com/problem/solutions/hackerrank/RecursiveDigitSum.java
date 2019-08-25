package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class RecursiveDigitSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        String n = tokenizer.nextToken();
        int k = Integer.parseInt(tokenizer.nextToken());
        int powerDigit = Integer.parseInt(getPowerDigit(n));
        powerDigit *= k;
        powerDigit = getPowerDigit(powerDigit);
        System.out.println(powerDigit);
    }

    private static int getPowerDigit(int number) {
        int sum = 0;
        if (number == 0) {
            return 0;
        }
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static String getNumber(String n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(n);
        }
        return stringBuilder.toString();

    }

    private static String getPowerDigit(String number) {
        if (number.length() == 1) {
            return number;
        }
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }

        String updatedNumber = getPowerDigit(Long.toString(sum));
        return getPowerDigit(updatedNumber);
    }


}
