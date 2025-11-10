package project1;

import java.util.ArrayList;



public class ProdLessThanK {
	
	static int countSubArrayProductLessThanK(ArrayList<Integer> al3, int k ){
		int count  = 0;
		int n =  al3.size();
		int curr_prod = 1;
		
		for (int i = 0 ; i < n ; i++) {
			curr_prod = 1;
			for (int j = i ; j < n ; j++)
			{
				curr_prod = curr_prod * al3.get(i);
				if (curr_prod < k)
					count++;
				else 
					break;
			}
		}
		
		
		
		return count;
	}
	
	static int countSubArrayProductLessThanK1(ArrayList<Integer> al3, int k ){
		int count  = 0;
		int n =  al3.size();
		int curr_prod = 1;
		
		int start = 0;
		for (int right = 0; right < n; right++) {
			curr_prod = curr_prod * al3.get(right);
			
			while (curr_prod >= k) {
				curr_prod = curr_prod/al3.get(start);
				start++;
			}
			
			//Now curr_prod < k
		}
		
		
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al4 = new ArrayList<Integer>();
        al4.add(100);
        al4.add(200);
        System.out.println(
            countSubArrayProductLessThanK(al4, 101));

	}

}
