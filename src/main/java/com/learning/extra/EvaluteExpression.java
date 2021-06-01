package com.learning.extra;

public class EvaluteExpression {
    public static void main(String args[]) {
        //(5+8)*(9-3)
        TreeNode root = new TreeNode("*");
        root.left = new TreeNode("+");
        root.right = new TreeNode("-");
        root.left.left = new TreeNode("5");
        root.left.right = new TreeNode("8");
        root.right.left = new TreeNode("9");
        root.right.right = new TreeNode("3");

        System.out.println(eval(root));

        //5+(8*9)-3
        root = new TreeNode("+");
        root.left = new TreeNode("5");
        root.right = new TreeNode("-");
        root.right.left = new TreeNode("*");
        root.right.left.left = new TreeNode("8");
        root.right.left.right = new TreeNode("9");
        root.right.right = new TreeNode("3");
        System.out.println(eval(root));

    }

    private static double eval(TreeNode root) {
        if(root.left==null && root.right==null)
            return Double.valueOf(root.val);
        double left = eval(root.left);
        double right = eval(root.right);
        char c = root.val.toCharArray()[0];

        switch (c) {
            case '+' : return left+right;
            case '-' : return left-right;
            case '*' : return left*right;
            case '/' : return left/right;
        }
        return Double.valueOf(root.val);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        String val;
        TreeNode(String val) {
            this.val = val;
        }
    }
}
