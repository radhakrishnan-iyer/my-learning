package com.learning.extra;

import java.util.HashMap;
import java.util.Map;

public class FindIfElementIsSearchable {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //boolean[] arr = solve2(new int[] {1,3,2});
        boolean[] arr = solve2(new int[] {4,3,1,5,7,6,10});
        for(int i=0;i<arr.length;i++) {
            System.out.println("arr["+i+"] : " + arr[i]);
        }
    }

    private static boolean[] solve2(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        leftMax[0] = Integer.MIN_VALUE;
        rightMin[arr.length-1] = Integer.MAX_VALUE;
        boolean[] result = new boolean[arr.length];
        for(int i=1;i<arr.length;i++)
            leftMax[i] = Math.max(leftMax[i-1] , arr[i-1]);
        for(int i=arr.length-2;i>=0;i--)
            rightMin[i] = Math.min(rightMin[i+1] , arr[i+1]);
        for(int i=0;i<arr.length;i++)
            result[i] = arr[i] >= leftMax[i] && arr[i] <= rightMin[i];
        return result;
    }

    static Map<Integer,Integer> position = new HashMap<>();
    private static boolean[] solve(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        boolean[] result = new boolean[arr.length];
        for(int i=0;i<arr.length;i++)
            position.put(arr[i] , i);
        while(left<=right) {
           updateMinMax(arr,left,right);
            if(position.get(min)==left) {
                result[left]  = true;
            }
            if(position.get(max)==right) {
                result[right] = true;
            }
            left = position.get(min)+1;
            right = position.get(max)-1;
        }
        return result;
    }

    private static void updateMinMax(int[] arr, int left, int right) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=left;i<=right;i++) {
            min = Math.min(min , arr[i]);
            max = Math.max(max , arr[i]);
        }
    }
}
