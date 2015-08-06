//面向过程思想
package com.gui;

import javax.swing.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		jframe是一个顶层容器类  可以放其他swing组件的类
		JFrame jf=new JFrame();
		JButton jb=new JButton("我是按钮");
		
//		给窗体设置标题
		jf.setTitle("Hello");
//		设置大小 像素  像素是一个密度单位 没有说1像素等于几个毫米
		jf.setSize(200,200);
		
//		添加jbutton组件
		jf.add(jb);//发现按钮占了全部窗口
		
//		设置初始位置
		jf.setLocation(800, 500);
//		由于点了x并没用让javaw.exe完全退出    所以让其点x时 jvm程序也关闭
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
