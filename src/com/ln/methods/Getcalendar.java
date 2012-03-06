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
 * This class get's the mirrored calendar from http://www.teamliquid.net/calendar/xml/calendar.xml
 * Note that no traffic is generated to teamliquid.net due to the page being mirrored to my own server
 */

package com.ln.methods;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

import com.ln.Configuration;

public class Getcalendar {
	public static String source;
	public static String Calendarurl = new String(Configuration.paths.CalendarURL);
	
	
	public static void Main(){
		//TODO store file locally and check if file changed == redownload
		try {
			
			//Get source
			// System.setProperty("http.agent", "lnrev2");
			URL calendar = new URL(Calendarurl);
			HttpURLConnection getsource = (HttpURLConnection) calendar.openConnection();
			InputStream in = new BufferedInputStream(getsource.getInputStream());
			//Write source
			Writer sw = new StringWriter();
			char[] b = new char[1024];
			Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			int n;
			while ((n = reader.read(b)) != -1){
				sw.write(b, 0, n);
			}
			//Source == String && Send source for parsing
	        Parser.source = sw.toString();
	        Betaparser.source = sw.toString();
	        String lol = sw.toString();
	        lol = StringUtils.substringBetween(lol, "<month year=\"2012\" num=\"2\">", "</month>");
	      //  Parser.source = lol;
			Parser.parse();
			Betaparser.parse();



		} catch (MalformedURLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
