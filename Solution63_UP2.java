
public class Solution63_UP2 {

	/*
	private int grid[][], ans, m, n;
	
	private void bt(int i, int j) {
		if(grid[i][j]==1) return;
		if(i==m-1 && j==n-1) {ans++; return;}
		bt(i+1, j);
		bt(i, j++);
		return;
	}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        ans = 0;
        m = grid.length;
        n = grid[0].length;
        bt(0,0);
        return ans;
    }
    */
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length;
       if(m<1) return 0;
       int n = obstacleGrid[0].length;
       if(n<1) return 0;
       int steps = m+n-2, i, j;
       
       if(obstacleGrid[0][0]==0) obstacleGrid[0][0] = 1;
       for(int dis = 1; dis<=steps; dis++) {
    	   if(dis<m) {
    		   i = dis;
    		   j = 0;
    		   
    	   }
    	   else {
    		   i = m-1;
    		   j = dis-m+1;
    	   }
    	   for(; i>=0 && j<n; i--, j++) {
    		   if(obstacleGrid[i][j]==1) obstacleGrid[i][j] = 0;
    		   else {
    			   if(j>0) obstacleGrid[i][j] += obstacleGrid[i][j-1];
    			   if(i>0) obstacleGrid[i][j] += obstacleGrid[i-1][j];
    		   }
    	   }
       }
       return obstacleGrid[m-1][n-1];
       
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
