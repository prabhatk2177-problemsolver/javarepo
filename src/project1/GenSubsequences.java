package project1;

import java.util.LinkedList;
import java.util.List;

public class GenSubsequences {

	static void  genSubSeqRec (String s, int index, StringBuilder sb, List<String> ans)
	{
		if (index == s.length())
			return;
		
	/*	for (int i = index; i < s.length(); i++) {
			sb = sb.append(s.charAt(i));
			ans.add(sb.toString());
			genSubSeqRec(s, i+1, sb,ans);
			sb = sb.deleteCharAt(sb.length()-1);
			
		} */
		
		
		sb = sb.append(s.charAt(index));
		ans.add(sb.toString());
		genSubSeqRec(s, index+1, sb,ans);
		
		sb = sb.deleteCharAt(sb.length()-1);
		//ans.add(sb.toString());
		if (sb.length() == 0)
		genSubSeqRec(s, index+1, sb,ans);
		
		
		
		
	}
	static List<String> genSubSeq (String s) {
		List<String> ans = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		genSubSeqRec(s, 0, sb, ans);
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		
		List<String> ls = genSubSeq ("abc");
		
		ls.stream().forEach(System.out::println);
		// TODO Auto-generated method stub

	}

}
