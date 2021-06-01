package com.learning.extra;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1 , 1 , -1 , -1 , 3} , -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            int a = nums[i];
            int start = i+1;
            int end = nums.length-1;
            System.out.println("I : " + i + " Start : " + start + " ; End : " + end);
            while(start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a+b+c;
                System.out.println("a:"+a + "; b:"+b +"; c:"+c +" ; sum:"+sum);
                if(Math.abs(target-sum) > min) {
                    end--;
                } else {
                    min = Math.min(min , Math.abs(target-sum));
                    ans = sum;
                    start++;
                }
            }
        }
        return ans;
    }
}
