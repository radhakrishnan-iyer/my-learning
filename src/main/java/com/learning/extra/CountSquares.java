package com.learning.extra;

public class CountSquares {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1,1},{0,1,1,1},{1,1,1,0}};
        System.out.println(countSquares(matrix));
    }

    private static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0)
                    continue;
                ans++;
                ans += solve(matrix, i, j, i+1,j+1);
            }
        }
        return ans;
    }

    private static int solve(int[][] matrix, int r, int c, int m, int n) {
        if(m >= matrix.length || n >= matrix[0].length)
            return 0;
        for(int i=m;i>=r;i--) {
            if(matrix[i][n]==0)
                return 0;
        }
        for(int j=n;j>=c;j--) {
            if(matrix[m][j]==0)
                return 0;
        }
        return 1+solve(matrix,r,c,m+1,n+1);
    }
}
