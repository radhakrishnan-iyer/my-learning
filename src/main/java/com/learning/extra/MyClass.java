package com.learning.extra;

public class MyClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass x = new MyClass();
		String s  = x.new String();
		System.out.print(s.x);
	}
	
	class String {
		String x;
	}

}
