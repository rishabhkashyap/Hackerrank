//Problem:https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

package com.problem.solutions.leetcode;

public class ZigZagPath {

    private static int result = 0;

    public static void main(String[] args) {

    }

    //bottom up approach
    private static int longestZigZagPath(TreeNode root, boolean moveLeft) {
        if (root == null) {
            return 0;
        }
        int leftResult = longestZigZagPath(root.left, false);
        int rightResult = longestZigZagPath(root.right, true);
        result = Math.max(result, Math.max(leftResult, rightResult));
        return (moveLeft ? leftResult : rightResult) + 1;

    }

    //top down approach
    private static void longestZigZagPath2(TreeNode root) {
        longestZigZagPath2(root, true, 0);
        longestZigZagPath2(root, false, 0);
    }

    private static void longestZigZagPath2(TreeNode root, boolean moveLeft, int count) {
        if (root == null) {
            return;
        }
        result = Math.max(result, count);
        if (moveLeft) {
            //move right and increment count
            longestZigZagPath2(root.left, false, count + 1);

            //use right node as starting point and move left
            longestZigZagPath2(root.right, true, 1);
        } else {
            //move left and increment count
            longestZigZagPath2(root.right, true, count + 1);

            //use left node as starting point and move right
            longestZigZagPath2(root.left, false, 1);
        }

    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
