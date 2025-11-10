package project1;


import java.util.*;

public class SubsCount {

    static int substrCount(String s, int k) {

        // If k is larger than the string length, return 0
        if (k > s.length()) return 0;

        int n = s.length();
        
        // Frequency array for characters 'a' to 'z'
        int[] cnt = new int[26]; 
        int ans = 0;
        int distinctCnt = 0;
        
        // First fill the initial window
        for (int i = 0 ; i <k ; i++) {
        	cnt[s.charAt(i) - 'a']++;
        	if (cnt[s.charAt(i) - 'a'] == 1)
        		distinctCnt++;
        }
        
        if (distinctCnt == k-1)
        	ans++;
        // Now iterate from i=k to i<n
        
        for (int i = k ; i < n; i++) {
        	
        	cnt[s.charAt(i) - 'a']++;
        	if (cnt[s.charAt(i) - 'a'] == 1)
        		distinctCnt++;
        	
        	// remove the element at the beginning of window
        	cnt[s.charAt(i-k) - 'a']--;
        	
        	if (cnt[s.charAt(i-k) - 'a'] == 0)
        		distinctCnt--;
        	
        	  if (distinctCnt == k-1)
              	ans++;
        	
        }

       return ans;
    }

    public static void main(String[] args) {
        
        String s = "aabab";
        int k = 3;
        System.out.println(substrCount(s, k));
    }
}
