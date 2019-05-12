package hackerrank.src.com.hackerrank.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//We know that prime numbers are positive integers that have exactly two distinct positive divisors.
//Similarly, we'll call a positive integer t Т-prime, if t has exactly three distinct positive divisors.
//You are given an array of n positive integers. For each of them determine whether it is Т-prime or not.

public class Tprime {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tokenizer.nextToken());
            if (isTPrime(arr[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }

    private static boolean isTPrime(long number) {
        List<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
            double divisor2 = (double)number/(double)i;
            if (divisor2 != i && Math.ceil(divisor2)==divisor2) {
                divisors.add(number/i);
            }
        }
        return divisors.size() == 3 ? true : false;
    }
}
