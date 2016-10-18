
public class Solution60_PS {

    public String getPermutation(int n, int k) {
        int factorials[] = new int[n-1], index, res, i, count;
        String s = "";
        boolean status[] = new boolean[n], flag;
        for(factorials[0] = index = 1; index<n; index++) {
        	factorials[index] = factorials[index-1]*index;
        }
        for(index = n-2; index>=0; index--) {
        	res = k/factorials[n-index-2];
        	for(i = count = 0, flag = true; i<n && flag; i++) {
        		if(!status[i]) count++;
        		if(count==res) flag = false;
        	}
        	s = s+i;
        	status[i-1] = true;
        	k = k%factorials[n-index-2];
        }
        for(index = 0; status[index]; index++);
        return s;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
