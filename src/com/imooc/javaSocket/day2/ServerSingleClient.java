package com.imooc.javaSocket.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */
public class ServerSingleClient {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			//1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			serverSocket=new ServerSocket(8888);
			System.out.println("***服务器即将启动，等待客户端的连接***");
			//2 调用accept()方法开始监听，等待客户端的连接，处于阻塞状态
			socket=serverSocket.accept();
			//获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);//将字节流转换为字符流
			br = new BufferedReader(isr);//为字符流添加缓冲
			String info=null;
			while((info=br.readLine())!=null){//循环读取客户端的信息
				System.out.println("我是服务器，客户端说："+info);
			}
			socket.shutdownInput();//关闭输入流
			//获取输出流，响应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("我是服务端qq，你好小王！欢迎您！");
			pw.flush();//调用flush()方法将缓冲输出
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(pw!=null){
					pw.close();
				}
				if(os!=null){
					os.close();
				}
				if(br!=null){
					br.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(is!=null){
					is.close();
				}
				if(serverSocket!=null){
					serverSocket.close();
				}
				if(socket!=null){
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
