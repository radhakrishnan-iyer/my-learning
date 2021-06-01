package com.learning.extra;

import java.util.Stack;

public class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack;
    BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        stack.push(this.root);
    }

    int next() {
        while(!stack.isEmpty()) {
            TreeNode top = stack.peek();
            while(top.left!=null && !top.left.visited) {
                stack.push(top.left);
                top = top.left; // moving left most
            }
            if(stack.peek()!=null)
                break;
        }
        // if left is blank - reached the next node
        TreeNode result = stack.pop();
        result.visited = true;
        if(result.right!=null)
            stack.push(result.right);
        return result.val;
    }

    boolean hasNext() {
        return stack.size()>0;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator iter = new BSTIterator(root);
        System.out.println(iter.next()); // 3
        System.out.println(iter.next()); // 7
        System.out.println(iter.hasNext()); // true
        System.out.println(iter.next()); //9
        System.out.println(iter.hasNext());//true
        System.out.println(iter.next()); //15
        System.out.println(iter.hasNext()); // true
        System.out.println(iter.next()); //20
        System.out.println(iter.hasNext()); //false
    }
}

 class TreeNode {
    TreeNode(int val) {
        this.val =  val;
    }
    TreeNode(int val , TreeNode left , TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    int val;
    TreeNode left;
    TreeNode right;
    boolean visited;
}
