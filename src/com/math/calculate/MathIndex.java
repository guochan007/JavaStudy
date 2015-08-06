package com.math.calculate;

public class MathIndex {

	/**
	 * 计算指数，测试字节长度
	 */
	public static void main(String[] args) {
		
		int result=index(2,6)+index(2,5)+index(2,4)+index(2,3)+index(2,2)+index(2,1)+index(2,0);
		int result1=index(2,7)+index(2,6)+index(2,5)+index(2,4)+index(2,3)+index(2,2)+index(2,1)+index(2,0);
		System.out.println(result);
		System.out.println(result1);
	}

//	x的y次幂
	public static int index(int x,int y){
		int result=1;
		for(int i=y;i>0;i--){
			result*=x;
		}
		return result;
	}
}
