package com.learning.extra;

public class SlidingWindowMaxFindK {
    public static void main(String[] args) {
        int[] arr = new int[] {2,1,5,2,4,0,6,-3,4,11};
        System.out.println(max(arr, 10));
    }

    private static int max(int[] arr, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (end<arr.length || start<arr.length) {
            while (end < arr.length && sum<target) {
                sum += arr[end];
                end++;
            }
            if(sum==target) {
                ans = Math.max(ans, end - start);
            }
            sum -= arr[start];
            start++;
            /*if(sum >= target) {
                sum -= arr[start];
                start++;
            }*/
        }
        return ans;
    }
}
