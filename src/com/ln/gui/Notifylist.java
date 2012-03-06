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
import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.ln.Configuration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Notifylist extends JFrame {	
	public static String[] Events = new String[Main.events];
	public static String[] Events2 = new String[Main.events];
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "rawtypes" })
	public static DefaultListModel model = new DefaultListModel();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JList list = new JList(model);

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notifylist frame = new Notifylist();
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
	@SuppressWarnings("unchecked")
	public Notifylist() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		setTitle("Event list");
		DateFormat dd = new SimpleDateFormat("dd");
		DateFormat dh = new SimpleDateFormat("HH");
		DateFormat dm = new SimpleDateFormat("mm");
		Date day = new Date();
		Date hour = new Date();
		Date minute = new Date();
		int dayd = Integer.parseInt(dd.format(day));
		int hourh = Integer.parseInt(dh.format(hour));
		int minutem = Integer.parseInt(dm.format(minute));
		
		int daydiff = dayd - Main.dayd;
		int hourdiff = hourh - Main.hourh;
		int mindiff = minutem - Main.minutem;
		
		model.clear();
		Events = new String[Main.events];
		Events2 = new String[Main.events];
//		Events = Main.Eventlist;
		for (int i = 0 ; i != Main.events ; i++){
			Events[i] = Main.Eventlist[i];
		}
		for (int i = 0 ; i != Main.events ; i++){
			Events2[i] = Main.Eventlist[i];
		}
		for (int i = 0 ; i != Events2.length ; i++){
			if (Events2[i] != null){
				Events2[i] = Main.Eventlist[i];
				Events2[i] = Events2[i].replace(StringUtils.substringBetween(Events2[i], "in: ", " Days"),
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events2[i], "in: ", " Days"))));
				Events2[i] = Events2[i].replace(StringUtils.substringBetween(Events2[i], "Days ", " Hours"), 
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events2[i], "Days ", " Hours"))));
				Events2[i] = Events2[i].replace(StringUtils.substringBetween(Events2[i], "Hours ", " Minutes"), 
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events2[i], "Hours ", " Minutes"))));
			
		}
			if (Events[i] != null){
				Events[i] = Main.Eventlist[i];
				Events[i] = Events[i].replace(StringUtils.substringBetween(Events[i], "in: ", " Days"),
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events[i], "in: ", " Days"))-daydiff));
				Events[i] = Events[i].replace(StringUtils.substringBetween(Events[i], "Days ", " Hours"), 
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events[i], "Days ", " Hours"))-hourdiff));
				Events[i] = Events[i].replace(StringUtils.substringBetween(Events[i], "Hours ", " Minutes"), 
						Integer.toString(Integer.parseInt(StringUtils.substringBetween(Events[i], "Hours ", " Minutes"))-mindiff));
				//Arrays.sort(Events);
				model.add(i, Events[i]);
			
		}
		}
		setBounds(100, 100, 671, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JButton Remove = new JButton("Remove selected");
		Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndices().length > 0) {
					int[] tmp = list.getSelectedIndices();
					Main.events = Main.events - tmp.length;
					 int[] selectedIndices = list.getSelectedIndices();
					 for (int i = tmp.length-1; i >=0; i--) {
					      selectedIndices = list.getSelectedIndices();
					      model.removeElementAt(selectedIndices[i]);
					     Events = ArrayUtils.remove(Events, selectedIndices[i]);
					     Events2 = ArrayUtils.remove(Events2, selectedIndices[i]);
					     Main.Eventlist = ArrayUtils.remove(Main.Eventlist, selectedIndices[i]);
					     //http://i.imgur.com/lN2Fe.jpg
					  } 
					} 
				}
		});
		Remove.setBounds(382, 258, 130, 25);
		contentPane.add(Remove);
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(522, 258, 130, 25);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		try{		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 642, 236);
			contentPane.add(scrollPane);
			list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			list.setBounds(10, 11, 642, 46);
			scrollPane.setViewportView(list);
			
			scrollPane.getVerticalScrollBar().setValue(0);
			
			}catch (NullPointerException e){}
}
}
