//泛型
package com.fanXingGenerics;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al=new ArrayList();
//		创建一只狗
		Dog dog1=new Dog();
//		放入集合中
		al.add(dog1);
//		取出
//		Dog temp=(Dog) al.get(0);//强转
		Cat temp=(Cat) al.get(0);//报错 类型转换出错
	}*/
	
//	解决办法 用泛型
	public static void main(String[] args) {
		ArrayList<Dog> al=new ArrayList<Dog>();
//		创建一只狗
		Dog dog1=new Dog();
//		放入集合中
		al.add(dog1);
//		取出
		Dog temp=al.get(0);//不用强转 就安全了
	}

}
class Dog{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Cat{
	private String color;
	private int age;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}