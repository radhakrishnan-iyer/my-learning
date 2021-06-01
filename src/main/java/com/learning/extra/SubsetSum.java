package com.learning.extra;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.print(solve(new int[]{2, 3 , 7 , 9} , 13));
    }

    private static boolean solve(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int j=0;j<=sum;j++)
            dp[0][j] = false;
        for(int i=0;i<=arr.length;i++)
            dp[i][0] = true;
        for(int i=1;i<=arr.length;i++)
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        return dp[arr.length][sum];
    }
}
