package project1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsequestiveSubsequneceInArray {

	private static int longestConsecutive(int[] arr) {
		Set<Integer> hs = new TreeSet<Integer>();
		for (int i : arr)
			hs.add(i);

		int max = 1;
		
		
		
		

		// All memebers added
		for (int s : arr) {
			// Assuming a subseq starts from s

			if (hs.contains(s) && !hs.contains(s - 1)) {

				int curr = s;
				int count = 0;

				while (hs.contains(curr)) {
					count++;
					hs.remove(curr);

					curr++;

				}
				max = Math.max(max, count);

			}

		}

		return max;

	}

	public static void main(String[] args) {

		int[] arr = { 100, 4, 1, 5, 1, 55, 6, 3, 2 };
		System.out.println(longestConsecutive(arr));
	}

}
