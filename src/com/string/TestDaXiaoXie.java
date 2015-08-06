package com.string;

public class TestDaXiaoXie {

	/**
	 * 测试大小写转换
	 * 
	 * “让大写的换小写，小写的换大写 如果是任意的字符串，那么需要转成字符数组，用string.tochararray()。然后根据ascII的值进行比较”
	 */
	public static void main(String[] args) {

		String str="ABCdef";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}

}
