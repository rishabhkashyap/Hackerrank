package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problem: https://www.hackerrank.com/challenges/crossword-puzzle/problem
public class Crossword {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[][] crossWord = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < 10; j++) {
                crossWord[i][j] = line.charAt(j);
            }
        }

        String[] words = bufferedReader.readLine().split(";");
        solveCrossword(crossWord, words, 0);
    }

    private static void solveCrossword(char[][] crossWord, String[] words, int i) {

        if (i == words.length) {
            printCrossword(crossWord);
            return;
        }


        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                int p = j;
                int q = k;
                int currentLen = 0;
                int len = words[i].length();
                while (currentLen < len && p + currentLen < 10) {
                    if (crossWord[p + currentLen][q] != '-' &&
                            crossWord[p + currentLen][q] != words[i].charAt(currentLen)) {
                        break;
                    }
                    ++currentLen;
                }
                //Fill vertical

                if (currentLen == len) {
                    char[][] temp = copyArray(crossWord);
                    for (int l = 0; l < len; l++) {
                        crossWord[p + l][q] = words[i].charAt(l);
                    }
                    solveCrossword(crossWord, words, i + 1);
                    crossWord = temp;
                }
                currentLen = 0;
                while (currentLen < len && q + currentLen < 10) {
                    if (crossWord[p][currentLen + q] != '-' && crossWord[p][currentLen + q] != words[i].charAt(currentLen)) {
                        break;
                    }
                    ++currentLen;
                }

                //Fill horizontal

                if (currentLen == len) {
                    char[][] temp = copyArray(crossWord);
                    for (int l = 0; l < len; l++) {
                        crossWord[p][q + l] = words[i].charAt(l);
                    }
                    solveCrossword(crossWord, words, i + 1);
                    crossWord = temp;
                }

            }
        }
    }

    private static void printCrossword(char[][] crossWord) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(crossWord[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] copyArray(char[][] crossword) {
        char[][] temp = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = crossword[i][j];
            }
        }
        return temp;
    }
}
