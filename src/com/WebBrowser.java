package com;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.net.*;
import java.io.*;



public class WebBrowser{
	private JFrame frame;
	private JPanel jpanel;
	private JEditorPane editor;
	private JScrollPane scroll;
	private JTextField field;
	private JButton button;
	private URL url;
	//xong
		
	public WebBrowser(String title) {
		initComponents();
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.getContentPane().add(BorderLayout.NORTH, jpanel);
		jpanel.add(field);		
		jpanel.add(button);
		frame.getContentPane().add(BorderLayout.CENTER, scroll);
		frame.setVisible(true);
	}
		
			private void initComponents() {
				frame = new JFrame();
				jpanel = new JPanel();
				try {
					url = new URL("https://www.google.com/");
				} catch (MalformedURLException mue) {
					JOptionPane.showConfirmDialog(null, mue);
				}
				try {
					editor =  new JEditorPane(url);
					
					editor.setEditable(false);
				} catch (IOException e) {
					JOptionPane.showConfirmDialog(null, e);
				}
				
				// Proccess when click button
				button = new JButton("Go URL");
				button.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							editor.setPage(field.getText());
						} catch (IOException e2) {
							JOptionPane.showConfirmDialog(null, e2);
						}
					}
				});
				
				scroll = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				field = new JTextField();
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						field.setText(url.toString());	
					}
				});	
		
			}
	
			public static void main(String[] args) {
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						new WebBrowser("Web Hacking Browser");
					}
				});
			}

}
	
