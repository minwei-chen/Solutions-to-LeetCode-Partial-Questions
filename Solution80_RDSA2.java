
public class Solution80_RDSA2 {

    public int removeDuplicates(int[] nums) {
        int ans = 0, dup = 0, pre = nums[0]-1, length = nums.length;
        for(int i = 0; i<length; i++) {
            if(nums[i]!=pre) {
                pre = nums[ans++] = nums[i];
                dup = 1;
            }
            else {
                dup++;
                if(dup<=2) nums[ans++] = nums[i];
            }
        }
        return ans;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,1,1,2,2,3};
		new Solution80_RDSA2().removeDuplicates(nums);
	}

}
