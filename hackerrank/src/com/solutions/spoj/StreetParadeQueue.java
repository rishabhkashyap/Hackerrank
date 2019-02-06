
//https://www.spoj.com/problems/STPAR/
package com.solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class StreetParadeQueue {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while(true){

            int n=Integer.parseInt(bufferedReader.readLine());
            if(n==0){
                break;
            }
            StringTokenizer tokenizer=new StringTokenizer(bufferedReader.readLine());
            Queue<Integer>mobiles=new LinkedList<>();
            for(int i=0;i<n;i++){
                mobiles.add(Integer.parseInt(tokenizer.nextToken()));
            }

            boolean order=hasOrder(mobiles);
            if(order){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }

        }



    }

    private static boolean hasOrder(Queue<Integer> mobiles) {
        int position=1;
        int mobileSize=mobiles.size();
        Stack<Integer>stack = new Stack<>();
        while (!mobiles.isEmpty() || !stack.isEmpty()){
            if(!mobiles.isEmpty() && mobiles.peek()==position){
                ++position;
                mobiles.remove();
            }else{
                if(!stack.isEmpty() && stack.peek()==position){
                    ++position;
                }else{
                    if(!mobiles.isEmpty()){
                        stack.push(mobiles.remove());
                    }else {
                         break;
                    }

                }

            }
        }
        return position==mobileSize?true:false;
    }
}
