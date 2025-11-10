package project1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindowOfSizeK {
	
	private static ArrayList<Integer> firstNegative(int[] arr, int k){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = arr.length;
		//Process 1st window
		//Only push -ve numbers and print out the 1st in queue
		
		Queue<Integer>soln = new LinkedList<>();
		for (int i = 0 ; i < k ;i ++) {
			//Push the index
			if (arr[i] < 0) {
				soln.add(i);
			}
		}
		
		//Add the soln for 1st k to the result
		if (!soln.isEmpty())
		res.add(arr[soln.peek()]);
		else
			res.add(100);
		
		
		//Process the rest of elements
		
		for (int i = k ; i < n ; i++) {
			//Add it
			if (arr[i] < 0) {
				soln.add(i);
			}
			
			//Remove the one's out of range
			while (!soln.isEmpty() && soln.peek() <= i-k) {
				soln.poll();
			}
			
			if (!soln.isEmpty())
				res.add(arr[soln.peek()]);
				else
					res.add(100);
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		ArrayList<Integer> res =  firstNegative(arr,3);
		
		System.out.println(res);

	}

}
