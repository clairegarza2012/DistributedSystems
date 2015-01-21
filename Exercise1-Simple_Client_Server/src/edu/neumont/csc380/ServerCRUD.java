package edu.neumont.csc380;

public class ServerCRUD implements ICRUD{

	private Store store;
	private IdGenerator idGenerator;
	
	private String lock;
	
	public ServerCRUD(){
		
		store = Store.getInstance();
		idGenerator = IdGenerator.getInstance();
		lock = "";
	}
	
	@Override
	public boolean create(String id, Object obj) {

		String binaryId = id.substring(1);

		if (Integer.parseInt(id.substring(1), 2) == 0) { // makes sure that the object doesn't already have an id.. then creates one

			idGenerator.incrementId();

			int idNum = idGenerator.getId();

			HallaStorObject object = (HallaStorObject) obj; 
			object.setId(idNum);

			binaryId = String.format("%16s", Integer.toBinaryString(idNum)).replace(" ", "0");
		}
		
		return store.addObject("" +  id.charAt(0) + "" + binaryId, obj);
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
		
		if (lock == ""){
			lock = id;
			return true;
		}
		
		return false;
	}

	@Override
	public void unlock() {
		
		lock = "";
	}

}
