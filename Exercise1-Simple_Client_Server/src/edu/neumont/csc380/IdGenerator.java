package edu.neumont.csc380;

public class IdGenerator {
	
	private static int id;
	
	private static IdGenerator idGenerator;
	
	private IdGenerator(){
		this.id = 0;
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
	
	public int getId(){
		return ++id;
	}

}
