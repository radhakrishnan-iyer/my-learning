package com.learning.extra;

import java.util.ArrayList;
import java.util.List;

public class PathSum4 {

    public static void main(String[] args) {
        System.out.println(pathSum(new int[]{113, 215, 221, 342}));
    }

    public static int pathSum(int[] nums) {
        TreeNode root = buildTree(nums);
        List<Integer> integerList = new ArrayList<>();
        helper(root, integerList, 0);
        int sum = 0;
        for(int i : integerList) {
            sum += i;
        }
        return sum;
    }

    static void helper(TreeNode root, List<Integer> list, int sum) {
        if(root==null)
            return;
        sum += root.val;
        if(root.left==null && root.right==null) {
            list.add(sum);
            return;
        }
        helper(root.left, list, sum);
        helper(root.right, list, sum);
    }

    static TreeNode buildTree(int[] nums) {
        TreeNode[][] mat = new TreeNode[6][33];
        TreeNode root = null;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            int x = num/100;
            num = num%100;
            int y = num/10;
            num = num%10;
            int z = num;
            TreeNode r = new TreeNode(z);
            if(i==0) {
                root = r;
                mat[x][y] = r;
            }
            else {
                if(y%2==0) {
                    //right
                    TreeNode parent = mat[x-1][y/2];
                    parent.right = r;
                }
                else {
                    TreeNode parent = mat[x-1][(y+1)/2];
                    parent.left = r;
                }
                mat[x][y] = r;
            }
        }
        return root;
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
