package project1;

import java.util.LinkedList;
import java.util.List;

public class PermutationWithCaseChange {
  
    static List<String> res = new LinkedList<String>();
	
	static void findSubsRec(String s, int i, String current, List<String> res){
		
		
		if (i == s.length()) {
			res.add(current.toString());
			//System.out.println(current);
			return;
		}
		
		Character c = s.charAt(i);
		Character Upper = Character.toUpperCase(c); 
		Character Lower = Character.toLowerCase(c);
		//Added the current character in upper case
		if (Character.isDigit(c)) {
			findSubsRec(s, i+1,  current + c , res);
			
		}
		else {
		findSubsRec(s, i+1,  current +  Upper , res);
        
		
		
		//Added the current character
		findSubsRec(s, i+1, current + Lower, res);
		}
		
		
		
		//return;
	}

	public static void main(String[] args) {
		String s = "A1b2";

         List<String> res = new LinkedList<String>();
         String sb = new String("");
		//res.clear(); // Clear previous results if method is called multiple times
		if (s != null) {
			findSubsRec(s, 0, sb, res);
		}
		System.out.println(res);
	}

}





