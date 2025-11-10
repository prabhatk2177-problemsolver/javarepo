package project1;

import java.util.LinkedList;
import java.util.List;

public class NBitBinaryWithOnesMoreThanZeros {

	private static void genNums(int ones, int zeros, int n, String curr, List<String> res) {

		if (n == 0) {
			res.add(curr);
			return;
		}


		
      // ones++;
		
		
		genNums(ones +1, zeros, n - 1, curr+"1", res);
		
		

		// Call with 0
		if (ones > zeros) {
		    
			genNums(ones,zeros+1, n - 1, curr+"0" , res);
		}
		
		
		

		// Call with 1
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new LinkedList<String>();
		genNums(0, 0, 3, "", res);
		System.out.println(res);

	}

}
