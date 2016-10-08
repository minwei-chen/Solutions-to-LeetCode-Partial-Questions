import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution118_PT {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new LinkedList<>();
        List<Integer> list, pre = null;
        for(int i = 0; i<numRows; i++) {
            list = new ArrayList<>(i+1);
            for(int k = 0; k<i+1; k++) list.add(0);
            list.set(0, 1);
            list.set(i, 1);
            if(i>0) pre = rs.get(i-1);
            for(int j = 1; j<list.size()-1; j++) {
                list.set(j, pre.get(j-1)+pre.get(j));
            }
            rs.add(list);
        }
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution118_PT().generate(5);
	}

}
