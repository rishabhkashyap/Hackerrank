package com.problem.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeSolution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCases; i++) {
			String str = br.readLine();
			if (isPalindrome(str)) {
				System.out.println("-1");
			} else {
				int k = str.length() - 1;
				for (int j = 0; j < str.length(); j++) {

					if(j==0){
						if (isPalindrome(str.substring(j+1))) {
							System.out.println(j);
							break;
						}
					}else{
						String check=str.substring(0,j-1)+str.substring(j+1,str.length()-1);
						if (isPalindrome(check)) {
							System.out.println(j);
							break;
						}
					}

				}
			}

		}

	}

	private static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		return str.equals(sb.reverse().toString());
	}

}
