package com.problem.solutions.coding.blocks;

public class RecursionBasics {

    public static void main(String[] args){

        printIncrease(5);
        System.out.println();
        printDecrease(5);
    }

    private static void printIncrease(int n){
        if(n==1){
            System.out.print(n+"\t");
            return;
        }else{
            printIncrease(n-1);
            System.out.print(n+"\t");
            return;

        }
    }

    private static void printDecrease(int n){
        if(n==1){
            System.out.print(n+"\t");
            return;
        }else{
            System.out.print(n+"\t");
            printDecrease(n-1);
            return;

        }
    }
}
