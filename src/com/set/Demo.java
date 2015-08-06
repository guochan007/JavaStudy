//集合和对象数组的感觉有点一样
package com.set;

import java.util.ArrayList;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义数组
//		Clerk clerk[]=new Clerk[n];//n不确定时
//		定义arraylist对象
		ArrayList al=new ArrayList();
//		显示大小
		System.out.println("al大小:"+al.size());
//		向al中加入数据  类型为object
//		创建一个职员
		Clerk clerk1=new Clerk("宋江",50,1000);
		Clerk clerk2=new Clerk("吴用",45,2000);
//		将clerk1加入到al中
		al.add(clerk1);
		System.out.println("al大小:"+al.size());
//		访问al中的对象 数据
		Clerk temp=(Clerk)al.get(0);
		System.out.println("第一个人的名字是："+temp.getName());
//		遍历al所有的对象
		/*for(int i=0;i<al.size();i++){
			Clerk temp=(Clerk)al.get(i);
			System.out.println("名字="+temp.getName());
		}*/
//		从al中删除一个对象		
		al.remove(0);
		System.out.println("al大小:"+al.size());
	}

}

//定义一个员工类
class Clerk{
	private String name;
	private int age;
	private float sal;
	
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

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public Clerk(String name,int age,float sal){
		this.name=name;
		this.age=age;
		this.sal=sal;
	}
}