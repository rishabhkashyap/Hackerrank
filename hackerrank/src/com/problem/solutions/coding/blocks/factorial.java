package com.problem.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class factorial {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        calculateFactorial(n);

    }

    private static void calculateFactorial(int n) {

        int[] result = new int[500];
        result[0] = 1;
        int resultSize = 1;
        int j = 0;
        for (int i = 2; i <= n; i++) {
            resultSize = multiply(i, result, resultSize);
        }
        int k = resultSize - 1;
        while (j < k) {
            int temp = result[k];
            result[k] = result[j];
            result[j] = temp;
            ++j;
            --k;

        }
        Arrays.stream(result,0,resultSize).forEach(e->System.out.print(e));


    }

    static int multiply(int x, int res[], int resultSize) {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < resultSize; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod / 10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[resultSize] = carry % 10;
            carry = carry / 10;
            resultSize++;
        }
        return resultSize;
    }
}
