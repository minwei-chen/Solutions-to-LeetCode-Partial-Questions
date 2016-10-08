
public class Solution14_LCP {

	
	public String longestCommonPrefix(String[] strs) {
        int unmatch[] = new int[strs.length];
        for(int i = 0; i<unmatch.length; i++) unmatch[i] = i;
        int hold, nUnmatch = strs.length, length = Integer.MAX_VALUE;
        String result = "";
        for(int i = 0; i<strs.length; i++)
        	if((hold = strs[i].length())<length) {length = hold; result = strs[i];}        
        while(nUnmatch>0 && length>0) {
        	for(int i = 0, j = 0, num = nUnmatch; i<num; i++)
        		if(result.equals(strs[unmatch[i]].substring(0, length))) nUnmatch--;
        		else unmatch[j++] = unmatch[i];
        	if(nUnmatch>0) result = result.substring(0, --length);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] ss = new String[]{"aca","cba"};
		System.out.println(new Solution14_LCP().longestCommonPrefix(ss));
	}

}
