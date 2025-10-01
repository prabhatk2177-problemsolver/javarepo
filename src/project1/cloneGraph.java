package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
	int val;
	ArrayList<Node> neighbours;

	Node(int val) {
		this.val = val;
		neighbours = new ArrayList<>();
	}

}

public class cloneGraph {

	static Node createClone(Node node) {
		if (node == null)
			return null;

		Map<Node, Node> cloneMap = new HashMap<>();

		Node clone = new Node(node.val);
		cloneMap.put(node, clone);
		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			Node current = q.poll();

			for (Node neighbour : current.neighbours) {

				if (!cloneMap.containsKey(neighbour)) {
					Node neighbourClone = new Node(neighbour.val);
					cloneMap.put(neighbour, neighbourClone);
				}

				cloneMap.get(current).neighbours.add(cloneMap.get(neighbour));

			}
		}

		return clone;

	}

	static boolean compareGraph(Node n1, Node n2, HashMap<Node, Node> visited) {

		if (n1 == null || n2 == null)
			return n1 == n2;

		if (n1.val != n2.val)
			return false;

		visited.put(n1, n2);

		if (n1.neighbours.size() != n2.neighbours.size())
			return false;

		// The base nodes are same; same val, same size of nodelist;
		// Now we need to compare their adjacencies

		for (int m = 0; m < n1.neighbours.size(); m++) {

			Node neighbour1 = n1.neighbours.get(m);
			Node neighbour2 = n2.neighbours.get(m);

			if (visited.containsKey(neighbour1)) {
				if (visited.get(neighbour1) != neighbour2)
					return false;
			} else {
				if (!compareGraph(neighbour1, neighbour2, visited))
					return false;
			}

		}
		return true;

	}
	
	static void printGraph (Node root, boolean[] visited) {
		
		if (!visited[root.val]) {
			System.out.println(root.val);
			System.out.println("----");
			visited[root.val] = true;
			
			
			for (Node neighbour : root.neighbours) {
				System.out.println(root.val +  "--->" + neighbour.val);
				if (!visited[neighbour.val]) {
					
					printGraph(neighbour,visited);
				}
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n0.neighbours.addAll(Arrays.asList( n2));
		n1.neighbours.addAll(Arrays.asList(n0));
		n2.neighbours.addAll(Arrays.asList( n3));
		n3.neighbours.addAll(Arrays.asList(n0));

		boolean[] visited =  new boolean[4];
		Arrays.fill(visited, false);
		printGraph(n0,visited);
		printGraph(n1,visited);
	}

}
