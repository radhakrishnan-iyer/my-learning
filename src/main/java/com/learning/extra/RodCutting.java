package com.learning.extra;

public class RodCutting {
    public static void main(String[] args) {
        System.out.println(rodCutting(new int[]{1,5,8,9,10,17,17,20}, new int[]{1,2,3,4,5,6,7,8} , 8));
    }

    private static int rodCutting(int[] prices, int[] length, int N) {
        int[][] dp = new int[length.length+1][N+1];
        for(int j=0;j<=N;j++)
            dp[0][j] = 0;
        for(int i=0;i<=length.length;i++)
            dp[i][0] = 0;
        for(int i=1;i<=length.length;i++){
            for(int j=1;j<=N;j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]] , dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[length.length][N];
    }
}
