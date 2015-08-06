package com.math.calculate;

public class JiaoHuanNumber {

	/**
	 *交换ab  使用异或
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println(a);
		System.out.println(b);
	}

}
