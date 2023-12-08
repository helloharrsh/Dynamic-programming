package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class CountPartitionsWithGivenDiffers {

	static int mod = (int)(Math.pow(10, 9)+7);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveMemo());
		System.out.println(solveTabu());

	}
	
	static int helper(int ind , int target, int []arr, int [][]dp) {
		if(ind ==0) {
			if(target == 0 && arr[0] == 0) {
				return 2; 
			}
			if(target == 0 || target == arr[0]) {
				return 1; 
			}
			return 0; 
		}
		
		if(dp[ind][target] != -1) {
			return dp[ind][target];
		}
		
		int notTaken = helper(ind-1, target, arr,dp);
		
		int taken = 0; 
		if(arr[ind] <= target) {
			taken = helper(ind -1, target - arr[ind], arr, dp); 
		}
		
		return dp[ind][target] = (notTaken + taken) % mod; 
	}
	
	
	static int solveMemo() {
		int arr[] = {5,2,6,4};
		int d = 3; 
		
		int n = arr.length;
		int totSum = 0; 
		for(int i=0; i< arr.length; i++) {
			totSum += arr[i];
		}
		
		if(totSum - d<0) return 0;
		if((totSum -d)%2 == 1) return 0; 
		
		int s2 = (totSum-d)/2;
		int dp[][] = new int [n][s2+1]; 
		
		for(int row[] : dp) {
			Arrays.fill(row, -1);
			
		}
		
		return helper(n-1,s2,arr,dp);
	}
	
	
	
	
	static int helper2(int[] num, int tar) {
		int n = num.length;
		int dp[][] = new int[n][tar+1]; 
		
		if(num[0] == 0) dp[0][0] =2;
		else dp[0][0] =1;
		
		if(num[0] != 0 && num[0] <= tar) dp[0][num[0]] =1;
		
		for(int ind =1; ind <n; ind++) {
			for(int target = 0; target< tar; target++) {
				int notTaken = dp[ind-1][target];
				int taken = 0; 
				
				if(num[ind] <= target) {
					taken = dp[ind -1][target - num[ind]];
				}
			}
		}
		
		return dp[n-1][tar];
	}
	
	static int solveTabu() {
		int arr[] = {5,2,6,4}; 
		int n = arr.length;
		int d = 3;
		
		int totSum = 0; 
		for(int i=0; i< n; i++) {
			totSum += arr[i];
		}
		
		if(totSum -d< 0 || (totSum -d)%2 ==1) {
			return 0; 
		}
		
		return helper2(arr,(totSum -d)/2);
		
	}

}
