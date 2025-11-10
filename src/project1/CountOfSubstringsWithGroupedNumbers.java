package project1;

public class CountOfSubstringsWithGroupedNumbers {

	static boolean checkValidSubstring(String s) {
		if (s.length() < 2)
			return false;

		if (s.length() % 2 != 0)
			return false;

		int faults = 0;
		int n = s.length();
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				faults++;
		}

		System.out.println("String is " + s + " Faults = " + faults);
		if (faults != 1)
			return false;

		int zeros = 0;
		int ones = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '0')
				zeros++;
			else if (s.charAt(i) == '1')
				ones++;
		}

		if (zeros != ones)
			return false;

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0001110010" ;
		  //String s = "0001110010";
		int count = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			String sb = new String();
			for (int j = i; j < n; j++) {
				sb = sb + s.charAt(j);
				if (checkValidSubstring(sb))
					count++;
			}
		}

		System.out.println("Count = " + count);
	}

}
