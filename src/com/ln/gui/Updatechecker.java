/*
    Copyright (C) 2012  Jiiks

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ln.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ln.Configuration;

import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updatechecker extends JFrame {

	private static final long serialVersionUID = 1L;

	public static String latestver = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatechecker frame = new Updatechecker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Updatechecker() {
		setResizable(false);
		setTitle("Update");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String url = "http://jiiks.net23.net/tlnotify/changes.html";
		try{
		contentPane.setLayout(new MigLayout("", "[][738.00px,grow,fill]", "[231.00px,top][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 0,grow");
		JEditorPane editorPane = new JEditorPane(url);
		scrollPane.setViewportView(editorPane);
		editorPane.setContentType("text/html");
		editorPane.setEditable(false);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(422, 11, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					URL DOWNLOAD = new URL("http://jiiks.net23.net/tlnotify/down/Latest.jar");
					ReadableByteChannel rbc = Channels.newChannel(DOWNLOAD.openStream());
					FileOutputStream fos = new FileOutputStream(Configuration.mydir + "/LiquidNotifyRev2-" + latestver + ".jar");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					JOptionPane.showMessageDialog(null, "Download ready! Program will now exit");
					System.exit(0);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Update.setBounds(323, 11, 89, 23);
		panel.add(Update);
		}catch(IOException e){
			JOptionPane.showMessageDialog(rootPane, "Unable to display url/page not found: " + url);
			
		}
	}
}
