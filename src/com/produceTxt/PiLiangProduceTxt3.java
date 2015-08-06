//计算公卫各表随访次数
package com.produceTxt;

import java.io.File;
import java.io.FileOutputStream;

public class PiLiangProduceTxt3 {

	static File f = new File("e:\\批量生成txt.txt");
	static FileOutputStream fos = null;// 字节输出流

	public static void main(String[] args) {

		try {
			System.out.println("start");
			fos = new FileOutputStream(f);
			String str ="";
//			for(int i=1;i<=230;i++){
			for(int i=231;i<=400;i++){
				System.out.println(i);
				str = "<f name='c"+i+"' type='-5' table='assesshospital'/>";
				fos.write(str.getBytes());
				String s = "\r\n";
				fos.write(s.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				System.out.println("over");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
