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
	//Currently just stores some variables
	public static int hour, minute, second, hour2, minute2, second2, hourd, mind, secd, day, day2, dayd;
	public static String source, Month1, Month2;
	public static String[] Month, Temp, Hours, Minutes;
	public static String[] Events = new String[1000];
	public static void parse(){
			Timeconversion.convert();
			Month = StringUtils.substringsBetween(source, "<month", "</month>");		
}
}
