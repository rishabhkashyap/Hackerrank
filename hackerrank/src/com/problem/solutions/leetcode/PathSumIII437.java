package com.problem.solutions.leetcode;

import java.util.HashSet;
import java.util.Set;

//Problem: https://leetcode.com/problems/path-sum-iii/

public class PathSumIII437 {

    private static int targetSum;

    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3_ = new TreeNode(-3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode2_ = new TreeNode(-2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode10.left = treeNode5;
        treeNode10.right = treeNode3_;
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode2;
        treeNode2.right = treeNode1;
        treeNode3.left = new TreeNode(3);
        treeNode3.right = treeNode2_;
        treeNode3_.right = treeNode11;
        System.out.println(pathSumHelper(treeNode10, 8));
        System.out.println(countPathSum2(treeNode10, 8));


    }

    private static int pathSumHelper(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int result = countPathSum(root, target);
        result += pathSumHelper(root.left, target);
        result += pathSumHelper(root.right, target);
        return result;
    }

    private static int countPathSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        int left = countPathSum(root.left, target - root.val);
        int right = countPathSum(root.right, target - root.val);
        if (target == root.val) {
            return left + right + 1;
        }
        return left + right;
    }


    private static int countPathSum2(TreeNode root, int target) {
        targetSum = target;
        Set<TreeNode> set = new HashSet<>();
        return countPathSum2(root, target, set, false);
    }

    private static int countPathSum2(TreeNode root, int target, Set<TreeNode> set, boolean hasParent) {
        if (root == null) {
            return 0;
        }
        //Check if node is already considered has starting node to find sum
        if (target == targetSum && set.contains(root) && !hasParent) {
            return 0;
        }
        //if node is a starting point add it to set
        if (target == targetSum && !hasParent) {
            set.add(root);
        }
        int count = target == root.val ? 1 : 0;
        count += countPathSum2(root.left, target - root.val, set, true);
        count += countPathSum2(root.right, target - root.val, set, true);
        count += countPathSum2(root.left, targetSum, set, false);
        count += countPathSum2(root.right, targetSum, set, false);
        return count;

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
