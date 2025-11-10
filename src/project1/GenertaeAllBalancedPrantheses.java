package project1;

import java.util.LinkedList;
import java.util.List;

public class GenertaeAllBalancedPrantheses {
	
	private static void  genParens(int open, int close,String curr, List<String> res ) {
		
		if (open == 0 && close == 0) {
			res.add(curr);
			System.out.println(curr);
			return;
		}
	//	System.out.println(curr);
		
		
		if (open !=0 ) {
			curr= curr+ "(";
			genParens (open-1, close, curr,res);
		}
		
		if (close > open) {
			curr= curr+ ")";
			genParens (open, close-1, curr,res);
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int open =3;
      int close =3;
      List<String> res = new LinkedList<String>();
		genParens (open, close, "",res);
		//System.out.println(res);
	}

}
