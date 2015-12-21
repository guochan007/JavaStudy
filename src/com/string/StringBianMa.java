package com.string;


public class StringBianMa {
	public static void main(String[] args) throws Exception {
		byte[] b="测试123".getBytes();
		System.out.println(new String(b));
		System.out.println(new String(b).getBytes());
		System.out.println(new String(b, "utf-8"));
		System.out.println(new String(b).getBytes("utf-8"));
	}
}
