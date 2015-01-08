package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

	/* The client will use the server to store and retrieve instances of the following simple POJOs 
	 * (associated with keys of type String):
	 * 
	 */
	//private static Scanner scan = new Scanner(System.in);

	private ArrayList<String> ids = new ArrayList<String>();
	private boolean serverFull = false;

	private BufferedReader buffReader;
	private PrintStream ps;

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
		buffReader = new BufferedReader(new InputStreamReader(is));

		OutputStream os = clientSocket.getOutputStream();
		ps = new PrintStream(os, true);

		ServerListener thread = new ServerListener();
		thread.start();
		
		Talker talk = new Talker();
		talk.start();


//		while(buffReader.readLine() != null){
//
//			String line = buffReader.readLine();
//			System.out.println("Message from Server: \n" + line);
//
//			if (line.equals("Server Is Full!")){
//				serverFull = true;
//			}
//			if (line.equals("sucessful!")){
//				ids.add("some string");
//			}
//		}

		//		while(!serverFull){
		//			
		//			// send objects to server
		//			String obj = ObjectGenerator.generate();
		//
		//			System.out.println("Object Created!");
		//
		//			ps.println("c" + obj);
		//
		//			System.out.println("Object Pushed to server: type:" + obj.charAt(0) + " id:" + Integer.parseInt(obj.substring(1, 17), 2) );
		//			
		//			try {
		//				Thread.sleep(1000);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//		}
		//		
		//		System.out.println("Number Of Id's: " + ids.size());

		//while (true){
		// update objects
		//}

		//clientSocket.close();
	}

	private class Talker extends Thread {

		public void run(){

			while(!serverFull){

				// send objects to server
				String obj = ObjectGenerator.generate();

				System.out.println("Object Created!");

				ps.println("c" + obj);

				System.out.println("Object Pushed to server: type:" + obj.charAt(0) + " id:" + Integer.parseInt(obj.substring(1, 17), 2) );

				ids.add(obj.substring(0, 17));

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Number Of Id's: " + ids.size());

			for (int i = 0; i < ids.size(); i++){
				String id = ids.get(i);
				ps.println("r" + id);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	private class ServerListener extends Thread {

		public void run () {

			try {
				while(buffReader.readLine() != null){

					String line = buffReader.readLine();
					System.out.println("Message from Server: \n" + line);

					if (line.equals("Server Is Full!")){
						serverFull = true;
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

}

