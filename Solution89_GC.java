import java.util.ArrayList;
import java.util.List;


public class Solution89_GC {
	
	
    public List<Integer> grayCode(int n) {
        if(n<1) return new ArrayList<Integer>();
        List<Integer> rs = new ArrayList<>((int)Math.pow(2, n));
        rs.set(0, 0);
        rs.set(1, 1);
        for(int i = 1, a = 2; i<n; i++, a *= 2) {
        	for(int j = 0; j<a; j++) rs.set(a+j, a+rs.get(a-j-1));
        }
        return rs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
