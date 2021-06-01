package com.learning.extra;

public class SearchInSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new  int[] {3,1} , 3));
    }

    private static int search(int[] nums, int target) {
        if(nums == null || nums.length==0)
            return -1;
        int pivot = 0;
        int i = 0;
        for(i=1;i<nums.length; i++) {
            if(nums[i] >= nums[pivot]) {
                continue;
            } else {
                pivot = i;
                break;
            }
        }
        int start = 0;
        int end = nums.length-1;
        // 0 to pivot-1 && pivot to n-1
        if(target == nums[pivot])
            return pivot;
        if(target > nums[pivot]) {
            // pivot to n-1
            if(pivot==nums.length-1) {
                end = pivot-1;
            } else {
                start = pivot;
            }
        } else {
            // 0 to pivot-1
            end = pivot-1;
        }
        System.out.println(start + " : " + end + " : " + pivot);

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
