import java.util.HashSet;
import java.util.Scanner;


public class Solution8_STI {

	public int myAtoi(String str) {
		
        if(str==null || str.length()==0) return 0;
        
        String ch;
        boolean overflow = false;
        int curDig = 0, sigNum = 1, result = 0;
        HashSet<String> sigs = new HashSet<String>();
        HashSet<String> nums = new HashSet<String>();
        
        sigs.add("+"); sigs.add("-");
        for(int i = 0; i<10; i++) nums.add(""+i);
        
        while(curDig<str.length()-1 && str.charAt(curDig)==' ') curDig++;
        
        ch = ""+str.charAt(curDig);
        if(sigs.contains(ch)) { curDig++; if(ch.equals("-")) sigNum = -1;}
     
        for(int pre, dig; curDig<str.length(); curDig++) {
        	ch = ""+str.charAt(curDig);
        	if(!nums.contains(ch)) {curDig = str.length(); continue;}
        	dig = Integer.valueOf(ch);
        	pre = result;
        	result = result*10+dig;
        	if(result<pre || (result-dig)/10!=pre) {overflow = true; break;}
        }
        
        if(overflow) {
        	if(sigNum < 0) result = -2147483648;
        	else result = 2147483647;
        }
        else if(sigNum < 0) result = 0-result;
        
        return result;	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//System.out.println(0-(-2147483648));
		System.out.println(new Solution8_STI().myAtoi(sc.nextLine()));
	}

}
