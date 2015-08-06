package com.string;

public class StringToInt {

	/**
	 * 测试字符串能不能转数字
	 */
	public static void main(String[] args){
//		String str="123";
//		String str="123a";
		String str="123+3";
		int a=Integer.valueOf(str);
		System.out.println(a);
	}

}
