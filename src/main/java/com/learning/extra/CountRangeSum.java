package com.learning.extra;

import java.util.*;
public class CountRangeSum {

    static TreeNode root;

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{0,-3,-3,1,1,2} , 3 , 5));
    }

    static public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length==0)
            return 0;
        root = build(nums,0,nums.length-1);
        return traverseTree(root,lower, upper);
    }

    static int traverseTree(TreeNode root, int lower, int upper) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode temp = q.poll();
                if(temp.sum>=lower && temp.sum<=upper)
                    ans++;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
        return ans;
    }

    static TreeNode build(int[] nums, int start, int end) {
        if(start > end)
            return null;
        TreeNode r = new TreeNode(start,end);

        if(start==end) {
            r.sum = nums[start];
            return r;
        }

        int mid = start + (end - start)/2;
        r.left = build(nums,start,mid);
        r.right = build(nums,mid+1,end);
        r.sum = (r.left!=null ? r.left.sum : 0) + (r.right!=null ? r.right.sum : 0);
        return r;
    }

    static class TreeNode {
        TreeNode left,right;
        int start,end;
        int sum;
        TreeNode(int start,int end) {
            this.start=start;
            this.end = end;
        }
    }
}
