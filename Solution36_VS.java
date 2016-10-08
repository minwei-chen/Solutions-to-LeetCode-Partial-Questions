
public class Solution36_VS {
	
	/* correct result.
	 * 
	private boolean[] isExist = new boolean[10];

	private void reset() {
		for(int i = 0; i<10; i++) isExist[i] = false;
	}
	
	private boolean testCell(char[][] board, int i, int j) {
		boolean rs;
		int index = board[i][j]-'0';
		if(index>0 && index<10) {
			if(isExist[index]) rs = false;
			else rs = isExist[index] = true;
		}
		else if(board[i][j]!='.') return false;
		else rs = true;
		return rs;
		
	}
	*/
	
	/* mode==0, test every row;
	 * mode==1, test every column;
	 */
	
	/*
	private boolean testRowCol(char[][] board, int mode, int size, int rB, int cB) {
		for(int i = rB; i<size+rB; i++) {
			if(size==9) reset();
			for(int j = cB; j<size+cB; j++) {
				if(mode==0) {
					if(!testCell(board, i, j)) return false;
				}
				else if(mode==1) {
					if(!testCell(board, j, i)) return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean rs;
		rs = testRowCol(board, 0, 9, 0, 0);
		if(!rs) return false;
		reset();
		rs = testRowCol(board, 1, 9, 0, 0);
		if(!rs) return false;
		reset();
		for(int r = 0; r<9; r+=3) {
			for(int c = 0; c<9; c+=3) {
				rs = testRowCol(board, 0, 3, r, c);
				if(!rs) return false;
				reset();
			}
		}
        return rs;
    }
    */
	
	private boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], squares = new boolean[9][9];
	
	private void reset(boolean arr[][]) {
		for(int i = 0; i<9; i++) 
			for(int j = 0; j<9; j++) arr[i][j] = true;
	}
	
	private boolean testCell(char[][] board, int i, int j) {
		int index = board[i][j]-'0'-1;
		if(index>=0 && index<9) {
			if(rows[i][index]) rows[i][index] = false;
			else return false;
			if(cols[j][index]) cols[j][index] = false;
			else return false;
			if(squares[i/3*3+j/3][index]) squares[i/3*3+j/3][index] = false;
			else return false;
		}
		else if(board[i][j]!='.') return false;
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		reset(rows);
		reset(cols);
		reset(squares);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(!testCell(board, i, j)) return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean rs = false;
		String[] ss = {"..5.....6","....14...",".........",".....92..","5....2...",".......3.","...54....","3.....42.","...27.6.."};
		char[][] board = new char[9][];
		for(int i = 0; i<9; i++) {
			board[i] = ss[i].toCharArray();
		}
		rs = new Solution36_VS().isValidSudoku(board);
		System.out.println(7/3*3+6/3);
	}

}
