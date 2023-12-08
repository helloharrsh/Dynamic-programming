package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class KnapsackZeroOne {

	public static void main(String[] args) {
		solveUsingMemo();
		System.out.println(solveUsingTabu());
	}
	
	static int helper(int[] wt, int [] val, int ind , int w, int[][] dp) {
		if(ind == 0) {
			if(wt[0] <= w) {
				return val[0];
			} else {
				return 0; 
			}
		}
		
		if(dp[ind][w] != -1) {
			return dp[ind][w];
		}
		
		int notTaken = 0 + helper(wt,val, ind -1, w, dp);
		
		int taken = Integer.MIN_VALUE; 
		if(wt[ind] <= w) {
			taken = val[ind] + helper(wt,val, ind -1, w - wt[ind],dp);
		}
		
		dp[ind][w] = Math.max(notTaken, taken);
		
		return dp[ind][w];
	}
	
	static void solveUsingMemo() {
		int wt[] = {1,2,4,5};
		int val[] = {5,4,8,6};
		int w = 5;
		int n = wt.length;
		
		int dp[][] = new int[n][w+1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(helper(wt,val,n-1,w,dp));
	}
	
	static int solveUsingTabu() {
		int wt[] = {1,2,4,5};
		int val[] = {5,4,8,6};
		int w = 5;
		int n = wt.length;
		
		int dp[][] = new int[n][w+1];
		
		for(int i =wt[0]; i<= w; i++) {
			dp[0][i] = val[0];
		}
		
		for(int ind = 1; ind<n; ind++) {
			for(int capi = 0; capi<=w; capi++) {
				int notTaken = dp[ind-1][capi];
				
				int taken = Integer.MIN_VALUE; 
				if(wt[ind] <= capi) {
					taken = val[ind] + dp[ind-1][capi - wt[ind]];
				}
				
				dp[ind][capi] = Math.max(notTaken,taken); 
			}
		}
		
		return dp[n-1][w]; 
	
}
	
}