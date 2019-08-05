package com.problem.solutions.coding.blocks;

public class BSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 10;
        int loc = search(arr, key, 0, arr.length - 1);
        if (loc >= 0) {
            System.out.println("Location of element = " + loc);
        } else {
            System.out.println("Element not found");
        }


    }

    private static int search(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return search(arr, key, low, mid - 1);
            } else if (key > arr[mid]) {
                return search(arr, key, mid + 1, high);
            } else {
                return -1;
            }
        }
        return -1;
    }
}
