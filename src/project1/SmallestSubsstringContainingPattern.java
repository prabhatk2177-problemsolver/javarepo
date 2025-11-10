package project1;

import java.util.HashMap;

//Assume all distinct chars

public class SmallestSubsstringContainingPattern {

	private static String smallestSubs(String s, String pattern) {
		int start_index = -1;
		int n = s.length();
		int p = pattern.length();
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> freq = new HashMap<>();
		HashMap<Character, Integer> freq_iter = new HashMap<>();

		for (Character c : pattern.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
			freq_iter.put(c, freq_iter.getOrDefault(c, 0) + 1);
		}

		int unique_chars = freq.size();
		int matchedChars = 0; // TO keep count of encountered uniq chars
		int min_length = Integer.MAX_VALUE;
		int curr_length = 0;

		while (end < n) {
			Character c = s.charAt(end);
			
			//Iterate the current character and decrease its frequency from the freq_iter map

			if (freq.containsKey(c)) {
				freq_iter.put(c, freq_iter.get(c) - 1);

				System.out.println(freq_iter);
				if (freq_iter.get(c) == 0) {
					matchedChars++;
				}
			}
System.out.println("BEFORE DATA" + matchedChars);
			System.out.println(start);
			System.out.println(end);

			if (matchedChars == unique_chars) {
				System.out.println("MMATCHED DATA");
				System.out.println(start);
				System.out.println(end);
				// Try to remove unnecessary cahrs

				while (start < end && (!freq.containsKey(s.charAt(start)) || freq_iter.get(s.charAt(start)) < 0)) {
					// In these cases u can remove the char at beginning
					// If it is not present at all in the pattern or
					// If it is present in excess in the current substring

					if (start< end && freq_iter.containsKey(s.charAt(start)) && freq_iter.get(s.charAt(start)) < 0) {
						freq_iter.put(s.charAt(start), freq_iter.get(s.charAt(start)) + 1);
					}

					start++;
				}
				
				System.out.println(start);
				System.out.println(end);

				curr_length = end - start + 1;
				System.out.println(curr_length + "CL");
				if (curr_length < min_length) {
					min_length = curr_length;
					start_index =  start;
				}

			}

			end++;

		}
        
		System.out.println(start_index);
		return s.substring(start_index, start_index + min_length);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = smallestSubs("gedoctfsdfggoktca", "toc");
		System.out.println(res);
	}

}
