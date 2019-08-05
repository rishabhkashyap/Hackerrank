package com.problem.solutions.chef;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Lapindromes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<t;i++){
            String string = bufferedReader.readLine();
            int[]left=new int[26];
            int[]right=new int[26];
            int len=string.length();
            int leftEnd=0;
            int rightStart=0;
            if(len%2==0){
                leftEnd=(len-1)/2;
                rightStart=leftEnd+1;
                checkLapindropmes(string,leftEnd,rightStart);
            }else{
                leftEnd= leftEnd=(len-1)/2-1;
                rightStart=leftEnd+2;
                checkLapindropmes(string,leftEnd,rightStart);
            }

        }


    }

    private static void checkLapindropmes(String string, int maxLeft,int rightStart){
        int[]left=new int[26];
        int[]right=new int[26];
        int i=0;
        int j=string.length()-1;

        while (i<=maxLeft && j>=rightStart){
            char ch=string.charAt(i);
            int index=ch-'a';
            ++left[index];
            ++i;
            ch=string.charAt(j);
            index=ch-'a';
            ++right[index];
            --j;
        }

        boolean isLapPalindropme=Arrays.equals(left, right);
        if(isLapPalindropme){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
