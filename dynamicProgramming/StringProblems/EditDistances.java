package dynamicProgramming.StringProblems;

import java.util.Arrays;

public class EditDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingMemo();
		System.out.println(usingTabu()); 

	}
	
	static int helper(String s1, String s2, int ind1, int ind2, int[][] dp) {
		if(ind1<0) {
			return ind2 +1;
		}
		if(ind2<0) {
			return ind1+1; 
		}
		
		if(dp[ind1][ind2] != -1) {
			return dp[ind1][ind2]; 
		}
		
		if(s1.charAt(ind1) == s2.charAt(ind2)) {
			return dp[ind1][ind2] = helper(s1,s2,ind1-1,ind2-1,dp); 
		}
		else {
	            return dp[ind1][ind2] = 1 + Math.min(helper(s1, s2, ind1 - 1, ind2 - 1, dp),
	                    Math.min(helper(s1, s2, ind1 - 1, ind2, dp), helper(s1, s2, ind1, ind2 - 1, dp)));
		}
		
	}
	
	static void usingMemo() {
		String s1 = "horse";
        String s2 = "ros";
        
        int n = s1.length();
        int m = s2.length(); 
        
        int[][] dp = new int[n][m]; 
        
        for(int row[] : dp) {
        	Arrays.fill(row, -1);
        }
        
        System.out.println(helper(s1,s2,n-1,m-1,dp)); 
	}
	
	
	
	
	static int usingTabu() {
		String s1 = "horse";
        String s2 = "ros";
        
        int n = s1.length();
        int m = s2.length(); 
        
        int dp[][] = new int [n+1][m+1]; 
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                   
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
       
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
	}

}
