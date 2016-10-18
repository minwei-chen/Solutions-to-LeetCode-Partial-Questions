import java.math.BigInteger;


public class Solution62_UP {

    public int uniquePaths(int m, int n) {
        BigInteger numerator = BigInteger.valueOf(1), denominator = BigInteger.valueOf(1);
        int bottom = m+n-2, top = Math.min(m-1, n-1);
        for(int i = 0; i<top; i++) numerator = numerator.multiply(BigInteger.valueOf(bottom-i));
        for(int i = top; i>1; i--) denominator = denominator.multiply(BigInteger.valueOf(i));
        return numerator.divide(denominator).intValue();
        
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution62_UP().uniquePaths(3, 2);
	}

}
