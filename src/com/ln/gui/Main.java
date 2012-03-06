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

/* Class info
 * Teamliquid Notify Revision 2
 * 
 * 
 * Released under GNU GENERAL PUBLIC LICENSE V3
 * http://www.gnu.org/licenses/gpl.txt
 * 
 * © Jiiks@Teamliquid.net || https://github.com/Jiiks || Jiiks@windowslive.com
 * 
 * Orignal application by R1CH http://www.teamliquid.net/forum/viewmessage.php?topic_id=54821
 * 
 */

package com.ln.gui;



import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingWorker;

import com.ln.Configuration;
import com.ln.methods.Betaparser;
import com.ln.methods.Descparser;
import com.ln.methods.Getcalendar;
import com.ln.methods.Parser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import java.awt.Point;
import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EtchedBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.ImageIcon;

@SuppressWarnings("rawtypes")
public class Main<notifierthread> extends JFrame implements ActionListener, Comparable {
private static final long serialVersionUID = 1L;

//Always declare components for easy time
//Declare components
	private static JPanel contentPane = new JPanel();
	private static JTextArea NewsArea = new JTextArea();
	private static JMenuBar menuBar = new JMenuBar();	
	private static JMenu File = new JMenu("File");
	public static JComboBox Titlebox;
	public final static JEditorPane Description = new JEditorPane();
	public final static JScrollPane Descriptionscrollpane = new JScrollPane();
	public static JFrame f = new JFrame();
	private final JButton Refreshbtn = new JButton("Refresh");
	private final JPanel panel = new JPanel();
	private final JMenuItem Exit = new JMenuItem("Exit");
	public static String[] stringarr = {"a", "z", "b"};
	public static int[] intarra = {5, 4, 2};
	public static int[] intarrb = {0, 7, 1};
	JMenuItem Update = new JMenuItem("Check for updates");
//Declare variables
	public static String News = "";
	public static int second = 1000, minute = second*60, hour = minute*60, day = hour*24, week = day*7;
	public static int fonp = 0;
	public static int sdate = 0;
	public static int month = 1;
	public static int today = 0;
	public static int aupd = 0, refresh = 0;
	public static String monthstring;
	public static String datestring;
	public static String monthday;
	public static String[] Descs;
	public static int globmonth;
	public static URL url;
	public static String[] ff;
	private final JButton Notify = new JButton("Notify");
	private final Component verticalStrut = Box.createVerticalStrut(20);
	private final JButton eventsbtn = new JButton("Events currently set to notify");
	public static String NOTIFY;
	public static String[] NOA = new String[1000], Eventlist = new String[1000];
	public static int NOTIFYD, NOTIFYH, NOTIFYM;
	public static int[] NOD = new int[1000], NOH = new int[1000], NOM = new int[1000];
	public static int events = 0;
	public static String ee;
	public static int dayd, hourh, minutem;
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createandshowgui();
				} catch (Exception e) {		
					//Kill&print on errors
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", JOptionPane.WARNING_MESSAGE);	
				}
			}
		});
	}
	public void gg(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					f.setState(NORMAL);
					f.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(rootPane, ee, "Event Starting!", JOptionPane.INFORMATION_MESSAGE);
					f.setAlwaysOnTop(false);
					if (Configuration.soundnotify == 1){
						try {
							InputStream is = new FileInputStream(Configuration.soundpath);
							Player asd = new Player(is);
							asd.play();
						} catch (JavaLayerException e1) {
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}catch (Exception e){				
				}
			}
		});
	}
	public void swingupd(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
		String av="Updates available!";
		JOptionPane pane1 = new JOptionPane(av, JOptionPane.WARNING_MESSAGE,
		JOptionPane.DEFAULT_OPTION);
		JDialog dialog1 = pane1.createDialog("Update");
		dialog1.setLocationRelativeTo(null);
		dialog1.setVisible(true);
		dialog1.setAlwaysOnTop(true);		
		Updatechecker upd = new Updatechecker();
		upd.setVisible(true);
		upd.setLocationRelativeTo(rootPane);
		upd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}catch (Exception e){				
			}
		}
	});
}

	//Create GUI	
	public static void createandshowgui(){
		f = new Main();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln6464.png"));
		DateFormat dd = new SimpleDateFormat("dd");
		DateFormat dh = new SimpleDateFormat("HH");
		DateFormat dm = new SimpleDateFormat("mm");
		Date day = new Date();
		Date hour = new Date();
		Date minute = new Date();
		dayd = Integer.parseInt(dd.format(day));
		hourh = Integer.parseInt(dh.format(hour));
		minutem = Integer.parseInt(dm.format(minute));	
		setTitle("Liquid Notify Revision 2");
		Description.setBackground(Color.WHITE);
		Description.setContentType("text/html");
		Description.setEditable(false);
		Getcalendar.Main();
		HyperlinkListener hyperlinkListener = new ActivatedHyperlinkListener(
		        f, Description);
		    Description.addHyperlinkListener(hyperlinkListener);
		//Add components
		setContentPane(contentPane);
		setJMenuBar(menuBar);
		contentPane.setLayout(new MigLayout("", "[220px:230.00:220,grow][209.00px:n:5000,grow]", "[22px][][199.00,grow][grow]"));
		eventsbtn.setToolTipText("Displays events currently set to notify");
		eventsbtn.setMinimumSize(new Dimension(220, 23));
		eventsbtn.setMaximumSize(new Dimension(220, 23));	
		contentPane.add(eventsbtn, "cell 0 0");
		NewsArea.setBackground(Color.WHITE);
		NewsArea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		NewsArea.setMinimumSize(new Dimension(20, 22));
		NewsArea.setMaximumSize(new Dimension(10000, 22));
		contentPane.add(NewsArea, "cell 1 0,growx,aligny top");
		menuBar.add(File);	
		JMenuItem Settings = new JMenuItem("Settings");
		Settings.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\settings.png"));
		Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings setup = new Settings();
				setup.setVisible(true);
				setup.setLocationRelativeTo(rootPane);
			}
		});
		File.add(Settings);
		Tray.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\ln1616.png"));
		File.add(Tray);
		Exit.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\exit.png"));
		File.add(Exit);
		
		menuBar.add(mnNewMenu);
		
		Update.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\update.png"));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					URL localURL = new URL("http://jiiks.net23.net/tlnotify/online.html");
					URLConnection localURLConnection = localURL.openConnection();
					BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localURLConnection.getInputStream()));
					String str = localBufferedReader.readLine();
					if (!str.contains("YES")){
						String st2221="Updates server appears to be offline";
						JOptionPane pane1 = new JOptionPane(st2221, JOptionPane.WARNING_MESSAGE,
						JOptionPane.DEFAULT_OPTION);
						JDialog dialog1 = pane1.createDialog("Update");
						dialog1.setLocationRelativeTo(null);
						dialog1.setVisible(true);
						dialog1.setAlwaysOnTop(true);
					}else if (str.contains("YES")){
					URL localURL2 = new URL("http://jiiks.net23.net/tlnotify/latestversion.html");
					URLConnection localURLConnection1 = localURL2.openConnection();
					BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader(localURLConnection1.getInputStream()));
					String str2 = localBufferedReader2.readLine();
					Updatechecker.latestver = str2;
					if (Integer.parseInt(str2) <= Configuration.version){
						String st2221="No updates available =(";
						JOptionPane pane1 = new JOptionPane(st2221, JOptionPane.WARNING_MESSAGE,
						JOptionPane.DEFAULT_OPTION);
						JDialog dialog1 = pane1.createDialog("Update");
						dialog1.setLocationRelativeTo(null);
						dialog1.setVisible(true);
						dialog1.setAlwaysOnTop(true);
					}else if (Integer.parseInt(str2) > Configuration.version){
						String st2221="Updates available!";
						JOptionPane pane1 = new JOptionPane(st2221, JOptionPane.WARNING_MESSAGE,
						JOptionPane.DEFAULT_OPTION);
						JDialog dialog1 = pane1.createDialog("Update");
						dialog1.setLocationRelativeTo(null);
						dialog1.setVisible(true);
						dialog1.setAlwaysOnTop(true);
						
						Updatechecker upd = new Updatechecker();
						upd.setVisible(true);
						upd.setLocationRelativeTo(rootPane);
						upd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
					}
					}catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				
		});
		mnNewMenu.add(Update);		
		JMenuItem About = new JMenuItem("About");
		About.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\about.png"));
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About a = new About();
				a.setVisible(true);
				a.setLocationRelativeTo(rootPane);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(About);	
		JMenuItem Github = new JMenuItem("Github");
		Github.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\github.png"));
		Github.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://github.com/Jiiks/Liquid-Notify-Rev2";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(Github);		
		JMenuItem Thread = new JMenuItem("Thread");
		Thread.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\liquid.png"));
		Thread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "http://www.teamliquid.net/forum/viewmessage.php?topic_id=318184";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(Thread);
		Refreshbtn.setToolTipText("Refreshes calendar, please don't spam ^_^");
		Refreshbtn.setPreferredSize(new Dimension(90, 20));
		Refreshbtn.setMinimumSize(new Dimension(100, 20));
		Refreshbtn.setMaximumSize(new Dimension(100, 20));	
		contentPane.add(Refreshbtn, "flowx,cell 0 1,alignx left");
		//Components to secondary panel	
		Titlebox = new JComboBox();
		contentPane.add(Titlebox, "cell 1 1,growx,aligny top");
		Titlebox.setMinimumSize(new Dimension(20, 20));
		Titlebox.setMaximumSize(new Dimension(10000, 20));
		//Set other
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 342);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		NewsArea.setEnabled(false); NewsArea.setEditable(false); NewsArea.setText("News: " + News);
		contentPane.add(panel, "cell 0 2,grow");
		panel.setLayout(null);
		final JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().setPreferredSize(new Dimension(120, 20));
		calendar.getMonthChooser().setMinimumSize(new Dimension(120, 24));
		calendar.getYearChooser().setLocation(new Point(20, 0));
		calendar.getYearChooser().setMaximum(100);
		calendar.getYearChooser().setMaximumSize(new Dimension(100, 2147483647));
		calendar.getYearChooser().setMinimumSize(new Dimension(50, 20));
		calendar.getYearChooser().setPreferredSize(new Dimension(50, 20));
		calendar.getYearChooser().getSpinner().setPreferredSize(new Dimension(100, 20));
		calendar.getYearChooser().getSpinner().setMinimumSize(new Dimension(100, 20));
		calendar.getMonthChooser().getSpinner().setPreferredSize(new Dimension(119, 20));
		calendar.getMonthChooser().getSpinner().setMinimumSize(new Dimension(120, 24));
		calendar.getDayChooser().getDayPanel().setFont(new Font("Tahoma", Font.PLAIN, 11));
		calendar.setDecorationBordersVisible(true);
		calendar.setTodayButtonVisible(true);
		calendar.setBackground(Color.LIGHT_GRAY);
		calendar.setBounds(0, 0, 220, 199);
		calendar.getDate();
		calendar.setWeekOfYearVisible(false);
		calendar.setDecorationBackgroundVisible(false);
		calendar.setMaxDayCharacters(2);
		calendar.getDayChooser().setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(calendar);	
		Descriptionscrollpane.setLocation(new Point(100, 100));
		Descriptionscrollpane.setMaximumSize(new Dimension(10000, 10000));
		Descriptionscrollpane.setMinimumSize(new Dimension(20, 200));	
		Description.setLocation(new Point(100, 100));
		Description.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		Description.setMaximumSize(new Dimension(1000, 400));
		Description.setMinimumSize(new Dimension(400, 200));	
		contentPane.add(Descriptionscrollpane, "cell 1 2 1 2,growx,aligny top");
		Descriptionscrollpane.setViewportView(Description);
		verticalStrut.setMinimumSize(new Dimension(12, 20));
		contentPane.add(verticalStrut, "cell 0 1");
		Notify.setToolTipText("Adds selected event to notify event list.");
		Notify.setHorizontalTextPosition(SwingConstants.CENTER);
		Notify.setPreferredSize(new Dimension(100, 20));
		Notify.setMinimumSize(new Dimension(100, 20));
		Notify.setMaximumSize(new Dimension(100, 20));
		contentPane.add(Notify, "cell 0 1,alignx right");
		calendar.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				month = calendar.getMonthChooser().getMonth();
				Parser.parse();
			}
		});
		

		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				try{
					int h = calendar.getMonthChooser().getMonth();
					@SuppressWarnings("deprecation")
					int date = calendar.getDate().getDate();
					int month = calendar.getMonthChooser().getMonth() + 1;
					globmonth = calendar.getMonthChooser().getMonth();
					sdate = date;
					datestring = Integer.toString(sdate);
					monthstring = Integer.toString(month);
					String[] Hours = Betaparser.Hours;
					String[] Titles =  Betaparser.STitle;
					String[] Full = new String[Hours.length];
					String[] Minutes = Betaparser.Minutes;
					String[] Des = Betaparser.Description;
					String[] Des2 = new String[Betaparser.Description.length];
					String Seconds = "00";
					String gg;
					int[] IntHours = new int[Hours.length];
					int[] IntMins = new int[Hours.length];
					int Events = 0;
					monthday = monthstring + "|" + datestring + "|";
					Titlebox.removeAllItems();
					for (int a = 0 ; a != Hours.length ; a++){
						IntHours[a] = Integer.parseInt(Hours[a]);
						IntMins[a] = Integer.parseInt(Minutes[a]);
					}					
					for (int i1 = 0 ; i1 != Hours.length ; i1++){
						if (Betaparser.Events[i1].startsWith(monthday)){
							Full[i1] = String.format("%02d:%02d", IntHours[i1], IntMins[i1]) + " | " + Titles[i1];
							Titlebox.addItem(Full[i1]);					
						}
					}
				}catch (Exception e1){
					//Catching mainly due to boot property change				
				}
			}
		});
		Image image = Toolkit.getDefaultToolkit().getImage(Configuration.mydir + "\\resources\\icons\\ln1616.png");
		
		//.setIcon(new ImageIcon(Configuration.mydir + "\\resources\\icons\\
		final SystemTray tray = SystemTray.getSystemTray();
		ActionListener listener = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            setVisible(true);
	        }
	    };
	    PopupMenu popup = new PopupMenu();
	    MenuItem defaultItem = new MenuItem();
	    defaultItem.addActionListener(listener);
	    TrayIcon trayIcon = null;
	    trayIcon = new TrayIcon(image, "LiquidNotify Revision 2", popup);
	    
	    trayIcon.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mouseClicked(MouseEvent arg0){
	    		setVisible(true);
	    	}
	    });//
	    try {
	        tray.add(trayIcon);
	    } catch (AWTException e) {
	        System.err.println(e);
	    }
	    if (trayIcon != null) {
	        trayIcon.setImage(image);
	    }
		
		Tray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		
		Titlebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						Descparser.parsedesc();	
			}		
		});
		
		Refreshbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Getcalendar.Main();
				Descparser.parsedesc();	
			}
		});
		
		Notify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NOTIFY = Descparser.TTT;
				NOTIFYD = Descparser.DDD;
				NOTIFYH = Descparser.HHH;
				NOTIFYM = Descparser.MMM;
				int i = events;
				NOA[i] = NOTIFY;
				NOD[i] = NOTIFYD;
				NOH[i] = NOTIFYH;
				NOM[i] = NOTIFYM;
				Eventlist[i] = "Starts in: " + Integer.toString(NOD[i]) + " Days " + Integer.toString(NOH[i]) + " Hours " + Integer.toString(NOM[i]) + " Minutes " + " | " + NOA[i];
				events = events + 1;
				Notifylist si = new Notifylist();
				si.setVisible(false);
				si.setBounds(1, 1, 1, 1);
				si.dispose();
				thread.execute();
				
				
				}
		});


		
		eventsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Notifylist list = new Notifylist();
				list.setVisible(true);
				list.setLocationRelativeTo(rootPane);
				list.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		
		
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Absolute exit
				JOptionPane.showMessageDialog(rootPane, "Bye bye :(", "Exit", JOptionPane.INFORMATION_MESSAGE);
				Runtime ln = Runtime.getRuntime();
				ln.gc();
				final Frame[] allf = Frame.getFrames();
				final Window[] allw = Window.getWindows();
				for (final Window allwindows : allw){
					allwindows.dispose();
				}
				for (final Frame allframes : allf) {
					allframes.dispose();
					System.exit(0);			
				}
			}
		});

		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}

	@Override
	public int compareTo(Object obj)
    {
         if (obj instanceof Main)
         {

         }
         return 0;
    }
	public  SwingWorker thread = new SwingWorker<notifierthread, Void>(){
		public notifierthread doInBackground() throws InterruptedException{	
			while ( true ){
				if (Configuration.autorefresh == 1){
					refresh = refresh + 1;
					if (refresh == Configuration.refreshtime){
						Refreshbtn.doClick();
						refresh = 0;
					}
					
				}
				if (Configuration.autoupdate == 1){
					aupd = aupd+1;
					if (aupd >= 15){
						URL localURL2;
						try {
							localURL2 = new URL("http://jiiks.net23.net/tlnotify/latestversion.html");
						URLConnection localURLConnection1 = localURL2.openConnection();
						BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader(localURLConnection1.getInputStream()));
						String str2 = localBufferedReader2.readLine();
						Updatechecker.latestver = str2;
						if (Integer.parseInt(str2) > Configuration.version){
							swingupd();	
						}
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						aupd = 0;
					}
				}
				try{
					DateFormat dd = new SimpleDateFormat("dd");
					DateFormat dh = new SimpleDateFormat("HH");
					DateFormat dm = new SimpleDateFormat("mm");
					Date day2 = new Date();
					Date hour2 = new Date();
					Date minute2 = new Date();
					int dayd2 = Integer.parseInt(dd.format(day2));
					int hourh2 = Integer.parseInt(dh.format(hour2));
					int minutem2 = Integer.parseInt(dm.format(minute2));
					
					int daydiff = dayd2 - dayd;
					int hourdiff = hourh2 - hourh;
					int mindiff = minutem2 - minutem;
				for (int i = 0 ; i != Notifylist.Events2.length ; i++){
					int day[] = new int[Notifylist.Events2.length];
					int hour[] = new int[Notifylist.Events2.length];
					int minute[] = new int[Notifylist.Events2.length];
					String title[] = new String[Notifylist.Events2.length];
					title[i] = StringUtils.substringAfter(Notifylist.Events2[i], "|");
					if (Notifylist.Events2[i] != null && Notifylist.Events2[i].contains("Days")){
					day[i] = Integer.parseInt(StringUtils.substringBetween(Notifylist.Events[i], "in: ", " Days"))-daydiff;
					}else day[i] = 0;
					hour[i] = Integer.parseInt(StringUtils.substringBetween(Notifylist.Events2[i], "Days ", " Hours"))-hourdiff;
					minute[i] = Integer.parseInt(StringUtils.substringBetween(Notifylist.Events2[i], "Hours ", " Minutes"))-mindiff;
					if (day[i] == 0 && hour[i] == 0 && minute[i] < Configuration.notifytime && minute[i] > 0){
						ee = "Starts in "+Integer.toString(minute[i])+" minutes: | " + title[i];
						minute[i] = minute[i] - 1;
						gg();
					}
				}
				}catch (Exception e){}
				Thread.sleep(minute);
				//Thread.sleep(second*5);
				
				
			}
			
			
		}
	};
	private final JMenuItem Tray = new JMenuItem("Send to tray");
	private final JMenu mnNewMenu = new JMenu("Help");
}


class ActivatedHyperlinkListener implements HyperlinkListener {
	 Frame frame;

	  JEditorPane editorPane;
	  public ActivatedHyperlinkListener(Frame frame, JEditorPane editorPane) {
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


