package com.problem.solutions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivSet368 {
	public static void main(String[] args) {
		int[] arr = { 4, 8, 10, 240 };
		System.out.println(findLargestSubset(arr));
		System.out.println(findLargestSubset2(arr));
	}

	private static List<Integer> findLargestSubset(int[] arr) {
		if (arr.length == 1) {
			return Arrays.asList(arr[0]);
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] subSeq = new int[arr.length];
		int maxLen = Integer.MIN_VALUE;
		int maxIndex = -1;
		Arrays.sort(arr);
		Arrays.fill(subSeq, 1);
		map.put(0, Arrays.asList(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0 && subSeq[i] < subSeq[j] + 1) {
					subSeq[i] = subSeq[j] + 1;
					list.clear();
					list.addAll(map.get(j));

				}
			}
			list.add(arr[i]);
			map.put(i, list);
			if (maxLen < subSeq[i]) {
				maxLen = subSeq[i];
				maxIndex = i;
			}
		}
		return map.get(maxIndex);
	}

	//without using map
	private static List<Integer> findLargestSubset2(int[] arr) {
		if (arr.length == 1) {
			return Arrays.asList(arr[0]);
		}
		int[] subSeq = new int[arr.length];
		int maxLen = Integer.MIN_VALUE;
		int maxIndex = -1;
		int[] prev = new int[arr.length];
		Arrays.sort(arr);
		Arrays.fill(subSeq, 1);
		prev[0]=-1;
		for (int i = 1; i < arr.length; i++) {
			prev[i] = -1;
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0 && subSeq[i] < subSeq[j] + 1) {
					subSeq[i] = subSeq[j] + 1;
					prev[i] = j;

				}
			}
			if (maxLen < subSeq[i]) {
				maxLen = subSeq[i];
				maxIndex = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		while (maxIndex != -1) {
			result.add(arr[maxIndex]);
			maxIndex = prev[maxIndex];
		}
		return result;
	}
}
