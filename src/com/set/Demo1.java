package com.set;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
public class Demo1 {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		Emp emp1=new Emp("s01","aa",1.2f);
		Emp emp2=new Emp("s02","bb",2.2f);
//		加在最前面  或最后面  此功能是arraylist没有的
		ll.addFirst(emp1);
		ll.addFirst(emp2);
		for(int i=0;i<ll.size();i++){
			System.out.println(((Emp)ll.get(i)).getName());
		}
	}*/
	
//	vector的用法
	public static void main(String[] args) {
		Vector vv=new Vector();
		Emp emp1=new Emp("1","aa",1.2f);
		vv.add(emp1);
		for(int i=0;i<vv.size();i++){
			System.out.println(((Emp)vv.get(i)).getName());
		}		
	}

//	Stack stack=new Stack();
	
}
//雇员类
class Emp{
	private String empNo;
	private String name;
	private float sal;
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	//	构造函数
	public Emp(String empNo,String name,float sal){
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
}