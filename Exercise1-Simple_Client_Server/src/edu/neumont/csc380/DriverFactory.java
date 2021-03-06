package edu.neumont.csc380;

import java.util.HashMap;
import java.util.Random;

public class DriverFactory {

	private static Random ran = new Random();
	
	private static HashMap<Integer, String> maleNames;
	private static HashMap<Integer, String> femaleNames;
	private static HashMap<Integer, String> lastNames;
	
	public static Driver makeDriver(){
		
		instanciateNames();
		
		boolean isMale = false;
		String name = "";
		int age = 0;
		
		int isMaleProp = ran.nextInt(2);
		
		if (isMaleProp == 0){
			isMale = true;
			name = getMaleFirstName();
		}
		else{
			name = getFemaleFirstName();
		}
		
		name += " " + getLastName();
		
		age = ran.nextInt(120);
		
		return new Driver(name, age, isMale);
	}
	
	private static String getMaleFirstName(){
		
		int key = ran.nextInt(30);
		
		return maleNames.get(key);
	}
	
	private static String getFemaleFirstName(){
		
		int key = ran.nextInt(30);

		return femaleNames.get(key);
	}
	
	private static String getLastName(){
		
		int key = ran.nextInt(30);

		return lastNames.get(key);
	}
	
	private static void instanciateNames() {

		maleNames = new HashMap<Integer, String>();
		femaleNames = new HashMap<Integer, String>();
		lastNames = new HashMap<Integer, String>();
		
		instanciateMaleNames();
		instanciateFemaleNames();
		instanciateLastNames();
	}

	private static void instanciateMaleNames() {
		maleNames.put(0, "Aaron");
		maleNames.put(1, "Clayton");
		maleNames.put(2, "Glen");
		maleNames.put(3, "River");
		maleNames.put(4, "Romeo");
		
		maleNames.put(5, "Gus");
		maleNames.put(6, "Rocky");
		maleNames.put(7, "Robbie");
		maleNames.put(8, "Dalton");
		maleNames.put(9, "Damon");
		
		maleNames.put(10, "Dan");
		maleNames.put(11, "David");
		maleNames.put(12, "Alen");
		maleNames.put(13, "Conan");
		maleNames.put(14, "Aden");
		
		maleNames.put(15, "Adam");
		maleNames.put(16, "Conor");
		maleNames.put(17, "Leo");
		maleNames.put(18, "Luis");
		maleNames.put(19, "Juan");
		
		maleNames.put(20, "John");
		maleNames.put(21, "Matt");
		maleNames.put(22, "Kyle");
		maleNames.put(23, "Ash");
		maleNames.put(24, "Avery");
		
		maleNames.put(25, "Jaiden");
		maleNames.put(26, "Mario");
		maleNames.put(27, "Mason");
		maleNames.put(28, "Nick");
		maleNames.put(29, "George");
	}

	private static void instanciateFemaleNames() {
		femaleNames.put(0, "Abigail");
		femaleNames.put(1, "Addison");
		femaleNames.put(2, "Allison");
		femaleNames.put(3, "Heidi");
		femaleNames.put(4, "Helene");
		
		femaleNames.put(5, "Celine");
		femaleNames.put(6, "Jenifer");
		femaleNames.put(7, "Claire");
		femaleNames.put(8, "Lorraine");
		femaleNames.put(9, "Sierra");
		
		femaleNames.put(10, "Kanea");
		femaleNames.put(11, "Jasmine");
		femaleNames.put(12, "Tanisha");
		femaleNames.put(13, "Leslie");
		femaleNames.put(14, "Linda");
		
		femaleNames.put(15, "Iris");
		femaleNames.put(16, "Alice");
		femaleNames.put(17, "Connie");
		femaleNames.put(18, "Anna");
		femaleNames.put(19, "Julie");
		
		femaleNames.put(20, "Maria");
		femaleNames.put(21, "Amanda");
		femaleNames.put(22, "Vanessa");
		femaleNames.put(23, "Pricilla");
		femaleNames.put(24, "Monica");
		
		femaleNames.put(25, "Gabriela");
		femaleNames.put(26, "Valorie");
		femaleNames.put(27, "July");
		femaleNames.put(28, "Nikki");
		femaleNames.put(29, "Tiana");
	}

	private static void instanciateLastNames() {
		lastNames.put(0, "Archer");
		lastNames.put(1, "Ericson");
		lastNames.put(2, "Razim");
		lastNames.put(3, "Brown");
		lastNames.put(4, "White");
		
		lastNames.put(5, "Garza");
		lastNames.put(6, "Gonzalez");
		lastNames.put(7, "Graff");
		lastNames.put(8, "Lion");
		lastNames.put(9, "Griffith");
		
		lastNames.put(10, "Rhodes");
		lastNames.put(11, "Rains");
		lastNames.put(12, "Rangel");
		lastNames.put(13, "Richman");
		lastNames.put(14, "Davidson");
		
		lastNames.put(15, "Romero");
		lastNames.put(16, "Sherman");
		lastNames.put(17, "Sandoval");
		lastNames.put(18, "Staggs");
		lastNames.put(19, "Zuniga");
		
		lastNames.put(20, "Zeller");
		lastNames.put(21, "Zamora");
		lastNames.put(22, "Parks");
		lastNames.put(23, "Peterson");
		lastNames.put(24, "Meyers");
		
		lastNames.put(25, "Mendoza");
		lastNames.put(26, "Hazel");
		lastNames.put(27, "Farrel");
		lastNames.put(28, "Farris");
		lastNames.put(29, "Fisher");
	}
	
}
