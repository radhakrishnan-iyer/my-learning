package com.learning.extra;

import java.util.Comparator;
import java.util.TreeSet;

public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(solve2(new int[]{-5,-4,-3,-2,-1})); //-6
        System.out.println(solve2(new int[]{1,2,3,4,5})); //60
        System.out.println(solve2(new int[]{-5,-1,3,6,8})); // 144
        System.out.println(solve2(new int[]{-5,-3,-1,6,8})); // 120
        System.out.println(solve2(new int[]{100, 1, 2, 7, 8, 5 , 4})); // 112
    }

    //O(n)
    private static int solve2(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] leftMin = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMin[0] = Integer.MAX_VALUE;
        leftMax[0] = Integer.MIN_VALUE;
        rightMax[arr.length-1] = Integer.MIN_VALUE;

        for(int i=1;i<arr.length;i++) {
            int maxSoFar = Math.max(leftMax[i-1] , arr[i-1]);
            if(maxSoFar<arr[i]) {
                leftMax[i] = maxSoFar;
            } else {
                leftMax[i] = leftMax[i-1];
            }

            int minSoFar = Math.min(leftMin[i-1] , arr[i-1]);
            if(minSoFar < arr[i]) {
                leftMin[i] = minSoFar;
            } else {
                leftMin[i] = leftMin[i-1];
            }
        }

        for(int i=arr.length-2;i>=0;i--) {
            int maxSoFar = Math.max(rightMax[i+1] , arr[i+1]);
            if(maxSoFar>arr[i]) {
                rightMax[i] = maxSoFar;
            } else {
                rightMax[i] = rightMax[i+1];
            }
        }

        int product = Integer.MIN_VALUE;

        if(isAllNegative(arr) || isAllPositive(arr)) {
            for(int i=1;i<arr.length-1;i++) {
                product = Math.max(product , leftMax[i] * arr[i] * rightMax[i]);
            }
        }
        else {
            for(int i=1;i<arr.length-1;i++) {
                if(arr[i]<0) {
                    product = Math.max(product, leftMin[i] * arr[i] * rightMax[i]);
                }
                else {
                    product = Math.max(product, leftMax[i] * arr[i] * rightMax[i]);
                }
            }
        }
        return product;
    }

    //O(nlogn)
    private static int solve(int [] arr) {
        TreeSet<Integer> leftSet = new TreeSet<>();
        leftSet.add(arr[0]);

        TreeSet<Integer> righttSet = new TreeSet<>(Comparator.reverseOrder());
        for(int i=1;i<arr.length;i++) {
            righttSet.add(arr[i]);
        }

        int product = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length-1; i++) {
            int left = leftSet.floor(arr[i])==null ? 0 : leftSet.floor(arr[i]);
            leftSet.add(arr[i]);
            righttSet.remove(arr[i]);
            int right = righttSet.first();
            if(right > arr[i]) {
                product = Math.max(product, arr[i] * left * right);
            }
        }
        return product;
    }

    private static boolean isAllPositive(int[] arr) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]<0)
                return false;
        return true;
    }

    private static boolean isAllNegative(int[] arr) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]>=0)
                return false;
        return true;
    }
}
