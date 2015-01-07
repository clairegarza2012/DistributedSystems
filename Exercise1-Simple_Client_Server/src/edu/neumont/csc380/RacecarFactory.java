package edu.neumont.csc380;

import java.util.Random;

public class RacecarFactory {
	
	private static Random ran = new Random();
	
	public static RaceCar makeCar(){
		
		String make = "";
		String model = "";
		int horsepower = 0;
		double quarterMileTime = 0.0;

		
		
		
		return new RaceCar(make, model, horsepower, quarterMileTime);
	}
	
	
}
