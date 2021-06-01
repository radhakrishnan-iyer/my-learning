package com.learning.extra;

public class StairsProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ways(3));
	}

	static int fibo(int n) {
		int a = 0, b= 1, c;
		for(int i = 2; i<=n ; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		return b;
	}
	
	static int ways(int s) {
		return fibo(s+1);
	}
}
