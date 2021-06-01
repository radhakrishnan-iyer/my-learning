package com.learning.extra;

public class HasPathSum {
    static int a = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        System.out.println(hasPathSum(treeNode , 1));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;

        a += root.val;

        if(root.left==null && root.right==null) {
            if(a==sum) {
                return true;
            } else {
                a -= root.val;
                return false;
            }
        }

        return hasPathSum(root.left , sum) || hasPathSum(root.right , sum);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
