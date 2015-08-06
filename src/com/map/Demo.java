package com.map;

import java.util.HashMap;
import java.util.Iterator;



public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hm=new HashMap();
		Emp emp1=new Emp("s01","aa",1.2f);
		Emp emp2=new Emp("s02","bb",2.2f);
		hm.put("s01", emp1);//一对一映射的存储key value
		hm.put("s02", emp2);
//		查找编号是 s02
		if(hm.containsKey("s02")){
			System.out.println("有该员工");
//			优点   不用遍历 就能取出
			Emp emp=(Emp) hm.get("s02");
			System.out.println("名字为"+emp.getName());
		}else{
			System.out.println("木有该员工");
		}
//		遍历hashmap中所有的key value
		/*for(int i=0;i<hm.size();i++){
			hm.g
		}*/
//		Iterator 迭代
		Iterator it=(Iterator) hm.keySet().iterator();
		while(it.hasNext()){//hashmap 自己里边存了多少东西，他自己不知道 所以试探一下 还有没有下一个了
//			取出key
			String key=it.next().toString();
//			通过key取出value
			Emp emp=(Emp) hm.get(key);
			System.out.println("名字："+emp.getName());
		}
	}
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