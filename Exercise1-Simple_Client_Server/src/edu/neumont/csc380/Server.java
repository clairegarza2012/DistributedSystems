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

				System.out.println("Message Recieved!\n" + Integer.parseInt(line.substring(2, 18), 2));

				char operation = line.charAt(0);

				char objProposition = line.charAt(1);

				String object = line.substring(2);

				Object obj = doOperation(operation, object, objProposition, protocol);

				if (obj != null){
					ps.println("From Server: " + obj.toString());
					System.out.println("Sent message to Client");
				}

			}

			// How do you know when the server is full?
			
			// If server is full,
				// tell client to stop making objects
		}

		//ss.close();
		//serverSocket.close();
	}

	private HallaStorObject getObject(char objProposition, String object, Protocol protocol) {

		HallaStorObject obj = null; 

		if (objProposition == 'r'){
			obj = protocol.deprotocolRacecar(object);
		}else if (objProposition == 'd'){
			obj = protocol.deprotocolDriver(object);
		}

		return obj;
	}

	private Object doOperation(char operation, String object, char objectProposition, Protocol protocol) {

		Object o = null;

		if (operation == 'c' || operation == 'u'){
			HallaStorObject obj = getObject(objectProposition, object, protocol);

			if (operation == 'c') {
				create(obj); 
			}
			else { 
				update(obj); 
			}
		}
		else if (operation == 'r' || operation == 'd'){
			int id = Integer.parseInt(object, 2);

			if (operation == 'r') {
				o = read(id);
			}
			else {
				delete(id);
			}
		}

		return o;
	}

	private void create(HallaStorObject obj){

		store.add("" + obj.getId(), obj);
	}

	private Object read(int id){

		return store.get("" + id);
	}

	private void update(HallaStorObject obj){

		store.update("" + obj.getId(), obj);
	}

	private void delete(int id){

		store.delete("" + id);
	}
}
