package project1;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInWindowOfK {
	
	private static ArrayList<Integer> countDistinctElems (int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;
		if (k > n)
			return null;
		HashMap<Integer, Integer> hm =  new HashMap<>();
		
		for (int i = 0 ; i < k ; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
			
		}
		res.add(hm.size());
		
		//Add entries for remaining array
		for (int i = k ; i < n ; i++) {
			// Add ith element
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
			
			//remove the one which falls off the window
			hm.put(arr[i-k], hm.get(arr[i-k]) - 1);
			
			if (hm.get(arr[i-k]) == 0)
				hm.remove(arr[i-k]);
			
			res.add(hm.size());
			
		}
		
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[] arr = {1, 2, 1, 3, 4, 2, 3};
	        int k = 4;
		ArrayList<Integer> res = countDistinctElems ( arr,  k) ;
		System.out.println(res);
	}

}
