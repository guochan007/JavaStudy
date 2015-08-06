package com.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Test {
	/**
	 * 异常 打开不存在文件
	 */
	public static void main(String[] args) {
//		FileReader fr=new FileReader("d:\\aa.test");
//		连接一个端口
//		Socket s=new Socket("192.168.1.23",78);
		
//		运行异常
//		int a=4/0;
//		int arr[]={1,2,3};
//		System.out.println(arr[3]);
		
		FileReader fr=null;
		try {
			fr=new FileReader("d:\\aa.test");
		} catch (FileNotFoundException e) {//(Exception e)异常的最大类
			e.printStackTrace();
			System.exit(-1);//程序退出  后面的finally的就没机会执行了
		}finally{//不管有没有异常 都会执行    通常在这里关闭文件 连接 内存
			System.out.println("enter finally");
			if(fr!=null){//如果 fr打开状态
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
