package edu.neumont.csc380;

public class Driver {

	private String name;
	private int age;
	private boolean isMale;
	private int id;
	
	public Driver(String name, int age, boolean isMale){
		
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}

	public Driver(int id, String name, int age, boolean isMale){
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}
	
	/* Getters */ 
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return isMale;
	}

	public int getId(){
		return id;
	}
	
	/* Setters */
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	@Override
	public String toString() {
		return "Driver [id= " + id + ", name=" + name + ", age=" + age + ", isMale=" + isMale
				+ "]";
	}

}
