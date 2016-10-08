
public class Solution27_RE {

	public int removeElement(int[] nums, int val) {
		if(nums==null || nums.length==0) return 0;
        int rs = 0, lenOfNums = nums.length;
        for(int i = 0; i<lenOfNums; i++)
        	if(nums[i]!=val) nums[rs++] = nums[i];
        return rs;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
