package com.javaBase;

public class LeftRightMove {
	/*
	 * 测试java基础语法 
	 * <<:左移运算符，num << 1,相当于num乘以2 
	 * >>:右移运算符，num >> 1,相当于num除以2
	 * >>>:无符号右移，忽略符号位，空位都以0补齐
	 */
	public static void main(String[] args) {

		int a = 10;
//		原始二进制
		System.out.println(Integer.toBinaryString(a));
//		左移
		a=a<<2;
		System.out.println(Integer.toBinaryString(a));
//		右移
		a=a>>2;
		System.out.println(Integer.toBinaryString(a));
//		无符号右移
		a=a>>>2;
		System.out.println(Integer.toBinaryString(a));
	}
	
//	2.为什么没有（<<<） 这个问题相当于JAVA为什么不叫JAVAAAA
//	这是人家规定的，没有为什么。如果非要问为什么 ，下面的理由是最解释得通的。因为左移绝不可能出现符号问题，所以不需要带不带符号。只取原来符号就行。
//	3.这种位运算我可以向你保证，除了考试会用到之外，以后绝不会遇到。公司如果出这种题来面试的话，我劝你那家公司你就别去了。去考一些永远不用的东西。
//	所以我的建议是你把精力花在JAVA的主要方面。你应该是初学 。主要是语法，OOP方面要先掌握起来
}
