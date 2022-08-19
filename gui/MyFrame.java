package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	public MyFrame() {
		setSize(600,600);
		JPanel panel = new MyPanel();
		add(panel,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

}
