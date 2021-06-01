package com.learning.extra;

public class StaticMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethods s = new StaticMethods();
		StaticMethods s1 = null;
		test();
		s.test();
		s1.test();
		System.out.println(s.getClass().getName());
	}
	
	public static void test() {
		System.out.println("Testing");
	}

}
