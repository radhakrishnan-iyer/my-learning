package com.learning.extra;

public class ContainsDup {

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647}  ,1 , 2147483647 ));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++) {
            int j = i+1;
            while(j<=nums.length-1 && (j-i) <= k) {
                if(Math.abs(nums[i]- nums[j]) <= t) {
                    System.out.println(i+ " : " + j + " : " + nums[i] + " : " + nums[j] + " : " + Math.abs(nums[i]- nums[j]));
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
