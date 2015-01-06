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
import com.hallaLib.HallaZip;

public class Server {

	/* The server should provide simple CRUD operations for a key/value store. 
	 *  
	*/
	
	public static void main(String[] args){
		
		try {
			new Server();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Server() throws IOException{
		
			ServerSocket ss = new ServerSocket(2222); // 2222 is the port
			
			System.out.println("server socket created");
			
			Socket serverSocket = ss.accept();
			
			System.out.println("server socket accepted!");
			
			OutputStream out = serverSocket.getOutputStream();
		
			PrintStream ps = new PrintStream(out, true);
			ps.println("A message to the client!");
			
			System.out.println("message sent to client");
			
			InputStream is = serverSocket.getInputStream();
			
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));
			
			while(buffReader.ready()){
				String line = buffReader.readLine();
				System.out.println(line);
			}
			
			HallaStor store = HallaStor.getInstance();
			HallaZip zip = new HallaZip();
			
			
			ss.close();
			serverSocket.close();
			
		
	}
	
}
