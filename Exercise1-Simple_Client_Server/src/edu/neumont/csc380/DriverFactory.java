package edu.neumont.csc380;

import java.util.Random;

public class DriverFactory {

	private static Random ran = new Random();
	
	public static Driver makeDriver(){
		
		boolean isMale = false;
		String name = "";
		int age = 0;
		
		int isMaleProp = ran.nextInt(2);
		
		if (isMaleProp == 0){
			isMale = true;
			name = getMaleFirstName();
		}
		else{
			name = getFemaleFirstName();
		}
		
		name += " " + getLastName();
		
		age = ran.nextInt(120);
		
		return new Driver(name, age, isMale);
	}
	
	private static String getMaleFirstName(){
		
		return "";
	}
	
	private static String getFemaleFirstName(){
		
		return "";
	}
	
	private static String getLastName(){
		
		return "";
	}
	
}
