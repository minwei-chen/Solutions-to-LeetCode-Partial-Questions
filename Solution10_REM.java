
public class Solution10_REM {

    private boolean isMatch(String s, String p, char pre) {
        
        char s0 = s.length()>0? s.charAt(0): '\0', p0 = p.length()>0? p.charAt(0): '\0';
        if(s0=='\0' && p0=='\0') return true;
        
        boolean match = false;
        
        if(s0==p0 || p0=='.') {
            if(s0!='\0') match = match || isMatch(s.substring(1, s.length()), p.substring(1, p.length()), p0);
        }
        else {
            if(p0=='*') {
                if(pre==s0 || pre=='.') if(s0!='\0') match = match || isMatch(s.substring(1, s.length()), p, pre);
                match = match || isMatch(s, p.substring(1, p.length()), '\0');
            }
        }
        if(p.length()>1 && p.charAt(1)=='*') match = match || isMatch(s, p.substring(2, p.length()), p0);
        return match;
    }
    
    
    public boolean isMatch(String s, String p) {
        //if(p.length()>0 && p.charAt(0)=='*') return false;
        return isMatch(s, p, '\0');
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean rs = new Solution10_REM().isMatch("bbbba", ".*a*a");
	}

}
