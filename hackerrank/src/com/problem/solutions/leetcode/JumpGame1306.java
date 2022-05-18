package com.problem.solutions.leetcode;

public class JumpGame1306 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
//        int[] arr = {3, 0, 2, 1, 2};
//        int start = 2;
        System.out.println(canReach(arr, start));
    }

    private static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReach(arr, start, visited);

    }

    private static boolean canReach(int[] arr, int start, boolean[] visited) {
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        boolean reach = false;
        if (start + arr[start] < arr.length && !visited[start + arr[start]]) {
            reach = canReach(arr, start + arr[start],visited);
        }
        if (start - arr[start] >=0 && !visited[start - arr[start]]) {
            reach = reach || canReach(arr, start - arr[start],visited);
        }
        return reach;

    }
}
