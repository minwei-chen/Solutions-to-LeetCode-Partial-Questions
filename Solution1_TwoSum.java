import java.lang.reflect.Array;
import java.util.Arrays;


public class Solution1_TwoSum {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] input = new int[]{-1, -2, -3, -4, -5};
	int[] result = new Solution1_TwoSum().twoSum(input, -8);
	System.out.println(""+result[0]+", "+result[1]);
	}
	*/
	
	public int[] twoSum(int[] nums, int target) {
        int[] rs = new int[]{-1, -1};
        int i, p ,q, j = -1;
        int[] dup = nums.clone(); 
        Arrays.sort(dup);
        for(i = 0; j<0; i++) j = Arrays.binarySearch(dup, target-dup[i]);
		for(p = 0, i--; p<nums.length; p++) {
			if(nums[p] == dup[i]) {
				rs[0] = p; 
				p += nums.length;
			}
		}
		for(q = 0, p -= (nums.length+1); q<nums.length; q++) {
			if((nums[q] == dup[j]) && (q!=p)) {
				rs[1] = q; 
				q += nums.length;
			}
		}
		return rs;
    }
}
