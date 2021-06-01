package com.learning.extra;

import java.util.HashSet;
import java.util.Set;

public class MedianInUnsortedArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {10,12,4,6,9,3})); // 7.5
        System.out.println(solve(new int[] {10,12,4,6,9,3,2})); // 6
        System.out.println(solve(new int[] {1,10,5,7,8,6})); // 6.5
        System.out.println(solve(new int[] {1,3,6,8,10})); // 6
        System.out.println(solve(new int[] {1,3,6,8,10,12})); // 7
        System.out.println(solve(new int[] {1,2,3,4})); // 2.5
    }

    private static double solve(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            min = Math.min(min , num);
            max = Math.max(max , num);
            set.add(num);
        }
        int mid = 0;
        int count = 0;
        while (count!=n/2+1) {
            mid = min + (max-min)/2;
            for(int i=min;i<=mid && count != (n/2 +1);i++) {
                if(!set.contains(i))
                    continue;
                count++;
                if(x==Integer.MAX_VALUE && count==n/2) {
                    x = i;
                }
                else if(y==Integer.MAX_VALUE && count == n/2 +1) {
                    y = i;
                }
            }
            if(count == n/2 +1)
                break;
            min = mid + 1;
        }
        if(n%2==0)
            return (x+y)/2.0;
        return y;
    }
}
