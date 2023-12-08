package dynamicProgramming;

import java.util.Arrays;

public class MiniPathSumInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		usingTabu();

	}
	
	static int helper(int i, int j, int [][]dp, int [][] matrix) {
		if (i == 0 && j == 0)
            return matrix[0][0]; 
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9); 
        if (dp[i][j] != -1)
            return dp[i][j]; 
        
        int up = matrix[i][j] + helper(i - 1, j,dp,matrix);
        int left = matrix[i][j] + helper(i, j - 1,dp, matrix);

       
        return dp[i][j] = Math.min(up, left);
	}
	
	static void usingMemo() {
		int matrix[][] = {
	            {5, 9, 6},
	            {11, 5, 2}
	        };

	        int n = matrix.length;
	        int m = matrix[0].length;
	        
	        int[][] dp = new int[n][m];
	        for(int row[]:dp) {
	        	Arrays.fill(row, -1);
	        }
	        
	        System.out.println(helper(n-1,m-1,dp,matrix));
	}
	
	static int helper2(int n, int m, int[][] matrix) {
		int dp[][] = new int[n][m];
		for(int i =0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				if( i== 0 && j == 0) {
					dp[i][j] = matrix[i][j];
				}
				else {
					int up = matrix[i][j];
					if(i>0) {
						up = up + dp[i-1][j];
					}
					else {
						up = up + (int)Math.pow(10, 9);
					}
					
					int left = matrix[i][j];
					if(j>0) {
						left += dp[i][j-1];
					}
					else {
						left += (int)Math.pow(10, 9);
					}
					
					dp[i][j] = Math.min(up, left);
					
				}
			}
		}
		return dp[n-1][m-1];
	}
	
	static void usingTabu() {
		int matrix[][] = {
	            {5, 9, 6},
	            {11, 5, 2}
	        };

	        int n = matrix.length;
	        int m = matrix[0].length;
	        
	    
	    System.out.println(helper2(n, m, matrix));
		
	}

}
