package com.hackerrank.solutions;

import java.util.Locale.LanguageRange;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionRunningMedain {

	public static void main(String[] args) {
		PriorityQueue<Integer> lowVals = new PriorityQueue<>();
		PriorityQueue<Integer> highVals = new PriorityQueue<>((Integer i1, Integer i2) -> i2 - i1);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
			
		}
		for(int i=0;i<a.length;i++){
			addVal(a[i],lowVals,highVals);
			rebalance(lowVals,highVals);
			double medain=getMedain(lowVals,highVals);
			System.out.println(medain);
		}

	}

	private static double getMedain(PriorityQueue<Integer> lowVals, PriorityQueue<Integer> highVals) {
		PriorityQueue<Integer>biggerHeap=lowVals.size()>highVals.size()?lowVals:highVals;
		PriorityQueue<Integer>smallerHeap=lowVals.size()<highVals.size()?lowVals:highVals;
		if(smallerHeap.size()==biggerHeap.size()){
			return ((double)biggerHeap.peek()+smallerHeap.peek())/2;
		}else{
			return biggerHeap.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lowVals, PriorityQueue<Integer> highVals) {
		PriorityQueue<Integer>biggerHeap=lowVals.size()>highVals.size()?lowVals:highVals;
		PriorityQueue<Integer>smallerHeap=lowVals.size()<highVals.size()?lowVals:highVals;
		if(biggerHeap.size()-smallerHeap.size()>=2){
			smallerHeap.offer(biggerHeap.poll());
		}
		
		
	}

	private static void addVal(int number, PriorityQueue<Integer> lowVals, PriorityQueue<Integer> highVals) {
		if(lowVals.size()==0||lowVals.peek()>number){
			lowVals.offer(number);
		}else{
			highVals.offer(number);
		}
		
	}

}
