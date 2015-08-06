package com.exception;

import java.io.FileReader;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father father=new Father();
		father.test1();
	}

}
class Father{
	private Son son=null;
	public Father(){
		son=new Son();
	}
	public void test1(){//一层一层抛异常  最后抛到了虚拟机那里
		System.out.println("1");
		try{//儿子犯得错  让他老子去处理了
			son.test2();
		}catch(Exception e){
			System.out.println("father hadling");
			e.printStackTrace();
		}		
	}
}
class Son{
	public void test2() throws Exception{
		FileReader fr=null;
		fr=new FileReader("d://dd.txt");
	}
}