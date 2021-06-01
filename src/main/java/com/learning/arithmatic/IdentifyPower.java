package com.learning.arithmatic;

public class IdentifyPower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPerfectPower(85 , 4);
	}
	
	static void isPerfectPower(int n , int k) {
		double x = Math.pow(Math.round(Math.log(n)/Math.log(k)),k);
		System.out.println(x);
		if(x == n) {
		System.out.println("Yes");
		}
		else 
		System.out.println("No");
		}

}
