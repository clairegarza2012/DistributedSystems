package edu.neumont.csc380;

import java.util.Random;

public class ObjectGenerator {

	private static Random ran = new Random();
	
	public static HallaStorObject generate(){
		
		HallaStorObject obj = null;
		
		int i = ran.nextInt(2);
				
		obj = (i == 0) ? makeRacecar() : makeDriver();
		
		return obj;
	}

	private static HallaStorObject makeRacecar() {

		return RacecarFactory.makeCar();
	}
	
	private static HallaStorObject makeDriver() {

		return DriverFactory.makeDriver();
	}
	
	
}
