package com.learning.extra;

import java.util.TreeMap;

public class SubarrayProduct {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6},100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer,Integer> countMap = new TreeMap<>();
        countMap.put(k,1);
        int product = 1;
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            product = product * nums[i];
            Integer curr = countMap.floorEntry(product).getValue();
            ans += curr == null ? 0 : curr;
            countMap.put(product , countMap.getOrDefault(product,0) + 1);
        }
        return ans;
    }
}
