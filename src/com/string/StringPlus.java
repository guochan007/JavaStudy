package com.string;

public class StringPlus {

	/**
	 * 测试字符串拼接问题
	 */
	public static void main(String[] args) {
		String str=null;
		str+="test";
		System.out.println(str);
//		nulltest
		
		String str1="";
		str1+="test";
		System.out.println(str1);
//		test
		
		String str2=null;
		str2=str2+"test";
		System.out.println(str2);
//		nulltest
	}

}
