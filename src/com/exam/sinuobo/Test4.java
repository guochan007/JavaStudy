//di 6 ti
package com.exam.sinuobo;

public class Test4 {

	public int aMethod(){
		static int i=0;
//		int i=0;
		i++;
		return i;
	}
	public static void main(String[] args) {
		Test4 test4=new Test4();
		test4.aMethod();
		int j=test4.aMethod();
		System.out.println(j);
	}

}
