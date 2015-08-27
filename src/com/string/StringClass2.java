package com.string;

/*
有种说法是：我进行下验证
String a = "a"; //假设a指向地址0x0001 
a = "b";//重新赋值后a指向地址0x0002，但0x0001地址中保存的"a"依旧存在，但已经不再是a所指向的,a 已经指向了新的地址。 
因此String的操作都是改变赋值地址而不是改变值操作，所以效率低下，而且大量浪费有限的内存空间。
*/

public class StringClass2 {

	public static void main(String[] args) {
		String s = "begin";
		System.out.println(s.hashCode());
		s += "add";
		System.out.println(s.hashCode());
		
//		93616297
//		1489425240
		
		StringBuilder sb = new StringBuilder("begin");
		System.out.println(sb.hashCode());
		sb.append("add");
		System.out.println(sb.hashCode());
		
//		1284693
//		1284693
		
		
		
	}
}
