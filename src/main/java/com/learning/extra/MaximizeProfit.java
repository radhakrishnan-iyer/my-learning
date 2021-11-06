package com.learning.extra;

public class MaximizeProfit {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,5,6,7,8} , 2));
    }

    static int solve(int[] profit , int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<profit.length;i++) {
            int totalProfit = calcProfit(profit, i, k);
            max = Math.max(max , totalProfit);
        }
        return max;
    }

    static int calcProfit(int[] profit, int pos , int k) {
        int count = k;
        int totalProfit = 0;
        int i = 0;
        int half = profit.length/2;
        while(count>0) {
            totalProfit += profit[(pos+i)%profit.length];
            totalProfit += profit[(half+pos+i)%profit.length];
            i++;
            count--;
        }
        return totalProfit;
    }
}
