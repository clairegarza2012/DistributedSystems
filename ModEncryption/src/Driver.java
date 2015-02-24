
public class Driver {

	public static void main(String [] args){
		
		Driver driver = new Driver();
		
		String strang = "STOP POLLUTION";
		
		driver.run(strang, 7, 17, 26);
		driver.run("stop pollution", 17, 4, 26);		
	}

	private void run(String strang, int multiple, int additive, int modder) {
				
		String encryptedString = encryptString(strang, multiple, additive, modder);
	
		System.out.println(encryptedString);
	}
	
	private String encryptString(String strang, int multiple, int additive, int modder) {

		String encryptedString = "";
		
		strang = strang.toUpperCase();
		
		for (int i = 0; i < strang.length(); i++){
			
			encryptedString += encryptChar(strang.charAt(i), multiple, additive, modder);
		}
		
		return encryptedString;
	}
	
	private char encryptChar(char originalChar, int multiple, int addative, int modder){
		
		char encryptedChar;
		
		int charInt = originalChar - 65;
		
		charInt *= multiple;
		charInt += addative;
		charInt %= modder;
		
		encryptedChar = (char)(charInt + 65);		
		
		return encryptedChar;		
	}
	
}
