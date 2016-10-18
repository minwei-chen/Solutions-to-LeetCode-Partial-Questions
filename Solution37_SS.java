
public class Solution37_SS {
	
	private boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], squares = new boolean[9][9];
	private int nexts[] = new int[89], firstIJ;
	private char[][] board;
	
	/*
	private void reset(boolean arr[][]) {
		for(int i = 0; i<9; i++) 
			for(int j = 0; j<9; j++) arr[i][j] = true;
	}
	
	// return value true means legal.
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
	
	private void getBack(char[][] board, int i, int j) {
		int index = board[i][j]-'0'-1;
		rows[i][index] = true;
		cols[j][index] = true;
		squares[i/3*3+j/3][index] = true;
		board[i][j] = '.';
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
	
	private int first(char[][] board, int i, int j) {
		for(; i<9; i++) 
			for(; j<9; j++) {
				if(board[i][j]=='.') return i*10+j;
			}
		return -1;
	}
	
	public boolean solver(char[][] board, int i, int j, char val) {
		int nextFirst, nextI, nextJ;
		board[i][j] = val;
		char nextVal = '1';
		if(!testCell(board, i, j)) {
			getBack(board, i, j);
			return false;
		}
		nextFirst = first(board, i, j);
		if(nextFirst==-1) return true;
		nextJ = nextFirst%10;
		nextI = nextFirst/10;
		while(nextVal<='9')
			if(solver(board, nextI, nextJ, nextVal++)) return true;
		getBack(board, i, j);
		return false;
	}
	
	public void solveSudoku(char[][] board) {
		if(!isValidSudoku(board)) return;
		int firstIJ = first(board, 0, 0);
		solver(board, firstIJ/10, firstIJ%10, '1');
    }
    */
	
	private boolean reject(int i, int j, char val) {
		int index = val-'0'-1;
		if(rows[i][index]) return true;
		if(cols[j][index]) return true;
		if(squares[i/3*3+j/3][index]) return true;
		return false;
	}
	
	private boolean accept(int i, int j) {
		if(nexts[i*10+j]==-1) return true;
		else return false;
	}
	
	private int first(int i, int j) {
		return nexts[i*10+j];
	}
	
	private void progress(int i, int j, char val) {
		int index = val-'0'-1;
		board[i][j] = val;
		rows[i][index] = cols[j][index] = squares[i/3*3+j/3][index] = true;
	}
	
	private void getBack(int i, int j) {
		int index = board[i][j]-'0'-1;
		board[i][j] = '.';
		rows[i][index] = cols[j][index] = squares[i/3*3+j/3][index] = false;
	}
	
	private boolean solver(int i, int j, char val) {
		int nextIJ;
		if(reject(i, j, val)) return false;
		progress(i, j, val);
		if(accept(i, j)) return true;
		nextIJ = first(i, j);
		for(char c = '1'; c<='9'; c++) {
			if(solver(nextIJ/10, nextIJ%10, c)) return true;
		}
		getBack(i, j);
		return false;
	}
	
	private boolean init(char[][] board) {
		int index;
		firstIJ = -1;
		this.board = board;
		for(int i = 8; i>=0; i--) {
			for(int j = 8; j>=0; j--) {
				index = board[i][j]-'0'-1;
				if(index>=0 && index<9) {
					if(!rows[i][index]) rows[i][index] = true;
					else return false;
					if(!cols[j][index]) cols[j][index] = true;
					else return false;
					if(!squares[i/3*3+j/3][index]) squares[i/3*3+j/3][index] = true;
					else return false;
				}
				else if(board[i][j]!='.') return false;
				else {
					nexts[i*10+j] = firstIJ;
					firstIJ = i*10+j;
				}
			}
		}
		return true;
	}
	
	public void solveSudoku(char[][] board) {	
		if(!init(board)) return;
        for(char val = '1'; val<='9' && !solver(firstIJ/10, firstIJ%10, val); val++);
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean rs = false;
		String[] ss = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][];
		for(int i = 0; i<9; i++) {
			board[i] = ss[i].toCharArray();
		}
		new Solution37_SS().solveSudoku(board);
		System.out.println("end.");
	}

}
