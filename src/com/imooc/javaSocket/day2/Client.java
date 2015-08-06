package com.imooc.javaSocket.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		OutputStream os=null;
		PrintWriter pw=null;
		InputStream is=null;
		BufferedReader br=null;
		
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket=new Socket("localhost", 8888);
			//2.获取输出流，向服务器端发送信息
			os=socket.getOutputStream();//字节输出流
			pw=new PrintWriter(os);//将输出流包装为打印流  字节流转换为字符流
			pw.write("你好服务端,我是客户端小王!");
			pw.flush();//向服务端输出数据
			socket.shutdownOutput();//关闭输出流
			//3.获取输入流，并读取服务器端的响应信息
			is=socket.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器说："+info);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源
			try {
				if(br!=null){
					br.close();
				}
				if(is!=null){
					is.close();
				}
				if(pw!=null){
					pw.close();
				}
				if(os!=null){
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
