package dynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		solveUsingMemo();
//		solveUsingTabu();
		solveUsingSpace();
		

	}
	
	static int helperMemo(int n, int[] dp) {
		if(n<=1) {
			return n;
		}
		if(dp[n]!= -1) {
			return dp[n];
		}
		
		return(dp[n] = helperMemo(n-1,dp) + helperMemo(n-2, dp));
	}
	
	static void solveUsingMemo() {
		int n =5;
		int dp[] = new int [n+1];
		Arrays.fill(dp,-1);
		System.out.println(helperMemo(n,dp));
		
	}
	
//   ************************
	
	static void solveUsingTabu() {
		int n = 5;
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i =2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
	
	
//	   ******************
	
	static void solveUsingSpace() {
		int n =5;
		int prev = 1;
		int prev2 = 0;
		
		for(int i = 2; i<= n; i++) {
			int curr_i = prev2 + prev;
			prev2 = prev;
			prev = curr_i;
		}
		
		System.out.println(prev);
	}
	

}
