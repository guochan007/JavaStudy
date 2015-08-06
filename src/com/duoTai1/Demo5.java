//多态
package com.duoTai1;

public class Demo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Cat cat=new Cat();
		cat.cry();
		Dog dog=new Dog();
		dog.cry();
		*/
		//多态
		Animal an=new Cat();
		an.cry();
		an=new Dog();
		an.cry();
	}
}

class Animal{
	String name;
	int age;
	
	public void cry(){//这个必须有
		System.out.println("不知道怎么叫");
	}	
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
