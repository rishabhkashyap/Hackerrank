package com.hackerrank.solutions;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String compressedString = getCompressedString(str);
		System.out.println(compressedString);

	}

	private static String getCompressedString(String str) {
		StringBuilder compressedString=new StringBuilder("");
		int count=0;
		for(int i=0;i<str.length();i++){
			count++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString.append(count)
								.append(str.charAt(i));
				count=0;
			}
		
	}
		return compressedString.toString();

}
}
