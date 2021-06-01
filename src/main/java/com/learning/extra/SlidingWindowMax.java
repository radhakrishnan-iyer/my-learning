package com.learning.extra;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr = new int[] {2,1,5,2,4,1,6,-3,4,2};
        System.out.println(max(arr, 3));
    }

    private static int max(int[] arr, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (end<arr.length) {
            while (end - start + 1 <= k) {
                sum += arr[end];
                end++;
            }
            ans = Math.max(ans , sum);
            if(end-start+1 > k) {
                sum -= arr[start];
                start++;
            }
        }
        return ans;
    }
}
