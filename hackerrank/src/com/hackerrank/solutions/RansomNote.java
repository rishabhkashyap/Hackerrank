package com.hackerrank.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RansomNote {

	public static void main(String[] args) throws IOException{
		boolean isThere=false;
		BufferedReader br =new  BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		String[]vals=line.split(" ");
		int m=Integer.parseInt(vals[0]);
		int n=Integer.parseInt(vals[1]);
		line=br.readLine();
		
		vals=line.split(" ");
		List<String> magazine=new ArrayList<>();
		for(String str:vals){
			magazine.add(str);			
		}
		line=br.readLine();
		vals=line.split(" ");
		for(String str:vals){
			if(magazine.contains(str)){
				isThere=true;
			}else{
				isThere=false;
				break;
			}
		}
		if(isThere){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		

	}

}
