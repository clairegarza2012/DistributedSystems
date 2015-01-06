package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	/* The client will use the server to store and retrieve instances of the following simple POJOs 
	 * (associated with keys of type String):
	 * 
	 */
	
	public static void main(String[] args){
		
		try {
			new Client();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client() throws IOException{
		
			Socket clientSocket = new Socket("localhost", 2222);
		
			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));
		
			OutputStream os = clientSocket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			
			while (buffReader.ready()){
				String line = buffReader.readLine();
				line = "Client: " + line;
				
				pw.println(line);
			}
			
			clientSocket.close();

	}
}

