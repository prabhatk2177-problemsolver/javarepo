package project1;
//A special two-digit number is a number such that 
//when the sum of the digits of the number is added to the product of its digits,
//the result is equal to the original two-digit number. 
public class Specialnumber {

	private static boolean numCheck(int x) {
		
		int orig = x;
		int sum = 0;
		int product = 1;
		int digit  = 0;
		while (x > 0) {
			digit = x %10;
			sum = sum + digit;
			product = product * digit;
			x = x/10;
		}
		
		return  ((sum +product) == orig);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean y = numCheck(59);
		System.out.println(y);

	}

}
