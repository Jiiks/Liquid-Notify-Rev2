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

public class TimedEvent implements Comparable<TimedEvent> {
	public static String title;
	public static int d, h, m;
	
	public TimedEvent(String name, int t1, int t2, int t3){
		title = name;
		d = t1;
		h = t2;
		m = t3;
	}
		
		public int compareTo(TimedEvent otherEvent){
			return title.compareTo(TimedEvent.title);
		}
	}