package com.learning.extra;

public class RemoveElementsOutsideRange {
    public static void main(String[] args) {

    }

    TreeNode solve(TreeNode root, int min, int max) {
        if(root==null)
        return null;
        root.left = solve(root.left,min,max);
        root.right = solve(root.right,min,max);
        if(root.val < min)
        {
            TreeNode rchild = root.right;
            root = null;
            return rchild;
        }
        if(root.val > max) {
            TreeNode lchild = root.left;
            root = null;
            return lchild;
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left , TreeNode right) {
            this.val=val;
            this.left=left;
            this.right=right;
        }
        TreeNode(int val) {
            this.val = val;
        }
    }
}
