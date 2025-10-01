package project1;

import java.util.Arrays;

public class ColoringProblem {
	   static final int V = 4;
	   
	  static boolean isSafe(boolean[][] graph, int[] color, int currentVertex, int currentColor) {
		  
		  for (int i = 0 ; i <V ; i++) {
			  if (color[i] == currentColor)
				  return false;
		  }
		  
		  return true;
		  
	  }
	   
	 static boolean graphColoringRec(boolean[][] graph, int numColors, int currentVertex, int[] color) {
		 
		 if (currentVertex == V)
		   return true;
		 
		 for (int c = 1; c <= numColors ; c++) {
			 if (isSafe(graph,color, currentVertex, c)) {
				 color[currentVertex] = c;
				 if (graphColoringRec(graph,numColors, currentVertex+1, color))
					 return true;
				 color[currentVertex] = -1;
				 
			 }
		 }
		 
		 return false;
		 
	 }
	
	static void graphColoring (boolean[][] graph, int numColors) {
		int[] color = new int[V];
		Arrays.fill(color,-1);
		
		//Starting from vertex 0
		graphColoringRec(graph, numColors,0, color);
		
	}
	
    // Driver code
    public static void main(String[] args) {
        // Create following graph and test whether it is 3 colorable
        // (3)---(2)
        // |   / |
        // |  /  |
        // | /   |
        // (0)---(1)

        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false }
        };

        // Number of colors
        int m = 3;

        // Function call
        graphColoring(graph, m);
    }


}
