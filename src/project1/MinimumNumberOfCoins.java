package project1;

public class MinimumNumberOfCoins {
	
	private static int count (int[] coins, int sum) {
		int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
		
		for (int  col= 0 ; col < sum+1; col++)
			dp[0][col] = Integer.MAX_VALUE-1;
		
		for (int row = 1; row < n+1; row++)
			dp[row][0] = 0;
		
		

		for (int i =1 ;i < n+1 ; i++) {
			for (int j = 1; j < sum+1; j++) {
				
				if (coins[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					int notpick = dp[i-1][j];
					int pick = 1+ dp[i][j- coins[i-1]];
					dp[i][j] = Math.min(pick,notpick);
				}
			}
		}
			
		return dp[n][sum];
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = {9, 6, 5, 1};
        int sum = 19;
		
		
	        System.out.println(count(coins, sum));
		

	}

}
