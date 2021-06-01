package com.learning.dp;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
 
        int m = X.length();
        int n = Y.length();
 
        System.out.println("Length of Longest Common Substring is "
                + lcs.lcs(X.toCharArray(), Y.toCharArray(), m, n));
	}
	
	int lcs(char X[] , char Y[] , int m, int n) {
		int L[][] = new int [m+1][n+1];
		int result = 0;
		for(int i = 0; i<= m; i++) {
			for(int j= 0;j <= n; j++) {
				if(i== 0 || j== 0)
					L[i][j] = 0;
				else if (X[i-1] == Y[j-1]) {
					L[i][j] = 1+ L[i-1][j-1];
					result = Math.max(result , L[i][j]);
				}
				else
					L[i][j] = 0;
			}
		}
		return result;
	}

}
