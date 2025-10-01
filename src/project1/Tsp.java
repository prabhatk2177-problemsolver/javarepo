package project1;

import java.util.ArrayList;
import java.util.Arrays;

public class Tsp {
	static int gminVal = Integer.MAX_VALUE;
	static ArrayList<Integer> path = new ArrayList<Integer>();
	
	static void tspRec (int[][]cost, boolean[] visited, int start, int current,  int currentCost,int n,ArrayList<Integer>finalPath) {
		if (path.size() == n && cost[current][start] != 0 ) {
			
			if (gminVal > currentCost + cost[current][start] ) {
				finalPath.clear();
				 finalPath.addAll(path);
				 System.out.println(path);
			}
			
			 gminVal = (Math.min(gminVal, currentCost + cost[current][start]));
			 
			
				return;
		}
		
		for (int i = 0 ; i <n ; i++) {
			if (!visited[i] && cost[current][i] != 0) {
				visited[i] = true;
				path.add(i);
				//System.out.println("*****");
				//System.out.println(path);
				
				tspRec (cost,visited ,start, i,  currentCost + cost[current][i] ,n,finalPath);
				visited[i] = false;
				path.remove(path.size() - 1);
			}
		}
		

	}
	
	static int tsp (int[][] cost) {
		
		boolean[] visited =  new boolean[cost.length];
		Arrays.fill(visited, false);
	
		path.add(0);
		visited[0] = true;
		int n= cost.length;
		ArrayList<Integer> finalPath = new ArrayList<Integer>();
	     tspRec (cost,visited, 0, 0,0 ,n,finalPath);
	    // System.out.println("Path size = " + path.size());
	     //for (int k = 0; k <path.size(); k++)
	     //System.out.println(path.get(k));
	     System.out.println(path);
	     return gminVal;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int n = 4;
	        int[][] cost = { { 0, 10, 15, 20 },
	                         { 10, 0, 35, 25 },
	                         { 15, 35, 0, 30 },
	                         { 20, 25, 30, 0 } };

	        int res = tsp(cost);
	        System.out.println(res);

	}

}
