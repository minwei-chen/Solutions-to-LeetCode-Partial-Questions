
public class Solution58_LLW {

    public int lengthOfLastWord(String s) {
        int len = s.length(), indexOfEnd, indexOfS;
        for(indexOfEnd = len-1; indexOfEnd>=0 && s.charAt(indexOfEnd)==' '; indexOfEnd--);
        for(indexOfS = indexOfEnd; indexOfS>=0 && s.charAt(indexOfS)!=' '; indexOfS--);
        return indexOfEnd-indexOfS;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
