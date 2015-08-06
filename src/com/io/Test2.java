//fileoutputstream
package com.io;
import java.io.*;
public class Test2 {

	/**
	 * 写入某文件
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f=new File("d:\\ss.txt");
//		字节输出流
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(f);
			String s="hello\r\n";
			String s1="world";
			/*
//			定义字节数组
			byte []bytes=new byte[1024];
//			把string转化为bytes数组
			*/
			
			fos.write(s.getBytes());
			fos.write(s1.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
