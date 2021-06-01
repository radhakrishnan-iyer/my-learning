package com.learning.extra;

public class PathInGrid {

    public static void main(String[] args) {
        int [][] grid = new int[][] {{0,3,2},
                                    {3,3,0},
                                    {1,3,0}};
        int [][] grid1 = new int[][]{{ 0, 3, 1, 0 },
            { 3, 0, 3, 3 },
            { 2, 3, 0, 3 },
            { 0, 3, 3, 3 }};
        System.out.println(path(grid1));
    }

    private static boolean path(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    if(dfs(grid, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if(r>=grid.length || r<0 || c<0 || c>=grid[0].length || visited[r][c])
            return false;
        if(grid[r][c] ==0)
            return false;
        if(grid[r][c] ==2)
            return true;
        visited[r][c] = true;
        return dfs(grid,r+1,c,visited) || dfs(grid, r-1, c,visited) || dfs(grid,r,c+1,visited) || dfs(grid,r,c-1,visited);
    }
}
