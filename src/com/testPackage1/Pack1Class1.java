package com.testPackage1;

public class Pack1Class1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pack1Class1 pack1Class1=new Pack1Class1();
		pack1Class1.pack1Class1PublicMethod();
		pack1Class1.pack1Class1ProtectedMethod();
		pack1Class1.pack1Class1PrivateMethod();
		pack1Class1.pack1Class1DefaultMethod();
	}

	public void pack1Class1PublicMethod() {
		System.out.println("pack1Class1PublicMethod");
	}

	protected void pack1Class1ProtectedMethod() {
		System.out.println("pack1Class1ProtectedMethod");
	}

	private void pack1Class1PrivateMethod() {
		System.out.println("pack1Class1PrivateMethod");
	}
	
	void pack1Class1DefaultMethod(){
		System.out.println("pack1Class1DefaultMethod");
	}
	
	public class BBB{}
}

// The public type AAA must be defined in its own file
// public class AAA {}