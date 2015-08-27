package com.string;

public class StringStringBufferStringBuilder {
	
	final static int time = 30; // 通常情况循环次数
//	final static int time = 500; // 最慢1ms
//	final static int time = 50000; // 循环次数

	public void test(String s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			s += "add";
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + s.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}

	public void test(StringBuffer s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			s.append("add");
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + s.getClass().getCanonicalName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}

	public void test(StringBuilder s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			s.append("add");
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + s.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}

	public static void main(String[] args) {
		String s1 = "head";
		StringBuffer s2 = new StringBuffer("head");
		StringBuilder s3 = new StringBuilder("head");
		StringStringBufferStringBuilder intance = new StringStringBufferStringBuilder();
		intance.test(s1);
		intance.test(s2);
		intance.test(s3);
	}
}
