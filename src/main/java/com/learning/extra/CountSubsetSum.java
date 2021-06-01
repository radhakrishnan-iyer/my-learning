package com.learning.extra;

public class CountSubsetSum {
    public static void main(String[] args) {
        System.out.print(solve(new int[]{2, 3 , 7 , 9} , 12));
    }

    private static int solve(int[] arr, int sum) {
        int[][] dp = new int[arr.length+1][sum+1];
        for(int j=0;j<=sum;j++)
            dp[0][j] = 0;
        for(int i=0;i<=arr.length;i++)
            dp[i][0] = 1;
        for(int i=1;i<=arr.length;i++)
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        return dp[arr.length][sum];
    }
}
