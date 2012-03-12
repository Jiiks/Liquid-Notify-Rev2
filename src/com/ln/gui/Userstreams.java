package com.ln.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import org.apache.commons.lang3.ArrayUtils;

import com.ln.Configuration;
import com.ln.methods.Userstream;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Userstreams extends JFrame {
	public static int streams = 0;

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userstreams frame = new Userstreams();
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
	public Userstreams() {
		Userstream.Main();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		setTitle("UserStreams");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Stream Name"
			}
		));
		table.setBounds(0, 0, 337, 134);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 337, 134);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				streams = 1;
				check();
			}
		});
		Save.setBounds(10, 145, 89, 23);
		contentPane.add(Save);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(240, 145, 89, 23);
		contentPane.add(btnClose);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				streams = 0;
			}
		});
		btnStop.setBounds(125, 145, 89, 23);
		contentPane.add(btnStop);
		
}
	public static void check(){
		Userstream.Main();
		int x = 0;
		for (int i = 0 ; i != 50 ; i++){
			if (table.getValueAt(i, 0) != null){
				x++;
				String[] asd = new String[x];
				asd[i] = table.getValueAt(i, 0).toString();
				try{
				if (Userstream.ss.contains(asd[i]) || Userstream.ss2.contains(asd[i])){
					JOptionPane.showMessageDialog(null, asd[i] + " is now live!", "Stream live", JOptionPane.INFORMATION_MESSAGE);
				}
				}catch (Exception e1){e1.printStackTrace();}
			}
		}
	}
}

