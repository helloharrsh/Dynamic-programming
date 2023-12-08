package dynamicProgramming;

import java.util.Arrays;

public class GridUniquePathsWithObs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();

	}
	
	static int helper(int i, int j, int [][] maze, int [][] dp) {
		if(i>=0 && j>=0 && maze[i][j] == -1) {
			return 0;
		}
		if( i== 0 && j ==0) {
			return 1;
		}
		if(i<0 || j<0) {
			return 0;
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int up = helper(i-1,j, maze, dp);
		int down = helper(i,j-1,maze,dp);
		
		return dp[i][j] = up + down; 
	}
	
	static void solveUsingMemo() {
		int[][] maze = {
	            {0, 0, 0},
	            {0, -1, 0},
	            {0, 0, 0}
	        };

	    int n = maze.length;
	    int m = maze[0].length;
	    
	    int[][] dp = new int[n][m];
	    
	    for(int row[] : dp) {
	    	Arrays.fill(row, -1);
	    }
	    System.out.println(helper(n-1,m-1,maze,dp));
	    
	}
	
	static int helper2(int n, int m, int [][] maze, int [][]dp) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(i>0 && j>0 && maze[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}
				if(i == 0 && j == 0) {
					dp[i][j] =1;
					continue;
				}
				int up =0;
				int left = 0;
				
				if(i>0) {
					up = dp[i-1][j];
				}
				if(j>0) {
					left = dp[i][j-1];
				}
				dp[i][j] = up + left;
			}
		}
		return dp[n-1][m-1];
	}
	
	static void solveUsingTabu() {
		int[][] maze = {
	            {0, 0, 0},
	            {0, -1, 0},
	            {0, 0, 0}
	        };

	    int n = maze.length;
	    int m = maze[0].length;
	    
	    int[][] dp = new int[n][m];
	    
	    for(int row[] : dp) {
	    	Arrays.fill(row, -1);
	    }
	    System.out.println(helper2(n,m,maze,dp));
	    
	}

}
