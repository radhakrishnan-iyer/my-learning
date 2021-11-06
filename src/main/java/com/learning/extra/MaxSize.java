package com.learning.extra;

public class MaxSize {

    public static void main(String[] args) {
        /*int[][] mat = new int[][] {{
            0,1,0
        },{1,1,1},{0,1,0}};
        System.out.println(maxSize(mat,0,mat.length-1, 0, mat[0].length-1));*/

        int[][] mat = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,1,1,1,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };
        System.out.println(maxSize(mat,0,mat.length-1, 0, mat[0].length-1));

    }

    private static int maxSize(int[][] mat, int row1, int row2, int col1, int col2) {
        if(row1>row2 || col1>col2)
            return Integer.MIN_VALUE;
        if(row1==row2 && col1==col2) {
            return mat[row1][col1];
        }
        int len = row2-row1+1;
        if(len%2==0) {
            // even len matrix like 4x4 cannot have symmetric plus with len as 4
            /*return Math.max(Math.max(Math.max(maxSize(mat, row1, row2-1, col1, col2-1) , maxSize(mat, row1, row2-1, col1+1, col2)) ,
                    maxSize(mat, row1+1, row2, col1, col2-1)) , maxSize(mat , row1+1, row2, col1+1, col2));*/
            return 0;
        }
        int midRow = (row2 - row1)/2;
        int midCol = (col2 - col1)/2;
        if(isAllOnesInRow(mat, midRow) && isAllOnesInCol(mat, midCol)) {
            return len;
        }
        else {
            // same as odd case
            //return Math.max(Math.max(Math.max(maxSize(mat, row1, row2-1, col1, col2-1) , maxSize(mat, row1, row2-1, col1+1, col2)) ,
            //        maxSize(mat, row1+1, row2, col1, col2-1)) , maxSize(mat , row1+1, row2, col1+1, col2));
            return maxSize(mat, row1+1, row2-1, col1+1, col2-1);
        }
    }

    private static boolean isAllOnesInRow(int[][] mat, int row) {
        for(int i=0;i<mat[0].length;i++) {
            if (mat[row][i] == 0)
                return false;
        }
        return true;
    }

    private static boolean isAllOnesInCol(int[][] mat, int col) {
        for(int i=0;i<mat.length;i++) {
            if (mat[i][col] == 0)
                return false;
        }
        return true;
    }
}
