package edu.neumont.csc380;

public class ServerCRUD implements ICRUD{
	
	private Store store;
	private IdGenerator idGenerator;
	private Locks locks;
	
	public ServerCRUD(){
		
		store = Store.getInstance();
		idGenerator = IdGenerator.getInstance();
		locks = Locks.getInstance();
	}
	
	@Override
	public boolean create(String id, Object obj) {

		if (id.equals("0")) { // makes sure that the object doesn't already have an id.. then creates one

			idGenerator.incrementId();

			int idNum = idGenerator.getId();
			
			HallaStorObject object = (HallaStorObject) obj; 
			object.setId(idNum);
			
			id = "" + idNum;
		}
		
		return store.addObject(id, obj);
	}

	@Override
	public Object read(String id) {

		return store.getObject(id);
	}

	@Override
	public void update(String id, Object obj) {
		
		store.updateObject(id, obj);		
	}

	@Override
	public void delete(String id) {

		store.deleteObject(id);
	}

	@Override
	public String getIds() {
		
		return store.getIds();
	}

	@Override
	public boolean lock(String id) {
					
		boolean lockAdded = locks.addLock(id);
		
		return lockAdded;
	}

	@Override
	public void unlock(String id) {
		
		locks.removeLock(id);
	}

}
