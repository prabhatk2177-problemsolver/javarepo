package project1;

class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int x) {
		data = x;
		left = null;
		right = null;
	}
}

public class MaxBSTSize {

	static int globalMax = 0;

	static int maxSizeTree(Node root) {

		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if (globalMax == 0)
				globalMax = 1;
			return 1;

		}
		
		int left = maxSizeTree(root.left);
		int right = maxSizeTree(root.right);
		int intVal = 0;
		if (root.left != null) {
			if (root.left.data >  root.data) {
			   return 0;
				
			}
			else
				intVal = left + 1;
		}
		
		if (root.right != null) {
			if (root.right.data <  root.data) {
			   return 0;
				
			}
			else
				if (intVal == 0)
				intVal =  right + 1;
				else
					 intVal = intVal + right;
		}
		
		if (intVal > globalMax)
			globalMax = intVal;

	return intVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(3); */
		
		
		Node root = new Node(10);
		root.left = new Node(4);
		root.right = new Node(11);
		root.right.left= new Node(12);
		root.right.right=  new Node(14);
		root.left.left = new Node(9);
		root.left.right = new Node(5); 
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(3);
		root.left.left.left.left = new Node(4);
		root.left.left.left.right = new Node(10);
		root.left.left.left.left.left = new Node(1);
		root.left.left.left.left.right = new Node(5);
		

		int maxSizeAtRoot = maxSizeTree(root);
		System.out.println(globalMax);

	}

}
