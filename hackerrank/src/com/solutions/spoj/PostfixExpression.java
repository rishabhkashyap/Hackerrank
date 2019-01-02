package com.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixExpression {

    public  static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<t;i++){
            String expression=bufferedReader.readLine();
            Stack<Character>stack=new Stack<>();
            for(int j=0;j<expression.length();j++){
                char ch=expression.charAt(j);
                if(ch=='('||ch=='['||ch=='{'){
                    stack.push(ch);

                }else if(Character.isLetter(ch)){
                    System.out.print(ch);
                }else if(ch==')'){
                    while (!stack.isEmpty() && stack.peek()!='('){
                        System.out.print(stack.pop());
                    }
                    if(!stack.isEmpty()){
                        stack.pop();
                    }

                }else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='^'){
                    while (!stack.isEmpty() && getPrecdence(stack.peek())>getPrecdence(ch)){
                        System.out.print(stack.pop());
                    }
                    stack.push(ch);

                }
            }
            System.out.println();
        }

    }

    private static int getPrecdence(Character ch) {
        int precedence=-1;
        switch (ch){

            case '+':
                precedence=1;
                break;
            case '-':
                precedence=1;
                break;
            case '/':
                precedence=2;
                break;
            case '*':
                precedence=2;
                break;
            case '^':
                precedence=3;
                break;
            default:
                precedence=-9;
        }
        return precedence;

    }
}
