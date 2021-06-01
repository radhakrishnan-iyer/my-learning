package com.learning.extra;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public static void main(String[] args) {

    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalUtil(root , result);
        return  result;
    }

    private static void postorderTraversalUtil(TreeNode root , List<Integer> result) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            result.add(root.val);
            return;
        }
        postorderTraversalUtil(root.left , result);
        postorderTraversalUtil(root.right , result);
        result.add(root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
