package com.learning.extra;

public class MatrixMovement {
    static int count = 0;
    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,0,0,1}, {0,1,1,1}, {1,0,0,1}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        dfs(mat);
        System.out.println(count);
    }

    private static void dfs(int[][] matrix) {
        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix[0].length;c++) {
                if(matrix[r][c]==1) {
                    if(r-1>=0 && matrix[r-1][c]==1) {
                        count++;
                    }
                    if(r-1>=0 && c-1>=0 && matrix[r-1][c-1]==1)
                        count++;
                    if(r-1>=0 && c+1<=matrix[0].length-1 && matrix[r-1][c+1]==1)
                        count++;
                    if(c+1<=matrix[0].length-1 && matrix[r][c+1]==1)
                        count++;
                }
            }
        }
    }
}
