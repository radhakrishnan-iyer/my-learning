package com.learning.dp;

public class EggDroppingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+eggDrop(n, k));
	}
	
	public static int eggDrop(int n, int k) {
		int eggDrop[][] = new int[n+1][k+1];
		
		for(int i=1 ; i<=n ; i++) {
			eggDrop[i][0] = 0;
			eggDrop[i][1] = 1;
		}
		
		for(int j=1;j<=k;j++) {
			eggDrop[1][j] = j;
		}
		
		for(int i = 2; i<=n ; i++) {
			for(int j=2 ;j<=k ; j++) {
				eggDrop[i][j] = Integer.MAX_VALUE;
				for(int x = 2; x<=j ; x++) {
					int res = 1+ Math.max(eggDrop[i-1][x-1], eggDrop[i][j-x]);
					if(res < eggDrop[i][j])
						eggDrop[i][j]=res;
				}
			}
		}
		
		return eggDrop[n][k];
	}

}
