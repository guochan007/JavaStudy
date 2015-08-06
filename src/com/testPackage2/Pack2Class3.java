package com.testPackage2;

import com.testPackage1.Pack1Class1;

public class Pack2Class3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pack1Class1 pack1Class1=new Pack1Class1();
		pack1Class1.pack1Class1PublicMethod();
		pack1Class1.pack1Class1ProtectedMethod();///说明在不同的包下  可以访问public方法，但不能访问private、protected、default方法
		pack1Class1.pack1Class1PrivateMethod();
		pack1Class1.pack1Class1DefaultMethod();
	}

}
