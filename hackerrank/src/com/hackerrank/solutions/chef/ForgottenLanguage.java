package com.hackerrank.solutions.chef;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ForgottenLanguage {

    public static void main(String[]args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer=null;
        List<String>words=new ArrayList<>();
        int t=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<t;i++){
            tokenizer=new StringTokenizer(bufferedReader.readLine());
            int n=Integer.parseInt(tokenizer.nextToken());
            int k=Integer.parseInt(tokenizer.nextToken());
            List<String>oldWords=new ArrayList<>();
            tokenizer=new StringTokenizer(bufferedReader.readLine());
            while (tokenizer.hasMoreTokens()){
                oldWords.add(tokenizer.nextToken());
            }


            for(int j=0;j<k;j++){
                tokenizer=new StringTokenizer(bufferedReader.readLine());
                tokenizer.nextToken();
                while (tokenizer.hasMoreTokens()){
                    words.add(tokenizer.nextToken());
                }

            }
            printWordsAvailability(oldWords,words);
        }



    }

    private static void printWordsAvailability(List<String> oldWords, List<String> words) {
        for(String oldWord:oldWords){
            if(words.contains(oldWord)){
                System.out.print("YES ");
            }else{
                System.out.print("NO ");

            }

        }
    }
}
