package com.learning.extra;

public class EggDropping {
    static int[][] dp = new int[101][10001];

    public static void main(String[] args) {
        for(int i=0;i<101;i++)
            for(int j=0;j<10001;j++)
                dp[i][j] = Integer.MIN_VALUE;
        System.out.println(superEggDrop(2,6));
    }

    static public int superEggDrop(int K, int N) {
        //return solve(K,N);
        return solve2(K,N);
    }

    static int solve(int K, int N) {
        if(K==1)
            return N;
        if(N==0 || N==1)
            return N;
        if(dp[K][N]!=Integer.MIN_VALUE)
            return dp[K][N];
        int min = Integer.MAX_VALUE;
        for(int x=1;x<=N;x++) {
            int low = 0;
            if(dp[K-1][x-1]!=Integer.MIN_VALUE) {
                low = dp[K-1][x-1];
            } else {
                low = solve(K-1,x-1);
                dp[K-1][x-1] = low;
            }
            int high = 0;
            if(dp[K][N-x]!=Integer.MIN_VALUE) {
                high = dp[K][N-x];
            } else {
                high = solve(K,N-x);
                dp[K][N-x] = high;
            }
            int temp = Math.max(low,high);
            min = Math.min(min,temp);
        }
        dp[K][N] = 1+min;
        return dp[K][N];
    }

    static int solve2(int k, int n) {
        int [][] egg = new int[k+1][n+1];
        for(int i=0;i<=k;i++) {
            egg[i][0] = 0;
            egg[i][1] = 1;
        }

        for (int i = 1; i <= n; i++)
            egg[1][i] = i;
        int res = 0;
        for(int i=2;i<=k;i++) {
            for(int j=2;j<=n;j++) {
                egg[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++) {
                    res = Math.min(dp[i-1][x-1], dp[i][j-x] );
                    egg[i][j] = Math.min(egg[i][j] , 1+res);
                }
            }
        }
        return egg[k-1][n-1];
    }
}
