package com.problem.solutions.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/find-k-closest-elements/

public class KClosestElement658 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> result = findKClosestElement(arr, x, k);
        result.stream().forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        result = findKClosestElement2(arr, x, k);
        result.stream().forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> findKClosestElement(int[] arr, int x, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (high - low >= k) {
            if ((Math.abs(x - arr[low]) > Math.abs(x - arr[high])) || (Math.abs(x - arr[low]) == Math.abs(x - arr[high]) && arr[low] > arr[high])) {
                ++low;
            } else {
                --high;
            }
        }
        List<Integer> result = new ArrayList<>();
        Arrays.stream(arr, low, high + 1)
                .forEach(e -> result.add(e));
        return result;

    }

    //Using max heap
    private static List<Integer> findKClosestElement2(int[] arr, int x, int k) {
        List<Pair> pairs = Arrays.stream(arr)
                .mapToObj(e -> new Pair(e, Math.abs(x - e)))
                .collect(Collectors.toList());

        Queue<Pair> maxHeap = new PriorityQueue<>((e1, e2) -> e2.difference - e1.difference);
        for (Pair pair : pairs) {
            if (maxHeap.size() < k) {
                maxHeap.add(pair);
            } else {
                if (maxHeap.peek().difference > pair.difference ||
                        (maxHeap.peek().difference == pair.difference && maxHeap.peek().element > pair.element)) {
                    maxHeap.remove();
                    maxHeap.add(pair);
                }
            }
        }
        return maxHeap.stream()
                .map(e -> e.element)
                .sorted()
                .collect(Collectors.toList());


    }

    private record Pair(int element, int difference) {}
}
