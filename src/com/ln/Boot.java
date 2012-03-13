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
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.pushingpixels.substance.api.skin.*;
import com.ln.gui.Main;

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
		}
		try{
			if (Configuration.theme == 0){UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());Configuration.theme = 0;}
			if (Configuration.theme == 1){UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());Configuration.theme = 1;}
			if (Configuration.theme == 2){UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());Configuration.theme = 2;}
			if (Configuration.theme == 3){UIManager.setLookAndFeel(new SubstanceCremeCoffeeLookAndFeel());Configuration.theme = 3;}
			if (Configuration.theme == 4){UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());Configuration.theme = 4;}
			if (Configuration.theme == 5){UIManager.setLookAndFeel(new SubstanceDustLookAndFeel());Configuration.theme = 5;}
			if (Configuration.theme == 6){UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());Configuration.theme = 6;}
			if (Configuration.theme == 7){UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());Configuration.theme = 7;}
			if (Configuration.theme == 8){UIManager.setLookAndFeel(new SubstanceGeminiLookAndFeel());Configuration.theme = 8;}
			if (Configuration.theme == 9){UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());Configuration.theme = 9;}
			if (Configuration.theme == 10){UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());Configuration.theme = 10;}
			if (Configuration.theme == 11){UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());Configuration.theme = 11;}
			if (Configuration.theme == 12){UIManager.setLookAndFeel(new SubstanceMagellanLookAndFeel());Configuration.theme = 12;}
			if (Configuration.theme == 13){UIManager.setLookAndFeel(new SubstanceMarinerLookAndFeel());Configuration.theme = 13;}
			if (Configuration.theme == 14){UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());Configuration.theme = 14;}
			if (Configuration.theme == 15){UIManager.setLookAndFeel(new SubstanceMistSilverLookAndFeel());Configuration.theme = 15;}
			if (Configuration.theme == 16){UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());Configuration.theme = 16;}
			if (Configuration.theme == 17){UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());Configuration.theme = 17;}
			if (Configuration.theme == 18){UIManager.setLookAndFeel(new SubstanceNebulaBrickWallLookAndFeel());Configuration.theme = 18;}
			if (Configuration.theme == 19){UIManager.setLookAndFeel(new SubstanceOfficeBlack2007LookAndFeel());Configuration.theme = 19;}
			if (Configuration.theme == 20){UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());Configuration.theme = 20;}
			if (Configuration.theme == 21){UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());Configuration.theme = 21;}
			if (Configuration.theme == 22){UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());Configuration.theme = 22;}
			if (Configuration.theme == 23){UIManager.setLookAndFeel(new SubstanceSaharaLookAndFeel());Configuration.theme = 23;}				
			if (Configuration.theme == 24){UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());Configuration.theme = 24;}
			if (Configuration.theme == 25){UIManager.setLookAndFeel(new SubstanceTwilightLookAndFeel());Configuration.theme = 25;}
			setDefaultLookAndFeelDecorated(true);
		}
		catch(Exception e){			
		}
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
