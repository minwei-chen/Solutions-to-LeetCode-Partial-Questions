import java.util.Scanner;


public class Solution7_RI {

	public int reverse(int x) {
		if(-10<x && x<10) return x;
        int reversed = 0;
        for(int result = x, remainder = 0, pre; result!=0; result /= 10) {
        	remainder = result%10;
        	pre = reversed;
        	reversed = reversed*10+remainder;
        	if((reversed-remainder)/10 != pre) return 0;
        }
        return reversed;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(new Solution7_RI().reverse(sc.nextInt()));
		
	}

}
