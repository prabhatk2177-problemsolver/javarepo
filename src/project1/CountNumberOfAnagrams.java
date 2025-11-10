package project1;

import java.util.HashMap;

public class CountNumberOfAnagrams {

	private static int countOccurences(String s, String pattern) {
		int count = 0;
		// Map to store freq of pattern elems
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		HashMap<Character, Integer> freq_iter = new HashMap<Character, Integer>();
		for (Character c : pattern.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
			freq_iter.put(c, freq_iter.getOrDefault(c, 0) + 1);
		}
		int unique_chars = freq.size();
		System.out.println(unique_chars);
		int i = 0;
		int j = 0;
		int k = pattern.length();
		int n = s.length();
		int matchedCharacters = 0;

		// Keep incrementing while the window size is not attained

		while (j < pattern.length()) {
			if (freq.containsKey(s.charAt(j))) {
				freq_iter.put(s.charAt(j), freq_iter.get(s.charAt(j)) - 1);

				if (freq_iter.get(s.charAt(j)) == 0) {
					matchedCharacters++;
				}
			}

			j++;
		}

		System.out.println("MC CKP0=" + matchedCharacters);
		for (int m = k; m < n; m++) {

			// Now window size is attained ; just keep incrementing
			if (matchedCharacters == unique_chars)
				count++;

			// Add the character at j

			if (freq.containsKey(s.charAt(m))) {
				freq_iter.put(s.charAt(m), freq_iter.get(s.charAt(m)) - 1);

				if (freq_iter.get(s.charAt(m)) == 0) {
					matchedCharacters++;
				}
			}

			// Remove the key which falls outside
			if (freq.containsKey(s.charAt(m - k))) {
				freq_iter.put(s.charAt(m - k), freq_iter.get(s.charAt(m - k)) + 1);

				if (freq_iter.get(s.charAt(m - k)) == 1) {
					matchedCharacters--;
				}
			}

		}

		if (matchedCharacters == unique_chars)
			count++;

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "for";
		String s = "forxxorfxdofr";
		int count = countOccurences(s, pattern);
		System.out.println(count);
	}

}
