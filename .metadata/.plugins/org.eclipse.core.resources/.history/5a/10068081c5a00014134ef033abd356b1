package edu.neumont.csc380;

import java.util.Random;

public class ObjectGenerator {

	private static Random ran = new Random();
	
	public static String generate(){
		
		String obj = null;
		
		int i = ran.nextInt(2);
		
		Protocol protocol = new Protocol();
		
		obj = (i == 0) ? protocol.protocolObject(makeRacecar()) : protocol.protocolObject(makeDriver());
		
		return obj;
	}

	private static HallaStorObject makeRacecar() {

		return RacecarFactory.makeCar();
	}
	
	private static HallaStorObject makeDriver() {

		return DriverFactory.makeDriver();
	}
	
	
}
