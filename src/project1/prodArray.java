package project1;

import java.util.Arrays;

public class prodArray {

	static int[] getSortedProd (int[] a) {
		
		int firstPositive = -1;
		for (int i = 0 ; i < a.length; i++) {
			if (a[i] >= 0) {
				firstPositive = i;
				break;
			}
		}
			
		int [] prod = new int[a.length];
		for (int i = 0 ; i < a.length; i ++)
			prod[i] =  a[i] * a[i];
		
		if (firstPositive == 0)
			return prod;
		
		boolean[] ledger =  new boolean[prod[prod.length-1] + 1];
		
		System.out.println("ledger suize= " + ledger.length );
		Arrays.fill(ledger, false);
		
		for (int i = 0 ; i < prod.length; i++) {
			ledger[prod[i]] =  true;
		}
			
		int[] newProd =  new int [a.length];
		int newProdIndex = 0;
		for (int i = 0 ; i < ledger.length; i++) {
			if (ledger[i] ==  true) {
				newProd[newProdIndex++] = i;
			}
		}
		
		return newProd;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {-5, -1, 0, 3, 10};
		int[] output =  getSortedProd(input);
		for (int i = 0 ; i < input.length; i++)
			System.out.print(input[i] + "  ");
		
		System.out.println();
		
		for (int i = 0 ; i < output.length; i++)
			System.out.print(output[i] + "  ");

	}

}
