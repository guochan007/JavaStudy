//网格布局
package com.gui;

import java.awt.GridLayout;

import javax.swing.*;

public class Test5 extends JFrame{

	/**
	 * @param args
	 */
	int size=9;
//	JButton jbs[]=null;
	JButton jbs[]=new JButton[size];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test5 test=new Test5();
	}
	public Test5(){
		for(int i=0;i<size;i++){
			jbs[i]=new JButton(String.valueOf(i));
		}
		
		this.setLayout(new GridLayout(3,3));//3*3
		
		for(int i=0;i<size;i++){
			this.add(jbs[i]);
		}
		
		this.setTitle("网格布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
