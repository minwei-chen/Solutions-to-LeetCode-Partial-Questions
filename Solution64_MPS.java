
public class Solution64_MPS {

	/*
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m<1) return 0;
        int n = grid[0].length;
        if(n<1) return 0;
        int steps = m+n-2, i, j;
        
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
     		   if(j>0) {
     			   if(i==0) grid[i][j] += grid[i][j-1];
     			   else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
     			   
     		   }
     		   else grid[i][j] += grid[i-1][j];
     	   }
        }
        return grid[m-1][n-1];
    }
    */
	
	private int min, m, n, grid[][];
	
	private void bt(int i, int j, int sum) {
		if((sum += grid[i][j])>min) return;
		if(i==m-1 && j==n-1) {
			min = sum;
			return;
		}
		if(i<m-1) bt(i+1, j, sum);
		if(j<n-1) bt(i, j+1, sum);
		return;
	}
	
	
	public int minPathSum(int[][] grid) {
		this.grid = grid;
		min = Integer.MAX_VALUE;
        m = grid.length;
        if(m<1) return 0;
        n = grid[0].length;
        if(n<1) return 0;
        bt(0,0,0);
        return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
