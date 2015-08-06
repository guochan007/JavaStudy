package com.extend;

//继承的必要性  感觉抽象和继承是绑在一起的
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostStu ps1=new PostStu();
		ps1.printName();
		
	}

}

//小学生类
class Pupils{
//	成员属性
	private int age;
	private String name;
	private float fee;
//	交学费
	public void pay(float fee){
		this.fee=fee;
	}
}

//中学生类
class MiddleStu{
//	成员属性
	private int age;
	private String name;
	private float fee;
//	交学费
	public void pay(float fee){
		this.fee=fee*0.8f;
	}
}

//大学生类
class ColStu{
//	成员属性
	private int age;
	private String name;
	private float fee;
//	交学费
	public void pay(float fee){
		this.fee=fee*0.1f;
	}
}

//将学生的共有属性提出 写一个父类
class Stu{
	//	成员属性
	public int age;
	public String name;
	public float fee;
	private int salary;//不能被继承
	
	public void printName(){
		System.out.println("名字是："+this.name);
	}
}

//研究生
class PostStu extends Stu{
	//	交学费
	public void pay(float fee){
		this.fee=fee*0.2f;
	}
}