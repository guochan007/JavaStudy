//图片的拷贝
package com.io;
import java.io.*;
public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		先把图片读入到内存  再写入到某个文件    图片是二进制文件  用字节流
		File f=new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
//		输入流
		FileInputStream fis=null;
//		输出流
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(f);
			fos=new FileOutputStream("d:\\2.jpg");
			byte buf[]=new byte[1024];
			int n=0;
//			循环读取
			while((n=fis.read(buf))!=-1){
//				输出到指定文件
				fos.write(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
