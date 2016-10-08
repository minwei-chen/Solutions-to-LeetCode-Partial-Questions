import java.util.LinkedList;
import java.util.List;


public class Solution77_Combinations {

	private List<List<Integer>> rs;
	private int n;
	
	private void bt(int s, int k, LinkedList<Integer> l) {
		if(k==0) {
			rs.add(new LinkedList<Integer>(l));
			return;
		}
		else if(n-s+1>=k) {
			l.add(s);
			bt(s+1, k-1, l);
			l.removeLast();
			bt(s+1, k, l);
		}
		return;
	}
	
	
	
    public List<List<Integer>> combine(int n, int k) {
        rs = new LinkedList<>();
        this.n = n;
        bt(1, k, new LinkedList<Integer>());
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
