/*
Miller-Rabin Primality Test
*/
import java.math.BigInteger;
 
public class MillerRabin {
	
	static final BigInteger ZERO = BigInteger.ZERO;
	static final BigInteger UN = BigInteger.ONE;
	static final BigInteger DEUX = new BigInteger("2");
	
	static int[] temoins_premiers = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97}; 
	
	public static void main(String[] args) {
		
		BigInteger x = new BigInteger("170141183460469231731687303715884105727");
		
		if(est_probablement_premier(x))
			System.out.println("Le nombre "+ x +" est trés probablement premier");
		else
			System.out.println("Le nombre "+ x +" n'est absolument pas premier");
		
	}
 
	public static boolean est_probablement_premier(BigInteger n)
    {
    	for(int i=0; i < 25; i++)
    	{
    		if(est_temoin(n,BigInteger.valueOf(temoins_premiers[i])))
    			return false;
    	}
    	return true;
    }
	
    static boolean est_temoin(BigInteger n, BigInteger a) {
    	
    	BigInteger s = ZERO;
    	BigInteger t = n.subtract(UN);
    	
    	while (t.mod(DEUX).equals(ZERO)) {
			s = s.add(UN);
			t = t.divide(DEUX);
		}
        
        if (a.modPow(t,n).equals(UN)) {
             return false;
        }
        for (int i=0; BigInteger.valueOf(i).compareTo(s) < 0; i++) {
            if (a.modPow(BigInteger.valueOf(2).pow(i).multiply(t), n).equals(n.subtract(UN))) {
                return false;
            }
        }
        return true;
    }    
}
