package edu.neumont.csc380;

import java.util.Random;

public class ObjectGenerator {

	private static Random ran = new Random();
	
	public static HallaStorObject generate(){
		
		HallaStorObject obj = null;
		
		int i = ran.nextInt(2);
		
		if (i == 0){
			obj = makeRacecar();
		}
		else {
			obj = makeDriver();
		}
		
		return obj;
	}

	private static HallaStorObject makeRacecar() {

		return null;
	}
	
	private static HallaStorObject makeDriver() {

		return null;
	}
	
	
}
