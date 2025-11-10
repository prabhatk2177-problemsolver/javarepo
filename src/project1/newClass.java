package project1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;







public class newClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"klm", "abc", "bmk","abc", "kpi", "abc", "bcd", "abc", "def", "ghi", "def"};
		HashMap<String, Integer> freqMap =  new HashMap<String, Integer>();
		Queue<String>soln =  new LinkedList <String>();
		for (int i = 0 ; i < input.length; i++) {
			if (freqMap.getOrDefault(input[i], 0) == 0) {
				freqMap.put(input[i], 1);
				soln.add(input[i]);
				
				  System.out.println("Printing Q");
			        System.out.println(soln);
			        System.out.println("*****");
				
			}
			else {
				
				System.out.println("Printing q");
		        System.out.println(soln); 
		        System.out.println("%%%%%");
		        
		        System.out.println("now will remove");
				
				 Iterator<String> iterator = soln.iterator();
			        while (iterator.hasNext()) {
			        	if (iterator.next().equals(input[i]))
			            
			            iterator.remove(); // Removes the current element
			        }
			        System.out.println("Printing q");
			        System.out.println(soln.peek()); 
			        System.out.println("%%%%%");
			        
				
				
			}
		}
		
		
		System.out.println(soln.peek() +"oio");
		

	}

}
