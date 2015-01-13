package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Timer;

public class Client {

	private boolean serverFull = false;

	private BufferedReader buffReader;
	private PrintStream ps;

	private Protocol protocol;

	private Timer timer;
	private MyTimer myTimer;

	private ArrayList<String> ids;

	public static void main(String[] args){

		try {
			new Client();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public Client() throws IOException{

		Socket clientSocket = new Socket("localhost", 2222);

		System.out.println("Client Socket Created!");

		InputStream is = clientSocket.getInputStream();
		buffReader = new BufferedReader(new InputStreamReader(is));

		OutputStream os = clientSocket.getOutputStream();
		ps = new PrintStream(os, true);

		ids = new ArrayList<String>();
		protocol = new Protocol();

		myTimer = new MyTimer();
		timer = new Timer(1000, myTimer);
		timer.start();

		Talker talker = new Talker();
		talker.start();

	}

	private class Talker extends Thread {

		public void run(){

			ServerListener listener = new ServerListener();
			listener.start();

			while(!serverFull){

				// send objects to server
				String obj = ObjectGenerator.generate();

				System.out.println("Object Created!" + " \n" + obj);

				ps.println("c" + obj);

				System.out.println("Object Pushed to server: type:" + obj.charAt(0) + " id: " + Integer.parseInt(obj.substring(1, 17), 2) );

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Communicate to server to get all the ids

			boolean allIds = false;
			
			IdListener idListener = new IdListener();
			idListener.start();
			
			while (!allIds){
				try {
					ps.println("gg" + String.format("%16s", Integer.toBinaryString(1)).replace(" ", "0"));

					while (buffReader.ready()){
						String line = buffReader.readLine();
						ids.add(line);
					}
					
				} catch (IndexOutOfBoundsException | IOException e) {
					e.printStackTrace();
					allIds = true;
				}
			}

			Thread.yield();
			
			System.out.println("Number Of Id's: " + ids.size());

			for (int index = 1; index <= ids.size(); index++) {
				ps.println("r" + String.format("%16s", Integer.toBinaryString(index)).replace(" ", "0"));

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int index = 1; index <= ids.size(); index++) {
				ps.println("r" + String.format("%16s", Integer.toBinaryString(index)).replace(" ", "0"));

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			timer.stop();
			System.out.println("Time: "  + myTimer.getTime());
		}

	}

	private class IdListener extends Thread {
		
		public void run () {
					
			boolean stop = false;
			while (!stop) {
				try {
					while (buffReader.ready()){
						String line = buffReader.readLine();
						ids.add(line);
					}				
				} catch (IOException e) {
					e.printStackTrace();
					stop = true;
				}
			}
			
		}
		
	}
	
	private class ServerListener extends Thread {

		public void run () {

			while (true){
				try {
					while(buffReader.ready()){

						String line = buffReader.readLine();
						System.out.println("Message from Server: \n" + line);

						if (line.equals("Server Is Full!")) {
							serverFull = true;
							break;
						}else if (line.charAt(0) == 'r') {
							RaceCar racecar = protocol.deprotocolRacecar(line);
							updateRacecar(racecar);
						}else if (line.charAt(0) == 'd') {
							Driver driver = protocol.deprotocolDriver(line);
							updateDriver(driver);
						}else{

						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}

		private void updateRacecar(RaceCar racecar) {

			int horsepower = racecar.getHorsePower();
			racecar.setHorsePower(horsepower + 1003);

			String racecarProtocol = protocol.protocolRacecar(racecar);
			ps.println("u" + racecarProtocol);
		}

		private void updateDriver(Driver driver) {

			int age = driver.getAge();
			driver.setAge(age + 100);

			String driverProtocol = protocol.protocolDriver(driver);
			ps.println("u" + driverProtocol);
		}

	}

}

