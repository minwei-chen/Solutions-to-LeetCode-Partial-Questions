import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Solution11_CWMW {

	/*TLE
	public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length-1; i++) 
        	for(int j = i+1; j<height.length; j++) 
        		max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
        return max;
    }
	*/
	
	/*TLE
	public int maxArea(int[] height) {
		if(height.length < 2) return 0;
        int max = 0;
        int[] maxOfRemain = new int[height.length];
        maxOfRemain[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i > -1; i--) maxOfRemain[i] = Math.max(height[i], maxOfRemain[i+1]);
        for(int i = 0; i < height.length-1; i++) {
        	for(int j = i+1; j < height.length && Math.min(height[i], maxOfRemain[j])*(height.length-1-i)>max; j++) {
        		max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
        	}
        }
        return max;
	}
	*/
	
	public int maxArea(int[] height) {
		if(height.length < 2) return 0;
        int max = 0, left, right;
        int[] sortedHeight = height.clone(), maxOfLeft = new int[height.length], maxOfRight = new int[height.length];
        
        Arrays.sort(sortedHeight);
        maxOfLeft[0] = maxOfRight[height.length-1] = 0;
        for(int i = 1; i < maxOfLeft.length; i++) maxOfLeft[i] = Math.max(maxOfLeft[i-1], height[i-1]);
        for(int i = maxOfRight.length-2; i > -1; i--) maxOfRight[i] = Math.max(maxOfRight[i+1], height[i+1]);
        
        for(left = 0; height[left] < sortedHeight[sortedHeight.length-2]; left++);
        for(right = sortedHeight.length-1; height[right] < sortedHeight[sortedHeight.length-2]; right--);
        
        for(int high = sortedHeight[sortedHeight.length-2], shortest = sortedHeight[0]; high >= shortest; high--) {
        	while(left>0 && maxOfLeft[left]>=high) left--;
        	while(right<maxOfRight.length-1 && maxOfRight[right]>=high) right++;
        	max = Math.max(max, (right-left)*high);
        }
        return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] height = new int[4];
		Solution11_CWMW obj = new Solution11_CWMW();
		for(int i = 0; i < 4; i++) {
			height[i] = sc.nextInt();
		}
		System.out.println(""+obj.maxArea(height));
	}

}
