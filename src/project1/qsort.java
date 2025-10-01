package project1;

public class qsort {
	//  2 5 7 8  9 0 1 5 1 3
	//Taking 1st element as pivot
	
	static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
		
	}
	static int partitionIndex (int[] arr, int start, int end) {
		int pivot = arr[end];
		
		
		
		int barPosn = start;
		
		for (int i = start; i <end ; i ++) {
			if (arr[i] < pivot) {
				
			    swap(arr,barPosn,i);
			    barPosn ++;
			}
		}
		
		//till barPosnj all are less than Pivot
		swap(arr, barPosn, end);
		return barPosn;
		
		
		
	}
	
	static void qsort (int[] arr, int low, int high) {
		
		
		if (low<high) {
			int pi = partitionIndex(arr,low,high);
			qsort(arr,low,pi-1);
			qsort(arr,pi+1,high);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] arr = {10, 7, 8, 9, 1, 5};
	        int n = arr.length;
	      
	        qsort(arr, 0, n - 1);
	        
	        for (int val : arr) {
	            System.out.print(val + " ");  
	        }

	}

}
