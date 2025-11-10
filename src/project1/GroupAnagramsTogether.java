package project1;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagramsTogether {
	
	private static String getHash(String s) {
		int[] freq = new int[26];
		
		for(Character c : s.toCharArray()) {
			freq[c -'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < 26 ; i++) {
			
			sb.append(freq[i]);
			sb.append('$');
		}
		
		
		return sb.toString();
	}
	
	private static ArrayList<ArrayList<String>> anagrams (String[] str){
		 ArrayList<ArrayList<String>> res = new  ArrayList<ArrayList<String>> ();
		 HashMap<String, Integer> hm = new HashMap<String,Integer>();
		 
		 for ( String s : str) {
			 String hash = getHash(s);
			 
			 if (!hm.containsKey(hash)) {
				 hm.put(hash, res.size());
				 res.add(new ArrayList<String>());
			 }
			 res.get(hm.get(hash)).add(s);
			 
		 }
		
		return res;
	}
	
	 public static void main(String[] args) {
	        String[] arr = {"act", "god", "cat", "dog", "tac"};
	        
	        ArrayList<ArrayList<String>> res = anagrams(arr);
	        for (int i = 0; i < res.size(); i++) {
	            for (int j = 0; j < res.get(i).size(); j++)
	                System.out.print(res.get(i).get(j) + " ");
	            System.out.println();
	        }
	    }

}
