package project1;

import java.util.LinkedList;
import java.util.List;

public class FindSubsSequences {

	static void findSubsSeqsRec(String s, int index, StringBuilder sb, List<String> res) {

		if (index == s.length()) {
			res.add(sb.toString());
			return;
			
		}

	
		for (int i = index; i < s.length(); i++) {
			sb.append(s.charAt(i));
			System.out.println(sb.toString());
			
			findSubsSeqsRec(s, i + 1, sb, res);

			sb.deleteCharAt(sb.length() - 1);

		}

	}

	static List<String> findSubseqs(String s) {
		LinkedList<String> res = new LinkedList<String>();

		StringBuilder sb = new StringBuilder();

		findSubsSeqsRec(s, 0, sb, res);

		return res;

	}

	public static void main(String[] args) {

		String s = "abc";
		List<String> subs = findSubseqs(s);
		System.out.println(subs);

	}

}
