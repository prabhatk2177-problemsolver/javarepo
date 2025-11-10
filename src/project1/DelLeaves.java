package project1;

public class DelLeaves {

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}

	static Node delLeaves(Node root) {
		
		Node current = root;
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			root = null;
			return null;
			//return;
		}
		
		root.left = delLeaves(root.left);
		root.right= delLeaves(root.right);
		
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(10);
		root.left = new Node(4);
		root.right = new Node(11);
		root.right.left= new Node(12);
		root.right.right=  new Node(14);
		root.left.left = new Node(9);
		root.left.right = new Node(5); 
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(3);
		root.left.left.left.left = new Node(24);
		root.left.left.left.right = new Node(10);
		root.left.left.left.left.left = new Node(1);
		root.left.left.left.left.right = new Node(5);
		
		
		inOrder(root);
		System.out.println();
		Node newRoot = delLeaves(root);
		//System.out.println("AFTER pruning leaves");
		inOrder(newRoot);
		
		
	}

}
