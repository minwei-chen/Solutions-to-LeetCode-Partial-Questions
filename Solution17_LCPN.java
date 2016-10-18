import java.util.LinkedList;
import java.util.List;


public class Solution17_LCPN {

	
	/* 2ms solution
	public List<String> letterCombinations(String digits) {
		String[] ref = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> rs = new LinkedList<String>();
		int index;
		String hold;
		rs.add("");
		for(int i = 0, digLen = digits.length(); i<digLen; i++) {
			index = digits.charAt(i) - '0';
			for(int j = 0, size = rs.size(); j<size; j++) {
				hold = rs.remove(0);
				for(int k = 0; k<ref[index].length(); k++) rs.add(hold+ref[index].substring(k, k+1));
			}
		}
		return rs;
        
    }
	
	*/
	
	public List<String> letterCombinations(String digits) {
        List<String> rs = new LinkedList<String>();
        if(digits.equals("")) return rs;
		String[] ref = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int[] index = new int[digits.length()];
		StringBuilder sb = new StringBuilder(digits.length()*2+2);
		while(index[0]<ref[digits.charAt(0)-'0'].length()) {
			sb.delete(0, sb.capacity());
			for(int i = 0; i<index.length; i++) sb.append(ref[digits.charAt(i)-'0'].charAt(index[i]));
			for(int j = index.length-1; j>-1; j--) {
				if(++index[j]==ref[digits.charAt(j)-'0'].length() && j>0) index[j] = 0;
				else j = 0;
			}
			rs.add(sb.toString());
		}
		return rs;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution17_LCPN().letterCombinations("32");
	}

}
