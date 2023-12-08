package dynamicProgramming;

import java.util.Arrays;
public class FrogJumpWithK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();
		
	}
	
	static int helper(int [] dp, int[] height, int n, int k) {
		if(n == 0) {
			return 0;
		}
		if(dp[n]!= -1) {
			return dp[n];
		}
		
		int mini_step = Integer.MAX_VALUE;
		
		for(int j = 1; j<=k; j++) {
			if(n - j>=0) {
				int jump = helper(dp,height,n-j,k) + Math.abs(height[n] - height[n - j]);
				mini_step = Math.min(jump, mini_step);
			}
			
		}
		return dp[n] = mini_step;
	}
	
	
	static void solveUsingMemo() {
		int height[] = { 30, 10, 60, 10, 60, 50 }; 
		int n = height.length;
		int k = 5;
		
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		
		System.out.println(helper(dp,height,n-1,k));
	}
	
// 		***************************
	
	static int helperOfTabu(int[] dp, int[] height, int n, int k) {
		dp[0] = 0;
		for(int i = 1; i< n; i++) {
			int mini_step = Integer.MAX_VALUE;
			
			for(int j =1; j <=k ;j++) {
				if(i-j >= 0) {
					int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mini_step = Math.min(jump, mini_step);
				}
			}
			dp[i] = mini_step;
		}
		return dp[n-1];
	}
	
	static void solveUsingTabu() {
		int height[] = { 30, 10, 60, 10, 60, 50 }; 
		int n = height.length;
		int k = 2;
		
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(helperOfTabu(dp,height,n-1,k));
	}

}
