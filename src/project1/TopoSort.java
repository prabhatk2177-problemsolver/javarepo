package project1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopoSort {

	static List<Integer>[] constructAdj(int[][] edges, int v) {
		List<Integer>[] adjListArray = new ArrayList[v];
		List<Integer>[] adjListArray1 = new ArrayList [v];
		
		List<List<Integer>> adjListList =  new ArrayList<List<Integer>>();
		for (int i = 0; i < v; i++)
			adjListArray[i] = new LinkedList<Integer>();

		for (int[] edge : edges) {
			adjListArray[edge[0]].add(edge[1]);
		}
		return adjListArray;

	}

	static void topologicalSortRec(int v, int[][] edges, int currentVertex, boolean[] visited, Stack<Integer> stack,
			List<Integer>[] adjListArray) {
		visited[currentVertex] = true;
		for (int i : adjListArray[currentVertex]) {
			if (!visited[i]) {
				topologicalSortRec(v, edges, i, visited, stack, adjListArray);
			}
		}
		stack.push(currentVertex);

	}

	static int[] topologicalSort(int v, int[][] edges) {
		List<Integer>[] adjListArray = constructAdj(edges, v);

		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				topologicalSortRec(v, edges, i, visited, stack, adjListArray);
			}
		}

		int[] result = new int[v];
		int index = 0;
		while (!stack.isEmpty()) {
			result[index++] = stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {
		int v = 6;
		int[][] edges = { { 2, 3 }, { 3, 1 }, { 4, 0 }, { 4, 1 }, { 5, 0 }, { 5, 2 } };

		int[] ans = topologicalSort(v, edges);

		for (int node : ans) {
			System.out.print(node + " ");
		}
		System.out.println();
	}

}
