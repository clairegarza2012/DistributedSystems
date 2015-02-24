
public class Driver {

	// works for n base 0
	public static void main(String[] args){
		
		Driver driver = new Driver();
	
		int first = 1;
		int second = 1;

		int n = 0;
		
		n = driver.doSequenceInterative(first, second, 5);
		
		System.out.println("N: " + n);
		
		n = driver.doSequenceRecursive(first, second, 1, 5);
		
		System.out.println("N: " + n);
	}

	private int doSequenceRecursive(int first, int second, int count, int n) {

		if (count >= n){
			return second;
		}
				
		return doSequenceRecursive(second, first + second, ++count, n);
	}

	private int doSequenceInterative(int first, int second, int n) {

		for (int count = 1; count < n; count++){
			int temp = second;
			second += first;
			first = temp;
		}
		
		return second;
	}
	
	
	
	
}
