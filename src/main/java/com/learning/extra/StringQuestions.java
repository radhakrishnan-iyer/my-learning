package com.learning.extra;

public class StringQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abc";
		String s2="ab";
		String s3="c";
		String s4=s2+s3;
		System.out.println(s1==s4);
		System.out.println(s1==(s2+s3));
		System.out.println(s1==s4.intern());
		System.out.println(s1==s4);
	}

}
