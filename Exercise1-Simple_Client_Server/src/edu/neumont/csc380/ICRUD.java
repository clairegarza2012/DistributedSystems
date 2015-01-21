package edu.neumont.csc380;

public interface ICRUD {

	public boolean create(String id, Object obj);
	
	public Object read(String id);
	
	public void update(String id, Object obj);
	
	public void delete(String id);
	
	public String getIds();
	
	public boolean lock(String id);
	
	public void unlock();
}
