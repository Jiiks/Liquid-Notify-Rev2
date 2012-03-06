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

package com.ln.methods;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Timeconversion extends com.ln.methods.Parser {
	public static void convert(){
	/****Convert time to KST****/
	//Get local time
	Calendar localTime = Calendar.getInstance();
	day = localTime.get(Calendar.DAY_OF_MONTH);
	hour = localTime.get(Calendar.HOUR_OF_DAY);
	minute = localTime.get(Calendar.MINUTE);
	second = localTime.get(Calendar.SECOND);
	localTime.set(Calendar.HOUR_OF_DAY, hour);
	localTime.set(Calendar.MINUTE, minute);
	localTime.set(Calendar.SECOND, second); 
	//Get KST
	Calendar KST = new GregorianCalendar(TimeZone.getTimeZone("Asia/Seoul"));
	KST.setTimeInMillis(localTime.getTimeInMillis());
	day2 = KST.get(Calendar.DAY_OF_MONTH);
	hour2 = KST.get(Calendar.HOUR_OF_DAY);
	minute2 = KST.get(Calendar.MINUTE);
	second2 = KST.get(Calendar.SECOND);	
	//Get difference between timezones
	dayd = day - day2;
	hourd = hour2 - hour;
	mind = minute2 - minute;
	secd = second2 - second;
	if (dayd !=0){
		hourd = hourd +24;
	}
	}
}
