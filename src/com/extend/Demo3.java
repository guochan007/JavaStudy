//方法重载
package com.extend;

public class Demo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abc abc=new Abc();
		System.out.println(abc.getMax(1, 2));
		System.out.println(abc.getMax(1.1f, 2.2f));
	}

}
class Abc{
//	返回较大的整数
	public int getMax(int i,int j){
		if(i>j){
			return i;
		}else{
			return j;
		}
	}
//	返回较大的小数
	public float getMax(float i,float j){
		if(i>j){
			return i;
		}else{
			return j;
		}
	}
//	仅仅返回类型不一样        不能构成重载
	public double getMax(float i,float j){
		if(i>j){
			return i;
		}else{
			return j;
		}
	}
}