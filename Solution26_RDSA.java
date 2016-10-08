
public class Solution26_RDSA {

	public int removeDuplicates(int[] nums) {
		if(nums==null || nums.length==0) return 0;
        int rs = 1, lenOfNums = nums.length;
        for(int i = 1, cur = nums[0]; i<lenOfNums; i++)
            if(nums[i]!=cur) cur = nums[rs++] = nums[i];
        return rs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
