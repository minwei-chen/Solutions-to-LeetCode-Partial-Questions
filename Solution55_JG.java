
public class Solution55_JG {

    public boolean canJump(int[] nums) {
        int len = nums.length, distance = 0;
        for(int i = 0; i<=distance && i<len; i++) {
        	if(distance<nums[i]+i) distance = nums[i]+i;
        }
        if(distance>=len-1) return true;
        else return false;
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
