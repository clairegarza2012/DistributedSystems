package edu.neumont.csc380;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientCRUD implements ICRUD{

	private final int port = 2222;
	
	private Protocol protocol;

	public ClientCRUD(){

		protocol = new Protocol();
	}

	@Override
	public boolean create(String id, Object obj) {

		boolean serverFull = true;

		try {

			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Create Requested!");

			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				String object = protocol.protocolObject((HallaStorObject) obj);
	
				ps.println("c" + object);
	
				String objectSucessfullyCreated = buffReader.readLine();
	
				serverFull = !( objectSucessfullyCreated.equals("true") ) ;
	
				System.out.println("Server Full: " + serverFull);

			buffReader.close();
			ps.close();
			is.close();
			os.close();

			clientSocket.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}

		return serverFull;
	}

	@Override
	public Object read(String id) {

		Object object = null;

		try {

			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Read Requested!");

			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				ps.println("r" + id);
	
				String serverMessage = buffReader.readLine();
	
				object = protocol.deprotocolObject(serverMessage);

			buffReader.close();
			ps.close();
			is.close();
			os.close();

			clientSocket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return object; 
	}

	@Override
	public void update(String id, Object obj) {

		try {

			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Update Requested!");

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				String protocolObject = protocol.protocolObject((HallaStorObject) obj);
	
				ps.println("u" + protocolObject);

			ps.close();
			os.close();

			clientSocket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {

		try {

			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Delete Requested!");

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				ps.println("d" + id);	

			ps.close();
			os.close();

			clientSocket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getIds() {

		String ids = "";

		try {
			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Get All Ids Requested!");

			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				ps.println("gg" + String.format("%16s", Integer.toBinaryString(1)).replace(" ", "0"));
	
				String serverMessage = buffReader.readLine();
	
				System.out.println("All Ids");
	
				ids = serverMessage;

			buffReader.close();
			ps.close();
			is.close();
			os.close();

			clientSocket.close();

		} catch (Exception e){
			e.printStackTrace();
		}

		return ids;
	}

	@Override
	public boolean lock(String id) {

		boolean lockAccepted = false;

		try {
			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Lock Requested!");

			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				ps.println("l" + id);
	
				String serverMessage = buffReader.readLine();
				
				lockAccepted = serverMessage.equals("true");
			
			buffReader.close();
			ps.close();
			is.close();
			os.close();

			clientSocket.close();

		} catch (Exception e){
			e.printStackTrace();
		}

		return lockAccepted;
	}

	@Override
	public void unlock(String id) {

		try {
			Socket clientSocket = new Socket("localhost", port);

			System.out.println("Unlock Requested!");

			InputStream is = clientSocket.getInputStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));

			OutputStream os = clientSocket.getOutputStream();
			PrintStream ps = new PrintStream(os, true);

				ps.println("a" + id);

			buffReader.close();
			ps.close();
			is.close();
			os.close();

			clientSocket.close();

		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
