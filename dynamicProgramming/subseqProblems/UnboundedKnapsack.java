package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		usingTabu(); 
		
		// rod cutting problem is same as this problem. 

	}
	
	static int helper(int[] wt, int[] val, int ind, int w, int[][]dp) {
		if(ind == 0) {
			return((int)(w/wt[0]) * val[0]); 
		}
		
		if(dp[ind][w] != -1) {
			return dp[ind][w]; 
		}
		int notTake = 0 + helper(wt,val,ind -1, w,dp); 
		
		int take = Integer.MIN_VALUE; 
		
		if(wt[ind] <= w) { 
			take = val[ind] + helper(wt,val, ind, w-wt[ind], dp); 
		}
		
		return dp[ind][w] = Math.max(notTake, take); 
	}
	
	static void usingMemo() {
		int wt[] = {2,4,6}; 
		int val[] = {5,11,13};
		int w = 10; 
		
		int n = val.length; 
		int [][] dp = new int[n][w+1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(helper(wt,val,n-1,w,dp)); 
	}
	
	static void usingTabu() {
		int wt[] = {2,4,6}; 
		int val[] = {5,11,13};
		int w = 10; 
		
		int n = val.length; 
		
		int dp[][] = new int[n][w+1]; 
		for(int i = wt[0]; i<= w; i++) {
			dp[0][i] = ((int) i/wt[0] * val[0]); 
		}
		
		for(int ind = 1; ind<n; ind++) {
			for(int cap =0; cap<=w; cap++) {
				int notTake = 0 + dp[ind-1][cap];
				int take = Integer.MIN_VALUE; 
				
				if(wt[ind] <= cap) {
					take = val[ind] + dp[ind][cap-wt[ind]]; 
				}
				
				dp[ind][cap] = Math.max(notTake, take);
			}
		}
		
		System.out.println(dp[n-1][w]); 
	}

}
