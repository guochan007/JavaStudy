package com.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThisClassEvent extends JFrame implements ActionListener {
	public ThisClassEvent() {
		setLayout(new FlowLayout());
		JButton btn = new JButton("ok");
		add(btn);
		btn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("The OK button is clicked");
	}

	public static void main(String args[]) {
		ThisClassEvent frame = new ThisClassEvent();
		frame.setTitle("自身类作为事件监听器");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 100);
		frame.setVisible(true);
		new ThisClassEvent();
	}
}