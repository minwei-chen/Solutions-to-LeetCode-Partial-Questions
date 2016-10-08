
public class Solution74_S2M {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = 0, num = 0;
        if(m==0) return false;
        num = (n = matrix[0].length)*m;
        int base = 0, top = num-1, mid, i, j;
        while(base<=top) {
        	mid = (base+top)/2;
        	i = mid/n;
        	j = mid%n;
        	if(matrix[i][j]==target) return true;
        	if(matrix[i][j]>target) top = mid-1;
        	else base = mid+1;
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
