package project1;

public class CheckIfSubSetWithAGivenSum {
	
	static boolean checkIfSubSetExists (int[] num, int sum) {
		
		boolean[][] dp = new boolean[num.length+1][sum+1];
		
		for (int i = 0; i < sum+1;i++)
			dp[0][i] = false;
		
		for (int i = 0; i< num.length+1; i++)
			dp[i][0] = true;
		
		for (int i = 1 ; i < num.length+1; i++) {
			for (int j = 1; j < sum+1;j++) {
				
				if (num[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else
					dp[i][j]= dp[i-1][j] || dp[i-1][j-num[i-1]];
			}
				
		}
		
		return dp[num.length][sum];
		
		  
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] num = { 17,4, 5, 1,9,101 };
		int sum = 17;

		System.out.println(checkIfSubSetExists(num,sum));

	}

}
