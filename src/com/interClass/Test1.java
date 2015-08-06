package com.interClass;

public class Test1 {
	
	public static void main(String[] args) {

		Test1 t1=new Test1();
		t1.sayHello();
		t1.new inerClass().sayHello();
	}

	public void sayHello(){
		System.out.println("hello");
	}
	
	class inerClass{
		public void sayHello(){
			System.out.println("hello");
		}
	}
}
