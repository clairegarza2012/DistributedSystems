package edu.neumont.csc380;

import com.hallaLib.HallaStor;

public class Store {

	private static HallaStor store;
		
	private static Store instance;
	
	private Store(){
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

	public void addObject(String key, Object value){
		store.add(key, value);
	}
			
	public Object getObject(String key){
		return store.get(key);
	}

	public void updateObject(String key, Object value){
		store.update(key, value);
	}
	
	public void deleteObject(String key){
		store.delete(key);
	}
	
}
