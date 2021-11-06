package com.learning.extra;

public class DesignTicTacToe {

    static char[][] board;
    static int n;
static int countOfX;
static int countOfO;
    public static void main(String[] args) {
        board = new char[2][2];
        n = 2;
        //["TicTacToe","move","move","move"]
        //[[2],[0,0,2],[0,1,1],[1,1,2]]
        System.out.println(move(0,0,2));
        System.out.println(move(0,1,1));
        System.out.println(move(1,1,2));
    }

    public static int move(int row, int col, int player) {
        board[row][col] = (player==1?'X':'O');
        if(player==1) {
            countOfX++;
        }
        else {
            countOfO++;
        }

        boolean isXWinner = winner(board , board[row][col] , row, col);

        if(!isXWinner)
            return 0;

        if(player==1)
            return isXWinner ? 1 : 0;
        return isXWinner ? 2 : 0;
    }

    static boolean  winner(char[][] board , char player, int row, int col) {
        boolean winner = true;
        for(int i=0;i<n;i++) {
            if(board[row][i]!=player) {
                winner = false;
                break;
            }
        }
        if(winner)
            return true;

        winner = true;
        for(int i=0;i<n;i++) {
            if(board[i][col]!=player) {
                winner = false;
                break;
            }
        }
        if(winner)
            return true;

        if(row==col) {
            /*System.out.println("Player : " + player);
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }*/
            winner = true;
            for(int i=0;i<n;i++) {
                if(board[i][i]!=player) {
                    winner = false;
                    break;
                }
            }
            //System.out.println(winner + " : " + row + " : " + col);
            if(winner)
                return true;
        }

        if(col==n-1-row) {
            winner = true;
            for(int i=0;i<n;i++) {
                if(board[i][n-1-i]!=player) {
                    winner = false;
                    break;
                }
            }
            if(winner)
                return true;
        }

        return false;
    }
}
