//文件字符流
package com.io;

import java.io.*;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		输入流
		FileReader fr=null;
//		输出流
		FileWriter fw=null;
		try {
			fr=new FileReader("d:\\aa.txt");
			fw=new FileWriter("d:\\bb.txt");
			int n=0;
//			读入到内存
			char c[]=new char[1024];
			while((n=fr.read(c))!=-1){
				String s=new String(c,0,n);
				System.out.println(c);
				System.out.println(s);
//				fw.write(c);//有乱码
				fw.write(c,0,n);
			}
			fr.read(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
