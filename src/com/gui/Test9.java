package com.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Test9 extends JFrame{

	/**
	 * @param args
	 */
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb1;
	JList jlist;
	JScrollPane jsp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test9 test=new Test9();
	}

	public Test9(){
		jp1=new JPanel();//jpanel默认是流式布局
		jp2=new JPanel();		
		
		jlb1=new JLabel("你的籍贯");
		jlb2=new JLabel("旅游地点");
		
		String []jg={"北京","上海","天津"};
		jcb1=new JComboBox(jg);
		
		String []dd={"九寨沟","峨眉山","故宫","天坛"};
		jlist=new JList(dd);//四项都显示出来了
	//		设置显示多少个选项	
		jlist.setVisibleRowCount(2);
		jsp=new JScrollPane(jlist);

		
			
	
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jlb1);
		jp1.add(jcb1);

		
		jp2.add(jlb2);
//		jp2.add(jlist);	
		jp2.add(jsp);	

				
		this.add(jp1);
		this.add(jp2);

		
		this.setSize(300,300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
