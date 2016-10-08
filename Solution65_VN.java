
public class Solution65_VN {


	private String s;
	private int len;
	
	private boolean s0(int pos) {
		if(pos>=len) return false;
		char c = s.charAt(pos);
		if(c==' ') return s0(pos+1);
		if(c=='+' || c=='-') return s1(pos+1);
		//if(c=='0') return s2(pos+1);
		if(c>='0' && c<='9') return s3(pos+1);
		if(c=='.') return s4(pos+1);
		return false;
	}
	
	private boolean s1(int pos) {
		if(pos>=len) return false;
		char c = s.charAt(pos);
		//if(c=='0') return s2(pos+1);
		if(c>='0' && c<='9') return s3(pos+1);
		if(c=='.') return s4(pos+1);
		return false;
	}
	
	private boolean s2(int pos) {
		if(pos>=len) return true;
		char c = s.charAt(pos);
		//if(c=='.') return s4(pos+1);
		if(c=='e') return s5(pos+1);
		if(c>='0' && c<='9') return s7(pos+1);
		if(c==' ') return s8(pos+1);
		return false;
	}
	
	private boolean s3(int pos) {
		if(pos>=len) return true;
		char c = s.charAt(pos);
		if(c>='0' && c<='9') return s3(pos+1);
		if(c=='.') return s2(pos+1);
		if(c=='e') return s5(pos+1);
		if(c==' ') return s8(pos+1);
		return false;
	}
	
	private boolean s4(int pos) {
		if(pos>=len) return false;
		char c = s.charAt(pos);
		if(c>='0' && c<='9') return s7(pos+1);
		return false;
	}
	
	private boolean s5(int pos) {
		if(pos>=len) return false;
		char c = s.charAt(pos);
		if(c=='+' || c=='-') return s9(pos+1);
		if(c>='0' && c<='9') return s6(pos+1);
		return false;
	}
	
	private boolean s6(int pos) {
		if(pos>=len) return true;
		char c = s.charAt(pos);
		if(c>='0' && c<='9') return s6(pos+1);
		if(c==' ') return s8(pos+1);
		return false;
	}
	
	private boolean s7(int pos) {
		if(pos>=len) return true;
		char c = s.charAt(pos);
		if(c>='0' && c<='9') return s7(pos+1);
		if(c=='e') return s5(pos+1);
		if(c==' ') return s8(pos+1);
		return false;
	}
	
	private boolean s8(int pos) {
	    if(pos>=len) return true;
	    if(s.charAt(pos)==' ') return s8(pos+1);
	    return false;
	}
	
	private boolean s9(int pos) {
	    if(pos>=len) return false;
	    char c = s.charAt(pos);
	    if(c>='0' && c<='9') return s6(pos+1);
	    return false;
	}
	
	
    public boolean isNumber(String s) {
    	this.s = s;
        len = s.length();
        return s0(0);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution65_VN().isNumber("0.1"));
	}

}
