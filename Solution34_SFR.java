
public class Solution34_SFR {

	private int lowBound(int[] nums, int base, int top, int target) {
		int low = -1, midIndex;
		while(base<top) {
			midIndex = (top+base)/2;
			if(nums[midIndex]==target && (midIndex==0 || nums[midIndex-1]!=target)) {
				low = midIndex;
				break;
			}
				
			else if(nums[midIndex]>=target) top = midIndex-1;
			else base = midIndex+1;
		}
		
		return low;
	}
	
	private int hignBound(int[] nums, int base, int top, int target) {
		int high = base, midIndex;
		while(base<top) {
			midIndex = (top+base)/2;
			if(nums[midIndex]==target && (midIndex==nums.length-1 || nums[midIndex+1]!=target)) {
				high = midIndex;
				break;
			}
			else if(nums[midIndex]>target) top = midIndex-1;
			else base = midIndex+1;
		}
		
		return high;
	}
	
	public int[] searchRange(int[] nums, int target) {
		int rs[] = new int[2];
		rs[1] = rs[0] = lowBound(nums, 0, nums.length, target);
		if(rs[0]!=-1) rs[1] = hignBound(nums, rs[0], nums.length, target);
		return rs;
		
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
