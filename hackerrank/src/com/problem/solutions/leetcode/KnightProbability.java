//Problem: https://leetcode.com/problems/knight-probability-in-chessboard/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KnightProbability {
    private static final int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());
        int r = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        System.out.println(findProbability(n, k, r, c));
        System.out.println(findProbability2(n, k, r, c));

    }

    private static float findProbability(int n, int k, int r, int c) {
        Map<String, Float> map = new HashMap<>();
        return findProbability(n, k, r, c, map);
    }

    private static float findProbability(int n, int k, int r, int c, Map<String, Float> map) {
        if (!validMove(n, r, c)) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        String key = k + "-" + r + "-" + c;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        float result = 0;
        for (int[] direction : directions) {
            result += findProbability(n, k - 1, r + direction[0], c + direction[1], map);
        }
        map.put(key, result / 8);
        return result / 8;
    }

    private static float findProbability2(int n, int k, int r, int c) {
        float[][][] dp = new float[k + 1][n][n];
        dp[0][r][c] = 1;
        for (int move = 1; move <= k; ++move) {
            for (int[] direction : directions) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (validMove(n, i + direction[0], j + direction[1])) {
                            dp[move][i + direction[0]][j + direction[1]] += dp[move - 1][i][j] / 8;
                        }


                    }
                }

            }
        }
        float probability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                probability += dp[k][i][j];
            }
        }
        return probability;
    }

    private static boolean validMove(int n, int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}
