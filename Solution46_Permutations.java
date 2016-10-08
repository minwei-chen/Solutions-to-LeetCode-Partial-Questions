import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Solution46_Permutations {

	private int len;
	private boolean[] status;
	private List<List<Integer>> rs;
	private List<Integer> element;
	private int[] workspace;
	private int[] nums;
	
	private int next(int cur) {
		for(cur++; cur<len && status[cur]; cur++);
		return cur;
	}
	
	private void conquer(int level) {
		if(level==len) {
			element = new LinkedList<>();
			for(int i:workspace) element.add(nums[i]);
			rs.add(element);
			return;
		}
		Set<Integer> picked = new HashSet<Integer>();
		for(int i = next(-1); i<len; i = next(i)) {
			if(!picked.contains(nums[i])) {
				workspace[level] = i;
				status[i] = true;
				conquer(level+1);
				status[i] = false;
				picked.add(nums[i]);
			}
			
		}
		
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	this.nums = nums;
    	len = nums.length;
    	status = new boolean[len];
    	rs = new LinkedList<>();
    	workspace = new int[len];
    	conquer(0);
    	return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		new Solution46_Permutations().permuteUnique(nums);

	}

}
