package com.testPackage1;

public class Pack1Class2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pack1Class1 pack1Class1=new Pack1Class1();
		pack1Class1.pack1Class1PublicMethod();
		pack1Class1.pack1Class1ProtectedMethod();
		pack1Class1.pack1Class1PrivateMethod();//说明在同一包下 可以访问protected方法，但不能访问private方法
		pack1Class1.pack1Class1DefaultMethod();
	}

	/*
	public void pack1Class2PublicMethod() {
		System.out.println("pack1Class2PublicMethod");
	}

	protected void pack1Class2ProtectedMethod() {
		System.out.println("pack1Class2ProtectedMethod");
	}

	private void pack1Class2PrivateMethod() {
		System.out.println("pack1Class2PrivateMethod");
	}
	
	void pack1Class2DefaultMethod(){
		System.out.println("pack1Class2DefaultMethod");
	}
*/
	
}
