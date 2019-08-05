package hackerrank.src.com.hackerrank.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tiling {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());

            int result = count(n, m);
            System.out.println(result);


        }

    }

    private static int count(int n, int m) {
        int[] countArr = new int[n + 1];
        int mod = 1000000000 + 7;
        for (int i = 1; i <= n; i++) {
            if (i > m) {
                countArr[i] = countArr[i - 1] + countArr[i - m];
            } else if (i == m) {
                countArr[i] = 2;
            } else if (i < m) {
                countArr[i] = 1;
            }
        }
        return countArr[n];
    }
}
