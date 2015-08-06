package com.exam.sinuobo;

public class Sub extends Super {

	Sub() {
		System.out.println("sub");
	}

	public static void main(String[] args) {

		Super sooper = new Super();//super
		Sub sub = new Sub();//super sub
		//super super sub
	}
}