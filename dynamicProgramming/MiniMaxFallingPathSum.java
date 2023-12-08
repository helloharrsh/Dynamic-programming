package dynamicProgramming;

import java.util.Arrays;

public class MiniMaxFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		System.out.println(usingTabu());

	}
	
	static int helper(int i, int j, int m ,int[][] matrix, int [][] dp) {
		if(j<0 || j>= m) {
			return (int) Math.pow(-10, 9);
		}
		
		if(i==0) {
			return matrix[i][j];
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int up = matrix[i][j] + helper(i-1,j,m,matrix,dp);
		int leftDiag = matrix[i][j] + helper(i-1,j-1,m,matrix,dp);
		int rightDiag = matrix[i][j] + helper(i-1,j+1, m, matrix,dp);
		
		return dp[i][j] = Math.max(up,Math.max(leftDiag, rightDiag));
	}
	
	static void usingMemo() {
		int matrix[][] = {
				{1,2,10,4},
				{100,3,2,1},
				{1,1,20,2},
				{1,2,2,1}
		};
		int n = matrix.length;
		int m = matrix[0].length;
		
		int dp[][] = new int[n][m];
		for(int row[]: dp) {
			Arrays.fill(row, -1);
		}
		int maxi = Integer.MIN_VALUE;
		
		for(int j =0; j<m; j++) {
			int ans = helper(n-1,j,m,matrix,dp);
			maxi = Math.max(maxi,ans);
			
		}
		System.out.println(maxi);
	}
	
	
	
	
	
	static int usingTabu() {
		int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
		
		int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }

                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
	}

}
