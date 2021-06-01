package com.learning.extra;

class KnightProblem {
    static int[][] dirs = new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};

    public static void main(String[] args) {
        System.out.println(minKnightMoves(5,5));
    }

    static public int minKnightMoves(int x, int y) {
        int max = Math.max(x,y);
        boolean[][] visited = new boolean[max+1][max+1];
        return minKnightMovesRecursion(0,0,x,y,visited,max,0);
    }

    static int minKnightMovesRecursion(int i,int j, int x, int y,boolean[][] visited, int max,int depth) {
        if(i==x && j==y)
            return depth;
        if(x==1 && y==1)
            return 2;
        if(i<0 ||i>max||j<0 ||j>max || visited[i][j])
            return Integer.MAX_VALUE;
        visited[i][j] = true;
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<dirs.length;k++) {
            ans = Math.min(ans , minKnightMovesRecursion(i+dirs[k][0] , j+dirs[k][1], x, y, visited, max, depth+1));
        }
        //visited[i][j] = false;
        return ans;
    }
}