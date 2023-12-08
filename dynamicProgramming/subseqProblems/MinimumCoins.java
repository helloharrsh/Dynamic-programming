package dynamicProgramming.subseqProblems;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveUsingMemo();
		solveUsingTabu();
	}
	
	static int helper(int [] arr, int ind, int t, int[][] dp) {
		if(ind == 0) {
			if(t%arr[0] == 0) {
				return t/arr[0];
			}
			else {
				return (int)Math.pow(10, 9);
			}
		}
		
		if(dp[ind][t] != -1) {
			return dp[ind][t];
		}
		int notTake = 0 + helper(arr, ind -1, t,dp); 
		
		int taken = (int)Math.pow(10, 9);
		
		if(arr[ind] <= t) {
			taken = 1 + helper(arr,ind,t- arr[ind],dp); 
		}
		
		return dp[ind][t] = Math.min(notTake, taken);
	}

	static void solveUsingMemo() {
		int arr [] = {1,2,3}; 
		int t = 7; 
		
		int n = arr.length;
		int[][] dp = new int[n][t+1]; 
		for(int[]row: dp) {
			Arrays.fill(row, -1);
		}
		
		int ans = helper(arr,n-1,t,dp);
		if(ans >= (int)Math.pow(10, 9)) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	
	
	static void solveUsingTabu() {
		int arr[] = {1,2,3};
		int t = 7; 
		
		int n = arr.length;
        int dp[][] = new int[n][t + 1];

        for (int i = 0; i <= t; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = i / arr[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= t; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                if (arr[ind] <= target)
                    take = 1 + dp[ind][target - arr[ind]];

                dp[ind][target] = Math.min(notTake, take);
            }
        }

        int ans = dp[n - 1][t];

        if (ans >= (int) Math.pow(10, 9))
            System.out.println(-1);
		System.out.println(ans);
	}
}
