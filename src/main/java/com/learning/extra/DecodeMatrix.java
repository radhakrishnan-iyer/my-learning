package com.learning.extra;

public class DecodeMatrix {

    public static void main(String[] args) {
        /*m n e s i _  _

        _ y a _ _ k _

        _ _ _ m i m e*/


        char[][] mat = new char[][]{
                {'m','n','e','s','i','_','_'},
                {'_','y','a','_','_','k','_'},
                {'_','_','_','m','i','m','e'}
        };

        System.out.println(decode("mnesi___ya__k____mime" , 3));
    }

    static String decode(String s, int n) {
        int cols = s.length()/n;
        char[][] mat = new char[n][cols];
        int index = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<cols;j++) {
                mat[i][j] = s.charAt(index++);
            }
        }
        return decode(mat);
    }

    static String decode(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i!=1 && j!=n) {
            int prevJ = j;
            while (i<m && j<n) {
                if (mat[i][j] == '_')
                    sb.append(" ");
                else
                    sb.append(mat[i][j]);
                i = i+1;
                j = j+1;
                if(i==m) {
                    i = 0;
                    j = prevJ+1;
                    break;
                }
                else if(i==1 && j==n)
                    break;
                else if(j==n) {
                    i = 0;
                    j = prevJ+1;
                }
            }
        }
        return sb.toString().trim();
    }
}
