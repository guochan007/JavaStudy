package com.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Test8 extends JFrame{

	/**
	 * @param args
	 */
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	
	JTextField jtf1;
	JPasswordField jpf1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test8 test=new Test8();
	}

	public Test8(){
		jp1=new JPanel();//jpanel默认是流式布局
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("你喜欢的运动");
		jlb2=new JLabel("你的性别");
		jb1=new JButton("注册");
		jb2=new JButton("取消");
		
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("蓝球");
		jcb3=new JCheckBox("网球");
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
//		一定要把jrb1 jrb2放入到一个buttongroup中进行管理
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);		
	
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
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
