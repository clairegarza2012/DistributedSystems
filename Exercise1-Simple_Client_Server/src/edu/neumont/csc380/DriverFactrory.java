package edu.neumont.csc380;

import java.util.Random;

public class DriverFactrory {

	private static Random ran = new Random();
	
	public static Driver makeDriver(){
		
		boolean isMale = false;
		String name = "";
		int age = 0;
		
		int isMaleProp = ran.nextInt(2);
		
		if (isMaleProp == 0){
			isMale = true;
			// get male first name
		}else{
			// get female first name
		}
		
		// concat last name
		
		// generate age
		
		return new Driver(name, age, isMale);
	}
}
