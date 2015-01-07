package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

	/* The client will use the server to store and retrieve instances of the following simple POJOs 
	 * (associated with keys of type String):
	 * 
	 */
	//private static Scanner scan = new Scanner(System.in);

	private ArrayList<String> ids = new ArrayList<String>();

	public static void main(String[] args){

		try {
			new Client();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client() throws IOException{

		Socket clientSocket = new Socket("localhost", 2222);

		System.out.println("Client Socket Created!");

		InputStream is = clientSocket.getInputStream();
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

		OutputStream os = clientSocket.getOutputStream();
		PrintStream ps = new PrintStream(os, true);

		boolean serverFull = false; 

		while(!serverFull){

			// send objects to server
			String obj = ObjectGenerator.generate();

			System.out.println("Object Created!");

			ps.println("c" + obj);
			
			System.out.println("Object Pushed to server: type:" + obj.charAt(0) + " id:" + Integer.parseInt(obj.substring(1, 17), 2) );

			while(buffReader.ready()){
				String line = buffReader.readLine();
				System.out.println("Message from Server: \n" + line);

				if (line.equals("Server Is Full!")){
					serverFull = true;
					break;
				}
				if (line.equals("sucessful!")){
					ids.add(obj.substring(1, 17));
				}
			}
		}
		
		//while (true){
			// update objects
			System.out.println("Number Of Id's: " + ids.size());
		//}

		clientSocket.close();

	}

	//System.out.println("Do you want to make 100 requests to the server? (yes or no)");

	//String proposition = scan.nextLine();

	//	if (proposition.equals("yes")){
	//		
	//	}
	//	else if (proposition.equals("no")){
	//		
	//		System.out.println("You said no.");
	//		
	//		String object = getObject(protocol);
	//		
	//		if ( !(object.equals("")) ){
	//			ps.println(object);
	//			System.out.println("message sent to server");
	//		}
	//
	//	}
	//	else{
	//		continue;
	//	}


	//	private String getObject(Protocol protocol){
	//
	//		System.out.println("Do you want to add a racecar or a driver?");
	//
	//		String ans = scan.nextLine();
	//
	//		String message = "";
	//		
	//		if (ans.toLowerCase().equals("racecar")) {				
	//				message = "r" + racecar(protocol);
	//		}
	//		else if (ans.toLowerCase().equals("driver")) {				
	//				message = "d" + driver(protocol);
	//		}
	//		else {
	//				System.out.println("I'm sorry you did not spell racecar or driver correctly.");
	//		}
	//
	//		return message;
	//	}
	//	
	//	private String racecar(Protocol protocol){
	//		
	//		RaceCar car = makeRacecar(scan);
	//		
	//		if (car == null){
	//			return "";
	//		}
	//		
	//		return protocol.protocolRacecar(car);
	//	}
	//	
	//	private String driver(Protocol protocol){
	//		
	//		Driver driver = addDriver(scan);
	//		
	//		if (driver == null){
	//			return "";
	//		}
	//		
	//		return protocol.protocolDriver(driver);
	//	}
	//	
	//	private Driver addDriver(Scanner scan) {
	//
	//		System.out.println("What is the driver's name:");
	//
	//		String name = scan.nextLine();
	//
	//		System.out.println("What is the driver's age:");
	//
	//		int age;
	//		try {
	//			age = Integer.parseInt(scan.nextLine());
	//		}
	//		catch (Exception e){
	//			System.out.println("I'm sorry you did not input a proper age.");
	//			return null;
	//		}
	//
	//		System.out.println("Is your driver male? (yes or no)");
	//
	//		boolean isMale;
	//		String isMaleS = scan.nextLine();
	//		if (isMaleS.equals("yes")){
	//			isMale = true;
	//		}
	//		else if (isMaleS.equals("no")){
	//			isMale = false;
	//		}
	//		else{
	//			System.out.println("I'm sorry you did not input a proper yes or no answer.");
	//			return null;
	//		}
	//
	//		return new Driver(name, age, isMale);
	//	}
	//
	//	private RaceCar makeRacecar(Scanner scan) {
	//
	//		System.out.println("What is the car's make?");
	//
	//		String make = scan.nextLine();
	//
	//		System.out.println("What is the car's model?");
	//
	//		String model = scan.nextLine();
	//
	//		System.out.println("What is the car's horsepower? (Integer)");
	//
	//		int horsePower;
	//
	//		try{
	//			horsePower = Integer.parseInt(scan.nextLine());
	//		} catch (Exception e){
	//			System.out.println("I'm sorry you did not enter an Integer.");
	//			return null;
	//		}
	//
	//		System.out.println("What is the quarter mile time? (Double)");
	//
	//		double quarterMileTime;
	//
	//		try{
	//			quarterMileTime = Double.parseDouble(scan.nextLine());
	//
	//		}catch (Exception e){
	//			System.out.println("I'm sorry you did not input a proper double.");
	//			return null;
	//		}
	//
	//		return new RaceCar(make, model, horsePower, quarterMileTime);
	//	}

}

