package com.abstractAndInterface;

public class AbstractChild extends AbstractParent{
	
//	like common class extends its parent
	public void fun(){
		System.out.println("abstractChild fun");
	}
	
	@Override
	void fun2() {
		
	}
	
	public static void main(String[] args) {
		AbstractChild a=new AbstractChild();
		a.fun();
	}

	
}
