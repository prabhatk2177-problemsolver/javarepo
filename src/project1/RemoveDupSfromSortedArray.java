package project1;

public class RemoveDupSfromSortedArray {

	static void modifyArray (int[] arr) {
		
		int n = arr.length;
		int i = 0;
		int distinct = 0;
		 
		if (arr.length == 1)
			return;
		while (i < n) {
			
			//Keep increasing pointer of i while same elems
			
			while ((i+1) < n && arr[i] == arr[i+1]) {
				i++;
			}
			
			//Now either i+1 is not there or arr[i+1] != arr[i]
			
			if ((i+1) < n){
				//Filled all the repeated elems with next distict elem
				for (int k = distinct+1; k <= i ; k++) {
					arr[k] = arr[i+1];
				}
				
			}
			
			distinct++;
			i++;
		
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,5};
		modifyArray(arr);
		for (int m = 0 ; m < arr.length; m++)
            System.out.print(arr[m] + " ");
	}

}
