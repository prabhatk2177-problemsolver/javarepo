package project1;

import java.util.PriorityQueue;

public class KSorted {
	
	static void nearlySorted(int[] arr, int k) {
		int n = arr.length;
		
		PriorityQueue<Integer> pq  = new PriorityQueue<Integer>();
		//Make the 1st window
		for (int i = 0; i <=k ; i++) {
			pq.add(arr[i]);
			
		}
		
		//Remove the 1st sorted elem
		arr[0]= pq.poll();
		
		for (int i = k+1; i< n; i++) {
			pq.add(arr[i]);
			
			arr[i-k] = pq.poll();
			
		}
		
		int t = n-k;
		
		while (!pq.isEmpty()) {
			arr[t] = pq.poll();
			t++;
		}
		
		
		
		
	}
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {2, 3, 1, 4};

        nearlySorted(arr, k);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

	
}
