package project1;

import java.util.LinkedList;
import java.util.List;

public class FindSubsRec {
	
	static List<String> res = new LinkedList<String>();
	
	static void findSubsRec(String s, int i, String current){
		
		
		if (i == s.length()) {
			res.add(current);
			//System.out.println(current);
			return;
		}
		//Added the current character
		findSubsRec(s, i+1, s.charAt(i) + current);
		
		//Did not add the current character
		
		findSubsRec(s, i+1, current );
		
		
		
		//return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		findSubsRec(s, 0,"");
        System.out.println(res);
	}

}
