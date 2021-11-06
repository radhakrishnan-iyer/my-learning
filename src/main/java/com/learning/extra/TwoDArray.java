package com.learning.extra;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {0,1,1,0},
                {0,1,1,1},
                {1,1,1,0}
        };
        getSubMatrixOfZeros(mat);
    }

    static void getSubMatrixOfZeros(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n][m];
        int prev = 1;
        for(int i=0;i<n;i++) {
            for(int j=m-1;j>=0;j--) {
                if(j==m-1 && mat[i][j]==0) {
                    prefixSum[i][j] = 1;
                    prev = mat[i][j];
                }
                else if(j==m-1 && mat[i][j]==1) {
                    prefixSum[i][j] = 0;
                    prev = mat[i][j];
                }
                else {
                    if(prev==0 && mat[i][j]==prev) {
                        prefixSum[i][j] = prefixSum[i][j+1] + 1;
                    }
                    else if(mat[i][j] == 1) {
                        prefixSum[i][j] = 0;
                    } else {
                        prefixSum[i][j] = 1;
                    }
                    prev = mat[i][j];
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
