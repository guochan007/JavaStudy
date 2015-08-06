//泛型 目的 安全 省代码
package com.fanXingGenerics;

import java.lang.reflect.Method;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Gen<String> gen1=new Gen<String>("aaa");
//		gen1.showTypeName();
//		Gen<Integer> gen2=new Gen<Integer>(1);
//		gen2.showTypeName();
		Gen<Bird> gen3=new Gen<Bird>(new Bird());
		gen3.showTypeName();
	}

}
//定义一个类
class Gen<T>{//T可以表示许多类型
	private T o;
//	构造函数
	public Gen(T a){
		o=a;
	}
//	得到T的类型名称
	public void showTypeName(){
		System.out.println("类型是："+o.getClass().getName());
//		通过反射机制可以得到一个类的许多信息  成员函数名
		Method [] m=o.getClass().getDeclaredMethods();//数组
//		打印
		for(int i=0;i<m.length;i++){
			System.out.println(m[i].getName());
		}
	}
}
class Bird{
	public void test1(){
		System.out.println("aa");
	}
	public void count(int a,int b){
		System.out.println(a+b);
	}
}