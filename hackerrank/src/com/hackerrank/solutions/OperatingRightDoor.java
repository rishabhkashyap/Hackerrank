package com.hackerrank.solutions;

public class OperatingRightDoor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makePalindrome("Ab3bd",0,4));

	}
	
	private static int makePalindrome(String str,int low,int high){
			if(low==high){
				return 0;
			}
			if(low>high){
				return -1;
			}
			if(low==high-1){
				return str.charAt(low)==str.charAt(high)?0:1;
			}
			if(str.charAt(low)==str.charAt(high)){
				return makePalindrome(str, low+1, high-1);
			}else{
				return Math.min(makePalindrome(str, low, high-1), makePalindrome(str, low+1, high))+1;
			}
	}
	
	private static boolean isPalindrome(String str){
		boolean isPalindrome=false;
		if(str!=null){
			StringBuilder sbr=new StringBuilder(str);
			String strRev=sbr.reverse().toString();
			if(sbr.equals(strRev)){
				isPalindrome=true;
			}
		}
		return isPalindrome;
	}
	
	

}
