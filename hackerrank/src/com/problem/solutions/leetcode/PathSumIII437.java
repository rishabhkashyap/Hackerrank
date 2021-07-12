package com.problem.solutions.leetcode;

public class PathSumIII437 {
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
        treeNode2.right=treeNode1;
        treeNode3.left = new TreeNode(3);
        treeNode3.right = treeNode2_;
        treeNode3_.right = treeNode11;
        System.out.println(pathSumHelper(treeNode10, 8));


    }

    private static int pathSumHelper(TreeNode root, int target) {
        if(root==null){
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
