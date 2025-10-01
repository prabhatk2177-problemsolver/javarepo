package project1;

import java.util.HashSet;
import java.util.Set;

public class longnonrepeatSubs_SlidingWIndow {
	
	private static int longnonrepeatSubs (String s)
	{
		int left = 0,maxCount = 0 , right = 0;
		Set<Character> hmap =  new HashSet<Character>();
		
		while (right < s.length() && right >= left) {
			while (right < s.length() && !hmap.contains(s.charAt(right))) {
				hmap.add(s.charAt(right));
				right++;
				
				
			}
			maxCount = Math.max(right-left,maxCount);
			System.out.println("mc=" + maxCount);
		//char at right is repeated
			while (right <s.length() && hmap.contains(s.charAt(right))) {
				hmap.remove(s.charAt(left));
				left++;
			}
			
		}
		return maxCount;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("geeksforgeeks->" + longnonrepeatSubs("geeksforgeeks"));

	}

}
