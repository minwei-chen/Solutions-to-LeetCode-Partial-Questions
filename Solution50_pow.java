
public class Solution50_pow {

    public double myPow(double x, int n) {
        double rs = 1.0;
        if(n<0) {
        	x = 1/x;
        }
        while(n!=0) {
        	if(Math.abs(n%2)==1) rs *= x;
        	n /= 2;
        	x *= x;
        }
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution50_pow().myPow(2.00000, -2147483648));
	}

}
