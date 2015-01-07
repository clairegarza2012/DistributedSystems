package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.hallaLib.HallaStor;

public class Server {

	/* The server should provide simple CRUD operations for a key/value store. 
	 *  
	 */
	private static HallaStor store;
	
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

		store = HallaStor.getInstance();
		
		Protocol protocol = new Protocol();
		
		while (true){
			while (buffReader.ready()){
				String line = buffReader.readLine();

				System.out.println("Message Recieved!\n" + line);
				char objProposition = line.charAt(0);

				String object = line.substring(1);

				if (objProposition == 'r'){
					RaceCar car = protocol.deprotocolRacecar(object);
					store.add("" + car.getId(), car);
				}else if (objProposition == 'd'){
					Driver driver = protocol.deprotocolDriver(object);
					store.add("" + driver.getId(), driver);
				}
				
				ps.println("From Server: " + line);
				System.out.println("Sent message to Client");
			}
		}
		
		//ss.close();
		//serverSocket.close();
	}

}
