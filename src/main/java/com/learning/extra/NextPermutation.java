package com.learning.extra;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1};
        nextPermutation(arr);
        for (int i = 0 ;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        if(i>=0) {
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums,i+1);
    }

    static void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void  reverse(int[] nums, int start) {
        int end = nums.length-1;
        while(start < end) {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
