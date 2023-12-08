package dynamicProgramming;

import java.util.Arrays;

public class MiniPathSumInTriGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		System.out.println(usingTabu());

	}
	
	static int helper(int i, int j, int[][] trinagle, int n, int[][]dp) {
		if(dp[i][j]!= -1) {
			return dp[i][j];
		}
		if(i == n-1) {
			return trinagle[i][j];
		}
		int down = trinagle[i][j] + helper(i+1,j,trinagle,n,dp);
		int daigonal = trinagle[i][j] + helper(i+1,j+1, trinagle,n,dp);
		
		return dp[i][j] = Math.min(daigonal, down);
	}
	
	static void usingMemo() {
		int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

		int n = triangle.length;
		
		int dp[][] = new int[n][n];
		for(int row[]: dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(helper(0,0,triangle,n,dp));

	}
	
	static int usingTabu() {
		int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

		int n = triangle.length;
		
		int dp[][] = new int[n][n];
		for(int j= 0; j<n;j++) {
			dp[n-1][j] = triangle[n-1][j];
		}
		
		for(int i = n-2; i>=0 ; i--) {
			for(int j = i; j>=0; j--) {
				
				int down = triangle[i][j] + dp[i+1][j];
				int diagonal = triangle[i][j] + dp[i+1][j+1];
				
				dp[i][j] = Math.min(diagonal, down);
			}
		}
		return dp[0][0];
	}
	

}
