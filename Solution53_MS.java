
public class Solution53_MS {

	
	public int maxSubArray(int[] nums) {
        int maxSum = nums[0], length = nums.length;
        for(int i = 1; i<length; i++) {
        	if(nums[i-1]>0) nums[i] = nums[i-1]+nums[i];
        	if(maxSum<nums[i]) maxSum = nums[i];
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
