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

	private ArrayList<String> ids = new ArrayList<String>();
	private boolean serverFull = false;

	private BufferedReader buffReader;
	private PrintStream ps;

	private Protocol protocol;
	
	private Timer timer;
	private MyTimer myTimer;
	
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

		protocol = new Protocol();
		
		myTimer = new MyTimer();
		timer = new Timer(1000, myTimer);
		timer.start();

		Talker talker = new Talker();
		talker.start();

	}

	private class Talker extends Thread {

		public void run(){

			IdListener idListener = new IdListener();
			idListener.start();
			
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

			idListener.stop();
			
			System.out.println("Number Of Id's: " + ids.size());

			ServerListener listener = new ServerListener();
			listener.start();
			
			for (int i = 0; i < ids.size(); i++) {
				ps.println("r" + ids.get(i));
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < ids.size(); i++) {
				ps.println("r" + ids.get(i));
				
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

	private class IdListener extends Thread{
		
		public void run (){
			
			while (true){
				try {
					while (buffReader.ready()){
						String line = buffReader.readLine();
						ids.add(line);
					}
					
				} catch (IOException e){
					e.printStackTrace();
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
						}
						else if (line.charAt(0) == 'r') {
							RaceCar racecar = protocol.deprotocolRacecar(line);
							updateRacecar(racecar);
						}else if (line.charAt(0) == 'd') {
							Driver driver = protocol.deprotocolDriver(line);
							updateDriver(driver);
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

