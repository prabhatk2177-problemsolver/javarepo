package project1;

public class revSwhileMaintaingSpace {

	static String revSSpecial (String s) {
		int i = 0;
		int j = s.length() -1;
		int n = s.length();
		StringBuilder strB = new StringBuilder(s);
		
		while (i < j && i <n && j>=0) {
			while (i <n-1 &&  strB.charAt(i) == '_')
				i++;
			//AT this point i is char
			while (j>0 && strB.charAt(j) == '_')
				j--;
			
			//At this point j is char
			
			if (i < j) {
				char tempC= strB.charAt(i);
			strB.setCharAt(i ,strB.charAt(j));
			strB.setCharAt(j, tempC);
			
			}
			i++;
			j--;
		}
		return strB.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String orS = "A_B__C___D____E";
System.out.println(orS);
System.out.println(revSSpecial(orS));
	}

}
