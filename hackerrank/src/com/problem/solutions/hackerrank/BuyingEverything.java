
//Link to problem https://www.hackerrank.com/contests/codeagon/challenges/buying-everything
package com.problem.solutions.hackerrank;

import java.util.Scanner;

public class BuyingEverything {
	private static int shopCount=0;
	
    public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		long k=scan.nextInt();
		int[]buildings=new int[n];
		for(int i=0;i<buildings.length;i++){
			buildings[i]=scan.nextInt();			
		}
		if(m<=n){
			System.out.println(getTime(m, k, buildings));
		}else{
			System.out.println(-1);
		}
		
		
		
		
	}
	
	private static long getTime(int m,long k,int[]buildings){
		int[] shops=getListOfDesiredShop(buildings);
		long timeMin=0;
		long time=0;
		
		for(int i=0;i<m;i++){
			if(i==0){
				time+=shops[i];
			
			}else{
				
					time+=(shops[i]-shops[i-1])*k*i;
					
				
			}
		}
		timeMin=time;
		for(int i=m;i<shopCount;i++){
			long diff=(long)(shops[i-1]-shops[i-m])*k;
			long leftIncrement=shops[i-m+1]-shops[i-m];
			long rightIncrement=(long)(shops[i]-shops[i-1])*k*(m-1);
			time=(time+rightIncrement+leftIncrement)-diff;
			timeMin=Math.min(time, timeMin);
		}
		
		
		return timeMin;
		
	}
	private static int[] getListOfDesiredShop(int []buildings){
		int [] shops=new int[buildings.length];
		
		int j=0;
		for(int i=0;i<buildings.length;i++){
			if(buildings[i]==1){
				shops[j++]=i;
				++shopCount;
				
			}
			
		}
		return shops;
	}
}
