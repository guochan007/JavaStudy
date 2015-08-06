package com.io;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Note extends JFrame implements ActionListener{
//	定义组件
	JTextField jta=null;
//	菜单
	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenuItem jmi1,jmi2=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Note nt=new Note();
	}

	public Note(){
		jta=new JTextField();
		jmb=new JMenuBar();
		jm1=new JMenu("file");
		jmi1=new JMenuItem("打开",new ImageIcon("1.jpg"));
		jmi2=new JMenuItem("保存");
//		注册监听
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2.setActionCommand("save");
		jmi2=new JMenuItem("保存");
//		设置助记符
		jm1.setMnemonic('F');
		
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		判断是按下哪个
		if(e.getActionCommand().equals("open")){
			System.out.println("open");
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("请选择文件");
			jfc1.showOpenDialog(null);//默认属性
			jfc1.setVisible(true);
//			得到用户选择文件的路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
//				从文件中读取信息并显示到jta
				String s="";
				String all="";
				while((s=br.readLine())!=null){
					System.out.println(s);
//					输出到
					all+=s+"\r\n";
				}
//				放到jta
				jta.setText(all);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		}else if(e.getActionCommand().equals("save")){
//			出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("请选择保存位置");
			jfc.showOpenDialog(null);//默认属性
			jfc.setVisible(true);
			
			String filename=jfc.getSelectedFile().getAbsolutePath();
//			写入到指定文件
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(filename);
				bw=new BufferedWriter(fw);
//				需要优化
				bw.write(this.jta.getText());
			} catch (Exception e2) {
				// TODO: handle exception
			}finally{
				try {
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		}
	}
}
