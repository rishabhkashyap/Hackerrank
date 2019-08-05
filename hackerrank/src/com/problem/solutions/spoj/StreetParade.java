

//Problem :https://www.spoj.com/problems/STPAR/
package com.problem.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class StreetParade {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));



        while (true){
            int n=Integer.parseInt(bufferedReader.readLine());
            if(n==0){
                break;
            }
            StringTokenizer tokenizer=new StringTokenizer(bufferedReader.readLine());
            int[]mobiles=new int[n];
            for(int i=0;i<n;i++){
                mobiles[i]=Integer.parseInt(tokenizer.nextToken());
            }

            boolean order=hasOrder(mobiles);
            if(order){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }

        }



    }

    private static boolean hasOrder(int[] mobiles) {
        int position=1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<mobiles.length;i++){


            if(mobiles[i]==position){
                ++position;
            }else {
                if(i<mobiles.length){
                    stack.push(mobiles[i]);
                }else {
                    return false;
                }

            }

            while(!stack.isEmpty() && stack.peek()==position){
                ++position;
                stack.pop();
            }
        }


        return position==mobiles.length+1?true:false;

    }
}
