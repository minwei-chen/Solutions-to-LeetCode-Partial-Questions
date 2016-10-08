import java.lang.invoke.ConstantCallSite;


public class Solution28_IS {
	
	/* 
	 * KMP for find the first subString. 
	 * */
	
	private int[] computerOverlay(String s) {
		final int lenOfS = s.length();
		int[] overlay = new int[lenOfS];
		int index;
	
		overlay[0] = 0;
		for(int i = 1; i<lenOfS; i++) {
			index = overlay[i-1];
			while(index>0 && s.charAt(index)!=s.charAt(i)) index = overlay[index-1];
			if(s.charAt(index)==s.charAt(i)) overlay[i] = overlay[index]+1;
			else overlay[i] = 0;
		}
		
		return overlay;
	}

	public int strStr(String haystack, String needle) {
		final int lenOfH = haystack.length(), lenOfN = needle.length();
		if(lenOfN==0 || lenOfH<lenOfN) return -1;
		int[] next = computerOverlay(needle);
		int i = 0, j = 0;
		while(i<lenOfH && j<lenOfN) {
			if(haystack.charAt(i)==needle.charAt(j)) {
				i++;
				j++;
			}
			else if(j==0) i++;
			else {
				j = next[j-1];
			}
		}
		if(j==lenOfN) return i-j;
		else return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rs = new Solution28_IS().strStr("abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba"
				,"bbbbbbaa");
		System.out.println(rs);
	}

}
