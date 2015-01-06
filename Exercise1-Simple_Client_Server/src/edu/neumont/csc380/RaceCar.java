package edu.neumont.csc380;

public class RaceCar {

	private int id;
	private String make;
	private String model;
	private int horsePower;
	private double quarterMileTime;
	
	public RaceCar(int id, String make, String model, int horsePower, double quarterMileTime){
		
		this.id = id;
		this.make = make;
		this.model = model;
		this.horsePower = horsePower;
		this.quarterMileTime = quarterMileTime;
	}

	public int getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public double getQuarterMileTime() {
		return quarterMileTime;
	}
	
	
}
