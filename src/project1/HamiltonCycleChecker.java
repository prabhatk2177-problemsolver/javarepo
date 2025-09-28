package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamiltonCycleChecker {

	// Check if it's valid to place vertex at current position
	static boolean isSafe(int vertex, int[][] graph, int[] path, int pos) {

		// The vertex must be adjacent to the previous vertex
		if (graph[path[pos - 1]][vertex] == 0) {
			return false;
		}

		// The vertex must not already be in the path
		for (int i = 0; i < pos; i++) {
			if (path[i] == vertex) {
				return false;
			}
		}

		return true;
}

	static boolean isSafePK(int vertex, int[][] graph, ArrayList<Integer> path) {

// The vertex must be adjacent to the previous vertex
		if (graph[path.get(path.size()-1)][vertex] == 0) {
			return false;
		}

// The vertex must not already be in the path
		if (path.contains(vertex))
			return false;

		return true;
	}

	// Recursive backtracking to construct Hamiltonian Cycle
	static boolean hamCycleUtil(int[][] graph, ArrayList<Integer> path, int start, int n) {

		// Base case: all vertices are in the path

		if (path.size() == n) {
			return (graph[path.get(n - 1)][start] == 1);
		}
		/*
		 * if (pos == n) {
		 * 
		 * // Check if there's an edge from // last to first vertex return
		 * graph[path[pos - 1]][path[0]] == 1; }
		 */

		// Try all possible vertices as next candidate
		for (int j = 0; j < n; j++) {
			if (isSafePK(j, graph, path)) {
				path.add(j);

				if (hamCycleUtil(graph, path, start, n)) {
					return true;
				}

				// Backtrack if v doesn't lead to a solution
				path.remove(path.size()- 1);
			}
		}

		return false;
	}

	// Initialize path and invoke backtracking function
	static List<Integer> hamCycle(int[][] graph) {
		int n = graph.length;
		ArrayList<Integer> path = new ArrayList<>();
		// int[] path = new int[n];
		// for (int i = 0; i < n; i++) {
		// path[i] = -1;
		// }
		int start = 0;
		// Start path with vertex 0
		path.add(start);

		if (!hamCycleUtil(graph, path, start, n)) {
			return Arrays.asList(-1);
		}

		return path;
	}

	// Driver Code
	public static void main(String[] args) {

		// Representation of the given graph
		// (0)-(1)-(2)
		// | / \ |
		// | / \ |
		// |/ \|
		// (3)-----(4)
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 } };

		// int[] path = hamCycle(graph);
		List<Integer> pathh = hamCycle(graph);

		if (pathh.get(0) == -1) {
			System.out.print("Solution does not Exist");
		} else {
			for (int i = 0; i < pathh.size(); i++) {
				System.out.print(pathh.get(i) + " ");
			}

			// Print the first vertex again
			// to complete the cycle
			System.out.print(pathh.get(0));
		}
	}
}
