package project1;

public class SubArraysWithSumEqualsK {

	private static int numberOfSubarrays(int[] arr, int k) {
		int n = arr.length;
		int count = 0;

		for (int l = 0; l < n; l++) {
			int sum = 0;
			for (int r = l; r < n; r++) {
				sum = sum + arr[r];
				if (sum == k)
					count++;

			}

		}

		return count;
	}

	private static int numberOfSubarrays1(int[] arr, int k) {
		
		
	     int n = arr.length;
	        int count = 0;
	        int currentSum = 0;
	        int left = 0;
	     //   int right = 0;

	        for (int right = 0 ; right < n ; right++ ) {
	        	
	        	currentSum =  currentSum + arr[right];
	            
	         while (currentSum < k && right < n) {
	        	 currentSum = currentSum + arr[right];
	        	 right++;
	         }
	         
	         //Now currentSum = k
	         
	         int initial = right;
	         
	         while (currentSum == k && right < n) {
	        	 right++;
	         }
	         
	         int finalRight = right -1;
	         //Now currentSum is more than k
	         
	         count +=  finalRight - initial + 1;
	         
	         //Now we will increment the left pointer
	         
	         currentSum = currentSum - arr[left];
	         left++;
	         
	         
	        }
	        return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 0, 1, 1, 0, 1 };
		int k = 2;

		System.out.println(numberOfSubarrays(arr, k));

	}

}
