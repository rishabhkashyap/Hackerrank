package com.hackerrank.solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TestClass {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] inputArr = line.split(" ");
		int n = Integer.parseInt(inputArr[0]);
		int q = Integer.parseInt(inputArr[1]);
		String str = br.readLine();
		for (int i = 0; i < q; i++) {
			int count = 0;
			line = br.readLine();
			inputArr = line.split(" ");
			int left = Integer.parseInt(inputArr[0]);
			int right = Integer.parseInt(inputArr[1]);
			String subStr = str.substring(left, right + 1);
			HashMap<Character, Integer> frequency = new HashMap<>();
			for (int k = 0; k < subStr.length(); k++) {
				if (frequency.containsKey(subStr.charAt(k))) {

					frequency.put(subStr.charAt(k), frequency.get(subStr.charAt(k)) + 1);

				} else {
					frequency.put(subStr.charAt(k), 1);
				}
			}
			Set<Entry<Character, Integer>> freqVals = frequency.entrySet();
			int min = Integer.MAX_VALUE;
			for (Map.Entry<Character, Integer> freq : freqVals) {
				if (freq.getValue() < min) {
					min = freq.getValue();
				}
			}
			for (Map.Entry<Character, Integer> freq : freqVals) {
				count = count + (freq.getValue() - min);
			}
			System.out.println(count);

		}

	}
}