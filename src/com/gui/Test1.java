package com.gui;

import javax.swing.*;
//面向对象
public class Test1 extends JFrame {

	/**
	 * @param args
	 */
	JButton jb=null;//定义组件
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1=new Test1();
	}
//	构造函数
	public Test1(){
		//创建组件
		jb=new JButton("button");
//		给窗体设置标题
		this.setTitle("Hello");
//		设置大小 像素  像素是一个密度单位 没有说1像素等于几个毫米
		this.setSize(200,200);		
//		添加jbutton组件
		this.add(jb);//发现按钮占了全部窗口		
//		设置初始位置
		this.setLocation(800, 500);
//		由于点了x并没用让javaw.exe完全退出    所以让其点x时 jvm程序也关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
