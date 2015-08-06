package com.exam.sinuobo;

import javax.management.RuntimeErrorException;

public class Num11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			badMethod();
			System.out.println("a");
		} catch (RuntimeException e) {
			System.out.println("b");
		} catch (Exception e) {
			System.out.println("c");
		} finally {
			System.out.println("d");
		}
		System.out.println("e");
	}

	public static void badMethod() {
		throw new RuntimeException();
	}

}
