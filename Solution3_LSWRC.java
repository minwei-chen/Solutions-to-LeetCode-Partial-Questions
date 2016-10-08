import java.util.Scanner;


public class Solution3_LSWRC {
	
	/*public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, curLenth = 0, subPos, index;
        int[] prePos = new int[128];
        char[] arr = s.toCharArray();
        for(int pos = 0; pos < arr.length; pos++) {
        	index = arr[pos];
        	subPos = prePos[index];
        	if(subPos>0) {
        		if(maxLength<curLenth) maxLength = curLenth;
        		for(int i = pos-curLenth; i<pos; i++) prePos[arr[i]] -= subPos;
        		curLenth -= (subPos-1);
        		prePos[index] = curLenth;
        	}
        	else prePos[index] = ++curLenth;
        }
        if(maxLength<curLenth) maxLength = curLenth;
        return maxLength;
    }
	*/
	public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, curLenth = 0, pre, index;
        /* prepos[128] keep the most recent position of all characters in the string, 
         * and no more than 128 characters in ASCII.
         */
        int[] prePos = new int[128];
        for(int pos = 0; pos < s.length();) {
        	index = s.charAt(pos);
        	pre = prePos[index];
        	// if the character isn't in the currently substring, just add the substring length.
        	if(pre<(pos+1-curLenth)) curLenth++;
        	/* else analysis to the current substring is over,
        	 * record the length of the length if necessary,
        	 * and recompute the length of new substring.
        	 */
        	else {
        		maxLength = Math.max(maxLength, curLenth);
        		curLenth = pos+1 - pre;
        	}
        	// update the position of the character
        	prePos[index] = ++pos;
        }
        return Math.max(maxLength, curLenth);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int len = new Solution3_LSWRC().lengthOfLongestSubstring(sc.nextLine());
		System.out.println("The longest lenth is: "+len);
	}

}
