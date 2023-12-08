package dynamicProgramming;

import java.util.Arrays;

public class GridUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();

	}
	static int helper(int i, int j, int[][] dp) {
		if(i == 0 && j == 0) {
			return 1;
		}
		if(i < 0 || j < 0) {
			 return 0;
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int up = helper(i-1,j,dp);
		int left = helper(i,j-1,dp);
		
		return dp[i][j] = up + left; 
	}
	
	static void solveUsingMemo() {
		int n = 2;
		int m = 3;
		
		int dp[][] = new int[m][n];
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(helper(m-1,n-1,dp));
	}
	
	
	static int helper2(int m, int n, int [][] dp) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j<n ;j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}
				int up =0;
				int left =0; 
				if(i>0) {
					up = dp[i-1][j];
				}
				if(j>0) {
					left = dp[i][j-1];
				}
				dp[i][j] = up + left;
			}
		}
		return dp[m-1][n-1];
	}
	
	static void solveUsingTabu() {
		int n = 2;
		int m = 3;
		int dp[][] = new int[m][n];
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(helper2(m,n,dp));
	}

}
