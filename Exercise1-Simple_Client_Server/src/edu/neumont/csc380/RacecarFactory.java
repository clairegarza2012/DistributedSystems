package edu.neumont.csc380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RacecarFactory {

	private static Random ran = new Random();
	private static HashMap<Integer, Make> makes;	

	public static RaceCar makeCar(){

		initializeMakes();

		String make = "";
		String model = "";
		int horsepower = 0;
		double quarterMileTime = 0.0;

		Make make1 = getMake();
		make = make1.getName();
		
		model = getModel(make1);

		horsepower = ran.nextInt(1800);

		quarterMileTime = ran.nextInt(3000) + ran.nextDouble();

		return new RaceCar(make, model, horsepower, quarterMileTime);
	}

	private static Make getMake() {

		int key = ran.nextInt(makes.size());

		return makes.get(key);
	}

	private static String getModel(Make make) {

		int index = ran.nextInt(make.getSize());

		return make.getModel(index);
	}

	private static void initializeMakes() {

		makes = new HashMap<Integer, Make>();

		Make ford = new Make("Ford");

		ford.addModel("Focus");
		ford.addModel("F-150");
		ford.addModel("Torus");
		ford.addModel("Mustang");
		ford.addModel("Fiesta");

		makes.put(0, ford);

		Make gmc = new Make("GMC");

		gmc.addModel("Terrain");
		gmc.addModel("Yukon");
		gmc.addModel("Sierra");
		gmc.addModel("Acadia");
		gmc.addModel("Canyon");

		makes.put(1, gmc);

		Make chevy = new Make("Chevy");

		chevy.addModel("Corvette");
		chevy.addModel("Camero");
		chevy.addModel("Volt");
		chevy.addModel("Implala");
		chevy.addModel("Cruze");

		makes.put(2, chevy);

		Make nissan = new Make("Nissan");

		nissan.addModel("Altima");
		nissan.addModel("Sentra");
		nissan.addModel("Frontier");
		nissan.addModel("Juke");
		nissan.addModel("Versa");

		makes.put(3, nissan);

		Make toyota = new Make("Toyota");

		toyota.addModel("Corolla");
		toyota.addModel("F-150");
		toyota.addModel("Camry");
		toyota.addModel("Rav4");
		toyota.addModel("Prius");

		makes.put(4, toyota);

		Make honda = new Make("Honda");

		honda.addModel("CR-V");
		honda.addModel("Civic");
		honda.addModel("Fit");
		honda.addModel("Accord");
		honda.addModel("Pilot");

		makes.put(5, honda);

		Make mazda = new Make("Mazda");

		mazda.addModel("CX-5");
		mazda.addModel("Mazda2");
		mazda.addModel("Mazda3");
		mazda.addModel("Miata");
		mazda.addModel("Mazda6");

		makes.put(6, mazda);

	}

	private static class Make {

		private String name;

		private ArrayList<String> models;

		public Make (String name){
			this.name = name;
			models = new ArrayList<String>();
		}

		public void addModel(String model){
			models.add(model);
		}

		public String getModel(int index){
			return models.get(index);
		}
		
		public String getName(){
			return name;
		}
		
		public int getSize(){
			return models.size();
		}
	}
}
