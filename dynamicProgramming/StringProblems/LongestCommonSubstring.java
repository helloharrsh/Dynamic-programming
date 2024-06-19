package dynamicProgramming.StringProblems;

import java.util.Arrays;

public class LongestCommonSubstring {

	static int maxLength = 0;
	public static void main(String[] args) {
		
		
		solveUsingMemo();
		System.out.println(solveUsingTabu()); 

	}
	static int solveUsingTabu() {
		String s1 = "abcjklp";
        String s2 = "acjkp";
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val); 
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
	}
	
	static int helper(String s1, String s2, int n, int m, int count) { 
		
	if (n == 0 || m == 0) {
            return count;
        }

        int count1 = count;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count1 = helper(s1, s2, n - 1, m - 1, count + 1);
        }

        int count2 = helper(s1, s2, n - 1, m, 0);
        int count3 = helper(s1, s2, n, m - 1, 0);

        return Math.max(count1, Math.max(count2, count3));
	}
	
	static void solveUsingMemo() {
		String s1 = "abcjklp";
        String s2 = "acjkp";
        int n = s1.length();
        int m = s2.length();
        
        System.out.println(helper(s1,s2,n,m,0));
        
	}
}
