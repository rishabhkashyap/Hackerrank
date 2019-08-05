package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtraLongFactorial {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[]fact=new int[1000];
		int sizeFact=1;
		fact[0]=1;
		int number=Integer.parseInt(br.readLine());
		for(int i=2;i<=number;i++){
			sizeFact=doMultiplication(fact,sizeFact,i);
		}
		displayFactorial(fact,sizeFact);

	}

	private static int doMultiplication(int[] fact, int sizeFact,int num) {
		int carry=0;		
		for(int i=0;i<sizeFact;i++){
			int product=fact[i]*num+carry;
			fact[i]=product%10;
			carry=product/10;
		}
		if(carry!=0){
			fact[sizeFact]=carry;
			++sizeFact;
		}
		return sizeFact;
	}
	
	private static void  displayFactorial(int[] fact,int sizeFact){
		for(int i=sizeFact-1;i>0;--i){
			System.out.print(fact[i]);
		}
	}

}
