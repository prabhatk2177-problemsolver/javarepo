package project1;

import java.util.HashMap;

public class IsoMorphicCheck {
	
	static boolean areIsomorphic (String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.length() < 2)
			return true;
		
		HashMap<Character, Character> mp = new HashMap<Character, Character>();
		
		for (int i = 0 ; i <s1.length(); i++) {
			if (!mp.containsKey(s1.charAt(i)))
				mp.put(s1.charAt(i), s2.charAt(i));
			else {
				if (mp.get(s1.charAt(i)) != s2.charAt(i))
					return false;
			}
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String s1 = "aab";
	        String s2 = "xxy";

	        if (areIsomorphic(s1, s2)) {
	            System.out.println("true");
	        } else {
	            System.out.println("false");
	        }
	}

}
