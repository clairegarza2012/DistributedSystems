package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.hallaLib.HallaStor;
import com.hallaLib.HallaZip;

public class Server {

	/* The server should provide simple CRUD operations for a key/value store. 
	 *  
	 */

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		try {
			new Server();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Server() throws IOException{

		ServerSocket ss = new ServerSocket(2222); // 2222 is the port

		System.out.println("server created");

		Socket serverSocket = ss.accept();

		System.out.println("client accepted!");

		OutputStream out = serverSocket.getOutputStream();

		PrintStream ps = new PrintStream(out, true);

		InputStream is = serverSocket.getInputStream();

		BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

		Protocol protocol = new Protocol();
		
		while(true){

			String object = getObject(protocol);

			if ( !(object.equals("")) ){
				ps.println(object);
				System.out.println("message sent to client");
			}

			while(buffReader.ready()){
				String line = buffReader.readLine();
				System.out.println(line);
			}

		}
		//ss.close();
		//serverSocket.close();
	}

	private String getObject(Protocol protocol){

		System.out.println("Do you want to add a racecar or a driver?");

		String ans = scan.nextLine();

		String message = "";
		
		if (ans.toLowerCase().equals("racecar")) {				
				message = "r" + racecar(protocol);
		}
		else if (ans.toLowerCase().equals("driver")) {				
				message = "d" + driver(protocol);
		}
		else {
				System.out.println("I'm sorry you did not spell racecar or driver correctly.");
		}

		return message;
	}
	
	private String racecar(Protocol protocol){
		
		RaceCar car = makeRacecar(scan);
		
		if (car == null){
			return "";
		}
		
		return protocol.protocolRacecar(car);
	}
	
	private String driver(Protocol protocol){
		
		Driver driver = addDriver(scan);
		
		if (driver == null){
			return "";
		}
		
		return protocol.protocolDriver(driver);
	}
	
	private Driver addDriver(Scanner scan) {

		System.out.println("What is the driver's name:");

		String name = scan.nextLine();

		System.out.println("What is the driver's age:");

		int age;
		try {
			age = Integer.parseInt(scan.nextLine());
		}
		catch (Exception e){
			System.out.println("I'm sorry you did not input a proper age.");
			return null;
		}

		System.out.println("Is your driver male? (yes or no)");

		boolean isMale;
		String isMaleS = scan.nextLine();
		if (isMaleS.equals("yes")){
			isMale = true;
		}
		else if (isMaleS.equals("no")){
			isMale = false;
		}
		else{
			System.out.println("I'm sorry you did not input a proper yes or no answer.");
			return null;
		}

		return new Driver(name, age, isMale);
	}

	private RaceCar makeRacecar(Scanner scan) {

		System.out.println("What is the car's make?");

		String make = scan.nextLine();

		System.out.println("What is the car's model?");

		String model = scan.nextLine();

		System.out.println("What is the car's horsepower? (Integer)");

		int horsePower;

		try{
			horsePower = Integer.parseInt(scan.nextLine());
		} catch (Exception e){
			System.out.println("I'm sorry you did not enter an Integer.");
			return null;
		}

		System.out.println("What is the quarter mile time? (Double)");

		double quarterMileTime;

		try{
			quarterMileTime = Double.parseDouble(scan.nextLine());

		}catch (Exception e){
			System.out.println("I'm sorry you did not input a proper double.");
			return null;
		}

		return new RaceCar(make, model, horsePower, quarterMileTime);
	}

}
