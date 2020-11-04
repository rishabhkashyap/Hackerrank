//Problem: https://leetcode.com/problems/predict-the-winner/
package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PredictWinner {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
        int[] scores = new int[tokenizer.countTokens()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(tokenizer.nextToken());
        }
        if (predictWinner1(scores)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    //Player 1 plays in such a way that it leaves rest of array in a state
    //where player2 can only pick minimum value.Therefore for player 2
    //pick minimum of 2 choices
    private static boolean predictWinner1(int[] scores) {
        Map<String, Integer> map = new HashMap<>();
        return predictWinner1(scores, 0, scores.length - 1, 0, map) >= 0 ? true : false;
    }

    private static int predictWinner1(int[] scores, int i, int j, int player, Map<String, Integer> dp) {
        if (i > j) {
            return 0;
        }
        if (i >= scores.length || j < 0) {
            return 0;
        }
        String key = i + "_" + j + "_" + player;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (player == 0) {
            int result1 = predictWinner1(scores, i + 1, j, 1, dp) + scores[i];
            int result2 = predictWinner1(scores, i, j - 1, 1, dp) + scores[j];
            int result = Math.max(result1, result2);
            dp.put(key, result);
            return result;
        } else {
            int result1 = predictWinner1(scores, i + 1, j, 0, dp) - scores[i];
            int result2 = predictWinner1(scores, i, j - 1, 0, dp) - scores[j];
            int result = Math.min(result1, result2);
            dp.put(key, result);
            return result;

        }

    }
}
