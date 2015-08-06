package com.string;

public class StringToIntException {

	/**
	 * 测试字符串能不能转数字
	 * 测试能不能忽略异常，继续往下走
	 */
	public static void main(String[] args){
//		String str="123";
//		String str="123a";
		try {
			fn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("还能走到这1");
	}

	public static void fn() {
		String str="123+3";
		int a=Integer.valueOf(str);
		System.out.println(a);
		
	}
}
