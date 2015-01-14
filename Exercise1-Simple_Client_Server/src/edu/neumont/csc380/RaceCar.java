package edu.neumont.csc380;

public class RaceCar {

	private String make;
	private String model;
	private int horsePower;
	private double quarterMileTime;
	private int id;
	
	public RaceCar(String make, String model, int horsePower, double quarterMileTime){
		
		this.make = make;
		this.model = model;
		this.horsePower = horsePower;
		this.quarterMileTime = quarterMileTime;
	}
	
	public RaceCar(int id, String make, String model, int horsePower, double quarterMileTime){
		
		this.id = id;
		this.make = make;
		this.model = model;
		this.horsePower = horsePower;
		this.quarterMileTime = quarterMileTime;
	}
	
	/* Getters */
	
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

	public int getId(){
		return id;
	}
	
	/* Setters */
	
	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public void setQuarterMileTime(double quarterMileTime) {
		this.quarterMileTime = quarterMileTime;
	}

	public void setId(int id){
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RaceCar [id= " + id + ", make=" + make + ", model=" + model + ", horsePower="
				+ horsePower + ", quarterMileTime=" + quarterMileTime + "]";
	}
	
}
