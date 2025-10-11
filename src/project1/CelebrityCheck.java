package project1;
class CelebrityCheck {
static int celebrity(int[][] mat) {
    int n = mat.length;

    int i = 0, j = n - 1;
    while (i < j) {
        
    	 if (mat[i][j] == 1)
             i++;
         
         // else j can't be celebrity
         else
             j--;
    	
    	
    	
       }

    // i points to our celebrity candidate
    int c = i;

    // check if c is actually
    // a celebrity or not
    for (i = 0; i < n; i++) {
        if (i == c) continue;
        
        // if any person doesn't
        // know 'c' or 'c' doesn't
        // know any person, return -1
        if (mat[c][i] != 0 || mat[i][c] == 0)
            return -1;
    }

    return c;
}

public static void main(String[] args) {
    int[][] mat = { { 1, 1, 0 },
                    { 0, 1, 0 },
                    { 0, 1, 1 } };
    System.out.println(celebrity(mat));
}
}


