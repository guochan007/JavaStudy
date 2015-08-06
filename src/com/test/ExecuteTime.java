package com.test;

import java.util.Date;

public class ExecuteTime {

	/**
	 * 观察执行时间
	 */
	public static void main(String[] args) {

		ExecuteTime e1 = new ExecuteTime();
		ExecuteTime e2 = new ExecuteTime();
		ExecuteTime e3 = new ExecuteTime();
		ExecuteTime e4 = new ExecuteTime();
		ExecuteTime e5 = new ExecuteTime();

		long rs = (e1.shiJianCha() + e2.shiJianCha() + e3.shiJianCha()
				+ e4.shiJianCha() + e5.shiJianCha()) / 5;
		System.out.println("avg=" + rs);//925ms 而html中的js执行要花费4024ms  nodejs执行花费2712
	}

	public long shiJianCha() {
		long i, a, b, c, max;
		max = 1000000000;
		Date d1 = new Date();
		for (i = 0; i < max; i++) {
			a = 1234 + 5678 + i;
			b = 1234 * 5678 + i;
			c = 1234 / 2 + i;
		}
		// 日期没法直接相减
		Date d2 = new Date();
		long result = d2.getTime() - d1.getTime();
		System.out.println(result);
		return result;
	}

}
