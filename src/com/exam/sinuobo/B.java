package com.exam.sinuobo;

public class B extends A {

	public int method1(int a, int b) {
		return 1;
	}

	public static void main(String[] args) {

		B b = new B();
		System.out.println("x=" + b.method1(0, 1));
	}

}
