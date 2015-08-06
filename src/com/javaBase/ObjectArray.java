//对象数组的使用
package com.javaBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ObjectArray {

	/**
	 * @param args
	 */
//	程序如有异常 则抛出异常 不理它？
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		定义一个对象数组 存放四只狗
		Dog dogs[]=new Dog[4];
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		for(int i=0;i<4;i++){
			dogs[i]=new Dog();
			System.out.println("enter dog"+(i+1)+" name");
//			从控制台读取狗名
			String name=br.readLine();
//			将名字赋给对象
			dogs[i].setName(name);
			System.out.println("enter dog"+(i+1)+" weight");
			String weight1=br.readLine();
//			string转成float
			float weight=Float.parseFloat(weight1);
			dogs[i].setWeight(weight);
		}

	//	计算平均体重
		float allWeight=0;
		for(int i=0;i<4;i++){
			allWeight+=dogs[i].getWeight();
		}
		float avgWeight=allWeight/dogs.length;
		System.out.println("总体重="+allWeight+"平均体重"+avgWeight);
//		找出体重最大的狗
		float maxWeight=dogs[0].getWeight();
		int maxIndex=0;
//		按顺序依次和后面的狗比较
		for(int i=1;i<dogs.length;i++){
			if(maxWeight<dogs[i].getWeight()){
//				改变最大的体重
				maxWeight=dogs[i].getWeight();
				maxIndex=i;
			}
		}
		System.out.println("体重最大的狗是第"+(maxIndex+1)+"只"+"体重为"+maxWeight);
	}

}

class Dog{
	private String name;
	private float weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}