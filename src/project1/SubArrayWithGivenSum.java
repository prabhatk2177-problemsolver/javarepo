package project1;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

	private static ArrayList<Integer> subarraySum(int[] arr, int target) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;
		int s = 0;
		int e = 0;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			e = i;
			sum = sum + arr[i];

			while (sum > target && s < e) {
				sum = sum - arr[s];
				s++;
			}

			if (sum == target) {
				res.add(s);
				res.add(e);
				return res;
			}

		}

		res.add(-1);
		return res;

	}

	public static void main(String[] args) {
		int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int target = 23;
		ArrayList<Integer> res = subarraySum(arr, target);

		for (int ele : res)
			System.out.print(ele + " ");
	}

}
