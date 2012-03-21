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

package com.ln;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.pushingpixels.substance.api.skin.*;
import com.ln.gui.Main;
import com.ln.methods.Newsreader;

public class Boot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boot frame = new Boot();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Boot() {
		if (!Configuration.config.exists()){
			Configuration.config.mkdir();
		}
		Properties settings = new Properties();
		String load = Configuration.mydir + "/resources/config.cfg";
		try {
			FileInputStream is = new FileInputStream(load);
			settings.load(is);	
			Configuration.popup = Integer.parseInt(settings.getProperty("Popupenabled"));
			Configuration.autoupdate = Integer.parseInt(settings.getProperty("Autoupdate"));
			Configuration.notifytime = Integer.parseInt(settings.getProperty("Notifytime"));
			Configuration.autorefresh = Integer.parseInt(settings.getProperty("AutoRefresh"));
			Configuration.refreshtime = Integer.parseInt(settings.getProperty("Refreshtime"));
			Configuration.soundnotify = Integer.parseInt(settings.getProperty("Soundnotify"));
			Configuration.theme = Integer.parseInt(settings.getProperty("Theme"));
			Configuration.soundpath = settings.getProperty("Soundpath");
			is.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Config file not found", "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Missing config parameters, download latest cfg from github", "Error", JOptionPane.ERROR_MESSAGE);
			try {
				URL cfg = new URL("https://github.com/Jiiks/Liquid-Notify-Rev2/blob/master/resources/config.cfg");
				String u = cfg.toString();
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(u));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try{
		switch(Configuration.theme){	
		case 0:
			UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());Configuration.theme = 0;
				break;
		case 1:
			UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());Configuration.theme = 1;
				break;
		case 2:
			UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());Configuration.theme = 2;
				break;
		case 3:
			UIManager.setLookAndFeel(new SubstanceCremeCoffeeLookAndFeel());Configuration.theme = 3;
				break;
		case 4:
			UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());Configuration.theme = 4;
				break;
		case 5:
			UIManager.setLookAndFeel(new SubstanceDustLookAndFeel());Configuration.theme = 5;
				break;
		case 6:
			UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());Configuration.theme = 6;
				break;
		case 7:
			UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());Configuration.theme = 7;
				break;
		case 8:
			UIManager.setLookAndFeel(new SubstanceGeminiLookAndFeel());Configuration.theme = 8;
				break;
		case 9:
			UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());Configuration.theme = 9;
				break;
		case 10:
			UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());Configuration.theme = 10;
				break;
		case 11:
			UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());Configuration.theme = 11;
				break;
		case 12:
			UIManager.setLookAndFeel(new SubstanceMagellanLookAndFeel());Configuration.theme = 12;
				break;
		case 13:
			UIManager.setLookAndFeel(new SubstanceMarinerLookAndFeel());Configuration.theme = 13;
				break;
		case 14:	
			UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());Configuration.theme = 14;
				break;
		case 15:	
			UIManager.setLookAndFeel(new SubstanceMistSilverLookAndFeel());Configuration.theme = 15;
				break;
		case 16:	
			UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());Configuration.theme = 16;
				break;
		case 17:	
			UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());Configuration.theme = 17;
				break;
		case 18:
			UIManager.setLookAndFeel(new SubstanceNebulaBrickWallLookAndFeel());Configuration.theme = 18;
				break;
		case 19:
			UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());Configuration.theme = 19;
				break;
		case 20:
			UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());Configuration.theme = 20;
				break;
		case 21:
			UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());Configuration.theme = 21;
				break;
		case 22:
			UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());Configuration.theme = 22;
				break;
		case 23:
			UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());Configuration.theme = 23;				
				break;
		case 24:
			UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());Configuration.theme = 24;
				break;
		case 25:
			UIManager.setLookAndFeel(new SubstanceTwilightLookAndFeel());Configuration.theme = 25;
				break;
		default:
			UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());Configuration.theme = 11;
				break;
		}
		}catch (Exception e){}		
		setDefaultLookAndFeelDecorated(true);

		Newsreader.Main();
		@SuppressWarnings("rawtypes")
		Main frame = new Main();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		dispose();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
