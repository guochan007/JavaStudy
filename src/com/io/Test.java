package com.io;

import java.io.*;

public class Test {

	/**
	 * 创建文件 文件夹
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		创建文件对象
		File f=new File("D:\\aa.txt");
//		得到文件的路径
		System.out.println(f.getAbsolutePath());
//		得到文件大小    字节
		System.out.println(f.length());
//		可读 f.canRead()
//		创建文件 文件夹
		File f=new File("D:\\aa.txt");
		if(!f.exists()){
			f.createNewFile();
		}else{
			System.out.println("存在该文件");
		}
//		创建文件夹
		File f=new File("d:\\ff");
		if(f.isDirectory()){
			System.out.println("文件夹存在");
		}else{
			f.mkdir();
		}
//		列出一个文件夹下所有文件
		File f=new File("d:\\ff");
		if(f.isDirectory()){
			File lists[]=f.listFiles();
			for(int i=0;i<lists.length;i++){
				System.out.println(lists[i].getName());
			}
		}
		
		
	}

}
