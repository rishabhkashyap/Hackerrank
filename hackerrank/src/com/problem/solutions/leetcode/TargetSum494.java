package com.problem.solutions.leetcode;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/target-sum/description/

public class TargetSum494 {

	public static void main(String[] args) throws IOException {
		int[] arr = { 1, 1, 1, 1, 1 };
		int s = 3;
		System.out.println(countWays(arr, s));
		System.out.println(findWays(arr, s));
		System.out.println(countWays2(arr, s));
		System.out.println(countWays3(arr, s));
	}

	private static int countWays(int[] arr, int s) {
		int[][] dp = new int[1000][3000];
		initializeArray(dp);
		return countWaysHelper(arr, s, 0, 0, dp);

	}


	private static int countWaysHelper(int[] arr, int target, int sum, int index,
			int[][] dp) {
		if(index == arr.length && sum == target) {
			return 1;
		}
		if(index >= arr.length) {
			return 0;
		}
		if(dp[index][sum + 1000] != Integer.MAX_VALUE) {
			return dp[index][sum + 1000];
		}

		dp[index][sum + 1000] = countWaysHelper(arr, target, sum + arr[index], index + 1, dp)
				+ countWaysHelper(arr, target, sum - arr[index], index + 1, dp);

		return dp[index][sum + 1000];
	}


	private static void initializeArray(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private static int countWaysRecursive(int[] arr, int target, int sum, int index) {
		if(index == arr.length && sum == target) {
			return 1;
		}

		if(index >= arr.length) {
			return 0;
		}
		int positiveWays = countWaysRecursive(arr, target, sum + arr[index], index + 1);
		int negativeWays = countWaysRecursive(arr, target, sum - arr[index], index + 1);
		return positiveWays + negativeWays;
	}

	private static int findWays(int[] nums, int target) {
		Map<String, Integer> map = new HashMap<>();
		return findWays(nums, target, 0, 0, map);
	}

	private static int findWays(int[] nums, int target, int sum, int i, Map<String, Integer> map) {
		if(target == sum && i == nums.length) {
			return 1;
		}
		if(i >= nums.length) {
			return 0;
		}
		String key = "" + sum + "_" + i;
		if(map.containsKey(key)) {
			return map.get(key);
		}
		int result1 = findWays(nums, target, sum + nums[i], i + 1, map);
		int result2 = findWays(nums, target, sum - nums[i], i + 1, map);
		map.put(key, result1 + result2);
		return result1 + result2;
	}

	//Similar approach used in count partitions with given difference
	private static int countWays2(int[] arr, int target) {
		int sum = Arrays.stream(arr).sum();
		if(sum < Math.abs(target) || (sum + target) % 2 != 0) {
			return 0;
		}
		//sum(p1) - sum(p2)=diff(differnce of sum of 2 partitions of array)
		//sum(p1) + sum(p2)=sum(sum of all elements in array)
		//solving 2 equation will give following result
		//sum(p1)=(diff+sum)/2
		//Problem boils down to find count of subset whose sum is equal to sum(p1)
		int partitionSum = (sum + target) / 2;
		int[][] dp = new int[arr.length + 1][partitionSum + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j <= partitionSum; j++) {
				if(j == 0) {
					dp[i][j] = 1;
				}

				if(j < arr[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[arr.length][partitionSum];

	}

	//Recursive 0/1 knapsack
	private static int countWays3(int[] arr, int diff) {
		int sum = Arrays.stream(arr).sum();
		if(sum < Math.abs(diff) || (sum + diff) % 2 != 0) {
			return 0;
		}
		int[][] dp = new int[arr.length + 1][(diff + sum) / 2 + 1];
		for (int[] dpArr : dp) {
			Arrays.fill(dpArr, -1);
		}
		return countWays3(arr, (diff + sum) / 2, arr.length - 1, dp);

	}

	private static int countWays3(int[] arr, int sum, int i, int[][] dp) {
		//check till i==-1 because entire array has to be covered to get target sum
		//by performing add and sub operations
		if(i == -1 && sum == 0) {
			return 1;
		}
		if(i < 0 || sum < 0) {
			return 0;
		}
		if(dp[i][sum] != -1) {
			return dp[i][sum];
		}
		if(sum < arr[i]) {
			return countWays3(arr, sum, i - 1, dp);
		}
		dp[i][sum] = countWays3(arr, sum, i - 1, dp)
				+ countWays3(arr, sum - arr[i], i - 1, dp);
		return dp[i][sum];
	}
}
