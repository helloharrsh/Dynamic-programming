package dynamicProgramming;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
//		solveUsingMemo();
//		solveUsingTabu();
		solveUsingSpace();

	}
	
	static int helper(int[]height, int[] dp, int ind) {
		if(ind == 0) {
			return 0;
		}
		if(dp[ind] != -1) {
			return dp[ind];
		}
		
		int jumpTwo = Integer.MAX_VALUE;
		int jumpOne = helper(height, dp, ind-1) + Math.abs(height[ind] - height[ind-1]);
		if(ind >1) {
			jumpTwo = helper(height, dp, ind-2) + Math.abs(height[ind] - height[ind-2]);
		}
		
		return dp[ind] = Math.min(jumpTwo, jumpOne);
	}
	
	static void solveUsingMemo(){
		int[] height = {30,10,60,10,60,50}; 
		int n  = height.length;
		int[] dp = new int[n]; 
		Arrays.fill(dp, -1);
		
		System.out.println(helper(height,dp,n-1));
	}
	
//					**************************
	
	static void solveUsingTabu() {
		int height[]={30,10,60,10,60,50};
		  int n=height.length;
		  int dp[]=new int[n];
		  Arrays.fill(dp,-1);
		  dp[0]=0;
		  for(int ind=1;ind<n;ind++){
		      int jumpTwo = Integer.MAX_VALUE;
		        int jumpOne= dp[ind-1] + Math.abs(height[ind]-height[ind-1]);
		        if(ind>1)
		            jumpTwo = dp[ind-2] + Math.abs(height[ind]-height[ind-2]);
		    
		        dp[ind]=Math.min(jumpOne, jumpTwo);
		  }
		  
		  System.out.println(dp[n-1]);
	}
	
	
// 				********************
	
	static void solveUsingSpace() {
		int[] height = {30,10,60,10,60,50};
		int n = height.length;
		int prev = 0;
		int prev2 = 0;
		for(int i = 1; i<n; i++) {
			int jumpTwo = Integer.MAX_VALUE;
			int jumOne = prev + Math.abs(height[i] - height[i-1]);
			if(i>1) {
				jumpTwo = prev2 + Math.abs(height[i] - height[i-2]);
			}
			int curr = Math.min(jumpTwo, jumOne);
			prev2 = prev;
			prev = curr;
		}
		System.out.println(prev);
	}

}
