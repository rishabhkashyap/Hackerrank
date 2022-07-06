package com.problem.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//TLE exceeded
public class Billboard956 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(findMaxBillboardHeight(arr));

    }

    private static int findMaxBillboardHeight(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        return findMaxBillboardHeight(arr, 0, 0, 0, map);
    }

    private static int findMaxBillboardHeight(int[] arr, int i, int height1, int height2,
                                              Map<String, Integer> map) {
        if (i >= arr.length) {
            if (height1 == height2) {
                return height1;
            } else {
                return -1;
            }
        }
        String key = "" + i + "_" + height1 + "_" + height2;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int op1 = findMaxBillboardHeight(arr, i + 1, height1 + arr[i],
                height2, map);
        int op2 = findMaxBillboardHeight(arr, i + 1, height1,
                height2 + arr[i], map);
        int op3 = findMaxBillboardHeight(arr, i + 1, height1,
                height2, map);
        map.put(key, Math.max(Math.max(op1, op2), op3));
        return map.get(key);
    }


}
