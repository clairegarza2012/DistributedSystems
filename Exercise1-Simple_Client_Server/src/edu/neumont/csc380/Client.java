package edu.neumont.csc380;

import java.util.ArrayList;

public class Client {

	private ArrayList<String> ids;
	private ICRUD crud;

	private long startTime;

	public static void main(String[] args){

		new Client();
	}

	public Client() {

		initializeVariablesAndStartTimer();

		createObjects();

		getObjectIds();

		System.out.println("Number Of Id's: " + ids.size());

		readAndUpdateObjects();

		Thread.yield();

		readObjects();

		getTime();
	}

	private void initializeVariablesAndStartTimer() {

		startTime = System.currentTimeMillis();

		ids = new ArrayList<String>();
		crud = new ClientCRUD();	
	}

	private void createObjects() {

		boolean serverFull = false;

		while (!serverFull) {

			HallaStorObject obj = ObjectGenerator.generate();

			System.out.println(obj.toString());

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

	private void readAndUpdateObjects(){

		int index = 0;

		while (index < ids.size()) {

			synchronized (ids.get(index)) {
				
				if (crud.lock(ids.get(index))) {

					HallaStorObject obj = (HallaStorObject) crud.read(ids.get(index));

					System.out.println("Read and Update: " + obj.toString());

					obj.update();

					crud.update(ids.get(index), obj);

					crud.unlock(ids.get(index));

					index++;
				}
				else {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void readObjects() {

		int index = 0;

		while (index < ids.size()) {

			if (crud.lock(ids.get(index))) {

				HallaStorObject obj = (HallaStorObject) crud.read(ids.get(index));

				System.out.println("Read: " + obj.toString());

				crud.unlock(ids.get(index));

				index++;
			}
		}

	}

	private void getTime() {

		long endTime = System.currentTimeMillis();

		long finalTime = endTime - startTime;

		System.out.println("Time: " + formatTimeFromMilliseconds(finalTime));
	}

	private String formatTimeFromMilliseconds(long millis){

		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;

		return String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
	}

}

