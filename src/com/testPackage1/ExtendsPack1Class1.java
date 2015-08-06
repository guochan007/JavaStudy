package com.testPackage1;

public class ExtendsPack1Class1 extends Pack1Class1{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExtendsPack1Class1 extendsPack1Class1=new ExtendsPack1Class1();
		extendsPack1Class1.pack1Class1PublicMethod();
		extendsPack1Class1.pack1Class1ProtectedMethod();
		extendsPack1Class1.pack1Class1PrivateMethod();//说明子类无法继承父类的private方法
		extendsPack1Class1.pack1Class1DefaultMethod();
	}

}
