package edu.neumont.csc380;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

public class Client {

	private ArrayList<String> ids;
	private ClientCRUD crud;
	
	private long startTime;
	
	public static void main(String[] args){

		try {
			new Client();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client() throws IOException{

		initializeVariablesAndStartTimer();

		createObjects();

		getObjectIds();

		System.out.println("Number Of Id's: " + ids.size());

		readObjects();

		readObjects();

		stopTimer();
	}

	private void initializeVariablesAndStartTimer() throws IOException {

		startTime = System.currentTimeMillis();
		
		ids = new ArrayList<String>();
		crud = new ClientCRUD();	
	}

	private void createObjects() {

		boolean serverFull = false;

		while (!serverFull) {

			HallaStorObject obj = ObjectGenerator.generate();

			System.out.println("Object Created!" + " \n" + obj.toString());

			serverFull = crud.create("", obj);
		}

	}

	private void getObjectIds() {

		String ids = null;
		
		ids = crud.getIds();

		getIds(ids);
	}

	private void getIds(String line) {

		System.out.println("Getting Ids");

		int lineBreak = 17;
		int placeInLine = 0;

		System.out.println("Line Length: " + line.length());

		while (placeInLine < (line.length() - 1)){

			String id = line.substring(placeInLine, placeInLine + lineBreak);
			System.out.println("Id: " + id);
			ids.add(id);
			placeInLine += lineBreak;
		}		

	}

	private void readObjects() {

		int index = 0;
		
		while (index < ids.size()) {

			if (crud.lock(ids.get(index))) {

				HallaStorObject obj = (HallaStorObject) crud.read(ids.get(index));

				obj.update();
				
				crud.update(ids.get(index), obj);
				
				crud.unlock();
				
				index++;
			}
		}

	}

	private void stopTimer() throws IOException {

		long endTime = System.currentTimeMillis();
		
		long finalTime = endTime - startTime;
		
		System.out.println("Time: " + getTime(finalTime));
	}
	
	private String getTime(long time){
		
		long second = (time / 1000) % 60;
		long minute = (time / (1000 * 60)) % 60;
		long hour = (time / (1000 * 60 * 60)) % 24;

		return String.format("%02d:%02d:%02d:%d", hour, minute, second, time);
	}

}

