package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();

	}
	
	static boolean helper(int ind, int target, int arr[], int[][] dp) {
		if(target == 0) {
			return true;
		}
		if(ind == 0) {
			return arr[0] == target;
		}
		if(dp[ind][target] != -1) {
			return dp[ind][target] == 0 ? false:true;
		}
		
		boolean notPick = helper(ind -1, target, arr, dp);
		
		boolean pick = false;
		
		if(arr[ind] <= target) {
			pick = helper(ind - 1, target - arr[ind], arr,dp);
		}
		
		dp[ind][target] = notPick || pick ? 1:0;
		
		return notPick || pick; 
		
		
	}
	static void solveUsingMemo() {
		int arr[] = {2,3,3,3,4,5};
		int n = arr.length;
		
		int Summ = 0;
		for(int i=0;i<n;i++) {
			Summ += arr[i];
		}
		if(Summ %2 == 1) {
			System.out.println(false);
		}
		else {
			int k = Summ /2;
		
		
		int dp[][] = new int[n][k+1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(helper(n-1,k,arr,dp));
		}
		
	}
	
	static void solveUsingTabu() {
		int arr[] = {2,3,3,3,4,5};
		int n = arr.length;
		
		int Summ = 0;
		for(int i=0;i<n;i++) {
			Summ += arr[i];
		}
		if(Summ %2 == 1) {
			System.out.println(false);
		}
		else {
			int k = Summ/2;
			boolean dp[][] = new boolean [n][k+1];
			for(int i = 0; i <n; i++) {
				dp[i][0] = true;
			}
			if(arr[0] <= k) {
				dp[0][arr[0]] = true;
			}
			
			for(int ind = 1; ind<n; ind++) {
				for(int target = 1; target <= k ; target++) {
					boolean notPick = dp[ind-1][target];
					
					boolean pick = false;
					if(arr[ind] <= target) {
						pick = dp[ind-1][target - arr[ind]];
					}
					dp[ind][target] = notPick || pick;
				}
			}
			
			System.out.println(dp[n-1][k]);
		}
		
		
	}

}
