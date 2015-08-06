package com.test;


public class Assert {

	/**
	 * 断言
	 */
	public static void main(String[] args) {
		System.out.println(fn1(1));
		System.out.println(fn1(-1));
	}

	private static int fn1(int a){
		assert(a>0);
		return 0;
	}
}
