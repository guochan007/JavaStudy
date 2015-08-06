//抽象类的必要性
package com.abstractClassAndInterface;
public class TestAbstract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an=new Cat();
		an.cry();
		an=new Dog();
		an.cry();
	}

}

/*class Animal{
	String name;
	int age;
	public void cry(){
		System.out.println("不知道怎么叫");//没有意义
	}	
}*/

abstract class Animal{//抽象类
	String name;
	int age;
	abstract public void cry();
}

class Cat extends Animal{
	public void cry(){
		System.out.println("猫叫");
	}
}

class Dog extends Animal{
	public void cry(){
		System.out.println("狗叫");
	}
}