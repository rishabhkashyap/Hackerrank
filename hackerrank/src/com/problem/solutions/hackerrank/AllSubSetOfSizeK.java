package com.problem.solutions.hackerrank;

public class AllSubSetOfSizeK {
	private static long count=0;
	public static void  subset(int[] A, int k, int start, int currLen, boolean[] used) {

		if (currLen == k) {
			++count;
			//System.out.println();
			return;
		}
		if (start == A.length) {
			//++count;
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subset(A, k, start + 1, currLen + 1, used);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subset(A, k, start + 1, currLen, used);
		//++count;
	}

	public static void main(String[] args) {
		int A[] = { 2,1,1,2 };
		boolean[] B = new boolean[A.length];
		
		subset(A, 4, 0, 0, B);
		System.out.println(count);

	}


}
