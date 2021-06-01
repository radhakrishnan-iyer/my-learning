package com.learning.extra;

public class KnightOnline {

    public static void main(String[] args) {
        System.out.println(knightValidCount(8, 1, 0,0));
        System.out.println(knightValidCount(8, 2, 0,0));
        System.out.println(knightValidCount(8, 20, 0,0));
    }

    public static long knightValidCount(int N, int K, int r, int c) {
        int[][] dir = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        long[][][] dp = new long[K+1][N][N];
        long res = dfsKnightCount(N,K,r,c,  dp);
        return res;
    }

    private static long dfsKnightCount(int N, int K, int r, int c, long[][][] dp) {
        if(r<0 || r>=N || c<0 || c>=N) return 0;
        if(dp[K][r][c] > 0) return dp[K][r][c];
        if(K==0)
            return 1;
        dp[K][r][c] = dfsKnightCount(N, K-1 , r+2, c+1, dp) +
                dfsKnightCount(N, K-1 , r+2, c-1,dp) +
                dfsKnightCount(N, K-1, r+1,c+2,  dp) +
                dfsKnightCount(N, K-1, r+1, c-2,  dp) +
                dfsKnightCount(N, K-1 , r-2, c+1,  dp) +
                dfsKnightCount(N, K-1 , r-2, c-1,  dp) +
                dfsKnightCount(N, K-1 , r-1, c+2,  dp) +
                dfsKnightCount(N, K-1 , r-1, c-2,  dp);
        return dp[K][r][c];
    }
}
