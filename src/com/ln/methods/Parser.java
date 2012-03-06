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

/***************Deprecated replaced with Betaparser***************/
/****Will be removed soon and all comments moved to betaparser****/
/* Class info
 * This class parses the source obtained with class Getcalendar
 * 
 * Extremely messy class due to my extremely bad parsing skills
 * TODO Rewrite whole class
 */



package com.ln.methods;
import org.apache.commons.lang3.StringUtils;
	

public class Parser {
	/****Parser has gone through multiple remakes
	 ****If you have a better idead for it let me know and submit a pull request
	 ****TODO better parser
	 ****/
	//All events stored inside string arrays
	//Nothing is really sorted into sections some useless vars from past parsers
	public static int hour, minute, second, hour2, minute2, second2, hourd, mind, secd, day, day2, dayd;
	public static String source, Month1, Month2;
	public static String[] Month, Temp, Hours, Minutes;
	public static String[] Events = new String[1000];


	
	
	

	public static void parse(){
			//Time conversion
			Timeconversion.convert();
			Month = StringUtils.substringsBetween(source, "<month", "</month>");
//			Month1 = Month[Main.month - 1];
//			Month1 = Month1.replaceAll("\\s+\\n", " ").replaceAll("\\s+", " ");
//			Month1 = Month1.replace("hour=\"", "<H>").replace("\" minute=\"", "</H><M>").replace("\" ov", "</M>").replace("er=\"1\"", "<O>1</O").replace("er=\"0\"", "<O>0</O");
//			//Old time tag == hour="5" minute="30" over="1"
//			//New time tag == <H>5</H><M>30</M><O>1</O>
//			//Replace days
//			String[] temptitles = StringUtils.substringsBetween(Month1, "<event", "</event>");
//			for (int i = 0 ; i != temptitles.length ; i++){
//				Month1 = Month1.replace("<day num=\"" + Integer.toString(i) + "\"><event ", "<D>" + Integer.toString(i) + "</D>");
//			}
//			//Give all events their own day tags
//			Month1 = Month1.replace("<D>", "@<D>");
//			Temp = StringUtils.substringsBetween(Month1, "@", "</day>");
//			for (int i = 0 ; i != Temp.length ; i++){
//				Temp[i] = Temp[i].replace("<H>", "<D>" + StringUtils.substringBetween(Temp[i], "<D>", "</D>") + "</D><H>");
//				//Remove extra day tags
//				Temp[i] = Temp[i].replace("<D>" + StringUtils.substringBetween(Temp[i], "<D>", "</D>") + "</D><D>", "<D>");
//			}
//			Month1 = ArrayUtils.toString(Temp);
//			//Brand new time tag == <D>day</D><H>hour</H><M>minute</M><O>over?<O>
//			//Now let us convert hours && days to local timezone
//			//I think this is kind of a bad workaround so let me know if you have a better alternative
//			//Create some temp tags
//			
//			Month1 = Month1.replace("<D>", "@<D>");
//			Month1 = Month1.replace("</event>", "¤</event>");
//			Temp = StringUtils.substringsBetween(Month1, "@", "¤");
//			for (int i = 0 ; i != Temp.length ; i++){
//				if (hour < hour2){
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<H>", "</H>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>"))-hourd));
//				}
//				if (hour > hour2){
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<H>", "</H>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>"))+hourd));
//					
//				}
//				if (hour == hour2){
//					//do nothing
//				}
//			}
//			Month1 = ArrayUtils.toString(Temp);
//			//Time to convert days and reformat hours
//			//Create some temp tags again
//			Month1 = Month1.replace("<D>", "@<D>").replace("</event-id>", "</event-id>¤");
//			Temp = StringUtils.substringsBetween(Month1, "@", "¤");
//			for (int i = 0 ; i != Temp.length ; i++){
//				if (Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>")) < 0){
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<H>", "</H>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>")) + 24));
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<D>", "</D>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<D>", "</D>")) - 1));
//							
//				}
//				if (Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>")) > 24){
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<H>", "</H>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<H>", "</H>")) - 24));
//					Temp[i] = Temp[i].replace(StringUtils.substringBetween(Temp[i], "<D>", "</D>"),
//							Integer.toString(Integer.parseInt(StringUtils.substringBetween(Temp[i], "<D>", "</D>")) + 1));
//							
//				}
//			}
//			Month1 = ArrayUtils.toString(Temp);
//			//Everything should now be properly converted to users timezone
//			//Full Event tag:
//			//<D>DAY</D><H>HOUR</H><M>MINUTE</M><O>over?</O><type>TYPE</type><title>TITLE</title><short-title>SHORT-TITLE</short-title><description>DESCRIPTION</description><event-id>EVENT-ID</event-id>
//			//Place all events to new homes in event array
//			Hours = StringUtils.substringsBetween(Month1, "<H>", "</H>");
//			Minutes = StringUtils.substringsBetween(Month1, "<M>", "</M>");
//			for (int i = 0 ; i != Events.length ; i++){
//				Events[i] = ArrayUtils.toString(StringUtils.substringsBetween(Month1, "<D>" + Integer.toString(i) + "</D>", "</event-id>"));
//			}
//			//All should be good now
//			
//			
//		
//			
//		
}
}
