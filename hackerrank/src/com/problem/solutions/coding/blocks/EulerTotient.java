package com.problem.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EulerTotient {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            System.out.println(calculatePhi(number));
        }

    }

    private static int calculatePhi(int number) {
        float result = number;
        for (int i = 2; i * i <= number; ++i) {

            if (number % i == 0) {
                while (number % i == 0) {
                    number = number / i;
                }

                result *= (1.0 - (1.0 / (float) i));

            }

        }

        if (number > 1)
            result *= (1.0 - (1.0 / (float) number));
        return (int) result;
    }


    static int phi(int n) {
        // Initialize result as n
        float result = n;

        // Consider all prime factors of n and for
        // every prime factor p, multiply result
        // with (1 - 1/p)
        for (int p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor.
            if (n % p == 0) {
                // If yes, then update n and result
                while (n % p == 0)
                    n /= p;
                result *= (1.0 - (1.0 / (float) p));
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (n > 1)
            result *= (1.0 - (1.0 / (float) n));

        return (int) result;
    }
}
