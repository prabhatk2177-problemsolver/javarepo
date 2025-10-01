package project1;

public class WordFinder {
	
	// We are at mat[x][y] and the word index is wIdx 
	 static boolean findMatch(char[][] mat, String word, int x, int y, 
			  int wIdx) {
		 
		 if (wIdx ==  word.length())
			 return false;
		 if (x <0 || y <0 || x>= mat.length || y >= mat[0].length)
			 return false;
		 
		 // We will proceeed only if it matches
		 if (mat[x][y] == word.charAt(wIdx)) {
			 char temp = mat[x][y];
			 mat[x][y] = '#';
			 boolean res = findMatch(mat, word, x - 1, y, wIdx + 1) ||
                     findMatch(mat, word, x + 1, y, wIdx + 1) ||
                     findMatch(mat, word, x, y - 1, wIdx + 1) ||
                     findMatch(mat, word, x, y + 1, wIdx + 1);
       mat[x][y] = temp;
       return res;
			 
		 }
		 
		 
		 return false;
	 }
	
	 static boolean isWordExist(char[][] mat, String word) {
	        int wLen = word.length();
	        int n = mat.length;
	        int m = mat[0].length;

	        // if total characters in matrix is less than word length
	        if (wLen > n * m)
	            return false;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                
	                // If first letter matches, then recur and check
	                if (mat[i][j] == word.charAt(0)) {
	                    if (findMatch(mat, word, i, j, 0))
	                        return true;
	                }
	            }
	        }
	        return false;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        char[][] mat = {{'T', 'E', 'E'}, {'S', 'G', 'K'}, {'T', 'E', 'L'}};
        String word = "GEEK";
        System.out.println(isWordExist(mat, word));

	}

}
