package com.string;
//测试javap
public class StringClass {
	

	public void test(String s) {
		for (int i = 0; i < 3000; i++) {
			s += "add";
		}
	}
}
