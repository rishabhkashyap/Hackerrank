package com.solutions.chef;



import java.io.*;
import java.util.Stack;


public class Compiler {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int maxSoFar = 0;

            String expression = bufferedReader.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < expression.length(); j++) {
                char ch = expression.charAt(j);

                if (ch == '<') {

                    stack.push(ch);
                } else if (ch == '>') {

                    if (stack.isEmpty()) {
                        break;
                    }
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxSoFar = j + 1;
                    }


                }
            }
            bufferedWriter.write(Integer.toString(maxSoFar));
            bufferedWriter.newLine();



        }


    }

    private static void parse(String expression){
        if(expression!=null){
            int count=0;
            int max=0;
            for(int i=0;i<expression.length();i++){
                char ch=expression.charAt(i);
                if(ch=='<'){
                    ++count;
                }else if(ch=='>'){
                    if(i==0){
                        break;
                    }
                    --count;
                }

                if(count==0){
                    max=i+1;
                }
            }
            System.out.println(max);
        }
    }


}


