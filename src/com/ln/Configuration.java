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
 * Configuration for paths, urls and other
 */

package com.ln;

import java.io.File;

public class Configuration {
		public static int version = 006;
		public static int autoupdate = 0;
	    public static int notifytime = 0;
	    public static int autorefresh = 0;
	    public static int refreshtime = 5;
	    public static int soundnotify = 0;
		public static int theme = 11;
		public static int popup = 1;
		public static String Year = "2012";
		public static String aboutver = "0.24";
		public static String soundpath = "";
		public static String mydir = System.getProperty ("user.dir"); 
		public static File config = new File(mydir + "/lib");
		public static class paths{
			public final static String CalendarURL = new String("http://jiiks.x10.mx/tlnotify/copied.xml");
		}
}
