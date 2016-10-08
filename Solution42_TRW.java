import java.util.Arrays;


public class Solution42_TRW {

	/* O(n^2), TLE
	public int trap(int[] height) {
        int rs = 0, leftB = 0, rightB = height.length-1, sorted[], preHigh = 0, curHigh, index, length = height.length;
        Arrays.sort(sorted = (int[])height.clone());
        for(index = 0; index<length && sorted[index]==0; index++);
        curHigh = sorted[index];
        for(int high = curHigh-preHigh; high!=0 && rightB>leftB; high = curHigh-preHigh) {
        	while(height[leftB]<curHigh) leftB++;
        	while(height[rightB]<curHigh) rightB--;
        	for(int i = leftB; i<rightB; i++) {
        		if(height[i]<curHigh) rs += high;
        	}
        	for(preHigh = curHigh; index<length && sorted[index]==preHigh; index++);
        	curHigh = sorted[index];
        }       
        return rs;
    }
    */
	
	/* wrong answer.
	private int height[], length;
	
	private int nextLeft(int curLeft) {
		for(curLeft++; curLeft<length && height[curLeft]>=height[curLeft-1]; curLeft++);
		return curLeft-1;
	}
	
	public int trap(int[] height) {
		int rs = 0, curLeft = 0, curRight = 0, curVol = 0, preHeight = 0;
		this.height = height;
		length = height.length;
		curLeft = nextLeft(curLeft);
		for(curRight = curLeft+1; curRight<length; curRight++) {
			if(height[curRight]>=height[curLeft]) {
				curVol += height[curLeft]*(curRight-curLeft-1);
				rs += curVol;
				curRight = curLeft = nextLeft(curRight);
				curVol = 0;
			}
			else if(curRight==(length-1) || (height[curRight]>height[curRight-1] && height[curRight]>height[curRight+1])) {
				curVol += height[curRight]*(curRight-curLeft-1);
				rs += curVol;
				curLeft = curRight;
				curVol = 0;
			}
			else curVol -= height[curRight];
		}
		return rs;
	}
	*/
	
	public int trap(int[] height) {
		int pre, rs = 0, summitPos = 0, length = height.length, index;
		for(index = 1; index<length; index++) {
			if(height[index]>=height[summitPos]) summitPos = index;
		}	
		
		for(pre = index = 0; index<summitPos; index++) {
			if(height[index]<pre) rs += (pre-height[index]);
			else pre = height[index];
		}
		
		for(pre = 0, index = length-1; index>summitPos; index--) {
			if(height[index]<pre) rs += (pre-height[index]);
			else pre = height[index];
		}
		
		return rs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int nums[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new Solution42_TRW().trap(nums));
	}

}
