import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution16_3sumClosest {

	private int rs, dif;
	
	private int computeDif(int a, int b) {
		int c = a-b;
		if(c<0) return -c;
		else return c;
	}
	
	private void twoSum(int[] in, int begin, int target) {
		int i = begin, j = in.length-1, sum, inI, inJ, curDif;
		while(dif!=0 && i<j) {
			inI = in[i]; inJ = in[j];
			sum = inI+inJ;
			curDif = computeDif(sum, target);
			if(curDif<dif) {
				rs = sum+in[begin-1];
				dif = curDif;
			}
			if(sum<target) while(++i<in.length-1 && in[i]==inI); 
			else while(--j>begin && in[j]==inJ);
		}
		return;
	}
	
	public int threeSumClosest(int[] nums, int target) {
        dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0, hold; i<nums.length-2 && dif!=0 && ((hold = nums[i])-target)<dif;) {
        	twoSum(nums, i+1, target-hold);
        	while(++i<nums.length-2 && nums[i]==hold);
        }        
        return rs;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 82;
		int nums[] = new int[]{1,2,4,8,16,32,64,128};
		System.out.println(new Solution16_3sumClosest().threeSumClosest(nums, target));
	}

}
