import java.util.HashSet;
import java.util.Set;


public class Solution139_WB {

	
	public boolean wordBreak(String s, Set<String> wordDict) {
        Set<Integer> starts = new HashSet<>();
        boolean[] ends = new boolean[s.length()+1];
        ends[0] = true; starts.add(0);
        int max = 0, min = Integer.MAX_VALUE;
        for(String str: wordDict) {
            max = str.length()>max? str.length(): max;
            min = str.length()<min? str.length(): min;
        }
        for(int i = min-1; !starts.isEmpty() && i<s.length(); i++) {
            for(int start: starts) {
                if(wordDict.contains(s.substring(start, i+1))) {
                    ends[i+1] = true;
                    starts.add(i+1);
                    break;
                }
            }
            if(i+2-min>=0 && ends[i+2-min]) starts.add(i+2-min);
            starts.remove(i+1-max);
        }
        return ends[s.length()];
    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		new Solution139_WB().wordBreak("leetcode", wordDict);

	}

}
