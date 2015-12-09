package com.math.calculate;

//测试 >  >>  >>>区别   貌似没有<<<
/*
>表示大于，如：if(a>b)...结果是boolean类型
>>表示右移，如：int i=15; i>>2的结果是3，移出的部分将被抛弃。
转为二进制的形式可能更好理解，0000 1111(15)右移2位的结果是0000 0011(3)，0001 1010(18)右移3位的结果是0000 0011(3)。
>>>叫什么我也不是很清楚，但是我知道它表示的含义：
j>>>i 与 j/(int)(Math.pow(2,i))的结果相同，其中i和j是整形。
*/
public class DaYuHao123 {

	public static void main(String[] args) {
		System.out.println("15 >> 2 = " + (15 >> 2));
		
		System.out.println();
		System.out.println(4 / (int) (Math.pow(2, 0)));   
		System.out.println(4 >>> 0);  
		System.out.println();
		System.out.println(4 / (int) (Math.pow(2, 1)));   
		System.out.println(4 >>> 1);  
		System.out.println();
		System.out.println(4 / (int) (Math.pow(2, 2)));   
		System.out.println(4 >>> 2);  
		System.out.println();
		System.out.println(4 / (int) (Math.pow(2, 3)));   
		System.out.println(4 >>> 3);  
		System.out.println();
	}

}
