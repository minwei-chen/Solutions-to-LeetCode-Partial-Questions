
public class Solution59_SM2 {

    public int[][] generateMatrix(int n) {
        int rs[][] = new int[n][], num = 1;
        for(int i = 0; i<n; i++) rs[i] = new int[n];
        for(int sI = 0, sJ = 0; n>0; n-=2, sI = ++sJ) {
        	for(int j = 0; j<n; j++) rs[sI][sJ+j] = num++;
        	for(int i = 1; i<n; i++) rs[sI+i][sJ+n-1] = num++;
        	for(int j = n-2; j>=0; j--) rs[sI+n-1][sJ+j] = num++;
        	for(int i = n-2; i>0; i--) rs[sI+i][sJ] = num++;
        }
        return rs;
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
