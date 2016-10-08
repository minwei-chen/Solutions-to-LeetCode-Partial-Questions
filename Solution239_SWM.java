
public class Solution239_SWM {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, left[] = new int[nums.length], right[] = new int[len], i;
        
        for(i = 1; i<len; i++) {
            if(nums[i]>=nums[i-1]) left[i] = Math.max(i-k+1, left[i-1]);
            else left[i] = i;
        }
        for(right[len-1] = len-1, i = len-2; i>=0; i--) {
            if(nums[i]>=nums[i+1]) right[i] = Math.min(i+k-1, right[i+1]);
            else right[i] = i;
        }
        
        int rs[] = new int[len-k+1];
        for(i = 0; i<len; i++) {
            if(right[i]-left[i]+1<k) continue;
            for(int j = left[i]; j<=right[i]-k+1; j++) rs[left[i]] = nums[i];
        }
        
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,3,-1,-3,5,3,6,7};
		new Solution239_SWM().maxSlidingWindow(nums, 3);
	}

}
