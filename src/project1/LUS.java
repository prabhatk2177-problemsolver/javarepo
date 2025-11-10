package project1;

import java.util.Arrays;

class LUS {
    
    static int longestUniqueSubstr(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int n= s.length();

        int res = 0;
        
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        int l = 0;
        int max = 1;
        
        for (int i = 1 ; i < n ; i++) {
        	
        	//IF repeating characters are found; keep trimming from left unless the offending character is deleted
        	while (freq[s.charAt(i) - 'a'] != 0 && l < i) {
        		freq[s.charAt(l) - 'a']--;
        		l++;
        	}
        	
        	//If not found yet ..just increase its freauency
        	freq[s.charAt(i) - 'a']++;
        	max = Math.max(max,  i-l+1);
        	
        }
        
        
        
        return max;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}