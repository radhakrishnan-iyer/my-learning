package com.learning.extra;

public class CountSubsetWithDiff {
    public static void main(String[] args) {
        int diff = 1;
        int[] arr = new int[] {1,1,2,3};
        System.out.print(solve(arr , 1));
    }

    private static int solve(int[] arr, int diff) {
        int sum = 0;
        for(int i:arr)
            sum += i;
        if((sum + diff)%2!=0)
            return 0;
        return subsSetSum(arr, (sum+diff)/2);
    }

    private static int subsSetSum(int[] arr, int sum) {
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
