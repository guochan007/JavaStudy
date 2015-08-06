package com.pack;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog1=new Dog();
		System.out.println(dog1.getPrice());//price 访问不到 需getPrice
	}

}

class Dog{
	public int a;
	protected String name;
	String color;
	private float price;
	//提供一个访问price的成员方法
	public float getPrice(){
		return this.price;
	}
	
	public void fn1(){
		System.out.println(a);
	}
	protected void fn2(){
		System.out.println(a);
	}
	private void fn3(){
		System.out.println(a);
	}
}