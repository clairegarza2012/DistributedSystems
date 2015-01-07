package edu.neumont.csc380;

public abstract class HallaStorObject {
	
	/* I just need the objects to know they are related in the sense that 
	 * I statically made there protocol and they are the only objects that
	 * can be communicated properly across the sockets
	 */
	
	private static int id = 0;
	
	public HallaStorObject(){
		
		id++;
	}
	
	public HallaStorObject(int id){
		HallaStorObject.id = id;
	}
	
	public int getId(){
		return id;
	}
}
