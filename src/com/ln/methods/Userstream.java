package com.ln.methods;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ln.gui.Main;

public class Userstream extends Main {

	private static final long serialVersionUID = 1L;
	public static String ss, ss2;
	public static String sc2 = "http://www.twitch.tv/directory/StarCraft%20II:%20Wings%20of%20Liberty";
	public static String bw = "http://www.twitch.tv/directory/StarCraft:%20Brood%20War";
	public static void Main(){
		try {
			URL streams = new URL(sc2);
			URL bwstreams = new URL(bw);
			HttpURLConnection getstreams = (HttpURLConnection) streams.openConnection();
			HttpURLConnection getbwstreams = (HttpURLConnection) bwstreams.openConnection();
			InputStream in = new BufferedInputStream(getstreams.getInputStream());
			InputStream in2 = new BufferedInputStream(getbwstreams.getInputStream());
			Writer sw = new StringWriter();
			Writer sw2 = new StringWriter();
			char[] b = new char[1024];
			char[] c = new char[1024];
			Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			Reader reader2 = new BufferedReader(new InputStreamReader(in2, "UTF-8"));
			int n, n2;
			while ((n = reader.read(b)) != -1){
				sw.write(b, 0, n);
			}
			while ((n2 = reader2.read(c)) != -1){
				sw2.write(c, 0, n2);
			}
			ss = sw.toString();
			ss2 = sw2.toString();				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
