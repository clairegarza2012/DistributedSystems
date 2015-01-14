package edu.neumont.csc380;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static Store store;
		
	private ServerSocket serverSocket;
	
	private Server server;
	
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

		store = Store.getInstance();
		
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
	
	public void create(String id, Object obj){
	
		store.addObject(id, obj);
	}

	public Object read(String id){

		return store.getObject(id);
	}

	public void update(String id, Object obj){

		store.updateObject(id, obj);
	}

	public void delete(String id){

		store.deleteObject(id);
	}
	
	public String getIds(){
		return store.getIds();
	}
}
