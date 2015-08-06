package com.javaBase;

import java.text.DecimalFormat;

public class TestJavaFloat {

	/**
	 * 保留小数点后两位
	 */
	public static void main(String[] args) {
		int a =1;
		int b =3;
		
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足. 
		String result=decimalFormat.format((float)a/b*100);
		System.out.println(result);
	}

}
