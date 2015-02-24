import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class Redstone {

	public static void main(String[] args){

		int result;

		try {
			result = getNumberOfLinesFromFile();
			System.out.println("Result: " + result);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int getNumberOfLinesFromFile() throws IOException{

		BufferedReader reader = new BufferedReader(new FileReader("test.txt"));

		HashSet<String> words = new HashSet<String>();

		while (reader.ready()){
			String s = reader.readLine();

			String[] wordsOnLine = s.split("\\W");

			for (String s1: wordsOnLine){
				System.out.println(s1);
				words.add(s1.toLowerCase());
			}
		}

		return words.size();
	}
}
