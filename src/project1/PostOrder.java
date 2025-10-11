package project1;

import java.util.ArrayList;
import java.util.Stack;

//Node5 Structure
class Node5 {
	int data;
	Node5 left;
	Node5 right;
	boolean rightVisited;

	Node5(int x) {
		data = x;
		left = right = null;
		rightVisited = false;
	}
}

public class PostOrder {

	static void postOrder(Node5 node, ArrayList<Integer> res) {
		if (node == null)
			return;
		Stack<Node5> s = new Stack<>();

		while (node != null || !s.isEmpty()) {
			while (node != null) {
				s.push(node);

				node = node.left;
			}

			// At this point node's left is null;
			// We have covered left subtree;
			// Now need to cover the right sub-tree
			
			//If right subtree is visited, then this node's left and right both are covered, just print it and pop it off the stack
			if (s.peek().rightVisited) {
				System.out.println(s.peek().data);
				s.pop();
			}
			else {
			node = s.peek().right;
			s.peek().rightVisited = true;
			}
			


		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		// Create binary tree
		// 1
		// / \
		// 2 3
		// / \ \
		// 4 5 6
		Node5 root = new Node5(1);
		root.left = new Node5(2);
		root.right = new Node5(3);
		root.left.left = new Node5(4);
		root.left.right = new Node5(5);
		root.right.right = new Node5(6);

		ArrayList<Integer> res = new ArrayList<>();
		postOrder(root, res);

		for (int Node5 : res)
			System.out.print(Node5 + " ");
	}

}
