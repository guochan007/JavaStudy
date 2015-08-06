package com.exam.sinuobo;

import java.math.BigInteger;

public class Num52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int result = 1;
		// long result = 1;
		// bigint result = 1;//不对
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= 100; i++) {
			// result*=i;
			// result = result.multiply(i);
			result = result.multiply(BigInteger.valueOf(i));
		}
		System.out.println("result=" + result);
	}
}
