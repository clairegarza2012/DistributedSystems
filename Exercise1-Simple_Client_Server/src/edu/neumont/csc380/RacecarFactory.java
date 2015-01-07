package edu.neumont.csc380;

import java.util.Random;

public class RacecarFactory {
	
	private static Random ran = new Random();
	
	public static RaceCar makeCar(){
		
		String make = "";
		String model = "";
		int horsepower = 0;
		double quarterMileTime = 0.0;

		make = getMake();
		
		model = getModel();
		
		horsepower = ran.nextInt(1800);
		
		quarterMileTime = ran.nextInt(3000) + ran.nextDouble();
		
		return new RaceCar(make, model, horsepower, quarterMileTime);
	}

	private static String getMake() {

		return "";
	}

	private static String getModel() {
		
		return "";
	}
	
}
