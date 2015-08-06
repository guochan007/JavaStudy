package com.test;

public class TryCatch {

	/**
	 *测试try里运行时有错，能不能捕获异常
	 */
	public static void main(String[] args) {
		try {
//			int i=1/0;
			String str="abc";
			int i=Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println("执行这里");
		}
	}

}
