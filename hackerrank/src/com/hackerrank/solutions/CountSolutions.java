package com.hackerrank.solutions;

import java.util.Scanner;

public class CountSolutions {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			int result = countSolutions(a, b, c, d);
			System.out.println(result);
		}
	}

	static int countSolutions(int a, int b, int c, int d) {
		int solution = 0;
		for (int x = 1; x <= c; x++) {
			int f = 1;
			int g = b;
			int h =  x*x- a;
			double temp1 = Math.sqrt(g * g - 4 * f * h);
			double root1 = (-g + temp1);
			double root2 = (-g - temp1);
			
				root1 /= 2;
				if(root1>=1 && root1<=d){
					++solution;
				}
				
			
			if (temp1 != 0) {
				root2 /= 2;
				if(root2>=1 && root2<=d){
					++solution;
				}

			}

		}
		return solution;

	}

}
