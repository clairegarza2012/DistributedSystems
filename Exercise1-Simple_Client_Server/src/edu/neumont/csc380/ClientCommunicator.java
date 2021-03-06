package edu.neumont.csc380;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.zip.ZipException;

import com.hallaLib.HallaZip;

public class ClientCommunicator {

	private Protocol protocol;

	private PrintStream ps;

	private ICRUD crud;

	public ClientCommunicator(Socket socket){

		this.crud = new ServerCRUD();

		protocol = new Protocol();

		crud = new ServerCRUD();

		try {
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();

			ps = new PrintStream(os, true);

			InputStreamReader inputReader = new InputStreamReader(is);

			BufferedReader buffReader = new BufferedReader(inputReader);

			while (!buffReader.ready()) {
				// wait until buffered reader is ready
			}

			byte[] bytes = new byte[inputReader.read()];
			int index = 0;
			
			while (buffReader.ready()){
				
//				int i = buffReader.read();
				
				System.out.println((char)buffReader.read());
//				char a = (char)i;
//				
//				bytes[index] = (byte) a;
//				
//				System.out.println(i + " " + a + " " + bytes[index]);
//				index++;
			}
			
//			String messageFromClient = buffReader.readLine();
//			System.out.println("Message From Client: " + messageFromClient);
//
//			//char operation = messageFromClient.charAt(0);
//
//			String object = messageFromClient.substring(1);
//
//			char[] objectCharacters = object.toCharArray();
//
//			for (int i = 0; i < objectCharacters.length; i++){
//				objectCharacters[i] = object.charAt(i);
//				System.out.println(objectCharacters[i] + "  :  " + object.charAt(i));
//			}
//
//			System.out.println("Object Characters: " + objectCharacters.toString());
//
//			byte[] objectBytes = new byte[objectCharacters.length];
//			System.out.println("objectBytes: " + objectBytes);
//
//			for (int i = 0 ; i < objectCharacters.length; i++){
//
//				objectBytes[i] = (byte) objectCharacters[i];
//				System.out.println(objectBytes[i]);
//			}			

			byte[] decompressedMessageFromClient = HallaZip.expand(bytes);

			System.out.println(decompressedMessageFromClient);

			//			synchronized (object) {
			//
			//				Object obj = doOperation(operation, object);
			//
			//				if (obj != null){
			//					sendObjectToClient(obj);
			//				}
			//			}

			buffReader.close();
			is.close();

			ps.close();
			os.close();

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendObjectToClient(Object obj) {

		char objProposition = obj.toString().charAt(0);

		if (objProposition == 'R' || objProposition == 'D'){

			ps.println(protocol.protocolObject((HallaStorObject) obj));
		}
		else {

			ps.println(obj);
		}

		System.out.println("Sent message to Client: " + obj.toString());
	}

	private Object doOperation(char operation, String object) {

		Object o = null;

		if (operation == 'g'){

			String ids = crud.getIds();

			o = ids;
		}
		else if (operation == 'u' || operation == 'c'){
			HallaStorObject obj = protocol.deprotocolObject(object);
			String id = "" + obj.getId();
			if (operation == 'u'){

				crud.update(id, obj); 
			}
			else if (operation == 'c'){

				o = crud.create(id, obj); 
			}
		}
		else {

			if (operation == 'r'){
				o = crud.read(object);
			}
			else if (operation == 'd'){
				crud.delete(object);
			}
			else if (operation == 'l'){
				o = crud.lock(object);
			}
			else if (operation == 'a'){
				crud.unlock(object);
			}
		}

		return o;
	}

}
