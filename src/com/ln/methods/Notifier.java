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

import javax.swing.SwingWorker;

import com.ln.gui.Main;
import com.ln.gui.Notifylist;

public class Notifier<notifierthread> extends Main {

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {

	}
	@SuppressWarnings("rawtypes")
	public  SwingWorker thread = new SwingWorker<notifierthread, Void>(){
		public notifierthread doInBackground() throws InterruptedException{	
			while ( true ){
				for (int i = 0 ; i != Notifylist.Events.length ; i++){
					NOM[i] = NOM[i] -1;
					if (NOM[i] < 5){
					}
				}
				Thread.sleep(minute);
				
			}
			
			
		}
	};
	

}
