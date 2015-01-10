package edu.neumont.csc380;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.hallaLib.HallaStor;

public class Server {

	private static HallaStor store;
	
	private ServerSocket serverSocket;
	
	private Server server;
	
	private IdGenerator idGenerator;

	public static void main(String[] args){

		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Server() throws IOException{

		serverSocket = new ServerSocket(2222); // 2222 is the port

		System.out.println("Server Created");

		store = HallaStor.getInstance();

		idGenerator = IdGenerator.getInstance();
		
		server = this;
		
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

					ClientCommunicator thread = new ClientCommunicator(clientSocket, server);

					thread.start();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int create(Object obj){

		int id = idGenerator.getId();
				
		store.add("" + id, obj);
		
		return id;
	}

	public Object read(int id){

		return store.get("" + id);
	}

	public void update(String id, Object obj){

		store.update(id, obj);
	}

	public void delete(int id){

		store.delete("" + id);
	}
}
