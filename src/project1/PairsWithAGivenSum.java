package project1;

import java.util.HashMap;

public class PairsWithAGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] arr = {1,23,47,25,48};
   HashMap<Integer,Integer>hm = new HashMap<Integer, Integer>();
   int count = 0;
   
   for (int i : arr) {
	   int remainder = i %24;
	   hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);
	   
	   int complement = 24 - remainder;
	   if (hm.size() > 0 && hm.containsKey(complement))
		   count++;
	   
	  
   }
   System.out.println(count);
	}

}
