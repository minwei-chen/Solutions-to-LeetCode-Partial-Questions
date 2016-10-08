import java.util.LinkedList;


public class Solution45_JG2 {
	
	
	/*
	private int max, target;
	private int[] nums;
	
	private void bt(int distance, int length) {
		if(distance==target) {
    		if(length<max) max = length;
    		return;
    	}
    	if(length==max-1 || distance>target || nums[distance]<=0) return;
    	else {
    		length++;
    		for(int i = nums[distance]; i>0; i--) {
    			bt(distance+i, length);
    		}
    	}
    }
	
    public int jump(int[] nums) {
        target = max = nums.length-1;
        this.nums = nums;
        bt(0, 0);
        return max;
    }
    */
    
    
    public int jump(int[] nums) {
        final int length = nums.length;
        int lastJump[] = new int[length], distance[] = new int[length];
        boolean isFound;
        for(int i = 1; i<length; i++) {
        	isFound = false;
        	for(int j = lastJump[i-1]; j<i && !isFound; j++) {
        		if(nums[j]>=(i-j)) {
        			distance[i] = distance[j]+1;
        			lastJump[i] = j;
        			isFound = true;
        		}
        	}
        }
        return distance[length-1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		System.out.println(new Solution45_JG2().jump(nums));

	}

}
