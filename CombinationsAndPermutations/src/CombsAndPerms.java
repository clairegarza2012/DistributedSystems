import java.math.BigInteger;


public class CombsAndPerms {

	public static void main(String [] args){
		CombsAndPerms cwr = new CombsAndPerms();
		
		BigInteger n = BigInteger.valueOf(8);
		BigInteger k = BigInteger.valueOf(24);
				
		BigInteger ans = cwr.getCombinationWithRepetition(n, k);
				
		System.out.println(ans);
	}
	
	private BigInteger getCombinationWithRepetition(BigInteger n, BigInteger k){
		
		n = (n.add(k)).subtract(BigInteger.valueOf(1));

		return choose(n, k);
	}
	
	private BigInteger factorial(BigInteger a){
		
		BigInteger result = BigInteger.valueOf(1);
		
		
		for (BigInteger i = BigInteger.valueOf(2); i.intValue() <= a.intValue(); i = i.add(BigInteger.valueOf(1))){
			result  = result.multiply(i);
		}
		
		return result;
	}
	
	private BigInteger choose(BigInteger n, BigInteger k){
		
		return factorial(n).divide((factorial(k).multiply(factorial(n.subtract(k)))));
	}
	
}
