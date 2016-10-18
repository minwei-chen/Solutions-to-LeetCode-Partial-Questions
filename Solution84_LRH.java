
public class Solution84_LRH {
	
	
	/* TLE
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for(int i = 0, lowest, max; i<heights.length; i++) {
        	max = lowest = heights[i];
            for(int j = i-1, temp; j>=0; j--) {
                if(heights[j]<lowest) lowest = heights[j];
                max = max>(temp = (lowest*(i-j+1)))? max: temp;
            }
            ans = ans>max? ans: max;
        }
        return ans;
    }
    */
	
	private int heights[];
	
	private int getMax(int s, int e) {
		if(s>e) return 0;
		if(s==e) return heights[s];
		boolean isAscend = true, isDescend = true;
		int min = heights[s], heightsI, max, i, minI = s;
		for(i = s+1; i<=e; i++) {
			if((heightsI = heights[i])<min) {
				min = heightsI;
				minI = i;
			}
			if(i>s && heightsI<heights[i-1]) isAscend = false;
			if(i>s && heightsI>heights[i-1]) isDescend = false;
		}
		if(isAscend) {
			for(i = s, max = 0; i<=e; i++) {
				max = Math.max(max, heights[i]*(e-i+1));
			}
			return max;
		}
		else if(isDescend) {
			for(i = e, max = 0; i>=s; i--) {
				max = Math.max(max, heights[i]*(i-s+1));
			}
			return max;
		}
		else {
			return Math.max(min*(e-s+1), Math.max(getMax(s, minI-1), getMax(minI+1, e)));
		}
		
	}
	
    public int largestRectangleArea(int[] heights) {
    	this.heights = heights;
    	return getMax(0, heights.length-1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] heights = {2,1,5,6,2,3};
		System.out.println(new Solution84_LRH().largestRectangleArea(heights));
	}

}
