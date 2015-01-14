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
		
		return string;
	}
	
	public void addObject(String key, Object value){
		
		store.add(key, value);		
		ids.add(key);
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