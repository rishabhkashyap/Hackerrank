package com.problem.solutions.chef;

import java.util.Arrays;

public class NextGreater {

    public static void main(String[] args){
        int[]number={6,9,3,8,6,5,2};
        getNExtGreaterNumber(number);
    }

    private static void getNExtGreaterNumber(int[] number) {
        int index=0;
        int nextLargestNumber=0;
        int nextIndex=0;
        for(int i=number.length-1;i>=0;--i ){
            if(number[i]>number[i-1]){
                index=i-1;
                break;
            }

        }
        for(int i=number.length-1;i>=0;--i){
            if(number[index]<number[i]){
                nextLargestNumber=number[i];
                nextIndex=i;
                break;
            }
        }
        int temp=number[index];
        number[index]=number[nextIndex];
        number[nextIndex]=temp;

        Arrays.sort(number, index+1, number.length);
        Arrays.stream(number)
                .forEach(e->System.out.print(e+"\t"));
        System.out.println();
    }
}
