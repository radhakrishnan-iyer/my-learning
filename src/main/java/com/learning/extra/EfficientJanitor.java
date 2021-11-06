package com.learning.extra;

import java.util.Arrays;

public class EfficientJanitor {

    public int solve(double[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int count = 0;
        while (left<=right) {
            if(left==right) {
                count++;
                break;
            }
            if(arr[left] + arr[right] <= 3.0) {
                left++;
                right--;
                count++;
            }
            else {
                right--;
                count++;
            }
        }
        return count;
    }
}
