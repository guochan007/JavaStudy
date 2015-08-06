//fileinputstream类的使用
package com.io;

import java.io.*;

public class Test1 {

	/**
	 * 读取某文件里的数据
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		得到一个文件对象
		File f=new File("d:\\aa.txt");
//		System.out.println(f.length());
//		file没有读写能力 所以需要使用inputstream流
		FileInputStream fis=null;
		try {			
//			定义一个字节数组 相当于缓存 一点一点读进来 一下都进来 内存放不下
			byte [] bytes=new byte[1024];
			fis=new FileInputStream(f);
			int n=0;//得到实际读取到的字节数
//			循环读取
			while((n=fis.read(bytes))!=-1){//读完了
//				把字节转成string
				String s=new String(bytes,0,n);
				System.out.println(s);
//				System.out.println(s.length());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			关闭文件流
			try {
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
