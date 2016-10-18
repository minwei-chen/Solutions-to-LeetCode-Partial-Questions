import java.util.LinkedList;
import java.util.List;


public class Solution51_NQ {

	private List<List<String>> rs = new LinkedList<>();
	private boolean cols[], lDiagonals[], rDiagonals[];
	private int n;
	private char[][] workspace;
	
	private void bt(int i, int j) {
		if(i==n) {
			if(j==0) {
				List<String> ans = new LinkedList<>();
				for(char[] charArr:workspace) ans.add(new String(charArr));
				rs.add(ans);
			}
			return;
		}
		if(cols[j] || lDiagonals[j-i+n-1] || rDiagonals[i+j]) return;
		workspace[i][j] = 'Q';
		cols[j] = lDiagonals[j-i+n-1] = rDiagonals[i+j] = true;
		for(int nextJ = 0; nextJ<n; nextJ++) bt(i+1, nextJ);
		workspace[i][j] = '.';
		cols[j] = lDiagonals[j-i+n-1] = rDiagonals[i+j] = false;
	}
	
	
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        workspace = new char[n][];
        cols = new boolean[n];
        lDiagonals = new boolean[n+n-1];
        rDiagonals = new boolean[n+n-1];
        for(int i = 0; i<n; i++) {
        	workspace[i] = new char[n];
        	for(int j = 0; j<n; j++) workspace[i][j] = '.';
        }
        for(int j = 0; j<n; j++) bt(0, j);
        return rs;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
