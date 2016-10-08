
public class Solution72_ED {

	int len1, len2, minD = Integer.MAX_VALUE;
	String word1, word2;
	
	private void bt(int m, int n, int distance) {
		while(m<len1 && n<len2 && word1.charAt(m)==word2.charAt(n)) {m++; n++;}
		if(n>=len2) {
			if(m<len1) distance += len1-m;
			minD = minD<distance? minD: distance;
			return;
		}
		if(m>=len1) {
			if(n<len2) distance += len2-n;
			minD = minD<distance? minD: distance;
			return;
		}
		if(distance+Math.abs(len1-len2+n-m)>=minD) return;
		// replace.
		bt(m+1, n+1, distance+1);
		// insert.
		bt(m, n+1, distance+1);
		// delete.
		bt(m+1, n, distance+1);
		return;
	}
	
    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        this.word1 = word1;
        this.word2 = word2;
        bt(0, 0, 0);
        return minD;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution72_ED().minDistance("dinitrophenylhydrazine", "dimethylhydrazine"));
	}

}
