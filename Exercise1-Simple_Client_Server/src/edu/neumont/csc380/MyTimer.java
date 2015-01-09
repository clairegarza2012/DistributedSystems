package edu.neumont.csc380;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimer implements ActionListener{

	private int count = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		//System.out.println("I Second Gone!");
	}


	public String getTime() {
								
		int minutes = count / 60;
		
		int seconds = count - (minutes * 60);
		
		int hours = minutes / 60;
		
		return hours + ":" + minutes + ":" + seconds;
	}
	
}
