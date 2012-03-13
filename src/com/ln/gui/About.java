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
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.io.IOException;
import java.net.URL;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import com.ln.Configuration;

public class About extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public About() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(161, 161, 161));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane dtrpnLiquidNotifyRevision = new JEditorPane();
		dtrpnLiquidNotifyRevision.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dtrpnLiquidNotifyRevision.setBackground(new Color(161, 161, 161));
		dtrpnLiquidNotifyRevision.setBounds(10, 72, 422, 366);
		dtrpnLiquidNotifyRevision.setContentType("text/html");
		dtrpnLiquidNotifyRevision.setEditable(false);
		dtrpnLiquidNotifyRevision.setText("<center>Notifies on upcoming Starcraft 2 and other events \r\nListed at <a href=\"http://www.teamliquid.net\">Teamliquid.net</a>\r\n<hr>\r\nUses following libraries: \r\n<table border=\"0\">\r\n<tr>\r\n<td><a href=\"http://commons.apache.org/lang/\">Commons lang v3</a></td>\r\n<td>\u00A9 2001-2011 The Apache Software Foundation</td>\r\n</tr>\r\n<td><a href=\"http://www.toedter.com/en/jcalendar/\">Jcalendar</a></td>\r\n<td>\u00A9 Kai Toedter 1999 - 2011</td>\r\n</tr><tr>\r\n<td><a href=\"http://www.pushing-pixels.org\">Substance</a></td>\r\n<td>\u00A9 2012 Pushing Pixels</td>\r\n</tr><tr>\r\n<td><a href=\"http://kenai.com/projects/trident/pages/Home\">Trident</a></td>\r\n<td> \u00A9 2010 Oracle Corporation and/or its affiliates</td>\r\n</tr><tr>\r\n<td><a href=\"http://sourceforge.net/projects/kefir-bb/\">Kefir bb</a></td>\r\n<td> \u00A9 2012 Geeknet, Inc.</td>\r\n</tr>\r\n<td><a href=\"http://www.javazoom.net/javalayer/javalayer.html\">JLayer</a></td>\r\n<td>Licensed under: <a href=\"http://www.gnu.org/licenses/lgpl.html\">LGPL</a></td>\r\n</td></tr></table> \r\n<hr>\r\nThanks to:\r\n<br><a href=\"http://www.teamliquid.net/forum/profile.php?user=R1CH\">R1CH</a> For the idea and original application:\r\n<a href=\"http://www.teamliquid.net/forum/viewmessage.php?topic_id=54821\">Teamliquid.net thread</a>\r\n<br><a href=\"http://www.teamliquid.net\">Teamliquid</a>\r\n<br>You for using!\r\n<hr>\r\nReleased under: <a href=\"http://www.gnu.org/licenses/gpl-3.0-standalone.html\">GPL V3</a> \u00A9 2012-2105 Jiiks\r\n<br>\r\nContact: <a href=\"mailto:jiiks@windowslive.com\">jiiks@windowslive.com</a>\r\n</center>\r\n\r\n\r\n");
		contentPane.add(dtrpnLiquidNotifyRevision);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		lblNewLabel.setBounds(0, 0, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Liquid Notify Revision 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(74, 0, 263, 61);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Version 0.22");
		lblNewLabel_2.setBounds(76, 50, 76, 14);
		contentPane.add(lblNewLabel_2);
		HyperlinkListener hyperlinkListener = new ActivatedHyperlinkListener(
		        this, dtrpnLiquidNotifyRevision);
		dtrpnLiquidNotifyRevision.addHyperlinkListener(hyperlinkListener);
	}
}

class ActivatedHyperlinkListener1 implements HyperlinkListener {
	 Frame frame;

	  JEditorPane editorPane;
	  public ActivatedHyperlinkListener1(Frame frame, JEditorPane editorPane) {
		    this.frame = frame;
		    this.editorPane = editorPane;
		  }
	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			URL url = e.getURL();
			String u = url.toString();
			 try {java.awt.Desktop.getDesktop().browse(java.net.URI.create(u));
			 } catch (IOException e1) {
				 e1.printStackTrace();
			 }
			 }
	}
	
	
}
