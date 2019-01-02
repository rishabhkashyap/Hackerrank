package com.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextGreater {

    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(bufferedReader.readLine());
            String numStr=bufferedReader.readLine();
            int[]number=new int[n];
            int k=0;
            for(int j=0;j<numStr.length();j++){
                char charNum = numStr.charAt(j);
                if(charNum!=' '){
                    number[k]=Character.getNumericValue(charNum);
                    ++k;
                }

            }
            getNExtGreaterNumber(number);


        }


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
                .forEach(e->System.out.print(e));
        //System.out.println();
    }

}
