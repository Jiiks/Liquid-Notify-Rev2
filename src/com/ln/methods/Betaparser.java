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

/****Beta parser is better version of Parser, actually capable of setting correct dates****/
   /**********For info on everything, refer to Parser.java most stuff is the same*************/

package com.ln.methods;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Betaparser {
	
	public static boolean success(int value, int... values) {
	    for (int i: values) if(value != i) return false;
	    return true;
	}


	
	public static int hour, minute, second, hour2, minute2, second2, hourd, mind, secd;
	public static String source, Month1, Month2;
	public static String[] Temp, Temp2;
	public static String[] Monthnumbers;
	public static String[] Months,Days, Hours, Minutes, Over, Title, STitle, Description, ID;
	public static String[] Events = new String[1000];
	public static int[] Daysint = new int[1000];
	public static int[] DD = new int[1000];
	public static void parse(){
		Timeconversion.convert();
		source = source.replaceAll("\\s+\\n", " ").replaceAll("\\s+", " ");
		source = StringUtils.substringBetween(source, "<calendar>", "</calendar>");
		source = source.replace("hour=\"", "<H>").replace("\" minute=\"", "</H><M>").replace("\" ov", "</M>").replace("er=\"1\"", "<O>1</O").replace("er=\"0\"", "<O>0</O");
		Monthnumbers = StringUtils.substringsBetween(source, "<month year=\"2012\" num=\"", "\">");
		Temp = StringUtils.substringsBetween(source, "<event", "</event>");
		for (int i = 0 ; i != Temp.length ; i++){
			source = source.replace("<month year=\"2012\" num=\"" + Monthnumbers[0] + "\">", "<mo>" + Monthnumbers[0] + "</mo>");
			if (Monthnumbers.length > 1){
			source = source.replace("<month year=\"2012\" num=\"" + Monthnumbers[1] + "\">", "<mo>" + Monthnumbers[1] + "</mo>")
			.replace("<day num=\"" + Integer.toString(i) + "\"><event ", "<D>" + Integer.toString(i) + "</D>");
			}else if (Monthnumbers.length == 1){
			source = source.replace("<day num=\"" + Integer.toString(i) + "\"><event ", "<D>" + Integer.toString(i) + "</D>");
			}
		}
		Month1 = StringUtils.substringBetween(source, "<mo>" + Monthnumbers[0] + "</mo>", "</month>");
		Month1 = Month1.replace("<D>", "@<D>");
		Temp = StringUtils.substringsBetween(Month1, "@", "</day>");
		if (Monthnumbers.length > 1){
		Month2 = StringUtils.substringBetween(source, "<mo>" + Monthnumbers[1] + "</mo>", "</month>");
		Month2 = Month2.replace("<D>", "@<D>");
		Temp2 = StringUtils.substringsBetween(Month2, "@", "</day>");
		}
		for (int i = 0 ; i != Temp.length ; i++){
			Temp[i] = Temp[i].replace("<H>", "<mo>"+ Monthnumbers[0] +"</mo><D>" + StringUtils.substringBetween(Temp[i], "<D>", "</D>") + "</D><H>");
			//Remove extra day tags
			Temp[i] = Temp[i].replace("<D>" + StringUtils.substringBetween(Temp[i], "<D>", "</D>") + "</D><D>", "<D>");
		}
		Month1 = ArrayUtils.toString(Temp);
		if (Monthnumbers.length > 1){
		for (int i = 0 ; i != Temp2.length ; i++){
			Temp2[i] = Temp2[i].replace("<H>", "<mo>"+ Monthnumbers[1] +"</mo><D>" + StringUtils.substringBetween(Temp2[i], "<D>", "</D>") + "</D><H>");
			//Remove extra day tags
			Temp2[i] = Temp2[i].replace("<D>" + StringUtils.substringBetween(Temp2[i], "<D>", "</D>") + "</D><D>", "<D>");
		}
		Month2 = ArrayUtils.toString(Temp2);
		source = StringUtils.join(Month1, Month2);
		}else{source = Month1;}
		for (int i = 0 ; i != 31 ; i++){
			source = source.replace("<D>" + Integer.toString(i) + "</D><mo>", "<mo>");
		}
		
		Days = StringUtils.substringsBetween(source, "<D>", "</D>");
		Months = StringUtils.substringsBetween(source, "<mo>", "</mo>");
		Hours = StringUtils.substringsBetween(source, "<H>", "</H>");
		Minutes = StringUtils.substringsBetween(source, "<M>", "</M>");
		Over = StringUtils.substringsBetween(source, "<O>", "</O>");
		Title = StringUtils.substringsBetween(source, "<title>", "</title>");
		STitle = StringUtils.substringsBetween(source, "<short-title>", "</short-title>");
		Description = StringUtils.substringsBetween(source, "<description", "</description>");
		ID = StringUtils.substringsBetween(source, "<event-id>", "</event-id>");
		/*if (success(Months.length, Hours.length, Minutes.length, Over.length, Title.length, STitle.length, Description.length, ID.length))
		{
		   System.out.println("SUCCESS"); 
		}else System.out.println("Something went wrong :(");
		*/
		int diff = Parser.hourd;
		for (int i = 0 ; i != Hours.length ; i++){
			Hours[i] = Integer.toString(Integer.parseInt(Hours[i]) - diff);
		}
		for (int i = 0 ; i != Hours.length ; i++){
			if (Integer.parseInt(Hours[i]) < 0){
				Hours[i] = Integer.toString(Integer.parseInt(Hours[i]) + 24);
				Days[i] = Integer.toString(Integer.parseInt(Days[i]) - 1);
			}
			if (Integer.parseInt(Hours[i]) > 24){
				Hours[i] = Integer.toString(Integer.parseInt(Hours[i]) - 24);
				Days[i] = Integer.toString(Integer.parseInt(Days[i]) + 1);
			}
		}
		for (int i = 0 ; i != Days.length ; i++){
			Daysint[i] = Integer.parseInt(Days[i]);
		}
		for (int i = 0 ; i != Daysint.length ; i++){
			if (Daysint[i] == i){
				DD[i]++;
			}
		}
		for (int i = 0 ; i != Title.length ; i++){
			if (Integer.parseInt(Days[i]) <= 0){
				Months[i] = Integer.toString(Integer.parseInt(Months[i]) -1);
				Days[i] = Integer.toString(Integer.parseInt(Days[i] + 31));
			}
		}
		for (int i = 0 ; i != Title.length ; i++){
			Events[i] = Months[i] + "|" + Days[i] + "|" + Hours[i] + "|" + Title[i] + "|" + STitle[i] + "|" + Description[i];
		}
		
		
	}

}



