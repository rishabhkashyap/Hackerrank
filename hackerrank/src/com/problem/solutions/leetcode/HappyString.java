//https://leetcode.com/problems/longest-happy-string/submissions/

package com.problem.solutions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class HappyString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        System.out.println(createHappyString(a, b, c));

    }

    private static String createHappyString(int a, int b, int c) {
        Letter letterA = new Letter('a', a);
        Letter letterB = new Letter('b', b);
        Letter letterC = new Letter('c', c);
        Queue<Letter> pq = new PriorityQueue<>((l1, l2) -> l2.getCount() - l1.getCount());
        pq.add(letterA);
        pq.add(letterB);
        pq.add(letterC);
        StringBuilder stringBuilder = new StringBuilder("");
        while (true) {
            Letter maxFreqLetter = pq.remove();
            if (maxFreqLetter.getCount() == 0) {
                break;
            }
            int length = stringBuilder.length();
            if (canAddMaxFreqLetter(stringBuilder, maxFreqLetter.getCharacter())) {
                stringBuilder.append(maxFreqLetter.getCharacter());
                maxFreqLetter.setCount(maxFreqLetter.getCount() - 1);

            } else {
                Letter secondMaxFreqLetter = pq.remove();
                if (secondMaxFreqLetter.getCount() == 0) {
                    break;
                }
                stringBuilder.append(secondMaxFreqLetter.getCharacter());
                secondMaxFreqLetter.setCount(secondMaxFreqLetter.getCount() - 1);
                pq.add(secondMaxFreqLetter);

            }
            pq.add(maxFreqLetter);

        }
        return stringBuilder.toString();

    }

    private static boolean canAddMaxFreqLetter(StringBuilder stringBuilder, char character) {
        int length = stringBuilder.length();

        return length < 2 || (stringBuilder.charAt(length - 1) != character
                || stringBuilder.charAt(length - 2) != character);
    }

    private static class Letter {
        private char character;
        private int count;

        public Letter(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public char getCharacter() {
            return character;
        }
    }
}
