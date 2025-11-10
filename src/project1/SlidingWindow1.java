package project1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindow1 {

	private static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;

		for (int i = 0; i <= n - k; i++) {
			int max = arr[i];
			for (int j = 0; j < k; j++) {
				if (arr[i + j] > max)
					max = arr[i + j];
			}
			res.add(max);

		}

		return res;

	}

	private static ArrayList<Integer> maxOfSubarrays1(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			public int compare(Pair a, Pair b) {
				return b.first - a.first;
			}
		});

		// 1st k put in Priority Queue
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(arr[i], i));
		}

		// Add the maximum of 1st key to res
		res.add(pq.peek().first);

		// Process the remaining ones
		for (int i = k; i < n; i++) {

			// Add to heap
			pq.add(new Pair(arr[i], i));

			// Remove those outside of boundary and which are maximum

			while (pq.peek().second <= i - k)
				pq.poll();

			// Now the maximum definitely belongs to this batch, add it to the result
			res.add(pq.peek().first);

		}

		return res;

	}

	private static ArrayList<Integer> maxOfSubarrays2(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;

		// Deque to store array indices
		Deque<Integer> dq = new ArrayDeque<Integer>();

		// Process 1st k elements
		for (int i = 0; i < k; i++) {

			// Keep removing from rear end if the element at rear
			// end is smaller than the incoming element
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
				dq.pollLast();

			dq.addLast(i);

		}
		
		//Process rest of the elems
		
		for(int i = k ; i < n ;i ++) {
			res.add(arr[(dq.peekFirst())]);
			
			while(!dq.isEmpty() && dq.peekFirst() <= i-k)
				dq.pollFirst();
			
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
				dq.pollLast();
			

			dq.addLast(i);

			
		}
		res.add(arr[(dq.peekFirst())]);
		return res;

	}

	static class Pair {
		// Array value
		int first;
		// Array index
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3;
		ArrayList<Integer> res = maxOfSubarrays2(arr, k);
		for (int maxVal : res) {
			System.out.print(maxVal + " ");
		}
	}

}
