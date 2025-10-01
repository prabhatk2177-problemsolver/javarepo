package project1;

public class MatrixPrint {
	
	
	private static void printMat (int[][] mat) {
		int rows = mat.length;
		int columns = mat[0].length;
		int n =  rows;
		
		//Print top row
		int top = 0;
		int bottom = rows-1;
		int left = 0;
		int right = columns-1;
		
		while (top <= bottom && left <= right) {
			//Print top row
			for (int c = left; c <= right; c++) {
				System.out.print(mat[top][c] + " ");
			}
			top = top+1;
			System.out.println();
			
			// Print right column
			
			for (int r= top; r <= bottom ; r++) {
				System.out.print(mat[r][right] + " ");
			}
			right = right-1;
			System.out.println();
			
		   //Print bottom row
			if ( bottom >= top) {
			for (int c= right; c >= left; c--) {
				System.out.print(mat[bottom][c] + " ");
			}
			bottom = bottom-1;
			System.out.println();
			}
			
			//Print left column
			if (left <= right) {
			for (int r = bottom; r >= top ;r--) {
				System.out.print(mat[r][left] + " ");
			}
			left = left +1;
			System.out.println();
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = new int [][]{ {1,2,3,4,5,6},
									{7,8,9,10,11,12},
									{13,14,15,16,17,18} ,
									{19,20,21,22,23,24} 
			
		};
		printMat(mat);
		
		
		}
		
	

}
