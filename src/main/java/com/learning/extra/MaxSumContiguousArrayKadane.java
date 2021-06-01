package com.learning.extra;

public class MaxSumContiguousArrayKadane {
    public static void main(String[] args) {
        calculate(new int[] {-2, -3, 4, -1, -2, 1, 5, -3});
    }

    private static void calculate(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
            sum = Math.max(nums[i] , sum + nums[i]);
            max = Math.max(max , sum);
        }
        System.out.println(max);
    }
}
