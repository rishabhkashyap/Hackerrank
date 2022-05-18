//Problem: https://leetcode.com/problems/partition-equal-subset-sum/description/
package com.problem.solutions.leetcode;

import java.io.IOException;
import java.util.Arrays;


public class EqualSubset416 {
	public static void main(String[] args) throws IOException {
		int[] arr = { 1, 5, 11, 5 };
		System.out.println(isEqualSubsetAvailable1(arr));
		System.out.println(isEqualSubsetAvailable2(arr));
		System.out.println(isEqualSubsetAvailable3(arr));
	}

	private static boolean isEqualSubsetAvailable1(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(sum % 2 == 1) {
			return false;
		}
		int[][] dp = new int[nums.length + 1][sum / 2 + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		return isEqualSubsetAvailable1(nums, 0, 0, sum / 2, dp);
	}

	private static boolean isEqualSubsetAvailable1(int[] arr, int i, int curSum, int sum,
			int[][] dp) {
		if(i >= arr.length) {
			return false;
		}
		if(curSum > sum) {
			return false;
		}
		if(curSum == sum) {
			return true;
		}
		if(dp[i][curSum] != -1) {
			return dp[i][curSum] == 1 ? true : false;
		}
		boolean result1 = isEqualSubsetAvailable1(arr, i + 1, curSum + arr[i], sum, dp);
		boolean result2 = isEqualSubsetAvailable1(arr, i + 1, curSum, sum, dp);
		boolean result = result1 || result2;
		dp[i][curSum] = result == true ? 1 : 2;
		return result;
	}


	private static boolean isEqualSubsetAvailable2(int[] arr) {
		int sum = Arrays.stream(arr).sum();
		if(sum % 2 == 1) {
			return false;
		}
		return isEqualSubsetAvailable2(arr, sum / 2);
	}

	private static boolean isEqualSubsetAvailable2(int[] arr, int target) {
		boolean[][] dp = new boolean[arr.length + 1][target + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], false);
		}
		for (int i = 1; i <= arr.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= target; ++i) {
			dp[0][i] = false;
		}
		for (int i = 1; i <= arr.length; i++) {
			for (int w = 1; w <= target; ++w) {
				if(w >= arr[i - 1]) {
					dp[i][w] = (dp[i - 1][w] || dp[i - 1][w - arr[i - 1]]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		return dp[arr.length][target];
	}

	private static boolean isEqualSubsetAvailable3(int[] arr) {
		int sum = Arrays.stream(arr).sum();
		if(sum % 2 == 1) {
			return false;
		}
		sum = sum / 2;
		boolean[][] dp = new boolean[arr.length + 1][sum + 1];
		for (int i = 0; i <= arr.length; i++) {
			for (int j = 0; j <= sum; j++) {
				if(i == 0 & j > 0) {
					dp[i][j] = false;
				} else if(j == 0) {
					dp[i][j] = true;
				} else {
					if(j < arr[i - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j]
								|| dp[i - 1][j - arr[i - 1]];
					}
				}
			}
		}
		return dp[arr.length][sum];
	}
}
