
public class Solution38_CS {
	
	private String next(String s) {
		StringBuilder sb = new StringBuilder();
		int length = s.length(), pre = 0, next = 0;
		while(next<length) {
			next = token(s, pre);
			sb.append(next-pre);
			sb.append(s.charAt(pre));
			pre = next;
		}
		return sb.toString();
	}

	private int token(String s, int begin) {
		char ch = s.charAt(begin);
		int index, length = s.length();
		for(index = begin; index<length && s.charAt(index)==ch; index++);
		return index;
	}
	
	public String countAndSay(int n) {
		String rs = "1";
		if(n<1) return rs;
        for(int i = 0; i<n-1; i++) rs = next(rs);
        return rs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution38_CS().countAndSay(5));
		
	}

}
