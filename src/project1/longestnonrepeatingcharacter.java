package project1;

import java.util.HashSet;
import java.util.Set;

public class longestnonrepeatingcharacter {

	private static int longnonrepeatSubs (String s)
	{
		if (s.length() ==1)
			return 1;
		int count = 0 , maxCount = 0;
		Set<Character> hmap =  new HashSet<Character>();
		for (int i = 0; i < s.length();i ++) {
			if (hmap.contains(s.charAt(i))) {
				hmap.clear();
				count = 0;
			}
			else {
				 hmap.add(s.charAt(i));
				 count++;
			
		     }
			maxCount = Math.max(maxCount, count);
			
		}		
		return maxCount;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("geeksforgeeks->" + longnonrepeatSubs("geeksforgeeks"));

		
	}

}
