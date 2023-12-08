package dynamicProgramming;

import java.util.ArrayList;

public class HouseRobber2 {
	
	public static void main(String[] args) {
//		the problem is totally based on the maxsumofnonadj problem. 
//		here we have to just create two different arrays so that we can have answers.  
		
		solve();
	}
	
	static long helper(ArrayList<Integer> arr) {
		int n = arr.size();
	    long prev = arr.get(0);
	    long prev2 =0;
	    
	    for(int i=1; i<n; i++){
	        long pick = arr.get(i);
	        if(i>1)
	            pick += prev2;
	        long nonPick = 0 + prev;
	        
	        long cur_i = Math.max(pick, nonPick);
	        prev2 = prev;
	        prev= cur_i;
	        
	    }
	    return prev;
	}
	
	
	
	static long houseRobber(int [] arr, int n) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		if(n == 1) {
			return arr[0];
		}
		for(int i = 0; i< n;i++) {
			if(i!=0) {
				list1.add(arr[i]);
			}
			if(i!=n-1) {
				list2.add(arr[i]);
			}
		}
		long ans1 = helper(list1);
		long ans2 = helper(list2);
		return Math.max(ans1, ans2);
	}
	
	static void solve() {
		int arr [] =  {1,5,1,2,6};
		int n = arr.length;
		System.out.println(houseRobber(arr,n));
	}

}
