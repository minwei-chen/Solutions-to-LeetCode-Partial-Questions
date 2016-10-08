import java.util.HashSet;
import java.util.Set;


public class Solution200_NOI {

    public int numIslands(char[][] grid) {
        
        int M = grid.length;
        if(M<1) return 0;
        int N = grid[0].length;
        Set<Integer> ones = new HashSet<>();
        
        for(int i = 0; i<M; i++) {
            for(int j = 0; j<N; j++) {
                if(grid[i][j]=='1') ones.add(i*N+j);
            }
        }
        
        int stack[] = new int[M*N], top = 0, rs = 0;
        
        while(!ones.isEmpty()) {
            stack[top++] = ones.iterator().next();
            ones.remove(stack[top-1]);
            
            while(top>0) {
                int v = stack[--top];
                if(ones.contains(v+1)) {ones.remove(v+1); stack[top++] = v+1;}
                if(ones.contains(v-1)) {ones.remove(v-1); stack[top++] = v-1;}
                if(ones.contains(v+N)) {ones.remove(v+N); stack[top++] = v+N;}
                if(ones.contains(v-N)) {ones.remove(v-N); stack[top++] = v-N;}
            }
            rs++;
        }
        
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = new char[20][];
	}

}
