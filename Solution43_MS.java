
public class Solution43_MS {

	
    public String multiply(String num1, String num2) {
        final int len1 = num1.length(), len2 = num2.length();
        int[] rs = new int[len1+len2];
        int mSignificant;
        
        for(int i = 0; i<len1; i++) {
        	for(int j = 0; j<len2; j++) {
        		rs[i+j] += (num1.charAt(len1-1-i)-'0')*(num2.charAt(len2-1-j)-'0');
        	}
        }
        
        for(int k = 0, med; k<len1+len2-1; k++) {
        	med = rs[k];
        	rs[k] = med%10;
        	rs[k+1] += med/10;
        }
        
        for(mSignificant = len1+len2-1; mSignificant>=0 && rs[mSignificant]==0; mSignificant--);
        
        char[] interRs = new char[mSignificant+1];
        
        for(int l = 0; l<=mSignificant; l++) {
        	interRs[l] = (char)(rs[mSignificant-l]+'0');
        }
        
        return new String(interRs);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
