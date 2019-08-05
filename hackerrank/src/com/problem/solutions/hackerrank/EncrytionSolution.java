package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncrytionSolution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		string = string.replaceAll(" ", "");
		System.out.println(string);
		System.out.println();
		int column = (int) Math.ceil(Math.sqrt(string.length()));
		int row = getRow(column, string.length());
		StringBuilder str = new StringBuilder(string);
		char[][] arr = getEncryptedText(row, column, str);
		displayEncryptedMsg(arr,row,column);

		
	}


	private static int getRow(int column, int length) {

		int maxRow = (int) Math.floor(Math.sqrt(length));
		int row = 0;
		while ((row * column <= length) && (row <= maxRow) && (row <= column)) {
			++row;
		}
		return row;

	}

	private static char[][] getEncryptedText(int row, int column, StringBuilder str) {
		int i=0;
		int begin=0;
		int end=column;
		char[][]arrEncrypted=new char[row][column];		
		char[]tempCharArr=new char[column];
		while(i<row){
			
			str.getChars(begin, end, arrEncrypted[i], 0);
			begin=end;
			end=end+column;
			if(end>str.length()){
				end=str.length();
			}			
			++i;
		}
		return arrEncrypted;
	}
	

	private static void displayEncryptedMsg(char[][] arr, int row, int column) {
		for(int i=0;i<column;i++ ){
			for(int j=0;j<row;j++){
				System.out.print(arr[j][i]);
			}
			System.out.print("");
		}
		
	}

}
