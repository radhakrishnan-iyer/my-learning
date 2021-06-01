package com.learning.extra;

public class SubArraySum {
    public static void main(String[] args) {
        int [] arr = new int[] {-1 , -1, 1};
        int k  =0;
        System.out.println(subarraySum(arr , k));
    }

    private static int subarraySum(int[] arr, int k) {
        int start = 0;
        int end = 0;
        int n = arr.length;
        int sum = Integer.MIN_VALUE;
        int count = 0;
        while(end < n) {
            while(end < n && sum < k) {
                if(sum==Integer.MIN_VALUE)
                    sum = 0;
                sum += arr[end++];
                System.out.println("End : " + end + " ; sum : " + sum);
            }
            while(sum>=k && start < n) {
                if(sum==k)
                    count++;
                sum -= arr[start++];
            }

            System.out.println(start+" : " + end + " : " + count +" : " + sum);
        }
        while(start < n && sum>=k) {
            if(sum==k)
                count++;
            sum -= arr[start++];
        }
        return count;
    }
}
