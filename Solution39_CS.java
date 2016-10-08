import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution39_CS {
	
	private List<List<Integer>> rs = new LinkedList<>();
	private int sorted[], target;
	
	private int next(int index) {
		for(int dup = sorted[index], length = sorted.length; index<length && dup==sorted[index]; index++);
		return index;
	}
	
	private void solver(LinkedList<Integer> list, int sum, int index) {
		sum += sorted[index];
		if(sum>target) return;
		list.add(sorted[index]);
		if(sum==target) rs.add((LinkedList<Integer>)list.clone());
		else {
			for(int length = sorted.length; index<length; index = next(index))
				solver(list, sum, index);
		}
		list.removeLast();
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(sorted = candidates);
        this.target = target;
        for(int index = 0, length = sorted.length; index<length; index = next(index))
        	solver(new LinkedList<Integer>(), 0, index);
        return rs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int candidates[] = {2, 3, 6, 7}, target = 7;
		Solution39_CS s = new Solution39_CS();
		s.combinationSum(candidates, target);
		for(int i = 0; i<s.rs.size(); i++) {
			for(int j: s.rs.get(i)) {
				System.out.print(""+j+",");
			}
			System.out.println("");
		}
		
	}

}
