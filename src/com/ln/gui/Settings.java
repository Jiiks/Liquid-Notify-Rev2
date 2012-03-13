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


import javax.swing.*;
import java.io.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.ln.Configuration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import org.pushingpixels.substance.api.skin.*;
import java.awt.Dimension;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Settings<play> extends JFrame {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	static Settings frame = new Settings();
	final JSpinner spinner = new JSpinner();
	final JCheckBox chckbxNewCheckBox = new JCheckBox("");
	final JSpinner spinner_1 = new JSpinner();
	final JCheckBox Soundcheck = new JCheckBox("");
	final SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 60, 1);
	final SpinnerNumberModel model2 = new SpinnerNumberModel(5, 5, 60, 1);
	final JCheckBox Autoupdate = new JCheckBox("");
	final JCheckBox Popup = new JCheckBox("");
	public Player asd;
	public int stop = 0;
	

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Settings() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		spinner.setModel(model);
		spinner_1.setModel(model2);
		setTitle("Settings");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox Themebox = new JComboBox();
		Themebox.setModel(new DefaultComboBoxModel(new String[] {"Autumn", "Black Steel", "Blue Steel", "Creme Coffee", "Deep", "Dust", "Dust Coffee", "Emerald", "Gemini", "Graphite", "Graphite Aqua", "Graphite Glass", "Magellan", "Mariner", "Mist Aqua", "Mist Silver", "Moderate", "Nebula", "Nebula Brick", "Office Black", "Office Blue", "Office Silver", "Raven", "Sahara", "Steel", "Twilight"}));
		Themebox.setBounds(102, 10, 240, 20);
		contentPane.add(Themebox);
		
		JLabel Themelabel = new JLabel("Theme:");
		Themelabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Themelabel.setBounds(10, 10, 58, 20);
		contentPane.add(Themelabel);
		Themebox.setSelectedIndex(Configuration.theme);
		if (Configuration.popup == 1){Popup.setSelected(false);}
		if (Configuration.popup == 0){Popup.setSelected(true);}
		if (Configuration.autoupdate == 1){Autoupdate.setSelected(true);}
		if (Configuration.autoupdate == 0){Autoupdate.setSelected(false);}
		if (Configuration.autorefresh == 1){chckbxNewCheckBox.setSelected(true);}
		if (Configuration.autorefresh == 0){chckbxNewCheckBox.setSelected(false);}
		if (Configuration.soundnotify == 1){Soundcheck.setSelected(true);}
		if (Configuration.soundnotify == 0){Soundcheck.setSelected(false);}
		spinner.setValue(Configuration.notifytime);
		spinner_1.setValue(Configuration.refreshtime);

		
		
		
		
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Popup.isSelected()){
					Configuration.popup = 0;
				}else if (!Popup.isSelected()){
					Configuration.popup = 1;
				}
				if (Autoupdate.isSelected()){
					Configuration.autoupdate = 1;
				}else if (!Autoupdate.isSelected()){
					Configuration.autoupdate = 0;
				}
				if (chckbxNewCheckBox.isSelected()){
					Configuration.autorefresh = 1;
				}else if (!chckbxNewCheckBox.isSelected()){
					Configuration.autorefresh = 0;
				}
				if (Soundcheck.isSelected()){
					Configuration.soundnotify = 1;
				}else if (!Soundcheck.isSelected()){
					Configuration.soundnotify = 0;
				}
				Configuration.refreshtime = Integer.parseInt(spinner_1.getValue().toString());
				Configuration.notifytime = Integer.parseInt(spinner.getValue().toString());
				try{
					if (Themebox.getSelectedIndex() == 0){UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());Configuration.theme = 0;}
					if (Themebox.getSelectedIndex() == 1){UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());Configuration.theme = 1;}
					if (Themebox.getSelectedIndex() == 2){UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());Configuration.theme = 2;}
					if (Themebox.getSelectedIndex() == 3){UIManager.setLookAndFeel(new SubstanceCremeCoffeeLookAndFeel());Configuration.theme = 3;}
					if (Themebox.getSelectedIndex() == 4){UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());Configuration.theme = 4;}
					if (Themebox.getSelectedIndex() == 5){UIManager.setLookAndFeel(new SubstanceDustLookAndFeel());Configuration.theme = 5;}
					if (Themebox.getSelectedIndex() == 6){UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());Configuration.theme = 6;}
					if (Themebox.getSelectedIndex() == 7){UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());Configuration.theme = 7;}
					if (Themebox.getSelectedIndex() == 8){UIManager.setLookAndFeel(new SubstanceGeminiLookAndFeel());Configuration.theme = 8;}
					if (Themebox.getSelectedIndex() == 9){UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());Configuration.theme = 9;}
					if (Themebox.getSelectedIndex() == 10){UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());Configuration.theme = 10;}
					if (Themebox.getSelectedIndex() == 11){UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());Configuration.theme = 11;}
					if (Themebox.getSelectedIndex() == 12){UIManager.setLookAndFeel(new SubstanceMagellanLookAndFeel());Configuration.theme = 12;}
					if (Themebox.getSelectedIndex() == 13){UIManager.setLookAndFeel(new SubstanceMarinerLookAndFeel());Configuration.theme = 13;}
					if (Themebox.getSelectedIndex() == 14){UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());Configuration.theme = 14;}
					if (Themebox.getSelectedIndex() == 15){UIManager.setLookAndFeel(new SubstanceMistSilverLookAndFeel());Configuration.theme = 15;}
					if (Themebox.getSelectedIndex() == 16){UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());Configuration.theme = 16;}
					if (Themebox.getSelectedIndex() == 17){UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());Configuration.theme = 17;}
					if (Themebox.getSelectedIndex() == 18){UIManager.setLookAndFeel(new SubstanceNebulaBrickWallLookAndFeel());Configuration.theme = 18;}
					if (Themebox.getSelectedIndex() == 19){UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());Configuration.theme = 19;}
					if (Themebox.getSelectedIndex() == 20){UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());Configuration.theme = 20;}
					if (Themebox.getSelectedIndex() == 21){UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());Configuration.theme = 21;}
					if (Themebox.getSelectedIndex() == 22){UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());Configuration.theme = 22;}
					if (Themebox.getSelectedIndex() == 23){UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());Configuration.theme = 23;}				
					if (Themebox.getSelectedIndex() == 24){UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());Configuration.theme = 24;}
					if (Themebox.getSelectedIndex() == 25){UIManager.setLookAndFeel(new SubstanceTwilightLookAndFeel());Configuration.theme = 25;}
					setDefaultLookAndFeelDecorated(true);
					BufferedWriter save = new BufferedWriter(new FileWriter(Configuration.mydir + "/resources/config.cfg"));
					save.write("Autoupdate=" + Integer.toString(Configuration.autoupdate));
					save.newLine();
					save.write("Notifytime=" + Integer.toString(Configuration.notifytime));
					save.newLine();
					save.write("AutoRefresh=" + Integer.toString(Configuration.autorefresh));
					save.newLine();
					save.write("Refreshtime=" + Integer.toString(Configuration.refreshtime));
					save.newLine();
					save.write("Soundnotify=" + Integer.toString(Configuration.soundnotify));
					save.newLine();
					save.write("Popupenabled=" + Integer.toString(Configuration.popup));
					save.newLine();
					save.write("Theme=" + Integer.toString(Configuration.theme));
					save.newLine();
					String sound = Configuration.soundpath.replace("\\", "\\\\");
					save.write("Soundpath=" + sound);
					save.close();
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
				}
		});
		SaveButton.setBounds(10, 221, 77, 23);
		contentPane.add(SaveButton);
		
		JLabel Notifylabel = new JLabel("Notify");
		Notifylabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Notifylabel.setBounds(10, 40, 58, 20);
		contentPane.add(Notifylabel);
		
		spinner.setBounds(102, 40, 55, 20);
		contentPane.add(spinner);
		
		JLabel Notifylabel2 = new JLabel("Minutes before event starts");
		Notifylabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Notifylabel2.setBounds(167, 40, 191, 20);
		contentPane.add(Notifylabel2);
		
		JLabel AutoRefreshLabel = new JLabel("Auto refresh");
		AutoRefreshLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AutoRefreshLabel.setBounds(10, 70, 77, 20);
		contentPane.add(AutoRefreshLabel);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBox.setBorder(null);

		chckbxNewCheckBox.setBounds(97, 71, 20, 20);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel Autorefreshlabel2 = new JLabel("Every:");
		Autorefreshlabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Autorefreshlabel2.setBounds(10, 100, 68, 20);
		contentPane.add(Autorefreshlabel2);

		spinner_1.setBounds(102, 100, 55, 20);
		contentPane.add(spinner_1);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinutes.setBounds(167, 100, 66, 20);
		contentPane.add(lblMinutes);
		
		JButton btnDefault = new JButton("Default");
		btnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Themebox.setSelectedIndex(11);
				Autoupdate.setSelected(false);
				chckbxNewCheckBox.setSelected(false);
				Soundcheck.setSelected(false);
				spinner.setValue(5);
				spinner_1.setValue(5);
			}
		});
		btnDefault.setBounds(95, 221, 77, 23);
		contentPane.add(btnDefault);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(265, 221, 77, 23);
		contentPane.add(btnClose);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Themebox.setSelectedIndex(Configuration.theme);
				if (Configuration.autoupdate == 1){Autoupdate.setSelected(true);}
				if (Configuration.autoupdate == 0){Autoupdate.setSelected(false);}
				if (Configuration.autorefresh == 1){chckbxNewCheckBox.setSelected(true);}
				if (Configuration.autorefresh == 0){chckbxNewCheckBox.setSelected(false);}
				if (Configuration.soundnotify == 1){Soundcheck.setSelected(true);}
				if (Configuration.soundnotify == 0){Soundcheck.setSelected(false);}
				spinner.setValue(Configuration.notifytime);
				spinner_1.setValue(Configuration.refreshtime);
			}
		});
		btnDiscard.setBounds(180, 221, 77, 23);
		contentPane.add(btnDiscard);
		
		JLabel lblSoundOnNotify = new JLabel("Notify sound");
		lblSoundOnNotify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoundOnNotify.setBounds(10, 130, 85, 20);
		contentPane.add(lblSoundOnNotify);
		Soundcheck.setHorizontalTextPosition(SwingConstants.CENTER);
		Soundcheck.setHorizontalAlignment(SwingConstants.CENTER);
		Soundcheck.setBorder(null);
		//Soundcheck.setToolTipText("Player is currently not threaded.\r\nSo avoid too long sound clips."); is now threaded

		Soundcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Soundcheck.isSelected()){
					try{
					File f = new File(new File("./resources").getCanonicalPath());
					String filename = File.separator+"tmp";
					JFileChooser fc = new JFileChooser(new File(filename));
					fc.setCurrentDirectory(f);
					 FileNameExtensionFilter filter = new FileNameExtensionFilter(
						        "Supported Audio Files", "mp3");
						    fc.setFileFilter(filter);
					fc.showOpenDialog(rootPane);
					File selFile = fc.getSelectedFile();
					Configuration.soundpath = selFile.getPath();
					}catch (Exception e){}
				}
			}
		});
		Soundcheck.setBounds(97, 131, 20, 20);
		contentPane.add(Soundcheck);
		final JButton buttonstop = new JButton("");
		final JButton btnNewButton = new JButton("");
		//btnNewButton.setToolTipText("Player is currently not threaded.\r\nSo avoid too long sound clips."); is now threaded
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\play1.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\play2.png"));
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\play2.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.execute();
				stop = 0;
				buttonstop.setEnabled(true);
				btnNewButton.setEnabled(false);
				buttonstop.setVisible(true);
				btnNewButton.setVisible(false);
			}
		});
		btnNewButton.setPreferredSize(new Dimension(59, 20));
		btnNewButton.setMaximumSize(new Dimension(59, 20));
		btnNewButton.setMinimumSize(new Dimension(59, 20));
		btnNewButton.setBounds(126, 131, 20, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Auto check for updates");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 160, 150, 20);
		contentPane.add(lblNewLabel);
		
		Autoupdate.setToolTipText("");
		Autoupdate.setHorizontalTextPosition(SwingConstants.CENTER);
		Autoupdate.setHorizontalAlignment(SwingConstants.CENTER);
		Autoupdate.setBounds(167, 162, 20, 20);
		contentPane.add(Autoupdate);
		
		JLabel lblDisablePopupNotify = new JLabel("Disable popup notify");
		lblDisablePopupNotify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisablePopupNotify.setBounds(10, 190, 150, 20);
		contentPane.add(lblDisablePopupNotify);
		
		Popup.setToolTipText("");
		Popup.setHorizontalTextPosition(SwingConstants.CENTER);
		Popup.setHorizontalAlignment(SwingConstants.CENTER);
		Popup.setBounds(167, 190, 20, 20);
		contentPane.add(Popup);
		
		buttonstop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!asd.isComplete()){
					buttonstop.setEnabled(false);
					btnNewButton.setEnabled(true);
					buttonstop.setVisible(false);
					btnNewButton.setVisible(true);
					asd.close();
					stop = 1;
				}
			}
		});
		buttonstop.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\stop.png"));
		//buttonstop.setToolTipText("Player is currently not threaded.\r\nSo avoid too long sound clips."); is now threaded
		buttonstop.setPreferredSize(new Dimension(59, 20));
		buttonstop.setOpaque(false);
		buttonstop.setMinimumSize(new Dimension(59, 20));
		buttonstop.setMaximumSize(new Dimension(59, 20));
		buttonstop.setContentAreaFilled(false);
		buttonstop.setBorderPainted(false);
		buttonstop.setBounds(126, 131, 20, 20);
		contentPane.add(buttonstop);
	}
	public  SwingWorker player = new SwingWorker<play, Void>(){
		public play doInBackground() throws InterruptedException{	
			while ( true ){
				try {
					InputStream is = new FileInputStream(Configuration.soundpath);
					asd = new Player(is);
					if (stop == 0){
					asd.play();
					}
				} catch (JavaLayerException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(rootPane, "No sound set/Invalid path", "File not found", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			}
	};
}
