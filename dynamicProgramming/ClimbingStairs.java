package dynamicProgramming;
import java.util.*;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		same as the fibonacci number 
//		solveUsingTabu();
		
		solveUsingSpace();

	}
	
	static void solveUsingTabu() {
		int n = 3;
		int [] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<=n ;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
	
//			******************
	
	static void solveUsingSpace() {
		int n =3;
		int prev = 1;
		int prev2 = 1;
		
		for (int i =2; i<= n; i++) {
			int curr_i = prev + prev2;
			prev2 = prev;
			prev = curr_i;
		}
		
		System.out.println(prev);
	}

}
