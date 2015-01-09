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

	private ServerSocket serverSocket;

	private Protocol protocol;

	public static void main(String[] args){

		try {
			new Server();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Server() throws IOException{

		serverSocket = new ServerSocket(2222); // 2222 is the port

		System.out.println("server created");

		store = HallaStor.getInstance();

		protocol = new Protocol();

		ClientListener listener = new ClientListener();

		listener.start();

		//ss.close();
		//serverSocket.close();
	}

	private class ClientListener extends Thread{

		public void run(){

			while (true){
				try {
					Socket clientSocket = serverSocket.accept();

					System.out.println("client accepted!");

					ClientCommunicator thread = new ClientCommunicator(clientSocket);

					thread.start();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ClientCommunicator extends Thread {

		private PrintStream ps;
		private BufferedReader buffReader;

		public ClientCommunicator(Socket socket){

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

								char objProposition = obj.toString().charAt(0);

								if (objProposition == 'R'){
									ps.println(protocol.protocolRacecar((RaceCar) obj));
								}
								else {
									ps.println(protocol.protocolDriver((Driver) obj));
								}
								System.out.println("Sent message to Client");

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
	}

	private Object doOperation(char operation, String object, Protocol protocol) {

		Object o = null;

		if (operation == 'c' || operation == 'u'){
			HallaStorObject obj = protocol.deprotocolObject(object);

			if (operation == 'c') {
				create(obj); 
			}
			else { 
				update(obj); 
			}
		}
		else if (operation == 'r' || operation == 'd'){
			int id = Integer.parseInt(object.substring(1), 2);

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
