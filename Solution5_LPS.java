import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;


public class Solution5_LPS {

	/*private int pos;
	private int maxLen;
	
	private class StringDescriptor {
		public final int start;
		public final int length;
		public StringDescriptor(int s, int l) {start = s; length = l;}
	}
	
	private StringDescriptor conquer(String s, StringDescriptor sd) {
		int dup, head, rear, i = sd.start+sd.length/2;
		for(dup = 1; (i-dup)>=sd.start && s.charAt(i)==s.charAt(i-dup); dup++);
		for(i = i-dup+1; i+dup<sd.start+sd.length && s.charAt(i)==s.charAt(i+dup); dup++);
		head = i-1;
    	rear = i+dup;
    	while(head>-1 && rear<s.length() && s.charAt(head)==s.charAt(rear)) {head--; rear++;};
    	if(maxLen<(rear-head-1)) {pos = head+1; maxLen = rear-head-1;}
        return new StringDescriptor(i, dup);
	}
	
	public String longestPalindrome(String s) {
		if(s==null || s.length()<2) return s;
        pos = 0;
        maxLen = 1;
        int lLen, rLen;
        StringDescriptor sdA, sdB;
        LinkedList<StringDescriptor> stack = new LinkedList<StringDescriptor>();
        stack.push(new StringDescriptor(0, s.length()));
        while(!stack.isEmpty()) {
        	sdA = stack.pop();
        	sdB = conquer(s, sdA);
        	lLen = sdB.start-sdA.start;
        	rLen = sdA.length-sdB.start-sdB.length;
        	if(lLen>0) stack.push(new StringDescriptor(sdA.start, lLen));
        	if(rLen>0) stack.push(new StringDescriptor(sdB.start+sdB.length, rLen));
        	
        }
        return s.substring(pos, pos+maxLen);
    }
	
	
	
	/*public String longestPalindrome(String s) {
		if(s == null) return null;
        LinkedList<Integer> odd = new LinkedList<Integer>();
        LinkedList<Integer> even = new LinkedList<Integer>();
        LinkedList<Integer> pre, cur;
        int pos = -1, maxLen;
        
        for(int i = 0; i<s.length(); i++) odd.add(pos = i);
        for(int i = 0; i<s.length()-1; i++) if(s.charAt(i) == s.charAt(i+1)) even.add(pos = i);
        if(!even.isEmpty()) maxLen = 2;
        else if(!odd.isEmpty()) maxLen = 1;
        else maxLen = 0;
        
        for(int len = 3, tag = 2; tag>0; len++) {
        	if(len%2 == 1) {
        		pre = odd;
        		odd = cur = new LinkedList<Integer>();
        	}
        	else {
        		pre = even;
        		even = cur = new LinkedList<Integer>();
        	}
        	if(pre.isEmpty()) tag--;
        	else {
        		tag = 2;
        		while(!pre.isEmpty()) {
        			pos = pre.remove();
        			if(pos>0 && pos+len-2<s.length()) {
        				if(s.charAt(pos-1) == s.charAt(pos+len-2)) {
        					cur.add(pos-1);
        					maxLen = len;
        				}
        			}
        		}
        	}
        	pre = null;
        }
        if(pos>-1) return s.substring(pos, pos+maxLen);
        else return "";
    }*/
	
	/*public String longestPalindrome(String s) {
		if(s==null || s.length()<2) return s;
        int pos = 0, maxLen = 1, dup, head, rear;
        for(int i = 0; i<(s.length()-maxLen/2); i += dup) {
        	for(dup = 1; i+dup<s.length() && s.charAt(i)==s.charAt(i+dup); dup++);
        	head = i-1;
        	rear = i+dup;
        	while(head>-1 && rear<s.length() && s.charAt(head)==s.charAt(rear)) {head--; rear++;};
        	if(maxLen<(rear-head-1)) {pos = head+1; maxLen = rear-head-1;}
        }
        return s.substring(pos, pos+maxLen);
    }
    */
	
	/*public String longestPalindrome(String s) {
		if(s==null || s.length()<2) return s;
		final int strLen = s.length();
		int[] len1 = new int[strLen], len2 = new int[strLen];
		int pos = 0, maxLen = 1, matchPos;
		len1[0] = len2[0] = 1;
		for(int i = 1; i<strLen; i++) {
			len1[i] = len2[i] = 1;
			matchPos = i-len1[i-1]-1;
			if(matchPos>=0 && s.charAt(matchPos)==s.charAt(i)) len1[i] = len1[i-1]+2;
			matchPos = i-len2[i-1]-1;
			if(matchPos>=0 && s.charAt(matchPos)==s.charAt(i)) len1[i] = Math.max(len1[i], len2[i-1]+2);
			if(s.charAt(i) == s.charAt(i-1)) len2[i] = len2[i-1]+1;
			if(Math.max(len1[i], len2[i])>maxLen) {maxLen = Math.max(len1[i], len2[i]); pos = i-maxLen+1;}
		}
		return s.substring(pos, pos+maxLen);
	}
	*/
	
	public String longestPalindrome(String s) {
		if(s==null || s.length()<2) return s;
		final int strLen = s.length();
		int pos = 0, maxLen = 1;
		LinkedList<Integer> lens = new LinkedList<Integer>();
		for(int i = 0, strNum; i<strLen; i++) {
			strNum = lens.size();
			lens.add(1);
			if(i>0 && s.charAt(i)==s.charAt(i-1)) {
				lens.add(2); 
				if(maxLen<2) {pos = i-1; maxLen = 2;}
			}
			for(int j = 0, cur; j<strNum; j++) {
				cur = lens.remove();
				if(i-cur>0 && s.charAt(i)==s.charAt(i-cur-1)) {
					lens.add(cur+2);
					if(maxLen<cur+2) {pos = i-cur-1; maxLen = cur+2;}
				}
			}
		}
		return s.substring(pos, pos+maxLen);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(new Solution5_LPS().longestPalindrome(sc.nextLine()));
	}

}
