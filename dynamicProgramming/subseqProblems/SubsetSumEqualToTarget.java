package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		solveUsingTabu();

	}
	
	static boolean helper(int ind, int target, int[] arr, int [][] dp) {
		if(target == 0) {
			return true;
		}
		if (ind == 0) {
			return arr[0] == target;
		}
		if(dp[ind][target] != -1) {
			return dp[ind][target] == 0 ? false:true;
		}
		
		boolean notPick = helper(ind-1,target,arr,dp);
		
		boolean pick = false;
		if(arr[ind] <= target) {
			pick = helper(ind-1,target - arr[ind], arr, dp);
		}
		
		dp[ind][target] = notPick || pick ? 1:0;
		
		return pick || notPick; 
	}
	
	
	static void usingMemo() {
		int arr [] = {1,2,3,4};
		int k = 4;
		int n  = arr.length;
		
		int dp[][] = new int[n][k+1];
		for(int row []: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(helper(n-1,k,arr,dp));
	}
	
	static boolean helper2(int n, int k, int[] arr) {
		boolean dp[][] = new boolean[n][k+1];
		
		for(int i =0;i <n; i++) {
			dp[i][0] = true;
		}
		
		if(arr[0] <= k) {
			dp[0][arr[0]] = true;
		}
		
		for(int idx = 1; idx<n; idx++) {
			for(int target = 1; target<=k; target++) {
				boolean notPick = dp[idx-1][target];
				
				boolean pick = false; 
				if(arr[idx] <= target) {
					pick = dp[idx -1][target - arr[idx]];
				}
				
				dp[idx][target] = pick || notPick;
			}
		}
		
		return dp[n-1][k];
		
	}
	static void solveUsingTabu(){
		int arr[] = {1,2,3,4};
		int k = 4;
		int n = arr.length;
		
		System.out.println(helper2(n,k,arr));
	}

}
