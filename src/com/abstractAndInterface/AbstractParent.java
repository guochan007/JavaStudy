package com.abstractAndInterface;

public abstract class AbstractParent {
	private String str="hello";
	
//	like common class extends its parent
	public void fun(){
		System.out.println("abstract fun:"+str);
	}
	
	abstract void fun2();
	
	static String str2="";
	
	static{
		System.out.println("abstract static area");
	}
}
