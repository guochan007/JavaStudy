//方法覆盖
package com.extend;

public class Demo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		cat.cry();
		Dog dog=new Dog();
		dog.cry();
	}

}

class Animal{
	int age;
	String name;
//	都会叫
	public void cry(){//我就奇怪 要是这样的话 父类里完全可以不写 方法 就在子类自己里写就好了嘛
		System.out.println("我是动物，不知道怎么叫");
	}
}

class Cat extends Animal{
//	覆盖父类方法
	public void cry(){
		System.out.println("猫叫");
	}
}

class Dog extends Animal{
//	覆盖父类方法
	public void cry(){
		System.out.println("狗叫");
	}
}