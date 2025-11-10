package project1;

public class ZeroOneKnapSack {

	static int knapsackRec(int W, int[] val, int[] wt, int n, int[][] memo) {
		if (n == 0 || W == 0)
			return 0;

		if (memo[W][n] != -1)
			return memo[W][n];
		// You can include it
		if (wt[n - 1] <= W) {
			return memo[W][n] = Math.max(knapsackRec(W, val, wt, n - 1, memo),
					val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1, memo));

		}

		else {
			return memo[W][n] = knapsackRec(W, val, wt, n - 1, memo);
		}

	}

	static int knapsack(int W, int[] val, int[] wt) {
		int n = 3;
		int[][] memo = new int[W + 1][n + 1];

		for (int i = 0; i <= W; i++) {
			for (int j = 0; j <= n; j++)
				memo[i][j] = -1;
		}

		return knapsackRec(W, val, wt, 3, memo);
	}

	static int knapsackTD(int W, int[] val, int[] wt) {
		int n = 3;
		int[][] memo = new int[n + 1][W + 1];
		
		

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0)
					memo[i][j] = 0;
			}
		}
		
		
		for (int i = 1; i < n +1; i ++) {
			for (int j = 1 ;j < W+ 1; j++) {
				//Don't pick
				if (wt[i-1] > j) {
					memo[i][j] = memo[i-1][j];
				}
				
				else {
					int pick = val[i-1] + memo[i-1][j - wt[i-1]] ;
					int notpick = memo[i-1][j];
					memo[i][j] = Math.max(pick, notpick);
					
				}
			}
		}
			
		

		return memo[n][W];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] val = { 1, 2, 3 };
		int[] wt = { 4, 5, 1 };
		int W = 4;

		System.out.println(knapsackTD(W, val, wt));

	}

}
