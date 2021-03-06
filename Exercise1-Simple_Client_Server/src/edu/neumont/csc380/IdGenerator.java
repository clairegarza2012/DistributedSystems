package edu.neumont.csc380;

public class IdGenerator {
	
	private static int id;
	
	private static IdGenerator idGenerator;
	
	private IdGenerator(){
		IdGenerator.id = 0;
	}
	
	public static IdGenerator getInstance(){
		
		if (idGenerator == null){
			synchronized (IdGenerator.class){
				if (idGenerator == null){
					idGenerator = new IdGenerator();
				}
			}
		}
		
		return idGenerator;
	}
	
	public void incrementId(){
		++id;
	}
	
	public int getId(){
		return id;
	}

}
