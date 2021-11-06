package com.learning.extra;

import java.util.Arrays;

public class CarParking {

    public static void main(String[] args) {
        System.out.println(findMinimumLengthRoof(new int[]{2,10,8,17} , 3));
    }

    static int findMinimumLengthRoof(int[] car, int k) {
        Arrays.sort(car);
        int[] left = new int[car.length];
        int[] right = new int[car.length];
        left[0] = 1;
        right[car.length-1] = 1;
        for(int i=1;i<car.length;i++) {
            left[i] = left[i-1]+1;
        }
        for(int j=car.length-2;j>=0;j--) {
            right[j] = right[j+1]+1;
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<car.length;i++) {
            if(left[i]>=k) {
                ans = Math.min(ans ,car[i]-car[0]+1);
            }
            else if(right[i]>=k) {
                ans = Math.min(ans , car[car.length-1]-car[i]+1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
