
public class Solution41_FMP {

	public int firstMissingPositive(int[] nums) {
		
		int length = nums.length, cur, next;
		
		for(int i = 0; i<length; i++) {
			if((cur = nums[i])>0) {
				while(cur>0 && cur<=length) {
					next = nums[cur-1];
					nums[cur-1] = cur;
					if(next==cur) cur = 0;
					else cur = next;
				}
			}
		}
		
		for(cur = 0; cur<length && cur+1==nums[cur]; cur++);
		return cur+1;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = {2,1};
		System.out.println(new Solution41_FMP().firstMissingPositive(nums));
	}

}
