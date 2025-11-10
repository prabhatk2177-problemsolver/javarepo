package project1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

	static char nonrc (String s) {
		HashMap<Character, Integer>hm = new HashMap<Character, Integer>();
		Queue<Character>possibles = new LinkedList<>();
		int n =  s.length();
		
		for (int i = 0 ; i < n; i++) {
			if (!hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), 1);
				possibles.add(s.charAt(i));
			}
			
			else {
				Iterator<Character> it = possibles.iterator();
				while (it.hasNext()) {
					if (it.next() == s.charAt(i)) {
						possibles.remove(s.charAt(i));
					}
				}
				hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
			}
		}
		
		
		if (possibles.size() >= 1)
		
		return possibles.poll();
		
		else
			return 'c';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "AAKBCDEER";
		System.out.println(nonrc(s));

	}

}
