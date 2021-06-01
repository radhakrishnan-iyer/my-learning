package com.learning.extra;

public class PinBallGame {

    public static void main(String[] args) {
        char[][] matrix = new char[][] {{'/','/','\\',' '},
                                        {' ',' ','\\',' '},
                                        {' ','\\',' ',' '}};
        System.out.println(solve(matrix, 2,3,0,3));
    }
    static boolean solve(char[][] matrix, int startX,int startY, int endX, int endY){
        if(startX<0 || startX>=matrix.length || startY<0 || startY>=matrix[0].length)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return solve(matrix, startX, startY, startX, startY, endX , endY, visited);
    }

    static boolean solve(char[][] matrix, int prevX,int prevY, int currentX , int currentY , int endX, int endY, boolean[][] visited){
        if(currentX<0 || currentX>=matrix.length || currentY<0 || currentY>=matrix[0].length || visited[currentX][currentY]) {
            return false;
        }
        if(currentX==endX && currentY==endY)
            return true;

        int diffX = prevX - currentX;
        int diffY = prevY - currentY;
        visited[currentX][currentY] = true;

        if(matrix[currentX][currentY]=='\\') {
            if(diffY==1) {
                //left to right
                return solve(matrix,currentX,currentY, currentX+1, currentY, endX, endY, visited);
            }
            if(diffY==-1) {
                //right to left
                return solve(matrix,currentX,currentY, currentX-1, currentY, endX, endY, visited);
            }

            if(diffX==1) {
                //top to down
                return solve(matrix,currentX,currentY, currentX, currentY+1, endX, endY, visited);
            }
            if(diffX==-1) {
                //down to up
                return solve(matrix,currentX,currentY, currentX, currentY-1, endX, endY, visited);
            }
        }
        if(matrix[currentX][currentY]=='/') {
            if(diffY==1) {
                //left to right
                return solve(matrix,currentX,currentY, currentX-1, currentY, endX, endY, visited);
            }
            if(diffY==-1) {
                //right to left
                return solve(matrix,currentX,currentY, currentX+1, currentY, endX, endY, visited);
            }

            if(diffX==1) {
                //top to down
                return solve(matrix,currentX,currentY, currentX, currentY-1, endX, endY, visited);
            }
            if(diffX==-1) {
                //down to up
                return solve(matrix,currentX,currentY, currentX, currentY+1, endX, endY, visited);
            }
        }
        return solve(matrix, currentX, currentY , currentX+1, currentY, endX , endY, visited) ||
                solve(matrix, currentX, currentY, currentX, currentY+1, endX, endY , visited) ||
                solve(matrix, currentX, currentY, currentX-1, currentY, endX, endY, visited) ||
                solve(matrix, currentX, currentY, currentX, currentY-1, endX, endY, visited);
    }
}
