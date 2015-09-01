package com.io;

import java.io.*;

public class WriteToFileEnd {

	/**
	 * 读取read.txt写入到write.txt末尾
	 */
	public static void main(String[] args) {

		// 字节输入流
		FileInputStream fis = null;
		RandomAccessFile randomAccessFile = null;
		try {
			// 打开一个随机访问文件流，按读写方式
			randomAccessFile = new RandomAccessFile("d:\\write.txt", "rw");
			// 文件长度，字节数
			long fileLength = randomAccessFile.length();
			// 将写文件指针移到文件尾。
			randomAccessFile.seek(fileLength);

			File fileRead = new File("d:\\read.txt");
			// 定义一个字节数组 相当于缓存 一点一点读进来 一下都进来 内存放不下
			byte[] bytes = new byte[1024];
			fis = new FileInputStream(fileRead);
			int n = 0;// 得到实际读取到的字节数
			// 循环读取
			while ((n = fis.read(bytes)) != -1) {// 读完了
				// 把字节转成string
				String str = new String(bytes, 0, n);
				randomAccessFile.writeBytes(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				randomAccessFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
