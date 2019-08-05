package com.problem.solutions.hackerrank;

public class BinarySearchFirstOccurence {

	public static void main(String[] args) {
		int[]arr={0,0,0,0,0,0,0,0,0,1};
		System.out.println("Length  = "+arr.length );
		System.out.println("Pos = "+binSearchFirstOccurence(arr, 0, arr.length-1, 1));
		

	}
	
	private static int binSearchFirstOccurence(int[]arr,int low,int high,int data){
		
		if(low<=high){
			int mid=low+(high-low)/2;
			if((low==mid && arr[mid]==data)||(arr[mid]== data && arr[mid-1]<arr[mid])){
				return mid;
			}
			if(data<=arr[mid]){
				return binSearchFirstOccurence(arr, low, mid-1, data);
			}else{
				return binSearchFirstOccurence(arr, mid+1, high, data);
			}
		}
		return -1;
	}
	


}
