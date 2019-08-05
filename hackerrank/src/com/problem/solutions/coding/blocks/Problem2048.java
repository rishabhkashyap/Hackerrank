package com.problem.solutions.coding.blocks;


//Write any number in words using recursion

public class Problem2048 {

    public static void main(String[] args) {
        int number = 2048;
        printWordsForNumber(number);
    }

    private static void printWordsForNumber(int number) {
        if (number == 0) {
            return;
        }
        int digit = number % 10;
        printWordsForNumber(number / 10);
        String word = getWordForNumber(digit);
        System.out.print(word+"  ");
    }

    private static String getWordForNumber(int digit) {

        String word = null;

        switch (digit) {
            case 0:
                word = "zero";
                break;
            case 1:
                word = "One";
                break;
            case 2:
                word = "Two";
                break;
            case 3:
                word = "Three";
                break;
            case 4:
                word = "Four";
                break;
            case 5:
                word = "Five";
                break;
            case 6:
                word = "Six";
                break;
            case 7:
                word = "Seven";
                break;
            case 8:
                word = "Eight";
                break;
            case 9:
                word = "Nine";
                break;
            default:
                word = "";


        }
        return word;
    }


}
