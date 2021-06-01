package com.learning.extra;

public class EqualSubSetSumPartition {
    public static void main(String[] args) {
        int[] arr = {2, 3 , 4, 9};
        System.out.println(solve(arr));
    }

    private static boolean solve(int[] arr) {
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum%2 !=0)
            return false;
        return subSetSum(arr, sum/2);
    }

    private static boolean subSetSum(int[] arr, int sum) {
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int j=0;j<=sum;j++)
            dp[0][j] = false;
        for(int i=0;i<=arr.length;i++)
            dp[i][0] = true;
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
