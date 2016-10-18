import java.util.LinkedList;
import java.util.Stack;


public class Solution20_VP {

	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<Character>(); 
		boolean rs = true;
		char ch1, ch2;
		for(int i = 0; i<s.length(); i++) {
			ch1 = s.charAt(i);
			if(ch1=='(' || ch1=='[' || ch1=='{') stack.push(ch1);
			else if(!stack.isEmpty()) {
				ch2 = stack.getFirst();
				if(ch2=='(' && ch1==')' ||ch2=='[' && ch1==']' || ch2=='{' && ch1=='}')
					stack.pop();
				else break;
				
			}
		}
		if(stack.size()>0) rs = false;
		return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new Solution20_VP().isValid("([])");
	}

}
