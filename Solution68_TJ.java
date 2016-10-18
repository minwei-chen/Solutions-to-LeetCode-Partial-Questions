import java.util.LinkedList;
import java.util.List;


public class Solution68_TJ {

	private String nSpace(int n) {
		StringBuilder sb = new StringBuilder(n);
		for(int i = 0; i<n; i++) sb.append(" ");
		return sb.toString();
	}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
    	int size = words.length, start = 0, minWidth  = 0;
    	String s = "";
    	int space, res, rem;
    	List<String> rs = new LinkedList<>();
    	for(int i = 0; i<size; i++) {
    		minWidth += words[i].length()+1;
    		if(minWidth-1>maxWidth) {
    			minWidth -= (words[i].length()+2);
    			space = maxWidth-minWidth;
    			if(start==(i-1)) s += (words[start]+nSpace(space));
    			else {
    				res = space/(i-1-start);
    				rem = space%(i-1-start);
    				for(int j = start; j<i-1; j++) {
    					if((rem--)>0) s += (words[j]+nSpace(res+2));
    					else s += (words[j]+nSpace(res+1));
    				}
    				s += words[i-1];
    			}
    			rs.add(s);
    			minWidth = words[i].length()+1;
    			start = i;
    			s = "";
    		}
    	}
    	for(int i = start; i<size-1; i++) s += words[i]+" ";
    	s += words[size-1];
    	space = maxWidth-s.length();
    	s += nSpace(space);
    	rs.add(s);
    	return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
		new Solution68_TJ().fullJustify(words, 16);
	}

}
