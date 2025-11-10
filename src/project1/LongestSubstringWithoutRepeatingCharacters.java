package project1;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	private static String longestSubs(String s) {
		int max = 1;
		int start = 0;
		int end  = 0;
		int start_index = 0;
			
		int n = s.length();
		
		if (n < 2)
			return s;
		
		HashMap<Character, Integer> hm =  new HashMap<>();
		
		while (end < n) {
			Character c = s.charAt(end);
			
			if (hm.isEmpty()|| !hm.containsKey(c))
				hm.put(c, hm.getOrDefault(c, 0) + 1);
			else {
				while(hm.containsKey(c) && start < end) {
					hm.put(s.charAt(start), hm.get(s.charAt(start)) -1);
					start++;
				}
				hm.put(c, 1);
			}
			
			if (end-start+1 > max) {
				max = end-start+1;
				start_index = start;
				
			}
			//Now hm does not have ny repeating characters;
			end++;
			
		}
		
		
		return s.substring(start_index, start_index + max+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String res = longestSubs("geeksforgeeks");
		System.out.println(res);

	}

}
