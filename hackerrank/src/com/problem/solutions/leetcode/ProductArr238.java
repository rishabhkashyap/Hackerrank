package com.problem.solutions.leetcode;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductArr238 {
    public static void main(String[] args) {
       // int[] arr={1,2,3,4};
        int[] arr={-1,1,0,-3,3};
        int[] result=computeProduct1(arr);
        Arrays.stream(result).forEach(e->System.out.print(e+"\t"));
        result=productCompute2(arr);
        System.out.println();
        Arrays.stream(result).forEach(e->System.out.print(e+"\t"));
        result=productCompute3(arr);
        System.out.println();
        Arrays.stream(result).forEach(e->System.out.print(e+"\t"));
    }

    private static int[] computeProduct1(int[] arr) {
        int[]prefix=new int[arr.length];
        int[]suffix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=arr[i]*prefix[i-1];
        }
        suffix[suffix.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*arr[i];
        }
        int[]result=new int[arr.length];
        result[0]=suffix[1];
        result[result.length-1]=prefix[prefix.length-2];
        int index=1;
        while (index<arr.length-1){
            result[index]=prefix[index-1]*suffix[index+1];
            ++index;
        }
        return result;
    }

    //Use same approach as used in computeProduct1, instead of using 2 arrays to store prefix and suffix sum
    //use one array ie result array to store prefix product and a variable to store  post product result. This will save memory
    private static int[] productCompute2(int[] arr){
        int[] result = new int[arr.length];
        //calculate prefix sum
        result[0]=1;
        for(int i=1;i<arr.length;i++){
            result[i]=result[i-1]*arr[i-1];
        }
        //calculate postfix sum and update result array
        int postProd=1;
        for(int i= arr.length-2;i>=0;--i){
            postProd*=arr[i+1];
            result[i]=result[i]*postProd;
        }
        return result;
    }


    private static int[] productCompute3(int[] arr){
        int[] result = new int[arr.length];
        result[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            result[i]=result[i-1]*arr[i];
        }
        int postProd=1;
        for(int i= arr.length-1;i>0;--i){
            result[i]=result[i-1]*postProd;
            postProd*=arr[i];
        }
        result[0]=postProd;
        return result;
    }
}
