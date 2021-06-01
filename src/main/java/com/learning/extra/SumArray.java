package com.learning.extra;

import java.util.Arrays;

public class SumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0,8,3,6,9,0,7,3};
        int[] x = calc(arr , 10 , 2);
        for (int i : x) {
            System.out.print(i+" ");
        }
    }

    private static int[] calc(int[] arr , int sum , int k) {
        int currSum = 0;
        int start = 0;
        int end = 0;
        while (end<arr.length) {
            if(end-start==k) {
                if (currSum == sum)
                    return Arrays.copyOfRange(arr, start, end);
                else
                {
                    currSum -= arr[start];
                    start++;
                }
            }
            else {
                currSum+= arr[end];
                end++;
            }
        }
        if(currSum==sum && end-start==k)
            return Arrays.copyOfRange(arr , start , end);
        return new int[]{};
    }
}
