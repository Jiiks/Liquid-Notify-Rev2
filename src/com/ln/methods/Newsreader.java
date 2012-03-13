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

import org.apache.commons.lang3.StringUtils;

import com.ln.gui.Main;

public class Newsreader {
	public static String url = "http://jiiks.x10.mx/tlnotify/news.html";
	public static void Main(){
	URL news;
	try {
		news = new URL(url);
	HttpURLConnection getnews = (HttpURLConnection) news.openConnection();
	InputStream in = new BufferedInputStream(getnews.getInputStream());
	Writer sw = new StringWriter();
	char[] b = new char[1024];
	Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
	int n;
	while ((n = reader.read(b)) != -1){
		sw.write(b, 0, n);
	}
	String newstring = sw.toString();
	Main.News = StringUtils.substringBetween(newstring, "<news>", "</news>");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
