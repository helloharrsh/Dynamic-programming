package dynamicProgramming;

import java.util.Arrays;
public class MaxSumOfNonAdjEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();
		System.out.println(solveUsingSpace());
		

	}
	static int helper(int idx, int[] arr, int[] dp) {
		if(idx < 0) {
			return 0;
		}
		if(idx == 0) {
			return arr[idx];
		}
		if(dp[idx] != -1) {
			return dp[idx];
		}
		
		int pick = arr[idx] + helper(idx - 2, arr,dp);
		int nonPick = helper(idx -1, arr,dp);
		
		return dp[idx] = Math.max(pick, nonPick);
		
	}
	
	static void solveUsingMemo() {
		int arr [] = {2,1,4,9};
		int n = arr.length;
		int dp [] = new int [n];
		Arrays.fill(dp, -1);
		
		System.out.println(helper(n-1, arr,dp));
	}
	
	
	
	static int helperOfTabu(int idx, int[]arr, int[] dp) {
		dp[0] = nums[0];
        
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int not_pick = dp[i-1];
            
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n-1];

	}
	
	static void solveUsingTabu() {
		int arr [] = {2,1,4,9};
		int n = arr.length;
		int dp [] = new int [n];
		Arrays.fill(dp, -1);
		
		System.out.println(helperOfTabu(n, arr,dp));
	}
	
	
	static int solveUsingSpace() {
		int arr [] = {2,1,4,9};
		int n = arr.length;
		
		int prev = arr[0];
		int prev2 = 0;
		
		for(int i =1; i<n;i++) {
			int pick = arr[i];
			if(i >1) {
				pick += prev2;
			}
			int nonPick = prev;
			
			int curr_i = Math.max(pick, nonPick);
			prev2 = prev;
			prev = curr_i;
		}
		
		return prev;
	}
}
