package edu.neumont.csc380;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/* The client will use the server to store and retrieve instances of the following simple POJOs 
	 * (associated with keys of type String):
	 * 
	 */
	
	public static void main(String[] args){
		
		new Client();
	}

	public Client(){

		try {
			Socket s = new Socket("localhost", 2222);
		
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

