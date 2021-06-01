package com.learning.extra;

import java.util.*;
public class CoinChange_Backtrack {
    static     int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2} , 2));
    }

    static public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            for(int j=0;j<=amount;j++)
                dp[i][j] = -1;
        return solve(coins,amount,coins.length-1,dp);
    }

    static int solve(int[] coins, int amount, int m,int[][] dp) {
        if(coins.length==1) {
            return amount%coins[0]==0 ? amount/coins[0] : -1;
        }
        if(amount==0) {
            return 1;
        }
        if(m==-1) {
            return Integer.MAX_VALUE-1;
        }
        if(dp[m][amount]!=-1)
            return dp[m][amount];
        if(m==0) {
            if(amount%coins[m+1]==0)
                return amount/coins[m+1];
            else
                return Integer.MAX_VALUE-1;
        }
        if(coins[m-1]<=amount) {
            dp[m][amount] = Math.min(1+solve(coins,amount-coins[m],m,dp) , solve(coins,amount,m-1,dp));
        } else {
            dp[m][amount] = solve(coins,amount,m-1,dp);
        }
        //System.out.println(dp[m][amount] + " : " + (Integer.MAX_VALUE-1));
        return dp[m][amount] == Integer.MAX_VALUE-1 ? -1 : dp[m][amount];
    }
}
