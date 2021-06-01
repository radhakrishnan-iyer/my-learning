package com.learning.extra;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int size = nums.length;
        int count = 0;

        int start = 0;
        int end = 0;
        int product = 1;
        for(start = 0 ; start < nums.length ; start++) {
            product *= nums[start];
            while(end <= start && product >= k) {
                product /= nums[end];
                end++;
            }
            count += start - end +1;
        }
        return count;
    }
}
