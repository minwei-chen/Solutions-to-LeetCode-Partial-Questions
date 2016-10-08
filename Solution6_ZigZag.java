
public class Solution6_ZigZag {

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution6_ZigZag obj = new Solution6_ZigZag();
		System.out.println(obj.convert("PAYPALISHIRING", 3));

	}
	*/

	/***** thinking wrong!
	public String convert(String s, int numRows) {
		
		StringBuilder rs = new StringBuilder();
        char[] array = s.toCharArray();
        int N = array.length;
        int Interval = numRows+numRows/2;
        
        for(int i = 0; i<numRows; i++) {
        	if(i%2 == 0) {
        		for(int j = i; j<N; j += Interval) rs.append(array[j]);
        	}
        	else for(int k = i; k<N; ) {
        		rs.append(array[k]);
        		if(k%Interval<numRows) k += numRows-i+i/2;
        		else k += (numRows-i-1)/2+i+1;
        	}
        }
        
        return rs.toString();
    }
    *******/
	
	public String convert(String s, int numRows) {
		if(numRows == 1) return s;
		StringBuilder rs = new StringBuilder();
		char[] arr = s.toCharArray();
		int N = arr.length;
		for(int i = 0; i<numRows; i++) {
			for(int j = i; j<N; ) {
				rs.append(arr[j]);
				if(j%(2*numRows-2) < (numRows-1)) j += 2*(numRows-i-1);
				else j += 2*i;
			}
		}
		return rs.toString();
	}
}
