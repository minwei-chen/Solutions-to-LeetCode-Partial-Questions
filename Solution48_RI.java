
public class Solution48_RI {

	public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	int rightup;
    	for(int i = 0, j = 0; n>1; n-=2, i++, j++) {
    		for(int l = 0; l<n-1; l++) {
    			rightup = matrix[i+l][n-1+j];
    			matrix[i+l][n-1+j] = matrix[i][j+l];
    			matrix[i][j+l] = matrix[i+n-1-l][j];
    			matrix[i+n-1-l][j] = matrix[i+n-1][j+n-1-l];
    			matrix[i+n-1][j+n-1-l] = rightup;
    		}
    	}
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
