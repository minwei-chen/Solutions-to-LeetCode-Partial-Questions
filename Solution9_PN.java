import java.util.Scanner;


public class Solution9_PN {

	public boolean isPalindrome(int x) {
		if(x < 0) return false;
        if(x < 10) return true;
        if(x%10 == 0) return false;
        for(int rHalf = 0, result; x > rHalf; x = result) {
            result = x/10;
        	if(result==rHalf) return true;
        	rHalf = rHalf*10+x%10;
        	if(result==rHalf) return true;
        }
        return false;   
    }
	
	/*public boolean ispalindrome(int x) {
		int digNum = 0, rHalf = 0;
        for(int result = x; result != 0; digNum++, result /= 10);
        for(int i = 0; i < digNum/2; i++, x /= 10) rHalf = rHalf*10+x%10;
        if(digNum%2 == 1) x /= 10;
        return x == rHalf;
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println(new Solution9_PN().isPalindrome(sc.nextInt()));
	}

}
