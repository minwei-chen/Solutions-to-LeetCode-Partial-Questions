import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution15_3sum {

	
	private List<List<Integer>> rs = new LinkedList<List<Integer>>();
	
	private void twoSum(int[] in, int begin, int target) {
		int i = begin, j = in.length-1, sum, inI, inJ;
		List<Integer> triple;
		while(i<j) {
			inI = in[i]; inJ = in[j];
			sum = inI+inJ;
			if(sum==target) {
				triple = new LinkedList<Integer>();
				triple.add(-target); triple.add(inI); triple.add(inJ);
				rs.add(triple);
				while(++i<in.length-1 && in[i]==inI);
				while(--j>begin && in[j]==inJ);
			}
			else if(sum<target) while(++i<in.length-1 && in[i]==inI); 
			else while(--j>begin && in[j]==inJ);
		}
		return;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return rs;
        Arrays.sort(nums);
        for(int i = 0, hold; i<nums.length-2 && (hold = nums[i])<1;) {
        	twoSum(nums, i+1, -nums[i]);
        	while(++i<nums.length-2 && nums[i]==hold);
        }        
        return rs;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
