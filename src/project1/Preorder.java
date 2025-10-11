package project1;


import java.util.ArrayList;
import java.util.Stack;

//Node3 Structure
class Node3 {
int data;
Node3 left;
Node3 right;

Node3(int x) {
    data = x;
    left = right = null;
}
}


public class Preorder {

	static void preOrder(Node3 node, ArrayList<Integer> res) {
		if (node == null)
			return;
		Stack<Node3> s =  new Stack();
		//Keep pushing items onto stack and simultaneously printing them until the left is not null
		
		while (node != null || !s.isEmpty()) {
		while (node != null) {
			s.push(node);
			System.out.println(node.data);
			node = node.left;
		}
		
		//At this point node's left is null;
		//We have covered left subtree; root is already printed while pushing onto stack, so now we need to take care of 
		// right sub-tree
		 
		//The right subtree will be the one of the stack top's right
		 node = s.peek().right;
		 
		 // Remove the stack top now , since we have alrady covered it's left, itself and right.
		 s.pop();
		
		 
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     // Create binary tree
	      //       1
	      //      /  \
	      //    2     3
	      //   / \     \
	      //  4   5     6
	      Node3 root = new Node3(1);
	      root.left = new Node3(2);
	      root.right = new Node3(3);
	      root.left.left = new Node3(4);
	      root.left.right = new Node3(5);
	      root.right.right = new Node3(6);

	      ArrayList<Integer> res = new ArrayList<>();
	      preOrder(root, res);

	      for(int Node3 : res)
	          System.out.print(Node3 + " ");

	}

}
