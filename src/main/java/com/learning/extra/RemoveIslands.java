package com.learning.extra;

import java.util.*;

public class RemoveIslands {

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1,0,0,0,0,0},
                {0,1,0,1,1,1},
                {0,0,1,0,1,0},
                {1,1,0,0,1,0},
                {1,0,1,1,0,0},
                {1,0,0,0,0,1}
        };
        removeIslands(mat);
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void removeIslands(int[][] mat) {
        Set<Entry> temp = new HashSet<>();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(i==0 || j==0 || i==mat.length-1 || j==mat[0].length-1) {
                    dfs(mat , temp, i, j);
                }
            }
        }
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(temp.contains(new Entry(i,j)))
                    continue;
                if(mat[i][j]==1)
                    mat[i][j] = 0;
            }
        }
    }

    static void dfs(int[][] mat, Set<Entry> temp, int i, int j) {
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] == 0)
            return;
        int x = mat[i][j];
        mat[i][j] = 0;
        dfs(mat, temp, i+1, j);
        dfs(mat, temp, i-1, j);
        dfs(mat, temp, i, j+1);
        dfs(mat, temp, i, j-1);
        mat[i][j] = x;
        temp.add(new Entry(i,j));
    }

    static class Entry {
        int x;
        int y;
        Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x,y);
        }

        public boolean equals(Object o) {
            if(!(o instanceof Entry))
                return false;
            Entry other = (Entry)o;
            return other.x==this.x && other.y == this.y;
        }
    }
}
