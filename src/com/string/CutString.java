package com.string;

import java.util.StringTokenizer;

public class CutString {

	/**
	 * 分割字符串    貌似这货只认空格
	 */
	public static void main(String[] args) {

//		StringTokenizer st = new StringTokenizer("Hello World Hello");
//		StringTokenizer st = new StringTokenizer("Hello+World+Hello");
		StringTokenizer st = new StringTokenizer("Hello/World/Hello");
		while (st.hasMoreTokens()) {
		    System.out.println(st.nextToken());
		}
	}

}
