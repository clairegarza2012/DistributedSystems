package edu.neumont.csc380;

public class Protocol {

	// my delimiter is a binary string representing the integer of how many characters after the
	// binary string is the data, unless the data is an integer
	
	public Protocol(){
		
	}
	
	public String protocolObject(HallaStorObject obj){
		
		String s = "";
		
		char objProposition = obj.toString().charAt(0);
		
		if (objProposition == 'R'){
			s = protocolRacecar((RaceCar)obj);
		}
		else{
			s = protocolDriver((Driver)obj);
		}
		
		
		return s;
	}
	
	public HallaStorObject deprotocolObject(String obj){
		
		HallaStorObject o = null;
		
		char prop = obj.charAt(0);
		
		if (prop == 'r'){
			o = deprotocolRacecar(obj);
		}
		else {
			o = deprotocolDriver(obj);
		}
		
		return o;
	}

	private String protocolRacecar(RaceCar car){
		
		int id = car.getId();
		String make = car.getMake();
		String model = car.getModel();
		int horsePower = car.getHorsePower();
		Double quarterMileTime = car.getQuarterMileTime();
		
		String proId = String.format("%16s", Integer.toBinaryString(id)).replace(" ", "0");
		
		String proMake = String.format("%16s", Integer.toBinaryString(make.length())).replace(" ", "0") + make;
		
		String proModel = String.format("%16s", Integer.toBinaryString(model.length())).replace(" ", "0") + model;
		
		String proHorsePower = String.format("%16s", Integer.toBinaryString(horsePower)).replace(" ", "0");
		
		String proQuarterMileTime = "" + quarterMileTime;
		
		return "r" + proId + proMake + proModel + proHorsePower + proQuarterMileTime;
	}
	
	private RaceCar deprotocolRacecar(String racecarProtocol){
		
		int binaryStringLength = 16;
		
		int placeInRacecarProtocol = 1;
		
		int id = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2); // first 16 characters .. does not include the character at index 16
		System.out.println("Id: " + id);
		placeInRacecarProtocol += binaryStringLength;
		
		int makeLength = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		
		placeInRacecarProtocol += binaryStringLength;
		
		String make = racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + makeLength);
		
		placeInRacecarProtocol += makeLength;
		
		int modelLength = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		
		placeInRacecarProtocol += binaryStringLength;
		
		String model = racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + modelLength);
		
		placeInRacecarProtocol += modelLength;
				
		int horsePower = Integer.parseInt(racecarProtocol.substring(placeInRacecarProtocol, placeInRacecarProtocol + binaryStringLength), 2);
		System.out.println("Horse Power: " + horsePower);
		placeInRacecarProtocol += binaryStringLength;

		double quarterMileTime = Double.parseDouble(racecarProtocol.substring(placeInRacecarProtocol));
						
		return new RaceCar(id, make, model, horsePower, quarterMileTime);
	}
	
	private String protocolDriver(Driver driver){
		
		int id = driver.getId();
		String name = driver.getName();
		int age = driver.getAge();
		boolean isMale = driver.isMale();
		
		String proId = String.format("%16s", Integer.toBinaryString(id)).replace(" ", "0");
		
		String proName = String.format("%16s", Integer.toBinaryString(name.length())).replace(" ", "0") + name;
		
		String proAge = String.format("%16s", Integer.toBinaryString(age)).replace(" ", "0");
		
		String proIsMale = isMale? "true" : "false"; 

		return "d" + proId + proName + proAge + proIsMale;
	}
	
	private Driver deprotocolDriver(String driverProtocol){
		
		int binaryStringLength = 16;
		
		int placeInDriverProtocol = 1;
		
		int id = Integer.parseInt(driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + binaryStringLength), 2);
		System.out.println("Id: " + id);
		placeInDriverProtocol += binaryStringLength;
				
		int nameLength = Integer.parseInt(driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + binaryStringLength), 2);
				
		placeInDriverProtocol += binaryStringLength;
						
		String name = driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + nameLength);
				
		placeInDriverProtocol += nameLength;
				
		int age = Integer.parseInt(driverProtocol.substring(placeInDriverProtocol, placeInDriverProtocol + binaryStringLength), 2);
		System.out.println("Age: " + age);
		placeInDriverProtocol += binaryStringLength;
				
		boolean isMale = driverProtocol.substring(placeInDriverProtocol).equals("true") ? true : false;
		
		return new Driver(id, name, age, isMale);
	}
}
