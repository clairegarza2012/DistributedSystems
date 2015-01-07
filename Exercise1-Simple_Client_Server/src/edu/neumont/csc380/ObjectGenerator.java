package edu.neumont.csc380;

import java.util.Random;

public class ObjectGenerator {

	private static Random ran = new Random();
	
	public static String generate(){
		
		String obj = null;
		
		int i = ran.nextInt(2);
		
		Protocol protocol = new Protocol();
		
		if (i == 0){
			obj = protocol.protocolRacecar(makeRacecar());
		}
		else {
			obj = protocol.protocolDriver(makeDriver());
		}
		
		return obj;
	}

	private static RaceCar makeRacecar() {

		return RacecarFactory.makeCar();
	}
	
	private static Driver makeDriver() {

		return DriverFactory.makeDriver();
	}
	
	
}
