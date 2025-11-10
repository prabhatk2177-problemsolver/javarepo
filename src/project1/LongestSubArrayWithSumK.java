package project1;

public class LongestSubArrayWithSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10,11, 12, 1, 1, 2, 3, 5 };
		int start = 0;
		int end = 0;
		int n = arr.length;
		int sum = 0;
		int target = 5;
		int len = 0;
		int max_len = -1;

		while (end < n) {
			sum = sum + arr[end];

			while (sum > target && start < end) {
				sum = sum - arr[start];
				start++;
			}

			if (sum == target) {
				len = end - start + 1;
				max_len = Math.max(len, max_len);
			}

			end++;

		}
		
		if (max_len > 0)
			System.out.println(max_len);

	}

}
