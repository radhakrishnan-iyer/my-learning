package com.learning.extra;

public class MinimumSumContiguousArrayKadane {
    public static void main(String[] args) {
        calculate(new int[] {3, -4, 2, -3, -1, 7, -5});
    }

    private static void calculate(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++) {
            sum = Math.min(nums[i] , sum + nums[i]);
            min = Math.min(min , sum);
        }
        System.out.println(min);
    }
}
