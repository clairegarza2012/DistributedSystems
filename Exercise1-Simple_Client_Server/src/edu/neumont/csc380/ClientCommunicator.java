package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientCommunicator extends Thread{

	private Protocol protocol;
	private Server server;
	
	private PrintStream ps;
	private BufferedReader buffReader;

	public ClientCommunicator(Socket socket, Server server){

		protocol = new Protocol();
		this.server = server;

		try {
			OutputStream out = socket.getOutputStream();

			ps = new PrintStream(out, true);

			InputStream is = socket.getInputStream();

			buffReader = new BufferedReader(new InputStreamReader(is));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(){

		while (true){

			try {
				while (buffReader.ready()){

					String line = buffReader.readLine();

					System.out.println("Message Recieved!\n" + Integer.parseInt(line.substring(2, 18), 2));

					char operation = line.charAt(0);

					String object = line.substring(1);

					System.out.println("Object: " + object);

					try{
						Object obj = doOperation(operation, object, protocol);

						if (obj != null){
							sendObjectToClient(obj);
						}

					} catch (IllegalStateException e){
						ps.println("Server Is Full!");
						System.out.println("Server is full!");
					}

				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void sendObjectToClient(Object obj) {
		
		char objProposition = obj.toString().charAt(0);

		if (objProposition == 'R'){
			ps.println(protocol.protocolRacecar((RaceCar) obj));
		}
		else {
			ps.println(protocol.protocolDriver((Driver) obj));
		}
		System.out.println("Sent message to Client");
		
	}

	private Object doOperation(char operation, String object, Protocol protocol) {

		Object o = null;

		if (operation == 'c' || operation == 'u'){
			
			String proposition = "";
			Object obj;
			
			if (object.charAt(0) == 'r'){
				obj = protocol.deprotocolRacecar(object);
				proposition = "r";
			}
			else {
				obj = protocol.deprotocolDriver(object);
				proposition = "d";
			}
			
			if (operation == 'c') {
				int id2 = server.create(obj); 
				ps.println(proposition + "" + Integer.toBinaryString(id2) );
			}
			else { 
				String id = object.substring(1, 17);
				server.update(id, obj); 
			}
		}
		else if (operation == 'r' || operation == 'd'){
			int id = Integer.parseInt(object.substring(1), 2);

			if (operation == 'r') {
				o = server.read(id);
			}
			else {
				server.delete(id);
			}
		}

		return o;
	}

}
