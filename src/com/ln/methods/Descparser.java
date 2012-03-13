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
 * This class parses the description for selected event
 * Dispatches parsed desc into gui
 */

package com.ln.methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import ru.perm.kefir.bbcode.BBProcessorFactory;
import ru.perm.kefir.bbcode.TextProcessor;
import com.ln.gui.Main;

public class Descparser {
	public static int d2, h2, m2;
	public static String test = "", TTT = "";
	public static int DDD, HHH, MMM;
	//TODO parse urls, tlpd links, and other stuff
	//TODO get time, time also needs to be on titlebox
	public static void parsedesc(){
		String Desc = "";
		String Title = "";
		String Hour = "";
		String Minute = "";
		String formatted[] = new String[Betaparser.Description.length];
		int selectedindex = Main.Titlebox.getSelectedIndex();
		for (int i1 = 0 ; i1 != Betaparser.Hours.length ; i1++){
			if (Betaparser.Events[i1].startsWith(Main.monthday)){
				Desc = Desc + "¤"   + Betaparser.Description[i1] + "~";
				Title = Title + "¤"  + Betaparser.Title[i1] + "~";
				Hour = Hour + "¤"  + Betaparser.Hours[i1] + "~";
				Minute = Minute + "¤" + Betaparser.Minutes[i1] + "~";
			}
		}
		String[] Desc2 = StringUtils.substringsBetween(Desc, "¤", "~");
		String[] Title2 = StringUtils.substringsBetween(Title, "¤", "~");
		String[] Hour2 = StringUtils.substringsBetween(Hour, "¤", "~");
		String[] Minute2 = StringUtils.substringsBetween(Minute, "¤", "~");
		String[] Full = new String[Desc2.length];
		TTT = ""; DDD = 0; HHH = 0; MMM = 0;
		for (int i = 0 ; i != Title2.length ; i++){
			int h = Integer.parseInt(Hour2[i]);
			int m = Integer.parseInt(Minute2[i]);
			DateFormat df = new SimpleDateFormat("dd");
			DateFormat dm = new SimpleDateFormat("MM");
			Date month = new Date();
			Date today = new Date();
			int mon = Integer.parseInt(dm.format(month));
			int d = Integer.parseInt(df.format(today));
			int dif = 0;
			int ds = 0;
			int pastd = 0;
			int pasth = 0;
			int pastm = 0;
			d = Main.sdate - d;
			h = h-Parser.hour;
			m = m-Parser.minute;
			if (d > 0){
				ds = 1;
			}
			if (mon > Main.globmonth){
				dif = dif + 1;
			}
			if (Main.sdate > d){
				dif = dif + 1;
			}
			if (h < 0){
				pasth = Math.abs(h);
			}
			if (m < 0){
				pastm = Math.abs(m);
				h = h-1;
				m = m+60;
			}
			if (d < 0){
				pastd = d;
			}
			if (d > 0 && h < 0){
				d = d-1;
				h = h+24;
			}
			if (d == 0){formatted[i] = "<font size=\"4\" color=\"lime\"><br><b>Starts in: " + String.format("%01d Hours %01d Minutes", h, m) + "</b></font>";}
			if (d >= 1){formatted[i] = "<font size=\"4\" color=\"lime\"><br><b>Starts in: " + String.format("%01d Days %01d Hours %01d Minutes",d, h, m) + "</b></font>";}	
			if (pastd == 0 && h < 0){formatted[i] = "<font size=\"4\" color=\"#B00000\"><br><b>Event is finished/going on. Started " + String.format("%01d Hours %01d Minutes", pasth, pastm) + " Ago</b></font>";}
			if (pastd < 0 && h < 0){formatted[i] = "<font size=\"4\" color=\"#B00000\"><br><b>Event is finished/going on. Started " + String.format("%01d Days %01d Hours %01d Minutes", pastd, pasth, pastm) + " Ago</b></font>";}

		}
		
		for (int i = 0 ; i != Title2.length ; i++){
			Full[i] = Title2[i];
		
		}
		
		try{
		if (Desc2[selectedindex] != null){
		StringBuilder sb = new StringBuilder(Desc2[selectedindex]);
		int i = 0;
		while ((i = sb.indexOf(" ", i + 50)) != -1) {
		//	sb.replace(i, i + 1, "<br>");
			String formatteddesc =  sb.toString();
			formatteddesc = formatteddesc.replace("/forum/", "http://www.teamliquid.net/forum/");
			TextProcessor processor = BBProcessorFactory.getInstance().create(); 
			formatteddesc = processor.process(formatteddesc);
			formatteddesc = formatteddesc.replace("#T#", "").replace("#P#", "").replace("#Z#", "");
			formatteddesc = formatteddesc.replace("[tlpd#players", "[tlpd][cat]players[/cat]");
			formatteddesc = formatteddesc.replace("[/cat]#","[ID]");
			formatteddesc = formatteddesc.replace("sc2-korean]", "[/ID][region]sc2-korean[/region][name]").replace("sc2-international", "[/ID][region]sc2-international[/region][name]");
			formatteddesc = formatteddesc.replace("[/tlpd]", "[/name][/tlpd]");
			String[] tlpd = StringUtils.substringsBetween(formatteddesc, "[tlpd]", "[/tlpd]");
			String[] cat = StringUtils.substringsBetween(formatteddesc, "[cat]", "[ID]");
			String[] ids = StringUtils.substringsBetween(formatteddesc, "[ID]", "[/ID]");
			String[] names = StringUtils.substringsBetween(formatteddesc, "[name]", "[/name]");
			String[] region = StringUtils.substringsBetween(formatteddesc, "[region]", "[/region]");
			
			try{
				if (formatteddesc.contains("tlpd")){
				formatteddesc = formatteddesc.replace("[tlpd]", "").replace("[/tlpd]", "");	
			for (int i1 = 0 ; i1 != tlpd.length ; i1++){
				formatteddesc = formatteddesc.replace(tlpd[i1], "<a href=\"http://www.teamliquid.net/tlpd/" + cat[i1] + "/" + region[i1] + "/" + ids[i1] + "\">" + names[i1] + "</a>");			

		//	formatteddesc = formatteddesc.replace("[tlpd]", "").replace("[/tlpd]", "");		
			}
				}
			
			}catch(NullPointerException e){e.printStackTrace();}
			formatteddesc = formatteddesc.replace("&lt;", "").replace("gt;", "");
			Main.Description.setText((Full[selectedindex] + formatted[selectedindex] + "<br>" + formatteddesc));
			try{
			if (formatted[selectedindex].contains("lime")){
			String[] notfytime = new String[formatted.length];
			String[] form = new String[formatted.length];
			form[selectedindex] = formatted[selectedindex].replace("Starts in: ", "$€");
			notfytime[selectedindex] = StringUtils.substringBetween(form[selectedindex], "$", "</b>");
			if (formatted[selectedindex].contains("Days")){
				String DD = StringUtils.substringBetween(notfytime[selectedindex], "€", " Days");
				String HH = StringUtils.substringBetween(notfytime[selectedindex], "Days ", " Hours");
				String MM = StringUtils.substringBetween(notfytime[selectedindex], "Hours ", " Minutes");
				 DDD = Integer.parseInt(DD);
				 HHH = Integer.parseInt(HH);
				 MMM = Integer.parseInt(MM);
				 TTT = Full[selectedindex];
			}
			if (!formatted[selectedindex].contains("Days")){
			String HH = StringUtils.substringBetween(notfytime[selectedindex], "€", " Hours");
			String MM = StringUtils.substringBetween(notfytime[selectedindex], "Hours ", " Minutes");
			 HHH = Integer.parseInt(HH);
			 MMM = Integer.parseInt(MM);
			 TTT = Full[selectedindex];
			}
			}
			}catch (Exception e){e.printStackTrace();}
			Main.Description.setCaretPosition(0);
			
		}
		}
		
		}catch (IndexOutOfBoundsException e){e.printStackTrace();}



}
}