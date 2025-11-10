package project1;

public class SmallestWindowContaingSubstring {

	private static String smallestWindow(String s, String pattern) {
		int[] freqP = new int[256];
		int[] freqS = new int[256];

		for (int i = 0; i < pattern.length(); i++) {
			freqP[pattern.charAt(i)]++;
		}

		int start = 0;
		int matchCount = 0;
		int len = Integer.MAX_VALUE;
		int minLen = Integer.MAX_VALUE;
		int startIndex = -1;

		for (int right = 0; right < s.length(); right++) {
			freqS[s.charAt(right)]++;

			if (freqP[s.charAt(right)] > 0 && freqS[s.charAt(right)] <= freqP[s.charAt(right)])
				matchCount++;

			if (matchCount == pattern.length()) {
				char startChar;
				while (freqS[startChar = s.charAt(start)] > freqP[startChar]) {
					freqS[startChar]--;
					start++;
				}

				len = right - start + 1;
				if (len < minLen) {
					minLen = len;
					startIndex = start;
				}

			}

		}
		
		if (startIndex == -1)

		return null;
		else
			return (s.substring(startIndex, startIndex + minLen));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "timetopractice";
		String p = "toc";

		String res = smallestWindow(s, p);
		System.out.println(res);
	}

}
