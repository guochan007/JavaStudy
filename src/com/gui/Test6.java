package com.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class Test6 extends JFrame{

	/**
	 * @param args
	 */
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test6 test=new Test6();
	}

	public Test6(){
		jp1=new JPanel();//jpanel默认是流式布局
		jp2=new JPanel();
		jb1=new JButton("西瓜1");
		jb2=new JButton("西瓜2");
		jb3=new JButton("西瓜3");
		jb4=new JButton("西瓜4");
		jb5=new JButton("西瓜5");
		jb6=new JButton("西瓜6");
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6);
		this.add(jp2,BorderLayout.SOUTH);
		this.setSize(300,150);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
