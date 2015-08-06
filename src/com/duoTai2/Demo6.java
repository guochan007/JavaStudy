//多态
package com.duoTai2;

public class Demo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Master master=new Master();
		master.feed(new Dog(), new Bone());
		master.feed(new Cat(), new Fish());
	}
}
//动物类
class Animal{
	String name;
	int age;

	public void eat(){
		System.out.println("不知道吃什么");
	}	
}
//猫类
class Cat extends Animal{

	public void eat(){
		System.out.println("猫吃什么");
	}
}
//狗类
class Dog extends Animal{

	public void eat(){
		System.out.println("狗吃什么");
	}
}
//食物类
class Food{
	String name;
	public void showName(){
		
	}
}
//鱼类
class Fish extends Food{
	public void showName(){
		System.out.println("鱼肉");
	}
}
//骨头类
class Bone extends Food{
	public void showName(){
		System.out.println("骨头");
	}
}
//主人类
class Master{
//	喂食 使用多态   不论以后可以扩展动物类和食物类   该方法不需要变
	public void feed(Animal an,Food f){
		an.eat();
		f.showName();
	}
	
}