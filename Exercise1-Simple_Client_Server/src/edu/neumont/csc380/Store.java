package edu.neumont.csc380;

import java.util.ArrayList;

import com.hallaLib.HallaStor;

public class Store {

	private static HallaStor store;

	private static Store instance;

	private static ArrayList<String> ids;

	private Store(){
		ids = new ArrayList<String>();
		store = HallaStor.getInstance();
	}

	public static Store getInstance(){

		if (instance == null){
			synchronized (Store.class){
				if (instance == null){
					instance = new Store();
				}
			}
		}

		return instance;
	}

	public String getIds(){

		String string = "";

		for (int i = 0; i < ids.size(); i++){
			string += ids.get(i);
		}
		System.out.println("From Store: " + string);
		return string;
	}

	public boolean addObject(String key, Object value){

		try {
			ids.add(key);

			store.add(key, value);	
		} catch (IllegalStateException e) {
			System.out.println("Adding an Object to Store Failed!!: " + " key:" + key + " value: " + value);
			ids.remove(key);
			return false;
		}
		return true;
	}

	public Object getObject(String key){
		return store.get(key);
	}

	public void updateObject(String key, Object value){
		store.update(key, value);
	}

	public void deleteObject(String key){
		ids.remove(key);
		store.delete(key);
	}

}
