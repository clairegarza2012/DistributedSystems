package edu.neumont.csc380;

public class Driver {

	private int id;
	private String name;
	private int age;
	private boolean isMale;
	
	public Driver(int id, String name, int age, boolean isMale){
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return isMale;
	}
	
	
}