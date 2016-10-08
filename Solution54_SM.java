import java.util.LinkedList;
import java.util.List;


public class Solution54_SM {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new LinkedList<>();
        if(matrix==null || matrix.length==0) return rs;
        int m = matrix.length, n = matrix[0].length;
        for(int sI = 0, sJ = 0, i, j; m>0 && n>0; sI = ++sJ, m--, n--) {
        	for(i = sI, j = sJ; j<sJ+n; j++) rs.add(matrix[i][j]);
        	if(m>1) {
        		for(i = sI+1, j = sJ+n-1; i<sI+m; i++) rs.add(matrix[i][j]);
        		if(n>1) {
        			for(i = sI+m-1, j = sJ+n-2; j>=sJ; j--) rs.add(matrix[i][j]);
        			if(m>2) {
        				for(i = sI+m-2, j = sJ; i>sI; i--) rs.add(matrix[i][j]);
        			}
        		}
        	}
        }
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		new Solution54_SM().spiralOrder(matrix);
		

	}

}
