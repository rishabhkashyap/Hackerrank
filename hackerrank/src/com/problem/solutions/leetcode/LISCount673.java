package com.problem.solutions.leetcode;

public class LISCount673 {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 2 };
		System.out.println(countLIS(arr));
	}

	private static int countLIS(int[] arr) {
		int[] lis = new int[arr.length];
		int[] count = new int[arr.length];
		int maxLen = Integer.MIN_VALUE;
		int maxCount = Integer.MIN_VALUE;
//		Arrays.fill(lis, 1);
//		Arrays.fill(count, 1);
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					}
					else if (lis[j] + 1 == lis[i]) {
						count[i] += count[j];
					}
				}
			}
			if (maxLen == lis[i]) {
				maxCount += count[i];
			}
			if (maxLen < lis[i]) {
				maxLen = lis[i];
				maxCount = count[i];
			}
		}

		return maxCount;
	}
}
