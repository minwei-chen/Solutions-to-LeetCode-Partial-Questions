import java.util.LinkedList;
import java.util.List;


public class Solution120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size(), min = Integer.MAX_VALUE;
        if(size<1) return 0;
        int[] pre = new int[size], cur = new int[size], inter;
        List<Integer> l;
        cur[0] = pre[0] = triangle.get(0).get(0);
        for(int i = 1; i<size; i++) {
            l = triangle.get(i);
            cur[0] = pre[0]+l.get(0);
            cur[i] = pre[i-1]+l.get(i);
            for(int j = 1; j<i; j++) cur[j] = Math.min(pre[j-1], pre[j])+l.get(j);
            inter = pre;
            pre = cur;
            cur = inter;
        }
        for(int i = 0; i<size; i++) min = cur[i]<min? cur[i]: min;
        return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> input = new LinkedList<>();
		List<Integer> l = new LinkedList<>();
		l.add(-1);
		input.add(l);
		l = new LinkedList<>();
		l.add(2); l.add(3);
		input.add(l);
		l = new LinkedList<>();
		l.add(1); l.add(-1); l.add(-1);
		input.add(l);
		new Solution120_Triangle().minimumTotal(input);
		
	}

}
