package com.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Test7 extends JFrame{

	/**
	 * @param args
	 */
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test7 test=new Test7();
	}

	public Test7(){
		jp1=new JPanel();//jpanel默认是流式布局
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("用户名");
		jlb2=new JLabel("密码");
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		
		jtf1=new JTextField(10);
		jpf1=new JPasswordField(10);
		
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jpf1);
		jp3.add(jb1);
		jp3.add(jb2);
				
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setSize(300,150);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
