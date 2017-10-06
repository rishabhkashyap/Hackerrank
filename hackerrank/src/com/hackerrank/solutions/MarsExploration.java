package com.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		int changeCharacters=getchangedCharacters(message);
		System.out.println(changeCharacters);
		
		

	}

	private static int getchangedCharacters(String message) {
		int count=0;
		int i=0;
		while(i<message.length()){
			if(message.charAt(i)!='S'){
				++count;
			}
			if(message.charAt(i+1)!='O'){
				++count;
			}
			
			if(message.charAt(i+2)!='S'){
				++count;
			}
			i+=3;
		}
		return count;
	}
	
	
}
