import java.util.Arrays;


public class Solution4_MTSA {

    int[] nums1, nums2;
    
    public double getMedian(int b1, int e1, int b2, int e2) {
        
        int med1 = b1+e1>>1, med2 = b2+e2>>1, n, max = Integer.MAX_VALUE, r[] = {max, max, max, max}, i = 0;
        
        if(nums1[med1]<nums2[med2]) {
            n = Math.min(med1-b1, e2-med2);
            if(n>0) return getMedian(b1+n, e1, b2, e2-n);
        }
        else {
            n = Math.min(e1-med1, med2-b2);
            if(n>0) return getMedian(b1, e1-n, b2+n, e2);
        }
        
        r[i++] = nums1[med1];
        r[i++] = nums2[med2];
        if((e1-b1&1)==1) r[i++] = nums1[med1+1];
        if((e2-b2&1)==1) r[i++] = nums2[med2+2];
        Arrays.sort(r);
        return (r[i>>1]+r[i-1>>1])/2.0;
            
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if(nums1.length<1 || nums2.length<1) return 0.0;
        this.nums1 = nums1;
        this.nums2 = nums2;
        return getMedian(0, nums1.length-1, 0, nums2.length-1);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 3, 4}, nums2 = {2};
		double a = new Solution4_MTSA().findMedianSortedArrays(nums1, nums2);
	}

}
