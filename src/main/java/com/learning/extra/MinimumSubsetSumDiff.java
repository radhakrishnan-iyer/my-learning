package com.learning.extra;

public class MinimumSubsetSumDiff {

    static boolean[] s1;
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,7};
        int sum = 0;
        for(int i=0;i<arr.length;i++)
            sum += arr[i];
        int ans = Integer.MIN_VALUE;
        s1 = new boolean[sum/2];
        for(int i=0;i<=sum/2;i++) {
            if(solve(arr , i)) {
                ans = Math.max(ans , i);
            }
        }
        System.out.println(sum-2*ans);
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
                } else
                    dp[i][j] = dp[i-1][j];
            }
        return dp[arr.length][sum];
    }
}
