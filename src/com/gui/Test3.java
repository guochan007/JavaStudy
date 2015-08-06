//borderlayout jframe默认为边界布局
package com.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class Test3 extends JFrame{

	/**
	 * @param args
	 */
//	定义组件
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test3 test=new Test3();
	}
//	构造函数
	public Test3(){
//		创建组件
		jb1=new JButton("中部");
		jb2=new JButton("北部");
		jb3=new JButton("东部");
		jb4=new JButton("南部");
		jb5=new JButton("西部");
//	添加组件
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.EAST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5, BorderLayout.WEST);
//		设置窗体参数
		this.setTitle("边界布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
