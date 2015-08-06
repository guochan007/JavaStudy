//缓冲字符流  一行一行读取
package com.io;

import java.io.*;

public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br=null;
		BufferedWriter bw=null;
//		先创建filereader对象
		FileReader fr;
		FileWriter fw;
		try {
			fr=new FileReader("d:\\aa.txt");
			fw=new FileWriter("d:\\bb.txt");
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			String s="";
			while((s=br.readLine())!=null){
				System.out.println(s);
//				输出到
//				bw.write(s);
				bw.write(s+"\r\n");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
