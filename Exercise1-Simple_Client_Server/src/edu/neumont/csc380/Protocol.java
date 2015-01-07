package edu.neumont.csc380;

public class Protocol {

	// my delimiter is a binary string representing the integer of how many characters after the
	// binary string is the data, unless the data is an integer
	
	public Protocol(){
		
	}
	
	public String protocolRacecar(RaceCar car){
		
		int id = car.getId();
		String make = car.getMake();
		String model = car.getModel();
		int horsePower = car.getHorsePower();
		Double quarterMileTime = car.getQuarterMileTime();
		
		String proId = String.format("%16s", Integer.toBinaryString(id)).replace(" ", "0");
		
		String proMake = String.format("%16s", Integer.toBinaryString(make.length())).replace(" ", "0") + make;
		
		String proModel = String.format("%16s", Integer.toBinaryString(model.length())).replace(" ", "0") + model;
		
		String proHorsePower = String.format("%16s", Integer.toBinaryString(horsePower)).replace(" ", "0");
		
//		String quarterMileString = "" + quarterMileTime;
//	    String[] result = quarterMileString.split("\\.");
//	    int quarterMileLength = result[0].length() + result[1].length() + 1;
//		
//		String proQuarterMileTime = String.format("%16s", Integer.toBinaryString(quarterMileLength)).replace(" ", "0") + quarterMileTime;
		
		String proQuarterMileTime = "" + quarterMileTime;
		
		return proId + proMake + proModel + proHorsePower + proQuarterMileTime;
	}
	
	public RaceCar deprotocolRacecar(String racecarProtocol){
		
		int binaryStringLength = 16;
		// id : a binary string the length of 16
		int id = Integer.parseInt(racecarProtocol.substring(0, binaryStringLength), 2); // first 16 characters .. does not include the character at index 16
		
		System.out.println("Id: " + id);
		
		int placeInRacecarProtocol = binaryStringLength;
		
		int makeLength = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		
		placeInRacecarProtocol += binaryStringLength;
		
		String make = racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + makeLength);
		
		placeInRacecarProtocol += makeLength;
		
		int modelLength = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		
		placeInRacecarProtocol += binaryStringLength;
		
		String model = racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + modelLength);
		
		placeInRacecarProtocol += modelLength;
				
		int horsePower = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		
		placeInRacecarProtocol += binaryStringLength;
		
		/* only needed if I add a binary string to the double 
		 * I got rid of it because I realized I could just get the values at the end.. 
		 * the remaning values of the string are the double values*/
//		int quarterMileLength = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength));
//				
//		placeInRacecarProtocol += binaryStringLength;
		
		double quarterMileTime = Double.parseDouble(racecarProtocol.substring(placeInRacecarProtocol));
						
		return new RaceCar(id, make, model, horsePower, quarterMileTime);
	}
	
	public String protocolDriver(Driver driver){
		
		int id = driver.getId();
		String name = driver.getName();
		int age = driver.getAge();
		boolean isMale = driver.isMale();
		
		String proId = String.format("%16s", Integer.toBinaryString(id)).replace(" ", "0");
		
		String proName = String.format("%16s", Integer.toBinaryString(name.length())).replace(" ", "0") + name;
		
		String proAge = String.format("%16s", Integer.toBinaryString(age)).replace(" ", "0");
		
		String proIsMale = isMale? "true" : "false"; 

		return proId + proName + proAge + proIsMale;
	}
	
	public Driver deprotocolDriver(String driverProtocol){
		
		int binaryStringLength = 16;
		
		int id = Integer.parseInt(driverProtocol.substring(0, binaryStringLength), 2);
		
		System.out.println("Id: " + id);
		
		int placeInDriverProtocol = binaryStringLength;
		
		System.out.println("place in driver protocol: " + placeInDriverProtocol);
		
		int nameLength = Integer.parseInt(driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + binaryStringLength), 2);
		
		System.out.println("Name Length: " + nameLength);
		
		placeInDriverProtocol += binaryStringLength;
				
		System.out.println("place in driver protocol: " + placeInDriverProtocol);
		
		String name = driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + nameLength);
		
		System.out.println("Name: " + name);
		
		placeInDriverProtocol += nameLength;
		
		System.out.println("place in driver protocol: " + placeInDriverProtocol);
		
		int age = Integer.parseInt(driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + binaryStringLength), 2);
		
		placeInDriverProtocol += binaryStringLength;
		
		System.out.println("place in driver protocol: " + placeInDriverProtocol);
		
		boolean isMale = driverProtocol.substring(placeInDriverProtocol).equals("true") ? true : false;
		
		return new Driver(id, name, age, isMale);
	}
}
