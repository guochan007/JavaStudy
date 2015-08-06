//流式布局
package com.gui;

import java.awt.FlowLayout;

import javax.swing.*;

public class Test4 extends JFrame{

	/**
	 * @param args
	 */
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test4 test = new Test4();
	}
	public Test4(){
		jb1=new JButton("关羽");
		jb2=new JButton("张飞");
		jb3=new JButton("赵云");
		jb4=new JButton("马超");
		jb5=new JButton("黄忠");
		jb6=new JButton("魏延");
		
//		设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.LEFT));//默认 空白居中对齐
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		this.setTitle("流式布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		禁止用户改变窗体大小
		this.setResizable(false);
	}
}
