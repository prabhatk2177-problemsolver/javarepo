package project1;

public class UnboundedKnapsack {
	
	private static int knapSack(int capacity, int[] val, int[] wt) {
		int n= val.length;
		
		int[][] dp = new int[n+1][capacity+1];
		
		for (int i = 0; i < n+1;i++) {
			for (int j =0 ; j <capacity+1;j ++) {
				if (i ==0 || j ==0 ) {
					dp[i][j] = 0;
				}
					
			}
		}
		
		for (int i = 1; i < n+1;i++) {
			for (int j =1 ; j <capacity+1;j ++) {
				
				if (wt[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					int notpick = dp[i-1][j];
					int pick = val[i-1] + dp[i][j-wt[i-1]];
					dp[i][j] = Math.max(pick, notpick);
				}
					
			}
		}
		
		
	return dp[n][capacity];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     int[] val = {1, 1};
	        int[] wt = {2, 1};
	        int capacity = 3;
	        System.out.println(knapSack(capacity, val, wt));    
	    }

	}


