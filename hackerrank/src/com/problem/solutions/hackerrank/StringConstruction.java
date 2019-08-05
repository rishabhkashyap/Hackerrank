package com.problem.solutions.hackerrank;

import java.util.Scanner;

public class StringConstruction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = stringConstruction(s);
			System.out.println(result);
		}
	}

	private static int stringConstruction(String s) {
		int cost = 0;
		int pos = 0;
		StringBuilder str = new StringBuilder(s);
		StringBuilder copy = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			if (copy.length() == 0) {
				copy.append(s.charAt(i));
				++cost;
			} else {
				pos = containsChar(copy, str.charAt(i));
				if (pos < 0) {
					copy.append(str.charAt(i));
					++cost;
				} else {
					copy.append(copy.charAt(pos));
				}
			}

		}
		return cost;

	}

	private static int containsChar(StringBuilder str, char ch) {
		int pos = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				pos = i;
				break;
			}
		}
		return pos;
	}

}
