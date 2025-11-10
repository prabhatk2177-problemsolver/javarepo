package project1;

import java.util.HashMap;

public class LongestSubstringwithKUniqueCharacters {

	private static String longestSubstring(String s, int k) {
		int n = s.length();
		int start = 0;
		int end = 0;
		int max_len = 1;
		int curr_len = 0;
		int start_index = 0;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		while (end < n) {
			Character c = s.charAt(end);

			hm.put(c, hm.getOrDefault(c, 0) + 1);

			
			if (hm.size() > k ) {
				while ((hm.size() > k) && start < end) {
					
					hm.put(s.charAt(start), hm.get(s.charAt(start)) - 1);
					start++;
				}

			}
			
			
            
           
			// At this point start = end; start further afresh;
			if (hm.size() == k && max_len < (end - start + 1)) {
				
				start_index = start;
				max_len = end- start + 1;
				
			}

			end++;

		}
		

		return s.substring(start_index, start_index+max_len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "kkeegeeeekggsforgeeks";
		int k = 3;

		System.out.println(longestSubstring(s, k));

	}

}
