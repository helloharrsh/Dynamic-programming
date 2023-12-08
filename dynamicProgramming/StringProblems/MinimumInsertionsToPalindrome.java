package dynamicProgramming.StringProblems;

import java.util.Arrays;

public class MinimumInsertionsToPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();

	}
	
	static int helper(String s1, String s2, int ind1, int ind2, int[][] dp) {
		if(ind1<0 || ind2<0) {
			return 0; 
		}
		if(dp[ind1][ind2] != -1) {
			return dp[ind1][ind2]; 
		}
		if(s1.charAt(ind1) == s2.charAt(ind2)) {
			return dp[ind1][ind2] = 1 + helper(s1,s2,ind1 - 1, ind2 - 1, dp); 
		}
		else {
			return dp[ind1][ind2] = Math.max(helper(s1,s2,ind1,ind2-1,dp),helper(s1,s2,ind1-1, ind2 ,dp)); 
		}
	}
	
	static void usingMemo() {
		String s = "abcaa"; 
		String reversed = new StringBuilder(s).reverse().toString();
		
		int n  = s.length(); 
		int m = reversed.length(); 
		
		int dp[][] = new int[n][m]; 
		for(int rows[] : dp) {
			Arrays.fill(rows, -1);
		}
		
		System.out.println(n - helper(s,reversed,n-1,m-1,dp));
		
		// we can use the lcs code in both tabulation and memoization.  
		
	}

}
