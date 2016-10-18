
public class Solution308_RSQ2D {

    private int M, N;
    private int[] sums, matrix[];
    private boolean[] flags;
    
    // dir==true, means separate vertically, otherwise separate horizontally
    private int construct(int node, int row1, int col1, int row2, int col2, boolean dir) {
        
        // if current rectangle only contains one slot, return its val.
        if(row1==row2 && col1==col2) return sums[node] = matrix[row1][col1];
        
        int sum = 0;
        
        // separate current rectangle vertically.
        if((dir && col1<col2) || (!dir && row1==row2)) {
            sum += construct(node*2, row1, col1, row2, (col1+col2)/2, false);
            sum += construct(node*2+1, row1, (col1+col2)/2+1, row2, col2, false);
            flags[node] = true;
        }
        // else separate it horizontally.
        else {
            sum += construct(node*2, row1, col1, (row1+row2)/2, col2, true);
            sum += construct(node*2+1, (row1+row2)/2+1, col1, row2, col2, true);
            flags[node] = false;
        }
        
        return sums[node] = sum;
    }

    public Solution308_RSQ2D(int[][] matrix) {
    	this.matrix = matrix;
        M = matrix.length;
        N = matrix.length>0? matrix[0].length: 0;
        if(M<1 || N<1) return;
        sums = new int[4*M*N];
        flags = new boolean[4*M*N];
        int sum = construct(1, 0, 0, M-1, N-1, true);
    }
    
    private int updateTree(int node, int row1, int col1, int row2, int col2, int row, int col) {
        
        if(row1==row2 && col1==col2) return sums[node] = matrix[row1][col1];
        
        if(flags[node] && col<=(col1+col2)/2) {
            return sums[node] = updateTree(node*2, row1, col1, row2, (col1+col2)/2, row, col)+sums[node*2+1];
        }
        if(flags[node]) {
            return sums[node] = updateTree(node*2+1, row1, (col1+col2)/2+1, row2, col2, row, col)+sums[node*2];
        }
        if(!flags[node] && row<=(row1+row2)/2) {
            return sums[node] = updateTree(node*2, row1, col1, (row1+row2)/2, col2, row, col)+sums[node*2+1];
        }
        return sums[node] = updateTree(node*2+1, (row1+row2)/2+1, col1, row2, col2, row, col)+sums[node*2];
    }

    public void update(int row, int col, int val) {
        if(row<0 || row>=M || col<0 || col>=N) return;
        matrix[row][col] = val;
        updateTree(1, 0, 0, M-1, N-1, row, col);
    }
    
    private int search(int node, int _row1, int _col1, int _row2, int _col2, int row1, int col1, int row2, int col2) {
        if(_row1>row2 || _row2<row1 || _col1>col2 || _col2<col1) return 0;
        if(_row1>=row1 && _row2<=row2 && _col1>=col1 && _col2<=col2) return sums[node];
        int sum = 0;
        if(flags[node]) {
            sum += search(node*2, _row1, _col1, _row2, (_col1+_col2)/2, row1, col1, row2, col2);
            sum += search(node*2+1, _row1, (_col1+_col2)/2+1, _row2, _col2, row1, col1, row2, col2);
        }
        else {
            sum += search(node*2, _row1, _col1, (_row1+_row2)/2, _col2, row1, col1, row2, col2);
            sum += search(node*2+1, (_row1+_row2)/2+1, _col1, _row2, _col2, row1, col1, row2, col2);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return search(1, 0, 0, M-1, N-1, row1, col1, row2, col2);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
		int rs;
		Solution308_RSQ2D numMatrix = new Solution308_RSQ2D(matrix);
		rs = numMatrix.sumRegion(1, 1, 3, 4);
		numMatrix.update(1, 1, 10);
		rs = numMatrix.sumRegion(1, 1, 3, 4);
		
	}

}
